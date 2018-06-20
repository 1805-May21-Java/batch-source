package com.revature.htulipan.Project1.test;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.revature.htulipan.Project1.daos.EmployeeDaoImpl;
import com.revature.htulipan.Project1.daos.RequestDaoImpl;
import com.revature.htulipan.Project1.pojos.Employee;
import com.revature.htulipan.Project1.pojos.Request;
import com.revature.htulipan.Project1.util.ConnectionUtil;

public class TestingDriver {
	public static void main(String[] args) {
		
		/**
		 * The below try block is just to ensure I have a working connection to my 
		 * database via the Connection and supplied connection.properties file.
		 */
//		try {
//			Connection con = ConnectionUtil.getConnection();
//			PreparedStatement ps = con.prepareStatement("SELECT REQUESTID FROM REQUEST");
//			ResultSet rs = ps.executeQuery();
//			while (rs.next()) {
//				System.out.println(rs.getInt("REQUESTID"));
//			}
//		} catch (SQLException e) {
//			System.out.println(e.getMessage());
//			e.printStackTrace();
//		} catch (IOException e) {
//			System.out.println(e.getMessage());
//			e.printStackTrace();
//		}
		
		/**
		 * The below tries to execute a callable statement "CheckCredentials" and 
		 * returns the employeeid of the matching credentials, or 0 if there
		 * was no match.
		 */
//		EmployeeDaoImpl edi = new EmployeeDaoImpl();
//		String un = "horrissl";
//		String pw = "password";
//		int eid = edi.checkLoginCredentials(un, pw);
//		
//		System.out.println(eid);
		
		/**
		 * The below tries to fetch the information for a known employee (eid is 2) and instantiate an Employee POJO.
		 */
		
//		EmployeeDaoImpl edi = new EmployeeDaoImpl();
//		int eid = 2;
//		Employee result = edi.getEmployeeById(eid);
//		System.out.println(result);
		/*
		 * The result was Employee [username=dduckering1, firstname=Daisie, lastname=Duckering, 
		 * 	dob=1993-07-23, phone=7405814455, email=dduckering1@booking.com, manager=false, employeeid=2]
		 */
		
		/**
		 * The below tries to update the newly gotten Employee's name and email.
		 */
		
//		result.setFirstname("Diana");
//		result.setEmail("dduckering@banking.com");
//		int num = edi.updateEmployee(result);
//		System.out.println(num);
//		System.out.println();
		
		/**
		 * The result was a return value of 1, indicating 1 row was changed. Examining the Table in SQL developer
		 * confirms that Daisie's name was changed to Diana, and her email changed to banking.com.
		 */
		
		/**
		 * The below tries to get all info for all employees. 
		 */
//		ArrayList<Employee> allResults = edi.getAllEmployees();
//		int count = 0;
//		for (Employee e : allResults) {
//			count++;
//			System.out.println(e.getUsername());
//		}
//		System.out.println(count);
		
		/**
		 * And it returned all 50 Employees
		 */
		
		/*
		 * Get one request by its id.
		 */
		RequestDaoImpl rdi = new RequestDaoImpl();
		
//		Request test = rdi.getRequestById(3);
//		System.out.println(test);
		
		/*
		 * Get all requests.
		 */
//		ArrayList<Request> results = rdi.getAllRequests();
//		int count = 0;
//		for (Request r : results) {
//			count++;
//			System.out.println(r);
//		}
		
		/*
		 * Get all by employee id.
		 */
//		ArrayList<Request> results = rdi.getRequestsByEmployeeId(7);
//		int count = 0;
//		for (Request r : results) {
//			count++;
//			System.out.println(r);
//		}
		/*
		 * Get all by manager id.
		 */
//		ArrayList<Request> results = rdi.getRequestsByManagerId(2);
//		int count = 0;
//		for (Request r : results) {
//			count++;
//			System.out.println(r);
//		}
		/*
		 * Get all by status.
		 */
//		ArrayList<Request> results = rdi.getRequestsByStatus(0);
//		int count = 0;
//		for (Request r : results) {
//			count++;
//			System.out.println(r);
//		}
//		System.out.println(count);
	}
	
}
