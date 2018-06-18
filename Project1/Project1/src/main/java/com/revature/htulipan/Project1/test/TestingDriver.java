package com.revature.htulipan.Project1.test;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.revature.htulipan.Project1.daos.EmployeeDaoImpl;
import com.revature.htulipan.Project1.pojos.Employee;
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
	}
	
}
