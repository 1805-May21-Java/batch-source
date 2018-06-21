package com.revature.htulipan.Project1.daos;

import java.io.IOException;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.revature.htulipan.Project1.pojos.Employee;
import com.revature.htulipan.Project1.util.ConnectionUtil;

public class EmployeeDaoImpl implements EmployeeDao{

	/*
	 * This should call the CHECKCREDENTIALS procedure and return either the EmployeeId of the 
	 * corresponding entry in the EMPLOYEE table or 0 if no entries matched.
	 */
	@Override
	public int checkLoginCredentials(String username, String password) {
		String sql = "{CALL CHECKCREDENTIALS(?, ?, ?)}";
		int result = 0;
		
		try {
			Connection conn = ConnectionUtil.getConnection();
			CallableStatement cs = conn.prepareCall(sql);
			cs.setString(1, username);
			cs.setString(2,  password);
			cs.registerOutParameter(3, java.sql.Types.INTEGER);
			
			cs.executeQuery();
			result = cs.getInt(3);
			
		} catch (SQLException se) { 
			result = 0;
		} catch (IOException ioe) {
			result = 0;
		}
		
		return result;
	}

	
	@Override
	public Employee getEmployeeById(int id) {
		String sql = "SELECT * FROM EMPLOYEE WHERE EMPLOYEEID = ?";
		
		try {
			Connection conn = ConnectionUtil.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1,  id);
			ResultSet rs = ps.executeQuery();
			int count = 0;
			String un = null;
			String fn = null;
			String ln = null;
			String em = null;
			Date dob = null;
			long phone = 0;
			int eid = 0;
			boolean man = false;
			while (rs.next()) {
				if (++count > 1) throw new SQLException("There should only be one.");
				un = rs.getString("USERNAME");
				fn = rs.getString("FIRSTNAME");
				ln = rs.getString("LASTNAME");
				dob = rs.getDate("DOB");
				phone = rs.getLong("PHONE");
				em = rs.getString("EMAIL");
				man = (rs.getInt("MANAGER") > 0);
				eid = rs.getInt("EMPLOYEEID");
			}
			if (un == null || eid < 1) return null;
			
			return new Employee(un, fn, ln, dob, phone, em, man, eid);
		} catch (SQLException se) {
			return null;
		} catch (IOException ioe) {
			return null;
		}
	}

	@Override
	public int updateEmployee(Employee emp) {
		String sql = "UPDATE EMPLOYEE SET FIRSTNAME = ?, LASTNAME = ?, DOB = ?, PHONE = ?, EMAIL = ? WHERE EMPLOYEEID = ?";
		int numUpdated = 0;
		
		try {
			Connection conn = ConnectionUtil.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1,  emp.getFirstname());
			ps.setString(2,  emp.getLastname());
			ps.setDate(3,  emp.getDob());
			ps.setLong(4,  emp.getPhone());
			ps.setString(5,  emp.getEmail());
			ps.setInt(6, emp.getEmployeeId());
			numUpdated = ps.executeUpdate();
		} catch (SQLException se) {
			System.out.println(se.getMessage());
			return 0;
		} catch (IOException ioe) {
			System.out.println(ioe.getMessage());
			return 0;
		}
		return numUpdated;
	}

	@Override
	public ArrayList<Employee> getAllEmployees() {
		String sql = "SELECT * FROM EMPLOYEE";
		ArrayList<Employee> result = new ArrayList<Employee>();
		
		try {
			Connection conn = ConnectionUtil.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				result.add(new Employee(
						rs.getString("USERNAME"),
						rs.getString("FIRSTNAME"),
						rs.getString("LASTNAME"),
						rs.getDate("DOB"),
						rs.getLong("PHONE"),
						rs.getString("EMAIL"),
						(rs.getInt("MANAGER") > 0),
						rs.getInt("EMPLOYEEID")));
			}
		} catch (SQLException se) {
			System.out.println(se.getMessage());
			return null;
		} catch (IOException ioe) {
			System.out.println(ioe.getMessage());
			return null;
		}
		return result;
	}

}
