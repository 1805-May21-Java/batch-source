package com.adora.access;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.sql.ResultSet;

import com.adora.pojos.Credential;
import com.adora.pojos.Employee;
import com.adora.utils.ConnectionUtil;

public class EmployeeDaoImpl implements EmployeeDao {

	@Override
	public List<Employee> getEmployees() {
		List<Employee> employeeList = new ArrayList();
		
		try(Connection connection = ConnectionUtil.getConnection()) {
			String sql = "SELECT * FROM employee";
			PreparedStatement ps = connection.prepareStatement(sql);
			ResultSet results = ps.executeQuery();
			while(results.next()) {
				Employee employee = new Employee();
				employee.setEmployeeId(results.getInt("employee_id"));
				employee.setFirstName(results.getString("first_name"));
				employee.setLastName(results.getString("last_name"));
				employee.setManagerId(results.getInt("manager_id"));
				employee.setRoleId(results.getInt("role_id"));
				employee.setEmailAddress(results.getString("email_address"));
				
				employeeList.add(employee);
			}
			
		} catch (SQLException | IOException e) {
			e.printStackTrace();
		}
		
		return employeeList;
	}
	
	@Override
	public Employee getEmployeeById(int employeeId) {
		Employee employee = new Employee();
		
		try(Connection connection = ConnectionUtil.getConnection()) {
			String sql = "SELECT * FROM employee WHERE employee_id = ?";
			PreparedStatement ps = connection.prepareStatement(sql);
			ps.setInt(1, employeeId);
			
			ResultSet results = ps.executeQuery();
			
			while(results.next()) {
				employee.setEmployeeId(results.getInt("employee_id"));
				employee.setFirstName(results.getString("first_name"));
				employee.setLastName(results.getString("last_name"));
				employee.setManagerId(results.getInt("manager_id"));
				employee.setRoleId(results.getInt("role_id"));
				employee.setEmailAddress(results.getString("email_address"));
				
				System.out.println(employee.toString());
			}
			
		} catch (SQLException | IOException e) {
			e.printStackTrace();
		}
		
		return employee;
	}

	

	

}
