package dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import model.Employee;
import model.Request;
import utilities.ConnectionUtil;

public class RequestDAOImpl implements RequestDAO {

	public ArrayList<Request> getRequests() {
		ArrayList<Request> requests = new ArrayList<Request>();
		
		try {
			Connection con = ConnectionUtil.getConnection();
			String sql = "SELECT * FROM REQUEST";
			PreparedStatement ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				int id = rs.getInt("REQ_ID");
				double amount = rs.getDouble("REQ_AMOUNT");
				Date requestDate = rs.getDate("REQ_DATE");
				int employeeId = rs.getInt("EMPLOYEE_ID");
				String approved = rs.getString("REQ_APPROVED");
				int managerApproved = rs.getInt("MAN_APPROVED");
				String description = rs.getString("DESCRIPTION");
				
				requests.add(new Request(id, amount, requestDate, employeeId, approved, managerApproved, description));
			}
			
		} catch (IOException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return requests;
	}

	public ArrayList<Request> getPendingRequests() {
		ArrayList<Request> requests = new ArrayList<Request>();
		
		try {
			Connection con = ConnectionUtil.getConnection();
			String sql = "SELECT * FROM REQUEST WHERE REQ_APPROVED = 'FALSE'";
			PreparedStatement ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				int id = rs.getInt("REQ_ID");
				double amount = rs.getDouble("REQ_AMOUNT");
				Date requestDate = rs.getDate("REQ_DATE");
				int employeeId = rs.getInt("EMPLOYEE_ID");
				String approved = rs.getString("REQ_APPROVED");
				int managerApproved = rs.getInt("MAN_APPROVED");
				String description = rs.getString("DESCRIPTION");
				
				requests.add(new Request(id, amount, requestDate, employeeId, approved, managerApproved, description));
			}
			
		} catch (IOException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return requests;
	}

	public ArrayList<Request> getApprovedRequests() {
		ArrayList<Request> requests = new ArrayList<Request>();
		
		try {
			Connection con = ConnectionUtil.getConnection();
			String sql = "SELECT * FROM REQUEST WHERE REQ_APPROVED = 'TRUE'";
			PreparedStatement ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				int id = rs.getInt("REQ_ID");
				double amount = rs.getDouble("REQ_AMOUNT");
				Date requestDate = rs.getDate("REQ_DATE");
				int employeeId = rs.getInt("EMPLOYEE_ID");
				String approved = rs.getString("REQ_APPROVED");
				int managerApproved = rs.getInt("MAN_APPROVED");
				String description = rs.getString("DESCRIPTION");
				
				requests.add(new Request(id, amount, requestDate, employeeId, approved, managerApproved, description));
			}
			
		} catch (IOException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return requests;
	}

	public void submitNewRequest(double d, int i, String description){
		
		try { 
			Connection con = ConnectionUtil.getConnection();
			String sql = "INSERT INTO REQUEST (REQ_AMOUNT, EMPLOYEE_ID, DESCRIPTION) VALUES (?,?,?)";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setDouble(1, d);
			ps.setInt(2, i);
			ps.setString(3, description);
			
			ps.executeUpdate();
			
			
		} catch (IOException | SQLException e) {
			e.printStackTrace();
		}
		
	}
	
	public void updateRequest(int id, int manid) {
		
		try {
			Connection con = ConnectionUtil.getConnection();
			String sql = "UPDATE REQUEST SET REQ_APPROVED = 'TRUE', MAN_APPROVED = ? WHERE REQ_ID = ?";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, manid);
			ps.setInt(2, id);
			ResultSet rs = ps.executeQuery();
			
			System.out.println(rs);
			
			
		} catch (IOException | SQLException e) {
			e.printStackTrace();
		}
		
	}

	
	@Override
	public ArrayList<Request> getPendingEmployeeRequests(int id) {
		ArrayList<Request> pendingrequests = new ArrayList<Request>();
		
		try {
		Connection con = ConnectionUtil.getConnection();
		String sql = "SELECT * FROM REQUEST WHERE REQ_APPROVED = 'FALSE' AND EMPLOYEE_ID = ?";
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setInt(1, id);
		ResultSet rs = ps.executeQuery();
		
		while(rs.next()) {
			int reqid = rs.getInt("REQ_ID");
			double amount = rs.getDouble("REQ_AMOUNT");
			Date requestDate = rs.getDate("REQ_DATE");
			int employeeId = rs.getInt("EMPLOYEE_ID");
			String approved = rs.getString("REQ_APPROVED");
			int managerApproved = rs.getInt("MAN_APPROVED");
			String description = rs.getString("description");
			
			pendingrequests.add(new Request(reqid, amount, requestDate, employeeId, approved, managerApproved, description));
		}
	}	
	catch (IOException e) {
	e.printStackTrace();
	} catch (SQLException e) {
		e.printStackTrace();
	}
	
	return pendingrequests;
	}

	
	@Override
	public ArrayList<Request> getApprovedEmployeeRequests(int id) {
		ArrayList<Request> approvedrequests = new ArrayList<Request>();
		
		try {
		Connection con = ConnectionUtil.getConnection();
		String sql = "SELECT * FROM REQUEST WHERE REQ_APPROVED = 'TRUE' AND EMPLOYEE_ID = ?";
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setInt(1, id);
		ResultSet rs = ps.executeQuery();
		
		while(rs.next()) {
			int reqid = rs.getInt("REQ_ID");
			double amount = rs.getDouble("REQ_AMOUNT");
			Date requestDate = rs.getDate("REQ_DATE");
			int employeeId = rs.getInt("EMPLOYEE_ID");
			String approved = rs.getString("REQ_APPROVED");
			int managerApproved = rs.getInt("MAN_APPROVED");
			String description = rs.getString("DESCRIPTION");
			
			approvedrequests.add(new Request(reqid, amount, requestDate, employeeId, approved, managerApproved, description));
		}
	}	
	catch (IOException e) {
	e.printStackTrace();
	} catch (SQLException e) {
		e.printStackTrace();
	}
	
	return approvedrequests;
	}

}
