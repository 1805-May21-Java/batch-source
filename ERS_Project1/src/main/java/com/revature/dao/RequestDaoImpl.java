package com.revature.dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.revature.pojos.Request;
import com.revature.utils.ConnectionUtil;
import com.revature.utils.Constants;

public class RequestDaoImpl implements RequestDao{

	public List<Request> getRequestsByEmployeeId(int id) {
		List<Request> requestsList = new ArrayList<Request>();
		
		try {
			Connection conn = ConnectionUtil.getConnection();
			String sql = "SELECT * FROM ERS_REQUEST WHERE EMPL_ID = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				int requestId = rs.getInt("REQ_ID");
				double amount = rs.getDouble("AMOUNT");
				String description = rs.getString("DESCRIPTION");
				String status = rs.getString("STATUS");
				Date dateRequested = rs.getDate("DATE_REQUESTED");
				Date dateResolved = rs.getDate("DATE_RESOLVED");
				
				requestsList.add(new Request(requestId, id, amount, description, status, dateRequested, dateResolved));
			}
			// Don't close this connection because this is called inside another DAO
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return requestsList;
	}

	public int resolveRequest(int requestId, String status) {
		int requestsUpdated = 0;
		try {
			Connection conn = ConnectionUtil.getConnection();
			String sql = "UPDATE ERS_REQUEST "
					+ "SET STATUS = ?, "
					+ "DATE_RESOLVED = LOCALTIMESTAMP "
					+ "WHERE REQ_ID = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			if(status.equals("approve")) {
				ps.setString(1, Constants.approved);
			}else if(status.equals("deny")) {
				ps.setString(1,  Constants.denied);
			} else {
				ps.setString(1,  Constants.pending);
			}
			ps.setInt(2,  requestId);
			requestsUpdated = ps.executeUpdate();
			
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return requestsUpdated;
	}

	public int createRequest(Request request) {
		int requestsCreated = 0;
		try {
			Connection conn = ConnectionUtil.getConnection();
			String sql = "INSERT INTO ERS_REQUEST (EMPL_ID, AMOUNT, DESCRIPTION, STATUS, DATE_REQUESTED) VALUES (?,?,?,?,LOCALTIMESTAMP)";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, request.getEmplId());
			ps.setDouble(2, request.getAmount());
			ps.setString(3,  request.getDescription());
			ps.setString(4,  Constants.pending);
			requestsCreated = ps.executeUpdate();
			
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return requestsCreated;
	}
}
