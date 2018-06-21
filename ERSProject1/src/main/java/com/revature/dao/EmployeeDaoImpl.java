package com.revature.dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.revature.pojos.Employee;
import com.revature.util.ConnectionUtil;

public class EmployeeDaoImpl implements EmployeeDao {

	public List<Employee> getEmployees() {
		List<Employee> employeeList = new ArrayList<Employee>();
		
		try {
			Connection con = ConnectionUtil.getConnection();
			String sql = "SELECT * FROM employee";
			PreparedStatement pStatement = con.prepareStatement(sql);
			ResultSet rs = pStatement.executeQuery();
//			Statement statement = con.createStatement(); //TODO: convert to PreparedStatement?
//			ResultSet rs = statement.executeQuery(sql);
			
			while (rs.next()) {
				int employeeId = rs.getInt("emp_id");
				String firstname = rs.getString("first_name");
				String lastname = rs.getString("last_name");
				int reportsto = rs.getInt("reports_to");
				String email = rs.getString("email");
				String username = rs.getString("emp_username");
				String password = rs.getString("emp_password");
				
				employeeList.add(new Employee(employeeId, firstname, lastname, reportsto, email, username, password));
			}
			
			con.close();
			
		} catch (IOException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return employeeList;
	}
	
	
	public Employee getEmployeeByUsername(String user) {
		Employee employee = null;
		try {
			Connection connection = ConnectionUtil.getConnection();
			String sql = "SELECT * FROM EMPLOYEE WHERE emp_username = ?";
			PreparedStatement pStatement = connection.prepareStatement(sql);
			pStatement.setString(1, user);
			ResultSet rSet = pStatement.executeQuery();
			
			while (rSet.next()) {
				int employeeId = rSet.getInt("emp_id");
				String firstname = rSet.getString("first_name");
				String lastname = rSet.getString("last_name");
				int reportsto = rSet.getInt("reports_to");
				String email = rSet.getString("email");
				String username = rSet.getString("emp_username");
				String password = rSet.getString("emp_password");
				
				employee = new Employee(employeeId, firstname, lastname, reportsto, email, username, password);
			}
			
			connection.close();
			
		} catch (IOException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return employee;
	}

	
	public Employee getEmployeeById(int id) {
		Employee employee = null;
		try {
			Connection connection = ConnectionUtil.getConnection();
			String sql = "SELECT * FROM EMPLOYEE WHERE emp_id = ?";
			PreparedStatement pStatement = connection.prepareStatement(sql);
			pStatement.setInt(1, id);
			ResultSet rSet = pStatement.executeQuery();
			
			while (rSet.next()) {
				int employeeId = rSet.getInt("emp_id");
				String firstname = rSet.getString("first_name");
				String lastname = rSet.getString("last_name");
				int reportsto = rSet.getInt("reports_to");
				String email = rSet.getString("email");
				String username = rSet.getString("emp_username");
				String password = rSet.getString("emp_password");
				
				employee = new Employee(employeeId, firstname, lastname, reportsto, email, username, password);
			}
			
			connection.close();
			
		} catch (IOException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return employee;
	}
	
	
	// check if employee is a manager
	public boolean isEmployeeManager(Employee employee) {
		List<Employee> managerList = new ArrayList<Employee>();

		try {
			Connection connection = ConnectionUtil.getConnection();
			String sql = "SELECT DISTINCT e.emp_id, e.first_name, e.last_name, e.reports_to, e.email, e.emp_username, e.emp_password\n" + 
					"FROM employee e, employee m\n" + 
					"WHERE e.emp_id = m.reports_to";
			PreparedStatement pStatement = connection.prepareStatement(sql);
			ResultSet rSet = pStatement.executeQuery();
			
			while (rSet.next()) {
				int employeeId = rSet.getInt("emp_id");
				String firstname = rSet.getString("first_name");
				String lastname = rSet.getString("last_name");
				int reportsto = rSet.getInt("reports_to");
				String email = rSet.getString("email");
				String username = rSet.getString("emp_username");
				String password = rSet.getString("emp_password");
				
				managerList.add(new Employee(employeeId, firstname, lastname, reportsto, email, username, password));
			}
			
			connection.close();
			
		} catch (IOException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		for (Employee e : managerList) {
			if (employee.getId() == e.getId()) {
				return true;
			}
		}
		
		return false;
	}

	public void createEmployee(String firstname, String lastname, int reportsto, String email, String username,
			String password) {
		try {
			Connection connection = ConnectionUtil.getConnection();
			String sql = "INSERT INTO employee (first_name, last_name, email, reports_to, emp_username, emp_password)\n" +
						"VALUES (?, ?, ?, ?, ?, ?)";
			PreparedStatement pStatement = connection.prepareStatement(sql);
			pStatement.setString(1, firstname);
			pStatement.setString(2, lastname);
			pStatement.setString(3, email);
			pStatement.setInt(4, reportsto);
			pStatement.setString(5, username);
			pStatement.setString(6, password);
			pStatement.executeQuery();
			
			connection.close();
			
		} catch (IOException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public int deleteEmployeeById(int id) {
		// TODO Auto-generated method stub
		return 0;
	}


	public void updateEmployee(int id, String firstname, String lastname, String email, String username,
			String password) {
		try {
			Connection connection = ConnectionUtil.getConnection();
			String sql = "UPDATE employee SET first_name=?, last_name=?, email=?, emp_username=?, emp_password=?\n" +
						"WHERE emp_id=?";
			PreparedStatement pStatement = connection.prepareStatement(sql);
			pStatement.setString(1, firstname);
			pStatement.setString(2, lastname);
			pStatement.setString(3, email);
			pStatement.setString(4, username);
			pStatement.setString(5, password);
			pStatement.setInt(6, id);
			pStatement.executeQuery();
			
			connection.close();
			
		} catch (IOException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	// get employees and employees of employees
	public List<Employee> getAllSubordinates(int id) {
		List<Employee> employeeList = new ArrayList<Employee>();
		
		try {
			Connection con = ConnectionUtil.getConnection();
			String sql = "SELECT *\n" + 
					"FROM employee tier1\n" + 
					"WHERE reports_to=?\n" + 
					"OR EXISTS (SELECT *\n" + 
					"FROM employee tier2\n" + 
					"WHERE emp_id = tier1.reports_to\n" + 
					"AND (reports_to=?\n" + 
					"OR EXISTS (SELECT *\n" + 
					"FROM employee tier3\n" + 
					"WHERE emp_id = tier2.reports_to\n" + 
					"AND reports_to=?)));";
			PreparedStatement pStatement = con.prepareStatement(sql);
			pStatement.setInt(1, id);
			pStatement.setInt(2, id);
			pStatement.setInt(3, id);
			ResultSet rs = pStatement.executeQuery();
			
			while (rs.next()) {
				int employeeId = rs.getInt("emp_id");
				String firstname = rs.getString("first_name");
				String lastname = rs.getString("last_name");
				int reportsto = rs.getInt("reports_to");
				String email = rs.getString("email");
				String username = rs.getString("emp_username");
				String password = rs.getString("emp_password");
				
				employeeList.add(new Employee(employeeId, firstname, lastname, reportsto, email, username, password));
			}
			
			con.close();
			
		} catch (IOException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return employeeList;
	}




}
