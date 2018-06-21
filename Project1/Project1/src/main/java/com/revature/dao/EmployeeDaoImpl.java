package com.revature.dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.revature.pojos.Employee;
import com.revature.pojos.Reimbursement;
import com.revature.util.ConnectionUtil;

public class EmployeeDaoImpl implements EmployeeDao {

	@Override
	public Employee getEmployee(String email, String password) {
		Employee employee = null;
		try {
			Connection con = ConnectionUtil.getConnection();
			String sql = "SELECT * FROM EMPLOYEE WHERE EMAIL=? AND EMPLOYEE_PASSWORD=?";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, email);
			ps.setString(2, password);
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				employee = new Employee(email, password);
				System.out.println("Successfully logged in.");
			}
			
			if(employee == null)
				System.out.println("Invalid username/password combination. Please try again");
			
			con.close();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return employee;
	}

	@Override
	public int createEmployee(String email, String password) {
		int employeeCreated = 0;

		try {
			Connection con = ConnectionUtil.getConnection();
			String sql = "INSERT INTO EMPLOYEE (EMAIL, EMPLOYEE_PASSWORD) VALUES(?,?)";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, email);
			ps.setString(2, password);
			employeeCreated = ps.executeUpdate();
			con.close();
		} catch (IOException e) {
			e.printStackTrace();
		}  catch (SQLException e) {
			e.printStackTrace();
		}
		return employeeCreated;
	}

	@Override
	public int updatePassword(String email, String password) {
		int employeeUpdated = 0;
		
		try {
			Connection con = ConnectionUtil.getConnection();
			String sql = "UPDATE EMPLOYEE SET EMPLOYEE_PASSWORD=? WHERE EMAIL=?";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, password);
			ps.setString(2, email);
			employeeUpdated = ps.executeUpdate();
			con.close();
		} catch (IOException e) {
			e.printStackTrace();
		}  catch (SQLException e) {
			e.printStackTrace();
		}
		return employeeUpdated;
	}

	@Override
	public Employee getEmployee(String email) {
		Employee employee = null;
		try {
			Connection con = ConnectionUtil.getConnection();
			String sql = "SELECT * FROM EMPLOYEE WHERE EMAIL=?";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, email);
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				String firstName = rs.getString("FIRST_NAME");
				String lastName = rs.getString("LAST_NAME");
				String phone = rs.getString("PHONE");
				String streetAddress = rs.getString("STREET_ADDRESS");
				String city = rs.getString("CITY");
				String state = rs.getString("STATE");
				String zipcode = rs.getString("ZIP_CODE");
				employee = new Employee(email, firstName, lastName, phone, streetAddress, city, state, zipcode);
			}
			
			if(employee == null)
				System.out.println("Invalid username/password combination. Please try again");
			
			con.close();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return employee;
	}

	@Override
	public int updateEmplyee(String email, String firstName, String lastName, String phone, String streetAddress,
			String city, String state, String zipCode) {
		int employeeUpdated = 0;
		Employee employee = getEmployee(email);
		if(firstName.equals(""))
			firstName = employee.getFirstName();
		if(lastName.equals(""))
			lastName = employee.getLastName();
		if(phone.equals(""))
			phone = employee.getPhone();
		if(streetAddress.equals(""))
			streetAddress = employee.getStreetAddress();
		if(city.equals(""))
			city = employee.getCity();
		if(state.equals(""))
			state = employee.getState();
		if(zipCode.equals(""))
			zipCode = employee.getZipcode();

		try {
			Connection con = ConnectionUtil.getConnection();
			String sql = "UPDATE EMPLOYEE SET FIRST_NAME=?, LAST_NAME=?, PHONE=?, STREET_ADDRESS=?, CITY=?, STATE=?, ZIP_CODE=? WHERE EMAIL=?";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, firstName);
			ps.setString(2, lastName);
			ps.setString(3, phone);
			ps.setString(4, streetAddress);
			ps.setString(5, city);
			ps.setString(6, state);
			ps.setString(7, zipCode);
			ps.setString(8, email);
			employeeUpdated = ps.executeUpdate();
			con.close();
		} catch (IOException e) {
			e.printStackTrace();
		}  catch (SQLException e) {
			e.printStackTrace();
		}
		return employeeUpdated;
	}

	@Override
	public ArrayList<Employee> getEmployees() {
		ArrayList<Employee> employees = new ArrayList<>();
		try {
			Connection con = ConnectionUtil.getConnection();		
			String sql = "SELECT * FROM EMPLOYEE";
			PreparedStatement ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				String email = rs.getString("EMAIL");
				String firstName = rs.getString("FIRST_NAME");
				String lastName = rs.getString("LAST_NAME");
				String phone = rs.getString("PHONE");
				String streetAddress = rs.getString("STREET_ADDRESS");
				String city = rs.getString("CITY");
				String state = rs.getString("STATE");
				String zipcode = rs.getString("ZIP_CODE");
				employees.add(new Employee(email, firstName, lastName, phone, streetAddress, city, state, zipcode));
			}
		} catch (IOException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return employees;
	}

}
