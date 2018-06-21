package com.revature.dao;

import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import com.revature.pojos.Reimbursement;
import com.revature.util.ConnectionUtil;

public class ReimbursementDAOImpl implements ReimbursementDAO {

	//Handles and Receives all listed Reimbursements
	public List<Reimbursement> getReimburse() {
		List<Reimbursement> reimList = new ArrayList<Reimbursement>();
		
		try {
			Connection conn = ConnectionUtil.getConnection();
			String sql = "SELECT * FROM EMPLOYEE";
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				int reimID = rs.getInt("R_ID");
				int modiID = rs.getInt("MODIFIER_ID");
				int money = rs.getInt("AMOUNT");
				String reason = rs.getString("REASON");
				Date dMade = rs.getDate("DATE_MADE");
				Date dModi = rs.getDate("DATE_MODI");
				int state = rs.getInt("STATE_NUMBER");
				int workerID = rs.getInt("E_ID");
				int typeID = rs.getInt("TYPE_ID");
				
				reimList.add(new Reimbursement(reimID,modiID,money,reason,dMade,dModi,state,workerID,typeID));
			}
			conn.close();
		}catch(SQLException e) {
			e.printStackTrace();
		}catch(IOException e) {
			e.printStackTrace();
		}
		
		return reimList;
	}
	
	//Find Reimbursement related by ID of the employee
	public List<Reimbursement> getReimByID(int ID) {
		List<Reimbursement> reimburseList = new ArrayList<Reimbursement>();
		
		try {
			Connection conn = ConnectionUtil.getConnection();
			String sql = "SELECT * FROM REIMBURSEMENT WHERE E_ID = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, ID);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				int reimID = rs.getInt("R_ID");
				int modiID = rs.getInt("MODIFIER_ID");
				int money = rs.getInt("AMOUNT");
				String reason = rs.getString("REASON");
				Date dMade = rs.getDate("DATE_MADE");
				Date dModi = rs.getDate("DATE_MODI");
				int state = rs.getInt("STATE_NUMBER");
				int workerID = rs.getInt("E_ID");
				int typeID = rs.getInt("TYPE_ID");
				
				reimburseList.add(new Reimbursement(reimID,modiID,money,reason,dMade,dModi,state,workerID,typeID));
			}
			conn.close();
		}catch(SQLException e) {
			e.printStackTrace();
		}catch(IOException e) {
			e.printStackTrace();
		}
		return reimburseList;
	}

	public int reimAnswer(int r_id, int stateNum, int mod_id) {
		return 0;
	}

	//Handles and creates method to handle a reimbursement being created
	public void createReim(int mod_id,double amount,String reason, int state, int e_id, String title) {		
		try {
			Connection conn = ConnectionUtil.getConnection();
			String sql = "INSERT INTO REIMBURSEMENT (MODIFIER_ID,AMOUNT,REASON,DATE_MADE,DATE_MODI,STATE_NUMBER,E_ID,TYPE_ID) VALUES(?,?,?,?,?,?,?,?)";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, mod_id);
			ps.setDouble(2, amount);
			ps.setString(3, reason);
			ps.setTimestamp(4, new Timestamp(System.currentTimeMillis()));
			ps.setTimestamp(5, new Timestamp(System.currentTimeMillis()));
			ps.setInt(6, state);
			ps.setInt(7, e_id);
			ps.setString(8, title);
			
			conn.close();
		}catch(SQLException e) {
			e.printStackTrace();
		}catch(IOException e) {
			e.printStackTrace();
		}
		
	}
	
}
