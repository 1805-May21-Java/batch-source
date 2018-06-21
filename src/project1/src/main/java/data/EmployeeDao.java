package data;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import interfaces.EmployeeInterface;
import util.ConnectionUtil;

public class EmployeeDao implements EmployeeInterface{
	private String createEmployee = "INSERT INTO EMPLOYEE (employeeId, reportsTo, employeeName, password, userName) values (SEQ_PK_EMPLOYEEID.nextval, ?, ?, ?, ?)";
	private String createManager = "INSERT INTO EMPLOYEE (employeeId, employeeName, password, userName) values (SEQ_PK_EMPLOYEEID.nextval, ?, ?, ?)";
	private String checkEmployee = "SELECT * FROM EMPLOYEE where username = ?";
	private String getEmployeeById = "SELECT * FROM EMPLOYEE where employeeId = ?";
	private String getEmployeeByUsername = "SELECT * FROM EMPLOYEE where username = ?";
	private String updatePassword = "UPDATE EMPLOYEE SET password = ? WHERE employeeId = ?";
	private String updateUsername = "UPDATE EMPLOYEE SET username = ? WHERE employeeId = ?";
	private String getManagers = "SELECT * FROM EMPLOYEE WHERE reportsTo = 0";
	private String updateEmployee = "UPDATE EMPLOYEE SET password = ?, username = ?, employeeName = ? WHERE employeeId = ?";
	
	public long createEmployee(Connection connection, long reportsTo, String employeeName, String password, String username) throws SQLException {
		PreparedStatement ps = connection.prepareStatement(createEmployee, new String[] {"employeeId"});
		ps.setLong(1, reportsTo);
		ps.setString(2, employeeName);
		ps.setString(3, password);
		ps.setString(4, username);
		ps.executeUpdate();
		ps.getGeneratedKeys().next();
		return ps.getGeneratedKeys().getLong(1);
	}

	public long createEmployee(Connection connection, String employeeName, String password,
			String username) throws SQLException {
		PreparedStatement ps = connection.prepareStatement(createManager, new String[] {"employeeId"});
		ps.setString(1, employeeName);
		ps.setString(2, password);
		ps.setString(3, username);
		ps.executeUpdate();
		ps.getGeneratedKeys().next();
		return ps.getGeneratedKeys().getLong(1);
	}

	public boolean checkEmployee(Connection connection, String username) throws SQLException {
		PreparedStatement ps = connection.prepareStatement(checkEmployee, new String[] {"USERNAME"});
		ps.setString(1, username);
		ResultSet rs = ps.executeQuery();
		if(rs != null && rs.next()) {
			return true;
		} else return false;
	}

	public Employee getEmployeeById(Connection connection, long employeeId) throws SQLException {
		Employee employee = null;
		PreparedStatement ps = connection.prepareStatement(getEmployeeById);
		ps.setLong(1, employeeId);
		ResultSet rs = ps.executeQuery();
		while(rs.next()){
			employee = new Employee(rs.getLong("employeeId"), rs.getLong("reportsTo"), rs.getString("employeeName"), rs.getString("password"), rs.getString("username"));
		}
		return employee;
	}

	public Employee getEmployeeByName(Connection connection, String username) throws SQLException {
		Employee employee = null;
		PreparedStatement ps = connection.prepareStatement(getEmployeeByUsername);
		ps.setString(1, username);
		ResultSet rs = ps.executeQuery();
		while(rs.next()){
			employee = new Employee(rs.getLong("employeeId"), rs.getLong("reportsTo"), rs.getString("employeeName"), rs.getString("password"), rs.getString("username"));
		}
		return employee;
	}

	public void updateEmployeePassword(Connection connection, long employeeId, String newPassword) throws SQLException {
		PreparedStatement ps = connection.prepareStatement(updatePassword);
		ps.setString(1, newPassword);
		ps.setLong(2, employeeId);
		ps.executeUpdate();
	}

	public ArrayList<Employee> getAllEmployee(Connection connection) throws SQLException {
		ArrayList<Employee> employeeList = new ArrayList();
		PreparedStatement ps = connection.prepareStatement("SELECT * FROM EMPLOYEE");
		ResultSet rs = ps.executeQuery();
		while(rs.next()){
			employeeList.add(new Employee(rs.getLong("employeeId"), rs.getLong("reportsTo"), rs.getString("employeeName"), rs.getString("password"), rs.getString("username")));
		}
		return employeeList;
	}

	@Override
	public void updateEmployeeUsername(Connection connection, long employeeId, String username) throws SQLException {
		PreparedStatement ps = connection.prepareStatement(updateUsername);
		ps.setString(1, username);
		ps.setLong(2, employeeId);
		ps.executeUpdate();
		
	}

	@Override
	public ArrayList<Employee> getAllSubordinates(Connection connection) throws SQLException {
		ArrayList<Employee> employeeList = new ArrayList();
		PreparedStatement ps = connection.prepareStatement(getManagers);
		ResultSet rs = ps.executeQuery();
		while(rs.next()){
			employeeList.add(new Employee(rs.getLong("employeeId"), rs.getString("employeeName"), rs.getString("password"), rs.getString("username")));
		}
		return employeeList;
	}

	@Override
	public void updateEmployee(Connection connection, long employeeId, String username, String newPassword,
			String name) throws SQLException {
		PreparedStatement ps = connection.prepareStatement(updateEmployee);
		ps.setString(1, newPassword);
		ps.setString(2, username);
		ps.setString(3, name);
		ps.setLong(4, employeeId);
		ps.executeUpdate();
		
	}
	
}
