package com.revature.dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.revature.pojo.Employee;
import com.revature.util.ConnectionUtil;

public class EmployeeDaoImpl implements EmployeeDao {

	@Override
	public List<Employee> getEmployees() {
		List<Employee> employeeList = new ArrayList<Employee>();
		// TODO Auto-generated method stub
		try {
			Connection con = ConnectionUtil.getConnection();
			String sql = "SELECT * FROM EMPLOYEE";
			Statement s = con.createStatement();
			ResultSet rs = s.executeQuery(sql);
		} catch (IOException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
	}

	@Override
	public Employee getEMployeeById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int createEmployee(Employee employee) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int updateEmployee(Employee employee) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int deleteEmployeeById(int id) {
		// TODO Auto-generated method stub
		return 0;
	}

}
