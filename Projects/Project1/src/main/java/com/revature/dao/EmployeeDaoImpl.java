package com.revature.dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.sql.Date;
import java.util.List;

import com.revature.pojos.Employee;
import com.revature.util.ConnectionUtil;

public class EmployeeDaoImpl implements EmployeeDao
{

	@Override
	public List<Employee> getEmployees()
	{
		List<Employee> employees = new ArrayList<>();
		try
		{
			Connection con = ConnectionUtil.getConnection();
			String sql = "SELECT * FROM EMPLOYEE";
			Statement s = con.createStatement();
			ResultSet rs = s.executeQuery(sql);
			
			while(rs.next())
			{
				int empId = rs.getInt("EMP_ID");
				String empName = rs.getString("EMP_NAME");
				String userName = rs.getString("USER_NAME");
				String userPass = rs.getString("USER_PASS");
				int reportTo = rs.getInt("REPORT_TO");
				Date birthDate = rs.getDate("BIRTH_DATE");
				String url = rs.getString("URL");
				employees.add(new Employee(empId, empName, userName, userPass, reportTo, birthDate, url));
			}
			con.close();
			
		} catch (IOException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return employees;
	}

	@Override
	public Employee getEmployeeById(int id)
	{
		Employee employee = null;
		try {
			Connection con = ConnectionUtil.getConnection();
			String sql = "SELECT * FROM EMPLOYEE WHERE EMP_ID = ?";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();	
			while(rs.next()) {
				int empId = rs.getInt("EMP_ID");
				String empName = rs.getString("EMP_NAME");
				String userName = rs.getString("USER_NAME");
				String userPass = rs.getString("USER_PASS");
				int reportTo = rs.getInt("REPORT_TO");
				Date birthDate = rs.getDate("BIRTH_DATE");
				String url = rs.getString("URL");	
				employee = new Employee(empId, empName, userName, userPass, reportTo, birthDate, url);		
			}		
			con.close();

		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}	
		return employee;
	}
	@Override
	public void createEmployee(Employee newEmployee)
	{
		
		try {
			Connection con = ConnectionUtil.getConnection();
			String sql = "INSERT INTO EMPLOYEE (EMP_NAME, USER_NAME, USER_PASS, REPORT_TO, BIRTH_DATE, URL) VALUES (?,?,?,?,?,?)";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, newEmployee.getEmpName());
			ps.setString(2, newEmployee.getUserName());
			ps.setString(3, newEmployee.getUserPass());
			ps.setInt(4, newEmployee.getReportTo());
			ps.setDate(5, newEmployee.getBirthDate());
			ps.setString(6, newEmployee.getUrl());
			ps.executeUpdate();
			
			con.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}


	@Override
	public Boolean isAuthenticated(String newName, String newPassword) {
		try {
			Connection con = ConnectionUtil.getConnection();
			String sql = "SELECT * FROM EMPLOYEE WHERE USER_NAME = ? AND USER_PASS = ? ";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, newName);
			ps.setString(2, newPassword);
			ResultSet rs = ps.executeQuery();
		
			if(rs.next()) {
				return true;
			}else
			{
				return false;
			}
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		return false;
	}

	@Override
	public void updateEmployee(Employee newEmployee)
	{
		String sql = "UPDATE EMPLOYEE "
				+ "SET EMP_NAME = ?, "
				+ "USER_NAME = ?, "
				+ "USER_PASS = ?, "
				+ "REPORT_TO = ?, "
				+ "BIRTH_DATE = ?, "
				+ "URL = ? "
				+ "WHERE EMP_ID = ?";
		try {
			Connection con = ConnectionUtil.getConnection();
			con.setAutoCommit(false);
			PreparedStatement ps = con.prepareStatement(sql);

			ps.setString(1, newEmployee.getEmpName());
			ps.setString(2, newEmployee.getUserName());
			ps.setString(3, newEmployee.getUserPass());
			ps.setInt(4, newEmployee.getReportTo());
			ps.setDate(5, newEmployee.getBirthDate());
			ps.setString(6, newEmployee.getUrl());
			ps.setInt(7, newEmployee.getEmpId());
			
			ps.executeUpdate();
			con.commit();
			con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public void deleteEmployeeById(int id)
	{
		String sql = "DELETE FROM EMPLOYEE WHERE EMP_ID = ?";
		
		try 
		{
			Connection con = ConnectionUtil.getConnection();
			con.setAutoCommit(false);
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, id);	
			ps.executeUpdate();
			con.commit();
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public Employee getEmployeeByName(String name) {
		Employee employee = null;
		
		try {
			Connection con = ConnectionUtil.getConnection();
			String sql = "SELECT * FROM EMPLOYEE WHERE EMP_NAME = ?";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, name);
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				
				int empId = rs.getInt("EMP_ID");
				String empName = rs.getString("EMP_NAME");
				String userName = rs.getString("USER_NAME");
				String userPass = rs.getString("USER_PASS");
				int reportTo = rs.getInt("REPORT_TO");
				Date birthDate = rs.getDate("BIRTH_DATE");
				String url = rs.getString("URL");
				employee =new Employee(empId, empName, userName, userPass, reportTo, birthDate, url);
						
			}
			
			con.close();

		} catch (IOException e1) {
			
			e1.printStackTrace();
		} catch (SQLException e1) {
			
			e1.printStackTrace();
		}
		return employee;
	}

	@Override
	public ArrayList<Integer> getEmployeesUnderManager(List<Employee> employees, int managerId)
	{
		ArrayList<Integer> result =new ArrayList<>();
		
		for(int i=0; i<employees.size(); i++)
		{
			if(employees.get(i).getReportTo()==managerId)
				result.add(i+1);
		}
		
		return result;
	}
	
}
