package com.revature.htulipan.Project1.daos;

import java.io.IOException;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.revature.htulipan.Project1.pojos.Employee;
import com.revature.htulipan.Project1.pojos.Request;
import com.revature.htulipan.Project1.util.ConnectionUtil;

public class RequestDaoImpl implements RequestDao {

	@Override
	public Request getRequestById(int requestId) {
	
		String sql = "SELECT * FROM REQUEST WHERE REQUESTID = ?";
		Request result = null;
		
		try {
			Connection conn = ConnectionUtil.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1,  requestId);
			ResultSet rs = ps.executeQuery();
			int count = 0;
			while (rs.next()) {
				if (++count > 1) throw new SQLException("There should only be one.");
				result = new Request(
						rs.getInt("REQUESTID"),
						rs.getInt("EMPLOYEEID"),
						rs.getInt("MANAGERID"),
						rs.getFloat("AMOUNT"),
						rs.getDate("DATECREATED"),
						rs.getDate("DATEADDRESSED"),
						rs.getString("REQUESTTEXT"),
						rs.getInt("STATUS"));
			}	
		} catch (SQLException se) {
			return null;
		} catch (IOException ioe) {
			return null;
		}
		return result;
	}

	@Override
	public ArrayList<Request> getAllRequests() {
		
		String sql = "SELECT * FROM REQUEST";
		ArrayList<Request> results = new ArrayList<Request>();
		
		try {
			Connection conn = ConnectionUtil.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				results.add(new Request(
						rs.getInt("REQUESTID"),
						rs.getInt("EMPLOYEEID"),
						rs.getInt("MANAGERID"),
						rs.getFloat("AMOUNT"),
						rs.getDate("DATECREATED"),
						rs.getDate("DATEADDRESSED"),
						rs.getString("REQUESTTEXT"),
						rs.getInt("STATUS")));
			}
		} catch (SQLException se) {
			System.out.println(se.getMessage());
			return null;
		} catch (IOException ioe) {
			System.out.println(ioe.getMessage());
			return null;
		}
		return results;
	}

	@Override
	public ArrayList<Request> getRequestsByEmployeeId(int employeeId) {
		
		String sql = "SELECT * FROM REQUEST WHERE EMPLOYEEID = ?";
		ArrayList<Request> results = new ArrayList<Request>();
		
		try {
			Connection conn = ConnectionUtil.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1,  employeeId);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				results.add(new Request(
						rs.getInt("REQUESTID"),
						rs.getInt("EMPLOYEEID"),
						rs.getInt("MANAGERID"),
						rs.getFloat("AMOUNT"),
						rs.getDate("DATECREATED"),
						rs.getDate("DATEADDRESSED"),
						rs.getString("REQUESTTEXT"),
						rs.getInt("STATUS")));
			}
		} catch (SQLException se) {
			System.out.println(se.getMessage());
			return null;
		} catch (IOException ioe) {
			System.out.println(ioe.getMessage());
			return null;
		}
		return results;
	}

	@Override
	public ArrayList<Request> getRequestsByManagerId(int managerId) {
		String sql = "SELECT * FROM REQUEST WHERE MANAGERID = ?";
		ArrayList<Request> results = new ArrayList<Request>();
		
		try {
			Connection conn = ConnectionUtil.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1,  managerId);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				results.add(new Request(
						rs.getInt("REQUESTID"),
						rs.getInt("EMPLOYEEID"),
						rs.getInt("MANAGERID"),
						rs.getFloat("AMOUNT"),
						rs.getDate("DATECREATED"),
						rs.getDate("DATEADDRESSED"),
						rs.getString("REQUESTTEXT"),
						rs.getInt("STATUS")));
			}
		} catch (SQLException se) {
			System.out.println(se.getMessage());
			return null;
		} catch (IOException ioe) {
			System.out.println(ioe.getMessage());
			return null;
		}
		return results;
	}

	@Override
	public ArrayList<Request> getRequestsByStatus(int status) {
		String sql = "SELECT * FROM REQUEST WHERE STATUS = ?";
		ArrayList<Request> results = new ArrayList<Request>();
		
		try {
			Connection conn = ConnectionUtil.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1,  status);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				results.add(new Request(
						rs.getInt("REQUESTID"),
						rs.getInt("EMPLOYEEID"),
						rs.getInt("MANAGERID"),
						rs.getFloat("AMOUNT"),
						rs.getDate("DATECREATED"),
						rs.getDate("DATEADDRESSED"),
						rs.getString("REQUESTTEXT"),
						rs.getInt("STATUS")));
			}
		} catch (SQLException se) {
			System.out.println(se.getMessage());
			return null;
		} catch (IOException ioe) {
			System.out.println(ioe.getMessage());
			return null;
		}
		return results;
	}

	@Override
	public int createRequest(int eid, float amount, String text, int status) {
		String sql = "INSERT INTO REQUEST (EMPLOYEEID, AMOUNT, REQUESTTEXT, STATUS) VALUES (?, ?, ?, ?)";
		
		int result = 0;
		try {
			Connection conn = ConnectionUtil.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1,  eid);
			ps.setFloat(2,  amount);
			ps.setString(3,  text);
			ps.setInt(4,  status);
			result = ps.executeUpdate();
		} catch (SQLException se) {
			System.out.println(se.getMessage());
			return 0;
		} catch (IOException ioe) {
			System.out.println(ioe.getMessage());
			return 0;
		}
		return result;
	}

}


/*
(int requestId, int employeeId, int managerId, float amount, Date dateCreated, Date dateAddressed,
String requestText, int status)*/