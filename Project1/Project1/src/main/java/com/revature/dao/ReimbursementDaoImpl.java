package com.revature.dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.revature.pojos.Reimbursement;
import com.revature.util.ConnectionUtil;

public class ReimbursementDaoImpl implements ReimbursementDao {
	@Override
	public ArrayList<Reimbursement> getPendingReimbursementsForUser(String employeeEmail) {
		ArrayList<Reimbursement> reimbursements = new ArrayList<>();
		try {
			Connection con = ConnectionUtil.getConnection();		
			String sql = "SELECT * FROM REIMBURSEMENT WHERE REQUESTED_BY=? AND STATUS='Pending' ORDER BY INSERTED_AT DESC";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, employeeEmail);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				String amount = rs.getString("AMOUNT");
				String reason = rs.getString("REASON");
				String status = rs.getString("STATUS");
				String requestedBy = rs.getString("REQUESTED_BY");
				String insertedAt =  rs.getString("INSERTED_AT");
				String id = rs.getString("REIMBURSEMENT_ID");
				String key = rs.getString("S3KEY");
				reimbursements.add(new Reimbursement(amount, reason, status, requestedBy, id, insertedAt, key));
			}
		} catch (IOException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return reimbursements;
	}
	
	@Override
	public ArrayList<Reimbursement> getResolvedReimbursementsForUser(String employeeEmail) {
		ArrayList<Reimbursement> reimbursements = new ArrayList<>();
		try {
			Connection con = ConnectionUtil.getConnection();		
			String sql = "SELECT * FROM REIMBURSEMENT WHERE REQUESTED_BY=? AND STATUS='Resolved' ORDER BY INSERTED_AT DESC";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, employeeEmail);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				String amount = rs.getString("AMOUNT");
				String reason = rs.getString("REASON");
				String status = rs.getString("STATUS");
				String requestedBy = rs.getString("REQUESTED_BY");
				String id = rs.getString("REIMBURSEMENT_ID");
				String outcome = rs.getString("OUTCOME");
				String resolvedBy = rs.getString("RESOLVED_BY");
				String insertedAt =  rs.getString("INSERTED_AT");
				String key = rs.getString("S3KEY");
				reimbursements.add(new Reimbursement(amount, reason, status, requestedBy, id, resolvedBy, outcome, insertedAt, key));
			}
		} catch (IOException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return reimbursements;
	}
	@Override
	public int createReimbursement(String amount, String reason, String employeeEmail, String key) {
		int reimbursementCreated = 0;

		try {
			Connection con = ConnectionUtil.getConnection();
			String sql = "INSERT INTO REIMBURSEMENT (AMOUNT, REASON, REQUESTED_BY, S3KEY) VALUES(?,?,?,?)";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, amount);
			ps.setString(2, reason);
			ps.setString(3, employeeEmail);
			ps.setString(4, key);
			reimbursementCreated = ps.executeUpdate();
			con.close();
		} catch (IOException e) {
			e.printStackTrace();
		}  catch (SQLException e) {
			e.printStackTrace();
		}
		return reimbursementCreated;
	}
	
	@Override
	public ArrayList<Reimbursement> getAllPendingReimbursements() {
		ArrayList<Reimbursement> reimbursements = new ArrayList<>();
		try {
			Connection con = ConnectionUtil.getConnection();		
			String sql = "SELECT * FROM REIMBURSEMENT WHERE STATUS='Pending' ORDER BY INSERTED_AT DESC";
			PreparedStatement ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				String amount = rs.getString("AMOUNT");
				String reason = rs.getString("REASON");
				String status = rs.getString("STATUS");
				String requestedBy = rs.getString("REQUESTED_BY");
				String id = rs.getString("REIMBURSEMENT_ID");
				String insertedAt =  rs.getString("INSERTED_AT");
				String key = rs.getString("S3KEY");
				reimbursements.add(new Reimbursement(amount, reason, status, requestedBy, id, insertedAt, key));
			}
		} catch (IOException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return reimbursements;	
	}
	
	@Override
	public int approveReimbursement(String id, String managerEmail) {
		int reimbursementUpdated = 0;
		try {
			Connection con = ConnectionUtil.getConnection();
			String sql = "UPDATE REIMBURSEMENT SET STATUS='Resolved', OUTCOME='Approved', RESOLVED_BY=? WHERE REIMBURSEMENT_ID=?";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, managerEmail);
			ps.setString(2, id);
			reimbursementUpdated = ps.executeUpdate();
			con.close();
		} catch (IOException e) {
			e.printStackTrace();
		}  catch (SQLException e) {
			e.printStackTrace();
		}
		
		return reimbursementUpdated;
	}
	@Override
	public ArrayList<Reimbursement> getAllResolvedReimbursements() {
		ArrayList<Reimbursement> reimbursements = new ArrayList<>();
		try {
			Connection con = ConnectionUtil.getConnection();		
			String sql = "SELECT * FROM REIMBURSEMENT WHERE STATUS='Resolved' ORDER BY INSERTED_AT DESC";
			PreparedStatement ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				String amount = rs.getString("AMOUNT");
				String reason = rs.getString("REASON");
				String status = rs.getString("STATUS");
				String requestedBy = rs.getString("REQUESTED_BY");
				String id = rs.getString("REIMBURSEMENT_ID");
				String resolvedBy = rs.getString("RESOLVED_BY");
				String outcome = rs.getString("OUTCOME");
				String insertedAt =  rs.getString("INSERTED_AT");
				String key = rs.getString("S3KEY");
				reimbursements.add(new Reimbursement(amount, reason, status, requestedBy, id, resolvedBy, outcome, insertedAt, key));
			}
		} catch (IOException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return reimbursements;	
	}

	@Override
	public int denyReimbursement(String id, String managerEmail) {
		int reimbursementUpdated = 0;
		try {
			Connection con = ConnectionUtil.getConnection();
			String sql = "UPDATE REIMBURSEMENT SET STATUS='Resolved', OUTCOME='Denied', RESOLVED_BY=? WHERE REIMBURSEMENT_ID=?";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, managerEmail);
			ps.setString(2, id);
			reimbursementUpdated = ps.executeUpdate();
			con.close();
		} catch (IOException e) {
			e.printStackTrace();
		}  catch (SQLException e) {
			e.printStackTrace();
		}
		
		return reimbursementUpdated;
	}

	@Override
	public Reimbursement getReimbursementById(String id) {
		Reimbursement reimbursement = null;
		try {
			Connection con = ConnectionUtil.getConnection();		
			String sql = "SELECT * FROM REIMBURSEMENT WHERE REIMBURSEMENT_ID=? ORDER BY INSERTED_AT DESC";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, id);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				String amount = rs.getString("AMOUNT");
				String reason = rs.getString("REASON");
				String status = rs.getString("STATUS");
				String requestedBy = rs.getString("REQUESTED_BY");
				String r_id = rs.getString("REIMBURSEMENT_ID");
				reimbursement = new Reimbursement(amount, reason, status, requestedBy, r_id);
			}
		} catch (IOException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return reimbursement;
	}

	@Override
	public ArrayList<Reimbursement> getAllReimbursementsForUser(String employeeEmail) {
		ArrayList<Reimbursement> reimbursements = new ArrayList<>();
		try {
			Connection con = ConnectionUtil.getConnection();		
			String sql = "SELECT * FROM REIMBURSEMENT WHERE REQUESTED_BY=? ORDER BY INSERTED_AT DESC";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, employeeEmail);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				String amount = rs.getString("AMOUNT");
				String reason = rs.getString("REASON");
				String status = rs.getString("STATUS");
				String requestedBy = rs.getString("REQUESTED_BY");
				String id = rs.getString("REIMBURSEMENT_ID");
				String insertedAt =  rs.getString("INSERTED_AT");
				String key = rs.getString("S3KEY");
				reimbursements.add(new Reimbursement(amount, reason, status, requestedBy, id, insertedAt, key));
			}
		} catch (IOException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return reimbursements;
	}

}
