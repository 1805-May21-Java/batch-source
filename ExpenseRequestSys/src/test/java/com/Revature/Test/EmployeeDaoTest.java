package com.Revature.Test;

import static org.junit.Assert.*;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.junit.AfterClass;
import org.junit.Before;
import org.junit.Test;

import com.Revature.Dao.EmployeeDao;
import com.Revature.Dao.EmployeeDaoImpl;
import com.Revature.Exceptions.NonExistentEmployee;
import com.Revature.Exceptions.NonExistentManager;
import com.Revature.Exceptions.UsernameTaken;
import com.Revature.Pojo.Employee;
import com.Revature.util.ConnectionUtil;

public class EmployeeDaoTest {

	/*
	 * All tests involve an implementation of EmployeeDao pre-declaring one here
	 * allows for @Before to define it once it has been implemented
	 */
	private EmployeeDao empDao;

	@Before
	public void init() {
		empDao = new EmployeeDaoImpl(); // Define implementation
		DBScrubber.scrub(); // Clean all tables of data and reset sequence to 1
	}

	@Test
	public void validCheckUnusedUsername() throws SQLException, IOException {
		// Checks if the username is taken or not
		assert (empDao.checkUsernameAvailable("THOMAS"));
	}

	@Test
	public void checkTakenUsername() throws SQLException, IOException, UsernameTaken, NonExistentManager {
		empDao.createEmployee(new Employee("THOMAS", null, "THOMAS", "JANSEN", "EMAIL", null, true));
		// Username has been taken in this scenario
		assertFalse(empDao.checkUsernameAvailable("THOMAS"));
	}

	@Test
	public void validCreateEmployee() throws SQLException, IOException, UsernameTaken, NonExistentManager {
		// Attempts to create an employee
		empDao.createEmployee(new Employee("THOMAS", null, "THOMAS", "JANSEN", "EMAIL", null, true));

		// Manually verifies that there is an employee with a matching username
		try (Connection con = ConnectionUtil.getConnection()) {
			ResultSet rs = con.prepareStatement("SELECT * FROM EMPLOYEE").executeQuery();
			assert (rs.next());
			assert (rs.getString("USERNAME").equals("THOMAS"));
		}
	}

	@Test(expected = UsernameTaken.class)
	public void createEmployeeTakenUsername() throws SQLException, IOException, UsernameTaken, NonExistentManager {
		empDao.createEmployee(new Employee("THOMAS", null, "THOMAS", "JANSEN", "EMAIL", null, true));
		// Attempt to recreate an employee with the same username
		// Expect for an exception to be thrown
		empDao.createEmployee(new Employee("THOMAS", null, "JIM", "JANSEN", "EMAIL", null, true));
	}

	@Test(expected = NonExistentManager.class)
	public void createEmployeeInvalidManager() throws SQLException, IOException, UsernameTaken, NonExistentManager {
		// Manager jim does not exist
		// Expect exception
		empDao.createEmployee(new Employee("THOMAS", null, "THOMAS", "JANSEN", "EMAIL", "JIM", true));
	}

	@Test
	public void createEmployeeWithManager() throws SQLException, IOException, UsernameTaken, NonExistentManager {
		// Create Thomas as manager of jim
		empDao.createEmployee(new Employee("THOMAS", null, "THOMAS", "JANSEN", "EMAIL", null, true));
		empDao.createEmployee(new Employee("JIM", null, "JIM", "PARSONS", "EMAIL", "THOMAS", true));

		// Manually verify that there is an employee with the username of jim
		// whose manager/reportsto is thomas
		try (Connection con = ConnectionUtil.getConnection()) {
			ResultSet rs = con.prepareStatement("SELECT * FROM EMPLOYEE WHERE USERNAME = 'JIM'").executeQuery();
			assert (rs.next());
			assert (rs.getString("REPORTSTO").equals("THOMAS"));
		}
	}

	@Test
	public void getValidEmployee() throws SQLException, IOException, UsernameTaken, NonExistentManager {
		// Create an employee
		empDao.createEmployee(new Employee("THOMAS", null, "THOMAS", "JANSEN", "EMAIL", null, true));

		// Assert that the employee being returned is not null
		// Could manually check that this employee object has matching attributes
		assertNotNull(empDao.getEmployee("THOMAS"));
	}

	@Test
	public void getNonExistentEmployee() throws SQLException, IOException {
		// Attempt to get an employee that does not exist
		assertNull(empDao.getEmployee("THOMAS"));
	}

	@Test
	public void validEmployeeUpdate() throws SQLException, IOException, UsernameTaken, NonExistentManager {
		// Create an employee
		empDao.createEmployee(new Employee("THOMAS", null, "THOMAS", "JANSEN", "EMAIL", null, true));

		// Get that employee from the db
		Employee e = empDao.getEmployee("THOMAS");

		// Make sure there were no errors
		assertNotNull(e);

		// Retire this employee
		e.setActive(false);

		// Attempt to update this employee
		empDao.updateEmployee(e);

		// Manually check that the change was effective
		try (Connection con = ConnectionUtil.getConnection()) {
			ResultSet rs = con.prepareStatement("SELECT * FROM EMPLOYEE WHERE USERNAME = 'THOMAS'").executeQuery();
			assert (rs.next());

			assert (rs.getInt("IS_ACTIVE") == 0);
		}
	}

	@Test(expected = NonExistentManager.class)
	public void updateEmployeeToNonExistentManager()
			throws SQLException, IOException, UsernameTaken, NonExistentManager {
		// Create an employee
		empDao.createEmployee(new Employee("THOMAS", null, "THOMAS", "JANSEN", "EMAIL", null, true));

		// Get the employee back
		Employee e = empDao.getEmployee("THOMAS");

		// Assume nothing has failed
		assertNotNull(e);

		// Assign Thomas a manager that does not exist
		e.setReportsTo("JIM");

		// Method should throw an exception
		empDao.updateEmployee(e);
	}

	@Test
	public void updateNonExistentEmployee() throws SQLException, IOException, NonExistentManager {
		// Attempt to update an employee that does not exist
		int rval = empDao.updateEmployee(new Employee("THOMAS", null, "THOMAS", "JANSEN", "EMAIL", null, true));
		// No rows were updated
		assert (rval == 0);
	}

	@Test
	public void allEmployeeTest() throws SQLException, IOException, UsernameTaken, NonExistentManager {
		for (int i = 0; i < 10; i++) {
			empDao.createEmployee(new Employee(String.valueOf(i), null, "NAME", "JANSEN", "EMAIL",
					(i == 0) ? null : String.valueOf(i - 1), true));
		}

		List<Employee> empList = empDao.getAllEmployees();

		for (int i = 0; i < 10; i++) {
			String user = empList.get(i).getUsername();
			int temp = Integer.parseInt(user);
			assert (temp >= 0 && temp < 10);
		}
	}
	
	@Test
	public void checkManager() throws SQLException, IOException, UsernameTaken, NonExistentManager, NonExistentEmployee {
		empDao.createEmployee(new Employee("THOMAS", null, "THOMAS", "JANSEN", "EMAIL", null, true));
		assertFalse(empDao.isManager(empDao.getEmployee("THOMAS")));
		
		empDao.createEmployee(new Employee("JIM", null, "JIM", "HALPERT", "EMAIL", "THOMAS", true));
		assert(empDao.isManager(empDao.getEmployee("THOMAS")));
	}
	
	@Test(expected=NonExistentEmployee.class)
	public void checkManagerForNonExistent() throws SQLException, IOException, NonExistentEmployee {
		empDao.isManager(new Employee("THOMAS", null, "THOMAS", "JANSEN", "EMAIL", null, true));
	}

	@AfterClass
	public static void cleaner() {
		// After all tests have completed, clean the database once more
		DBScrubber.scrub();
	}

}
