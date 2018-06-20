package com.Revature.Test;

import static org.junit.Assert.*;

import java.io.IOException;
import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.junit.AfterClass;
import org.junit.Before;
import org.junit.Test;

import com.Revature.Dao.EmployeeDao;
import com.Revature.Dao.EmployeeDaoImpl;
import com.Revature.Dao.ExpenseRequestDao;
import com.Revature.Dao.ExpenseRequestDaoImpl;
import com.Revature.Exceptions.NonExistentEmployee;
import com.Revature.Exceptions.NonExistentManager;
import com.Revature.Exceptions.UsernameTaken;
import com.Revature.Pojo.Employee;
import com.Revature.Pojo.ExpenseRequest;
import com.Revature.util.ConnectionUtil;

public class ExpenseRequestDaoTest {

	private ExpenseRequestDao erDao;

	@Before
	public void init() {
		erDao = new ExpenseRequestDaoImpl();
		DBScrubber.scrub();
	}

	@Test
	public void createOkExpense()
			throws SQLException, IOException, UsernameTaken, NonExistentManager, NonExistentEmployee {
		EmployeeDao empDao = new EmployeeDaoImpl();
		empDao.createEmployee(new Employee("THOMAS", null, "THOMAS", "JANSEN", "EMAIL", null, true));

		erDao.createExpenseRequest(new ExpenseRequest("THOMAS", 100f, "OCA"));

		try (Connection con = ConnectionUtil.getConnection()) {
			ResultSet rs = con.prepareStatement("SELECT * FROM EXPENSE_REQUEST").executeQuery();

			assert (rs.next());

			assert (rs.getString("USERNAME").equals("THOMAS"));
		}
	}

	@Test(expected = NonExistentEmployee.class)
	public void createExpenseForNonExistentEmployee() throws SQLException, IOException, NonExistentEmployee {
		erDao.createExpenseRequest(new ExpenseRequest("THOMAS", 100f, "OCA"));
	}

	@Test
	public void getExistingExpenseRequest()
			throws SQLException, IOException, UsernameTaken, NonExistentManager, NonExistentEmployee {
		EmployeeDao empDao = new EmployeeDaoImpl();
		empDao.createEmployee(new Employee("THOMAS", null, "THOMAS", "JANSEN", "EMAIL", null, true));
		erDao.createExpenseRequest(new ExpenseRequest("THOMAS", 100f, "OCA"));

		ExpenseRequest er = erDao.getExpenseRequest(1);

		assertNotNull(er);

		assert (er.getSubmitter().equals("THOMAS"));
	}

	@Test
	public void getNonExistentExpenseRequest() throws SQLException, IOException {
		ExpenseRequest er = erDao.getExpenseRequest(1);

		assertNull(er);
	}

	@Test
	public void updateExpense()
			throws SQLException, IOException, UsernameTaken, NonExistentManager, NonExistentEmployee {
		EmployeeDao empDao = new EmployeeDaoImpl();
		empDao.createEmployee(new Employee("THOMAS", null, "THOMAS", "JANSEN", "EMAIL", null, true));
		empDao.createEmployee(new Employee("JIM", null, "JIM", "HALPERT", "EMAIL", "THOMAS", true));

		erDao.createExpenseRequest(new ExpenseRequest("JIM", 100f, "OCA"));

		ExpenseRequest er = erDao.getExpenseRequest(1);

		er.setState("APPROVED");
		er.setResolvingManager("THOMAS");

		int rval = erDao.updateExpenseRequest(er);

		assert (rval != 0);
	}

	@Test
	public void updateNonExistentExpense() throws SQLException, IOException, NonExistentManager {
		int rval = erDao.updateExpenseRequest(
				new ExpenseRequest(1, "THOMAS", new Date(10000000), 100f, "OCA", "PENDING", null));
		assert (rval == 0);
	}

	@Test(expected = NonExistentManager.class)
	public void updateExpenseForNonExistentResolver()
			throws SQLException, IOException, UsernameTaken, NonExistentManager, NonExistentEmployee {
		EmployeeDao empDao = new EmployeeDaoImpl();
		empDao.createEmployee(new Employee("THOMAS", null, "THOMAS", "JANSEN", "EMAIL", null, true));

		erDao.createExpenseRequest(new ExpenseRequest("THOMAS", 100f, "OCA"));

		ExpenseRequest er = erDao.getExpenseRequest(1);

		assertNotNull(er);

		er.setResolvingManager("JIM");

		erDao.updateExpenseRequest(er);
	}

	@Test
	public void checkExpenseList()
			throws SQLException, IOException, UsernameTaken, NonExistentManager, NonExistentEmployee {
		EmployeeDao empDao = new EmployeeDaoImpl();
		empDao.createEmployee(new Employee("THOMAS", null, "THOMAS", "JANSEN", "EMAIL", null, true));

		for (int i = 0; i < 4; i++) {
			erDao.createExpenseRequest(new ExpenseRequest("THOMAS", i * 100f, "Stuff"));
		}

		List<ExpenseRequest> erList = erDao.getAllExpenseRequests(empDao.getEmployee("THOMAS"));

		assert (erList.size() == 4);

		for (ExpenseRequest er : erList) {
			assert (er.getRequestId() > 0 && er.getRequestId() < 5);
		}
	}

	@Test(expected = NonExistentEmployee.class)
	public void checkExpenseListForNonExistentEmployee() throws SQLException, IOException, NonExistentEmployee {
		erDao.getAllExpenseRequests(new Employee("THOMAS", null, "THOMAS", "JANSEN", "EMAIL", null, true));
	}

	@Test
	public void noRequests() throws SQLException, IOException, UsernameTaken, NonExistentManager, NonExistentEmployee {
		EmployeeDao empDao = new EmployeeDaoImpl();
		empDao.createEmployee(new Employee("THOMAS", null, "THOMAS", "JANSEN", "EMAIL", null, true));

		assert (erDao.getAllExpenseRequests(new Employee("THOMAS", null, "THOMAS", "JANSEN", "EMAIL", null, true))
				.size() == 0);
	}

	@Test
	public void getAllExpensesCheck() throws SQLException, IOException, UsernameTaken, NonExistentManager, NonExistentEmployee {
		EmployeeDao empDao = new EmployeeDaoImpl();
		empDao.createEmployee(new Employee("THOMAS", null, "THOMAS", "JANSEN", "EMAIL", null, true));
		empDao.createEmployee(new Employee("JIM", null, "JIM", "HALPERT", "EMAIL", "THOMAS", true));
		empDao.createEmployee(new Employee("JAY", null, "JAY", "FELDMAN", "EMAIL", "JIM", true));

		for (int i = 0; i < 4; i++) {
			erDao.createExpenseRequest(new ExpenseRequest("THOMAS", i * 100f, "Stuff"));
			erDao.createExpenseRequest(new ExpenseRequest("JIM", (i+1)*100f, "WORK THINGS"));
			erDao.createExpenseRequest(new ExpenseRequest("JAY", (i+2)*50f, "HAIR"));
		}
		
		List<ExpenseRequest> erList = erDao.getAllExpenseRequests();
		
		assert(erList.size()==12);		
	}
	
	@AfterClass
	public static void cleaner() {
		DBScrubber.scrub();
	}

}
