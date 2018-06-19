package com.adora.access;

import java.io.IOException;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import com.adora.pojos.Request;
import com.adora.utils.ConnectionUtil;

public class RequestDaoImpl implements RequestDao{

	@Override
	public List<Request> getAllRequests(int employeeId) {
List<Request> requestList = new ArrayList();
		
		try(Connection connection = ConnectionUtil.getConnection()) {
			String sql = "SELECT * FROM request WHERE employee_id <> ?";
			PreparedStatement ps = connection.prepareStatement(sql);
			ps.setInt(1, employeeId);
			
			
			ResultSet results = ps.executeQuery();
			while(results.next()) {
				Request request = new Request();
				request.setRequestId(results.getInt("request_id"));
				request.setEmployeeId(results.getInt("employee_id"));
				request.setManagerId(results.getInt("manager_id"));
				request.setRequestedAmount(results.getDouble("requested_amount"));
				request.setApprovedAmount(results.getDouble("approved_amount"));
				request.setStatus(results.getInt("status"));
				request.setDateSubmitted(results.getDate("date_submitted"));
				request.setDateApproved(results.getDate("date_approved"));
				request.setSubject(results.getString("subject"));
				requestList.add(request);
			}
			
		} catch (SQLException | IOException e) {
			e.printStackTrace();
		}
		
		
		return requestList;
	}

	

	@Override
	public List<Request> getAllRequestsByEmployee(int employeeId) {
		List<Request> requestList = new ArrayList<Request>();
		
		try(Connection connection = ConnectionUtil.getConnection()) {
			String sql = "SELECT * FROM request WHERE employee_id = ?";
			PreparedStatement ps = connection.prepareStatement(sql);
			ps.setInt(1, employeeId);
			ResultSet results = ps.executeQuery();
			
			System.out.println("getting results for " + employeeId);
			
			while(results.next()) {
				Request request = new Request();
				request.setRequestId(results.getInt("request_id"));
				request.setEmployeeId(results.getInt("employee_id"));
				request.setManagerId(results.getInt("manager_id"));
				request.setRequestedAmount(results.getDouble("requested_amount"));
				request.setApprovedAmount(results.getDouble("approved_amount"));
				request.setStatus(results.getInt("status"));
				request.setDateSubmitted(results.getDate("date_submitted"));
				request.setDateApproved(results.getDate("date_approved"));
				request.setSubject(results.getString("subject"));
				requestList.add(request);
			}
			
			System.out.println(requestList.toString());
			
		} catch (SQLException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return requestList;
	}

	@Override
	public Request getRequestById(int requestId) {
		Request request = null;
			try(Connection connection = ConnectionUtil.getConnection()) {
				String sql = "SELECT * FROM request WHERE request_id = ?";
				PreparedStatement ps = connection.prepareStatement(sql);
				ps.setInt(1, requestId);
				ResultSet  results = ps.executeQuery();
				
				while(results.next()) {
					request = new Request();
					request.setRequestId(results.getInt("request_id"));
					request.setEmployeeId(results.getInt("employee_id"));
					request.setManagerId(results.getInt("manager_id"));
					request.setRequestedAmount(results.getDouble("requested_amount"));
					request.setApprovedAmount(results.getDouble("approved_amount"));
					request.setStatus(results.getInt("status"));
					request.setDateSubmitted(results.getDate("date_submitted"));
					request.setDateApproved(results.getDate("date_approved"));
					request.setSubject(results.getString("subject"));
				}
				
			} catch (SQLException | IOException e) {
				e.printStackTrace();
			}
		
		
		return request;
	}

	@Override
	public List<Request> getAllRequestsByManager(int managerId) {
		List<Request> requestList = new ArrayList();
		
		try(Connection connection = ConnectionUtil.getConnection()) {
			String sql = "SELECT * FROM request WHERE manager_id = ? and employee_id <> ?";
			PreparedStatement ps = connection.prepareStatement(sql);
			ps.setInt(1, managerId);
			ps.setInt(2, managerId);
			
			ResultSet results = ps.executeQuery();
			while(results.next()) {
				Request request = new Request();
				request.setRequestId(results.getInt("request_id"));
				request.setEmployeeId(results.getInt("employee_id"));
				request.setManagerId(results.getInt("manager_id"));
				request.setRequestedAmount(results.getDouble("requested_amount"));
				request.setApprovedAmount(results.getDouble("approved_amount"));
				request.setStatus(results.getInt("status"));
				request.setDateSubmitted(results.getDate("date_submitted"));
				request.setDateApproved(results.getDate("date_approved"));
				request.setSubject(results.getString("subject"));
				requestList.add(request);
			}
			
		} catch (SQLException | IOException e) {
			e.printStackTrace();
		}
		
		
		return requestList;
	}

	@Override
	public int createRequest(Request request) {
		int result = 0;
		
		try(Connection connection = ConnectionUtil.getConnection()) {
			
			String sql = "INSERT INTO request(request_id, employee_id, manager_id, requested_amount, status, date_submitted, subject)"
					+ "VALUES(?, ?, ?, ?, ?, ?, ?) ";
			PreparedStatement ps = connection.prepareStatement(sql);
			ps.setInt(1, 0);
			ps.setInt(2, request.getEmployeeId());
			ps.setInt(3, request.getManagerId());
			ps.setDouble(4, request.getRequestedAmount());
			ps.setInt(5, request.getStatus());
			ps.setDate(6, request.getDateSubmitted());
			ps.setString(7, request.getSubject());
			
			result = ps.executeUpdate();
			
		} catch (SQLException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return result;
	}

	@Override
	public List<Request> getAllPendingRequests() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Request> getAllPendingRequestsByManager(int managerId) {
		List<Request> requestList = new ArrayList();
		
		try(Connection connection = ConnectionUtil.getConnection()) {
			String sql = "SELECT * FROM request WHERE manager_id = ? and employee_id <> ? and status = 1";
			PreparedStatement ps = connection.prepareStatement(sql);
			ps.setInt(1, managerId);
			ps.setInt(2, managerId);
			
			ResultSet results = ps.executeQuery();
			while(results.next()) {
				Request request = new Request();
				request.setRequestId(results.getInt("request_id"));
				request.setEmployeeId(results.getInt("employee_id"));
				request.setManagerId(results.getInt("manager_id"));
				request.setRequestedAmount(results.getDouble("requested_amount"));
				request.setApprovedAmount(results.getDouble("approved_amount"));
				request.setStatus(results.getInt("status"));
				request.setDateSubmitted(results.getDate("date_submitted"));
				request.setDateApproved(results.getDate("date_approved"));
				request.setSubject(results.getString("subject"));
				requestList.add(request);
			}
			
		} catch (SQLException | IOException e) {
			e.printStackTrace();
		}
		
		
		return requestList;
	}

	@Override
	public List<Request> getAllPendingRequestsByEmployee(int employeeId) {
		List<Request> requestList = new ArrayList();
		
		try(Connection connection = ConnectionUtil.getConnection()) {
			String sql = "SELECT * FROM request WHERE employee_id = ? and status = 1";
			PreparedStatement ps = connection.prepareStatement(sql);
			ps.setInt(1, employeeId);
			
			
			ResultSet results = ps.executeQuery();
			while(results.next()) {
				Request request = new Request();
				request.setRequestId(results.getInt("request_id"));
				request.setEmployeeId(results.getInt("employee_id"));
				request.setManagerId(results.getInt("manager_id"));
				request.setRequestedAmount(results.getDouble("requested_amount"));
				request.setApprovedAmount(results.getDouble("approved_amount"));
				request.setStatus(results.getInt("status"));
				request.setDateSubmitted(results.getDate("date_submitted"));
				request.setDateApproved(results.getDate("date_approved"));
				request.setSubject(results.getString("subject"));
				requestList.add(request);
			}
			
		} catch (SQLException | IOException e) {
			e.printStackTrace();
		}
		
		
		return requestList;
	}


	public int approveRequest(int requestId, int managerId, double requestAmount) {
		int result = 0;
		
		try(Connection connection = ConnectionUtil.getConnection()) {
			String sql = "UPDATE request SET status=2, manager_id=?, approved_amount=?, date_approved=? WHERE request_id=? ";
			PreparedStatement ps = connection.prepareStatement(sql);
			ps.setInt(1, managerId);
			ps.setDouble(2, requestAmount);
			ps.setDate(3, new Date(Calendar.getInstance().getTimeInMillis()));
			ps.setInt(4, requestId);
			
			result = ps.executeUpdate();
			System.out.println("Approved");
			
		} catch (SQLException | IOException e) {
			e.printStackTrace();
		}
		
		return result;
	}
	
	public int denyRequest(int requestId, int managerId) {
		int result = 0;
		
		try(Connection connection = ConnectionUtil.getConnection()) {
			String sql = "UPDATE request SET status=3, manager_id=?, approved_amount=0, date_approved=? WHERE request_id=?";
			PreparedStatement ps = connection.prepareStatement(sql);
			ps.setInt(1, managerId);
			ps.setDate(2, new Date(Calendar.getInstance().getTimeInMillis()));
			ps.setInt(3, requestId);
			
			result = ps.executeUpdate();
			
			
		} catch (SQLException | IOException e) {
			e.printStackTrace();
		}
		
		return result;
	}
}
