package com.revature.dao;

import java.io.IOException;
import java.sql.Connection;
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
			Statement statement = con.createStatement();
			ResultSet rs = statement.executeQuery(sql);
			
			while (rs.next()) {
				int employeeId = rs.getInt("emp_id");
				String firstname = rs.getString("first_name");
				String lastname = rs.getString("last_name");
				int reportsto = rs.getInt("reports_to");
				String email = rs.getString("email");
				String phone = rs.getString("phone");
				String username = rs.getString("emp_username");
				String password = rs.getString("emp_password");
				
				employeeList.add(new Employee(employeeId, firstname, lastname, reportsto, email, phone, username, password));
			}
			
			con.close();
			
		} catch (IOException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return employeeList;
	}

	public Employee getEmployeeById(int id) {
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

	public int deleteEmployeeById(int id) {
		// TODO Auto-generated method stub
		return 0;
	}

}
