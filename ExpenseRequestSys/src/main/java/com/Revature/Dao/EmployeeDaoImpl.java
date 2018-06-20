package com.Revature.Dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.Revature.Exceptions.NonExistentEmployee;
import com.Revature.Exceptions.NonExistentManager;
import com.Revature.Exceptions.UsernameTaken;
import com.Revature.Pojo.Employee;
import com.Revature.util.ConnectionUtil;

public class EmployeeDaoImpl implements EmployeeDao {

	@Override
	public boolean checkUsernameAvailable(String username) throws SQLException, IOException {
		// Try with resources without catch or finally
		// Guarantees connection is closed
		boolean rval = true;
		try (Connection con = ConnectionUtil.getConnection()) {
			String sql = "SELECT * FROM EMPLOYEE WHERE USERNAME = ?";
			PreparedStatement stmt = con.prepareStatement(sql);
			stmt.setString(1, username);
			ResultSet rs = stmt.executeQuery();
			if (rs.next()) {
				// If there is an element, then the usename is not available
				rval = false;
			}
		}
		return rval;
	}

	@Override
	public int createEmployee(Employee e) throws SQLException, IOException, UsernameTaken, NonExistentManager {
		// Check if the username is available
		if (!checkUsernameAvailable(e.getUsername())) {
			throw new UsernameTaken();
		}
		// Check if this employee has a manger and that manager is a valid employee
		// If the username is available, then there is no row in the db with a username
		// matching
		if (e.getReportsTo() != null && checkUsernameAvailable(e.getReportsTo())) {
			throw new NonExistentManager();
		}

		int rval = 0;

		try (Connection con = ConnectionUtil.getConnection()) {
			String sql = "INSERT INTO EMPLOYEE(USERNAME,PWD,FIRSTNAME,LASTNAME,EMAIL,REPORTSTO,IS_ACTIVE) VALUES(?,?,?,?,?,?,?)";
			PreparedStatement stmt = con.prepareStatement(sql);
			stmt.setString(1, e.getUsername());
			stmt.setString(2, e.getPwd());
			stmt.setString(3, e.getFirstName());
			stmt.setString(4, e.getLastName());
			stmt.setString(5, e.getEmail());
			stmt.setString(6, e.getReportsTo());
			stmt.setInt(7, (e.isActive()) ? 1 : 0);

			rval = stmt.executeUpdate();
		}
		return rval;
	}

	@Override
	public Employee getEmployee(String username) throws SQLException, IOException {
		Employee e = null;

		try (Connection con = ConnectionUtil.getConnection()) {
			String sql = "SELECT * FROM EMPLOYEE WHERE USERNAME = ?";
			PreparedStatement stmt = con.prepareStatement(sql);
			stmt.setString(1, username);

			ResultSet rs = stmt.executeQuery();

			if (rs.next()) {
				// Username does not need to be accessed from the rs
				// If there is an element that has username, then it is unique
				// String username = rs.getString("USERNAME");
				String pwd = rs.getString("PWD");
				String firstName = rs.getString("FIRSTNAME");
				String lastName = rs.getString("LASTNAME");
				String email = rs.getString("EMAIL");
				String reportsTo = rs.getString("REPORTSTO");
				boolean isActive = rs.getInt("IS_ACTIVE") == 1;

				e = new Employee(username, pwd, firstName, lastName, email, reportsTo, isActive);
			}
		}
		return e;
	}

	@Override
	public int updateEmployee(Employee e) throws SQLException, IOException, NonExistentManager {
		// Verifies that if there is a manager that is being added to the employee
		// that is an actual element in the table
		if (e.getReportsTo() != null && checkUsernameAvailable(e.getReportsTo())) {
			throw new NonExistentManager();
		}

		int rval = 0;
		try (Connection con = ConnectionUtil.getConnection()) {
			// Updates all aspects of the employee
			String sql = "UPDATE EMPLOYEE SET PWD = ?, FIRSTNAME = ?, LASTNAME = ?, EMAIL = ?, REPORTSTO = ?, IS_ACTIVE = ? WHERE USERNAME = ?";
			PreparedStatement stmt = con.prepareStatement(sql);
			stmt.setString(1, e.getPwd());
			stmt.setString(2, e.getFirstName());
			stmt.setString(3, e.getLastName());
			stmt.setString(4, e.getEmail());
			stmt.setString(5, e.getReportsTo());
			stmt.setInt(6, (e.isActive()) ? 1 : 0);
			stmt.setString(7, e.getUsername());

			rval = stmt.executeUpdate();
		}
		return rval;
	}

	@Override
	public List<Employee> getAllEmployees() throws SQLException, IOException {
		// Gets a list of all employees
		List<Employee> empList = new ArrayList<Employee>();

		try (Connection con = ConnectionUtil.getConnection()) {
			ResultSet rs = con.prepareStatement("SELECT * FROM EMPLOYEE").executeQuery();

			while (rs.next()) {
				String username = rs.getString("USERNAME");
				String pwd = rs.getString("PWD");
				String firstName = rs.getString("FIRSTNAME");
				String lastName = rs.getString("LASTNAME");
				String email = rs.getString("EMAIL");
				String reportsTo = rs.getString("REPORTSTO");
				boolean isActive = rs.getInt("IS_ACTIVE") == 1;

				empList.add(new Employee(username, pwd, firstName, lastName, email, reportsTo, isActive));
			}
		}
		return empList;
	}

	@Override
	public boolean isManager(Employee e) throws SQLException, IOException, NonExistentEmployee {
		// Verify that e is a valid employee
		if (e.getUsername() == null || checkUsernameAvailable(e.getUsername())) {
			throw new NonExistentEmployee();
		}

		// Query whether there employees that report to e
		boolean rval = false;
		try (Connection con = ConnectionUtil.getConnection()) {
			String sql = "SELECT * FROM EMPLOYEE WHERE REPORTSTO = ?";
			PreparedStatement stmt = con.prepareStatement(sql);
			stmt.setString(1, e.getUsername());

			ResultSet rs = stmt.executeQuery();

			if (rs.next()) {
				rval = true;
			}
		}
		return rval;
	}

	@Override
	public List<Employee> getSubEmployees(Employee e) throws SQLException, IOException {
		if (getEmployee(e.getUsername()) == null) {
			return null;
		}

		List<Employee> empList = getAllEmployees();

		if (empList == null) {
			return null;
		}

		if (e.getReportsTo() == null) {
			return empList;
		}

		List<Employee> rList = new ArrayList<Employee>();

		// Add manager to list as first element
		rList.add(e);

		// Iterate through list, adding all employees from empList that report to member
		// of rList
		for (int i = 0; i < rList.size(); i++) {
			Employee cur = rList.get(i);
			for (int j = 0; j < empList.size(); j++) {

				Employee in = empList.get(j);
				if (cur.getUsername().equals(in.getReportsTo())) {
					rList.add(in);
				}
			}
		}

		// Remove initial manager from list
		rList.remove(e);

		return rList;
	}

	@Override
	public boolean isSubEmployee(Employee manager, Employee e) throws SQLException, IOException {
		if (e.getReportsTo() == null) {
			return false;
		} else if (e.getReportsTo().equals(manager.getUsername())) {
			return true;
		} else {
			return isSubEmployee(manager, getEmployee(e.getReportsTo()));
		}
	}

	public static void main(String args[]) throws SQLException, IOException, UsernameTaken, NonExistentManager {
		EmployeeDao empDao = new EmployeeDaoImpl();
		for ( int i = 0; i < 20; i++ ) {
			empDao.createEmployee(new Employee(String.valueOf(i), null, "THOMAS", "JANSEN", "EMAIL", "ADMIN", true));
		}
	}
}
