package com.revature.dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import com.revature.pojos.Request;
import com.revature.util.ConnectionUtil;

public class RequestDaoImpl implements RequestDao {

	public List<Request> getRequests() {
		List<Request> requestList = new ArrayList<Request>();
		
		try {
			Connection con = ConnectionUtil.getConnection();
			String sql = "SELECT * FROM request";
			PreparedStatement pStatement = con.prepareStatement(sql);
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
				String managerName = rs.getString("manager_name");
				
				requestList.add(new Request(requestId, imageURL, empId, managerId, title, amount, comments, dateCreated, dateApproved, managerName));
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
				String managerName = rs.getString("manager_name");
				
				requestList.add(new Request(requestId, imageURL, empId, managerId, title, amount, comments, dateCreated, dateApproved, managerName));
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

	public Request getRequestById(int id) {
		Request request = null;
		try {
			Connection connection = ConnectionUtil.getConnection();
			String sql = "SELECT * FROM request WHERE req_id = ?";
			PreparedStatement pStatement = connection.prepareStatement(sql);
			pStatement.setInt(1, id);
			ResultSet rSet = pStatement.executeQuery();
			
			while (rSet.next()) {
				int reqId = rSet.getInt("req_id");
				String imageURL = rSet.getString("img");
				int employeeId = rSet.getInt("emp_id");
				int managerId = rSet.getInt("manager_id");
				String title = rSet.getString("title");
				Double amount = rSet.getDouble("amount");
				String comments = rSet.getString("comments");
				Date dateCreated = rSet.getDate("date_created");
				Date dateApproved = rSet.getDate("date_approved");
				String managerName = rSet.getString("manager_name");
				
				request = new Request(reqId, imageURL, employeeId, managerId, title, amount, comments, dateCreated, dateApproved, managerName);
			}
			
			connection.close();
			
		} catch (IOException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return request;
	}
	

	public void deleteRequestById(int id) {
		try {
			Connection connection = ConnectionUtil.getConnection();
			String sql = "DELETE FROM request WHERE req_id = ?";
			PreparedStatement pStatement = connection.prepareStatement(sql);
			pStatement.setInt(1, id);
			pStatement.executeQuery();
			
			connection.close();
			
		} catch (IOException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	public void updateRequest(int reqId, int mgrId, Date dateApproved, String managerName) {
		try {
			Connection connection = ConnectionUtil.getConnection();
			String sql = "UPDATE request SET manager_id = ?, date_approved = ?, manager_name = ? WHERE req_id = ?";
			PreparedStatement pStatement = connection.prepareStatement(sql);
			pStatement.setInt(1, mgrId);
			pStatement.setDate(2, dateApproved);
			pStatement.setString(3, managerName);
			pStatement.setInt(4, reqId);
			pStatement.executeQuery();
			
			connection.close();
			
		} catch (IOException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}



}
