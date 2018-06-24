package com.revature.dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.revature.pojos.Employee;
import com.revature.utils.ConnectionUtils;

public class EmployeeDaoImpl implements EmployeeDAO {

	@Override
	public Employee getEmployeeByUsername(String username) {
		Employee employee = null;

		try {
			Connection connection = ConnectionUtils.getConnection();
			String sql = "SELECT * FROM EMPLOYEE WHERE username = ?";
			PreparedStatement statement = connection.prepareStatement(sql);
			statement.setString(1, username);
			ResultSet rSet = statement.executeQuery();
			while(rSet.next()) {
				int empID = rSet.getInt("EMPLOYEE_ID");
				String empName = rSet.getString("EMP_NAME");
				String user = rSet.getString("USERNAME");
				String pass = rSet.getString("PWORD");
				int manager = rSet.getInt("MANAGER_ID");
				boolean isMan = rSet.getInt("MANAGER_FLAG")==1?true:false;
				employee = new Employee(empID,manager,empName,user,pass,isMan);
			}
			connection.close();
		} catch (IOException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return employee;
	}

	@Override
	public List<Employee> getAllEmployeesByManager(int managerId) {
		List<Employee> employees = new ArrayList<>();
		try {
			Connection connection = ConnectionUtils.getConnection();
			String sql = "Select * from Employee where MANAGER_ID=?";
			PreparedStatement statement = connection.prepareStatement(sql);
			statement.setInt(1, managerId);
			ResultSet rSet = statement.executeQuery(sql);
			while(rSet.next()) {
				int empID = rSet.getInt("EMP_ID");
				String empName = rSet.getString("EMP_NAME");
				int status = rSet.getInt("STATUS");
				String user = rSet.getString("USERNAME");
				String pass = rSet.getString("PWORD");
				int manager = rSet.getInt("MANAGER_ID");
				boolean isMan = rSet.getInt("MANAGER_FLAG")==1?true:false;
				employees.add(new Employee(empID,manager,empName,user,pass,isMan));
			}
			connection.close();
		} catch (IOException | SQLException e) {
			e.printStackTrace();
		}
		return employees;
	}

	@Override
	public int updateEmployee(Employee emp) {
		int requestUpdates = 0;
		try {
			Connection connection = ConnectionUtils.getConnection();
			connection.setAutoCommit(false);
			String sql = "update EMPLOYEE set EMP_NAME=?, USERNAME=?, PWORD=? where EMPLOYEE_ID=?";
			PreparedStatement pStatement = connection.prepareStatement(sql);
			pStatement.setString(1, emp.getName());
			pStatement.setString(2, emp.getUsername());
			pStatement.setString(3, emp.getPassword());
			pStatement.setInt(4, emp.getEmployeeId());
			requestUpdates = pStatement.executeUpdate();
			connection.commit();
			connection.close();
		} catch (IOException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return requestUpdates;
	}

	@Override
	public int createEmployee(Employee emp) {
		int empCreated = 0;
		
		try {
			Connection connection = ConnectionUtils.getConnection();
			String sql = "INSERT INTO EMPLOYEE (EMP_NAME,USERNAME,PWORD,MANAGER_ID,MANAGER_FLAG) VALUES(?,?,?,?,?)";
			PreparedStatement pStatement = connection.prepareStatement(sql);
			pStatement.setString(1, emp.getName());
			pStatement.setString(2, emp.getUsername());
			pStatement.setString(3, emp.getPassword());
			pStatement.setInt(4, emp.getManagerId());
			pStatement.setInt(5, emp.isManager()?1:0);
			empCreated = pStatement.executeUpdate();
			connection.close();
		} catch (IOException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return empCreated;
	}

	@Override
	public int deleteEmployee(Employee emp) {
		// TODO Auto-generated method stub
		return 0;
	}

}
