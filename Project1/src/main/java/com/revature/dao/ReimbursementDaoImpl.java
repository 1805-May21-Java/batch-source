package com.revature.dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.revature.pojos.Reimbursement;
import com.revature.util.ConnectionUtil;

public class ReimbursementDaoImpl implements ReimbursementDao{

	public List<Reimbursement> getReimbursements() {
		List<Reimbursement> reimbursements = new ArrayList<Reimbursement>();
		
		String sql = "SELECT * FROM P1_REIMBURSEMENT";
		
		try {
			Connection con = ConnectionUtil.getConnection();
			Statement s = con.createStatement();
			ResultSet rs = s.executeQuery(sql);
			while(rs.next()) {
				int reimbursementId = rs.getInt("REIMBURSEMENT_ID");
				String status = rs.getString("STATUS");
				int empId = rs.getInt("EMP_ID");
				int mngId = rs.getInt("MANAGER_ID");
				String description = rs.getString("DESCRIPTION");
				String amount = rs.getString("AMOUNT");
				reimbursements.add(new Reimbursement(reimbursementId, status, empId, mngId, description, amount));
			}
			rs.close();
			con.close();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return reimbursements;
	}

	public Reimbursement getReimbursementByUsername(String user) {
		Reimbursement r = null;
		
		try {
			Connection con = ConnectionUtil.getConnection();
			String sql = "SELECT * FROM P1_REIMBURSEMENT WHERE EMP_ID =(SELECT EMP_ID FROM P1_EMPLOYEE WHERE USERNAME=?";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, user);
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				int reimbursementId = rs.getInt("REIMBURSEMENT_ID");
				String status = rs.getString("STATUS");
				int empId = rs.getInt("EMP_ID");
				int mngId = rs.getInt("MANAGER_ID");
				String description = rs.getString("DESCRIPTION");
				String amount = rs.getString("AMOUNT");
				
				r = new Reimbursement(reimbursementId, status, empId, mngId, description, amount);
			}
			rs.close();
			ps.close();
			con.close();

		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		return r;
	}

	public int createReimbursement(Reimbursement reimbursement) {
		int reimbursementCreated = 0;
		
		try {
			Connection con = ConnectionUtil.getConnection();
			String sql = "INSERT INTO P1_REIMBURSEMENT (STATUS, EMP_ID, MANAGER_ID, DESCRIPTION, AMOUNT) VALUES (?,?,?,?,?)";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, reimbursement.getStatus());
			ps.setInt(2, reimbursement.getEmpId());
			ps.setNull(3, reimbursement.getMngId());
			ps.setString(4, reimbursement.getDescription());
			ps.setString(5, reimbursement.getAmount());;
			reimbursementCreated = ps.executeUpdate();
			ps.close();
			con.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return reimbursementCreated;
	}

	public List<Reimbursement> getPendingsById(int employeeId) {
		List<Reimbursement> reimbursements = new ArrayList<Reimbursement>();
				
		try {
			Connection con = ConnectionUtil.getConnection();
			String sql = "SELECT * FROM P1_REIMBURSEMENT WHERE STATUS = 'Pending' AND EMP_ID = ?";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, employeeId);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				int reimbursementId = rs.getInt("REIMBURSEMENT_ID");
				String status = rs.getString("STATUS");
				int empId = rs.getInt("EMP_ID");
				int mngId = rs.getInt("MANAGER_ID");
				String description = rs.getString("DESCRIPTION");
				String amount = rs.getString("AMOUNT");
				reimbursements.add(new Reimbursement(reimbursementId, status, empId, mngId, description, amount));
			}
			rs.close();
			con.close();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return reimbursements;
	}
	
	public List<Reimbursement> getPendings() {
		List<Reimbursement> reimbursements = new ArrayList<Reimbursement>();
				
		try {
			Connection con = ConnectionUtil.getConnection();
			String sql = "SELECT * FROM P1_REIMBURSEMENT WHERE STATUS = 'Pending'";
			PreparedStatement ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				int reimbursementId = rs.getInt("REIMBURSEMENT_ID");
				String status = rs.getString("STATUS");
				int empId = rs.getInt("EMP_ID");
				int mngId = rs.getInt("MANAGER_ID");
				String description = rs.getString("DESCRIPTION");
				String amount = rs.getString("AMOUNT");
				reimbursements.add(new Reimbursement(reimbursementId, status, empId, mngId, description, amount));
			}
			rs.close();
			con.close();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return reimbursements;
	}
	
	public List<Reimbursement> getResolvedById(int employeeId) {
		List<Reimbursement> reimbursements = new ArrayList<Reimbursement>();
				
		try {
			Connection con = ConnectionUtil.getConnection();
			String sql = "SELECT * FROM P1_REIMBURSEMENT WHERE STATUS != 'Pending' AND EMP_ID = ?";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, employeeId);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				int reimbursementId = rs.getInt("REIMBURSEMENT_ID");
				String status = rs.getString("STATUS");
				int empId = rs.getInt("EMP_ID");
				int mngId = rs.getInt("MANAGER_ID");
				String description = rs.getString("DESCRIPTION");
				String amount = rs.getString("AMOUNT");
				reimbursements.add(new Reimbursement(reimbursementId, status, empId, mngId, description, amount));
				System.out.println(reimbursements);
			}
			rs.close();
			con.close();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return reimbursements;
	}
	
	public int approveReimbursement(int reimbursementId, int mngId) {
		int reimbursementUpdated = 0;
		String sql = "UPDATE P1_REIMBURSEMENT SET STATUS = 'Approved', MANAGER_ID = ? WHERE REIMBURSEMENT_ID = ?";
		try {
			Connection con = ConnectionUtil.getConnection();
			con.setAutoCommit(false);
			PreparedStatement pstatement = con.prepareStatement(sql);
			pstatement.setInt(1, mngId);
			pstatement.setInt(2, reimbursementId);
			reimbursementUpdated = pstatement.executeUpdate();
			con.commit();
			con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return reimbursementUpdated;
		
	}
	
	public int denyReimbursement(int reimbursementId, int mngId) {
		int reimbursementUpdated = 0;
		String sql = "UPDATE P1_REIMBURSEMENT SET STATUS = 'Denied', MANAGER_ID = ? WHERE REIMBURSEMENT_ID = ?";
		try {
			Connection con = ConnectionUtil.getConnection();
			con.setAutoCommit(false);
			PreparedStatement pstatement = con.prepareStatement(sql);
			pstatement.setInt(1, mngId);
			pstatement.setInt(2, reimbursementId);
			reimbursementUpdated = pstatement.executeUpdate();
			con.commit();
			con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return reimbursementUpdated;
		
	}
	
	public List<Reimbursement> getResolved() {
		List<Reimbursement> reimbursements = new ArrayList<Reimbursement>();
				
		try {
			Connection con = ConnectionUtil.getConnection();
			String sql = "SELECT * FROM P1_REIMBURSEMENT WHERE STATUS != 'Pending'";
			PreparedStatement ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				int reimbursementId = rs.getInt("REIMBURSEMENT_ID");
				String status = rs.getString("STATUS");
				int empId = rs.getInt("EMP_ID");
				int mngId = rs.getInt("MANAGER_ID");
				String description = rs.getString("DESCRIPTION");
				String amount = rs.getString("AMOUNT");
				reimbursements.add(new Reimbursement(reimbursementId, status, empId, mngId, description, amount));
				System.out.println(reimbursements);
			}
			rs.close();
			con.close();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return reimbursements;
	}
	
	public List<Reimbursement> getReimbursementsById(int employeeId) {
		List<Reimbursement> reimbursements = new ArrayList<Reimbursement>();
		
		try {
			Connection con = ConnectionUtil.getConnection();
			String sql = "SELECT * FROM P1_REIMBURSEMENT WHERE EMP_ID = ?";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, employeeId);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				int reimbursementId = rs.getInt("REIMBURSEMENT_ID");
				String status = rs.getString("STATUS");
				int empId = rs.getInt("EMP_ID");
				int mngId = rs.getInt("MANAGER_ID");
				String description = rs.getString("DESCRIPTION");
				String amount = rs.getString("AMOUNT");
				reimbursements.add(new Reimbursement(reimbursementId, status, empId, mngId, description, amount));
			}
			rs.close();
			con.close();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return reimbursements;
	}
}
