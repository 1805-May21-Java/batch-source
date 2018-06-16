package com.revature.dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
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

	public Request getRequestById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	public int createRequest(Request request) {
		// TODO Auto-generated method stub
		return 0;
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
