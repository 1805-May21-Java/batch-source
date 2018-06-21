package com.revature.dao;

import java.io.*;
import java.sql.*;
import java.util.*;

import com.revature.pojos.Employee;
import com.revature.util.ConnectionUtil;

public class EmployeeDaoImpl implements EmployeeDao{
	
	public List<Employee> getEmployees() {
		List<Employee> employees = new ArrayList<Employee>();
		
		String sql = "SELECT * FROM P1_EMPLOYEE";
		
		try {
			Connection con = ConnectionUtil.getConnection();
			Statement s = con.createStatement();
			ResultSet rs = s.executeQuery(sql);
			while(rs.next()) {
				int empId = rs.getInt("EMP_ID");
				String username = rs.getString("USERNAME");
				String password = rs.getString("PASSWORD");
				String fName = rs.getString("FNAME");
				String lName = rs.getString("LNAME");
				String address = rs.getString("ADDRESS");
				String city = rs.getString("CITY");
				String state = rs.getString("STATE");
				String zipcode = rs.getString("ZIPCODE");
				int manager = rs.getInt("MANAGER");
				employees.add(new Employee(empId, username, password, fName, lName, address, city, state, zipcode, manager));
			}
			rs.close();
			con.close();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return employees;
	}
	
	public Employee getEmployeeByUsername(String user) {
		Employee c = null;
		
		try {
			Connection con = ConnectionUtil.getConnection();
			String sql = "SELECT * FROM P1_EMPLOYEE WHERE USERNAME = ?";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, user);
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				int empId = rs.getInt("EMP_ID");
				String username = rs.getString("USERNAME");
				String password = rs.getString("PASSWORD");
				String fName = rs.getString("FNAME");
				String lName = rs.getString("LNAME");
				String address = rs.getString("ADDRESS");
				String city = rs.getString("CITY");
				String state = rs.getString("STATE");
				String zipcode = rs.getString("ZIPCODE");
				int manager = rs.getInt("MANAGER");
				
				c = new Employee(empId, username, password, fName, lName, address, city, state, zipcode, manager);
			}
			rs.close();
			ps.close();
			con.close();

		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		return c;
	}
	public int createEmployee(Employee employee) {
		int employeeCreated = 0;
		
		try {
			Connection con = ConnectionUtil.getConnection();
			String sql = "INSERT INTO P1_EMPLOYEE (USERNAME, PASSWORD, FNAME, LNAME, ADDRESS, CITY, STATE, ZIPCODE, MANAGER) VALUES (?,?,?,?,?,?,?,?,?)";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, employee.getUsername());
			ps.setString(2, employee.getPassword());
			ps.setString(3, employee.getfName());
			ps.setString(4, employee.getlName());
			ps.setString(5, employee.getAddress());
			ps.setString(6, employee.getCity());
			ps.setString(7, employee.getState());
			ps.setString(8, employee.getZipcode());
			ps.setInt(9, employee.getManager());
			employeeCreated = ps.executeUpdate();
			ps.close();
			con.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return employeeCreated;
	}
	
	public int updateEmployee(String fName, String lName, String address, String city, String state, String zipcode, String username) {
		int employeesUpdated = 0;
		String sql = "UPDATE P1_EMPLOYEE SET FNAME = ?, LNAME = ?, ADDRESS = ?, CITY = ?, STATE = ?, ZIPCODE = ? WHERE USERNAME = ?";
		try {
			Connection con = ConnectionUtil.getConnection();
			con.setAutoCommit(false);
			PreparedStatement pstatement = con.prepareStatement(sql);
			pstatement.setString(1, fName);
			pstatement.setString(2, lName);
			pstatement.setString(3, address);
			pstatement.setString(4, city);
			pstatement.setString(5, state);
			pstatement.setString(6, zipcode);
			pstatement.setString(7, username);
			employeesUpdated = pstatement.executeUpdate();
			con.commit();
			con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return employeesUpdated;
		
	}
	
	public Employee getEmployeeById(int employeeId) {
		Employee c = null;
		
		try {
			Connection con = ConnectionUtil.getConnection();
			String sql = "SELECT * FROM P1_EMPLOYEE WHERE EMP_ID = ?";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, employeeId);
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				int empId = rs.getInt("EMP_ID");
				String username = rs.getString("USERNAME");
				String password = rs.getString("PASSWORD");
				String fName = rs.getString("FNAME");
				String lName = rs.getString("LNAME");
				String address = rs.getString("ADDRESS");
				String city = rs.getString("CITY");
				String state = rs.getString("STATE");
				String zipcode = rs.getString("ZIPCODE");
				int manager = rs.getInt("MANAGER");
				
				c = new Employee(empId, username, password, fName, lName, address, city, state, zipcode, manager);
			}
			rs.close();
			ps.close();
			con.close();

		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		return c;
	}

}
