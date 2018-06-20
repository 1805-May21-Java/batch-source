package com.revature.dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import com.revature.pojos.Request;
import com.revature.util.ConnectionUtil;

public class RequestDaoImpl implements RequestDao {

	public List<Request> getRequests() {
		List<Request> requestList = new ArrayList<Request>();
		
		try {
			Connection con = ConnectionUtil.getConnection();
			String sql = "SELECT * FROM request";
			Statement statement = con.createStatement(); //TODO: convert to PreparedStatement?
			ResultSet rs = statement.executeQuery(sql);
			
			while (rs.next()) {
				int requestId = rs.getInt("req_id");
				String imageURL = rs.getString("img");
				int empId = rs.getInt("emp_id");
				int managerId = rs.getInt("manager_id");
				String title = rs.getString("title");
				Double amount = rs.getDouble("amount");
				String comments = rs.getString("comments");
				Date dateCreated = rs.getDate("date_created");
				Date dateApproved = rs.getDate("date_approved");
				
				requestList.add(new Request(requestId, imageURL, empId, managerId, title, amount, comments, dateCreated, dateApproved));
			}
			
			con.close();
			
		} catch (IOException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return requestList;
	}

	public List<Request> getRequestsById(int id) {
		List<Request> requestList = new ArrayList<Request>();
		System.out.println(id);
		
		try {
			Connection con = ConnectionUtil.getConnection();
			String sql = "SELECT * FROM request WHERE emp_id=?";
			PreparedStatement pStatement = con.prepareStatement(sql);
			pStatement.setInt(1, id);
			ResultSet rs = pStatement.executeQuery();
			
			while (rs.next()) {
				int requestId = rs.getInt("req_id");
				String imageURL = rs.getString("img");
				int empId = rs.getInt("emp_id");
				int managerId = rs.getInt("manager_id");
				String title = rs.getString("title");
				Double amount = rs.getDouble("amount");
				String comments = rs.getString("comments");
				Date dateCreated = rs.getDate("date_created");
				Date dateApproved = rs.getDate("date_approved");
				
				requestList.add(new Request(requestId, imageURL, empId, managerId, title, amount, comments, dateCreated, dateApproved));
			}
			
			con.close();
			
		} catch (IOException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return requestList;
	}

	public void createRequest(int id, String title, double amount, String comments) {
		try {
			Connection connection = ConnectionUtil.getConnection();
			String sql = "INSERT INTO request (emp_id, title, amount, comments, date_created)\n" +
						"VALUES (?, ?, ?, ?, ?)";
			PreparedStatement pStatement = connection.prepareStatement(sql);
			pStatement.setInt(1, id);
			pStatement.setString(2, title);
			pStatement.setDouble(3, amount);
			pStatement.setString(4, comments);
			pStatement.setTimestamp(5, new Timestamp(System.currentTimeMillis()));
			pStatement.executeQuery();
			
			connection.close();
			
		} catch (IOException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

	public int updateRequest(Request request) {
		// TODO Auto-generated method stub
		return 0;
	}

	public int deleteRequestById(Request request) {
		// TODO Auto-generated method stub
		return 0;
	}



}
