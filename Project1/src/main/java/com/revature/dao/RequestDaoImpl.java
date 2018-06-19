package com.revature.dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.revature.pojos.Employee;
import com.revature.pojos.Request;
import com.revature.utils.ConnectionUtils;

public class RequestDaoImpl implements RequestDAO {

	@Override
	public List<Request> getAllRequests() {
		List<Request> requests = new ArrayList<>();
		try {
			Connection connection = ConnectionUtils.getConnection();
			String sql = "select REQUEST_ID, EMP_NAME, STATUS, AMOUNT, COMMENTS, Employee.EMPLOYEE_ID from Request join Employee on " + 
					"Request.EMPLOYEE_ID = Employee.EMPLOYEE_ID";
			Statement statement = connection.createStatement();
			ResultSet rSet = statement.executeQuery(sql);
			while(rSet.next()) {
				requests.add(new Request(rSet.getInt("REQUEST_ID"), rSet.getInt("EMPLOYEE_ID"), rSet.getInt("STATUS"), rSet.getFloat("AMOUNT"), rSet.getString("COMMENTS"), rSet.getString("EMP_NAME")));
			}
			connection.close();
		} catch (IOException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return requests;
	}

	@Override
	public List<Request> getAllRequestsByEmployee(Employee emp) {
		List<Request> requests = new ArrayList<>();
		try {
			Connection connection = ConnectionUtils.getConnection();
			String sql = "select REQUEST_ID, EMP_NAME, STATUS, AMOUNT, COMMENTS, Employee.EMPLOYEE_ID from Request join Employee on "
					+ "Request.EMPLOYEE_ID = Employee.EMPLOYEE_ID where Employee.EMPLOYEE_ID=?";
			PreparedStatement statement = connection.prepareStatement(sql);
			statement.setInt(1, emp.getEmployeeId());
			ResultSet rSet = statement.executeQuery();
			while(rSet.next()) {
				requests.add(new Request(rSet.getInt("REQUEST_ID"), rSet.getInt("EMPLOYEE_ID"), rSet.getInt("STATUS"), rSet.getFloat("AMOUNT"), rSet.getString("COMMENTS"), rSet.getString("EMP_NAME")));
			}
			connection.close();
		} catch (IOException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return requests;
	}

	@Override
	public List<Request> getAllRequestsByManager(Employee emp) {
		List<Request> requests = new ArrayList<>();
		try {
			Connection connection = ConnectionUtils.getConnection();
			String sql = "select REQUEST_ID, EMP_NAME, STATUS, AMOUNT, COMMENTS, Employee.EMPLOYEE_ID from Request join Employee on " + 
					"Request.EMPLOYEE_ID = Employee.EMPLOYEE_ID where STATUS=0 and MANAGER_ID=? and Employee.Employee_ID != ?";
			PreparedStatement statement = connection.prepareStatement(sql);
			statement.setInt(1, emp.getEmployeeId());
			statement.setInt(2, emp.getEmployeeId());
			ResultSet rSet = statement.executeQuery();
			while(rSet.next()) {
				requests.add(new Request(rSet.getInt("REQUEST_ID"), rSet.getInt("EMPLOYEE_ID"), rSet.getInt("STATUS"), rSet.getFloat("AMOUNT"), rSet.getString("COMMENTS"), rSet.getString("EMP_NAME")));
			}
			connection.close();
		} catch (IOException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return requests;
	}

	@Override
	public int createRequest(Request req) {
		int reqCreated = 0;

		try {
			Connection connection = ConnectionUtils.getConnection();
			connection.setAutoCommit(false);
			String sql = "insert into REQUEST (EMPLOYEE_ID,STATUS,AMOUNT,COMMENTS) VALUES(?,?,?,?)";
			PreparedStatement pStatement = connection.prepareStatement(sql);
			pStatement.setInt(1, req.getEmployeeId());
			pStatement.setInt(2, req.getStatus());
			pStatement.setFloat(3, req.getAmount());
			pStatement.setString(4, req.getComments());
			reqCreated = pStatement.executeUpdate();
			connection.commit();
			connection.close();
		} catch (IOException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return reqCreated;
	}

	@Override
	public int updateRequest(int reqId, int status) {
		int requestUpdates = 0;
		try {
			Connection connection = ConnectionUtils.getConnection();
			connection.setAutoCommit(false);
			String sql = "update REQUEST set STATUS=? where REQUEST_ID=?";
			PreparedStatement pStatement = connection.prepareStatement(sql);
			pStatement.setInt(1, status);
			pStatement.setInt(2, reqId);
			requestUpdates = pStatement.executeUpdate();
			connection.commit();
			connection.close();
		} catch (IOException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return requestUpdates;
	}
}
