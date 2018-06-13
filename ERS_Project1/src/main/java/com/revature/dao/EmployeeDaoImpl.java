package com.revature.dao;

import java.io.IOException;

import java.sql.*;
import java.util.*;

import com.revature.pojos.Employee;
import com.revature.utils.ConnectionUtil;

public class EmployeeDaoImpl implements EmployeeDao {

	public List<Employee> getEmployees() {
		List<Employee> employeeList = new ArrayList<Employee>();
		
		try {
			Connection conn = ConnectionUtil.getConnection();
			
			String sql = "SELECT * FROM ERS_EMPLOYEE";
			PreparedStatement s = conn.prepareStatement(sql);
			ResultSet rs = s.executeQuery();
			while(rs.next()) {
				int id = rs.getInt("EMPL_ID");
				String firstName = rs.getString("FIRSTNAME");
				String lastName = rs.getString("LASTNAME");
				String email = rs.getString("EMAIL");
				String password = rs.getString("PWD");
				int managerId = rs.getInt("MANAGER_ID");
				
				employeeList.add(new Employee(id, firstName, lastName, email, password, managerId));
				
			}
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return employeeList;
	}

	public Employee getEmployeeById(int emplId) {
		// TODO Auto-generated method stub
		return null;
	}

	public int createEmployee(Employee employee) {
		// TODO Auto-generated method stub
		return 0;
	}

	public int updateEmployee(Employee employee) {
		// TODO Auto-generated method stub
		return 0;
	}

	public int removeEmployee(int emplId) {
		// TODO Auto-generated method stub
		return 0;
	}

}
