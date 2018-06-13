package com.revature.dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.LinkedList;

import com.revature.pojo.Employee;
import com.revature.pojo.Reimbursement;
import com.revature.util.ConnectionUtil;

public class ERSDaoImpl implements ERSDao {

	public LinkedList<Reimbursement> getReimbursementsByEmplID(int empl_id) {
		LinkedList<Reimbursement> reimbs = new LinkedList<Reimbursement>();
		
		try {
			Connection con = ConnectionUtil.getConnection();
			String sql = "SELECT * FROM ERS_REIMBURSEMENT WHERE REQ_BY = ?"
					+ " ORDER BY REIMB_ID ASC";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, empl_id);
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				int ID = rs.getInt("REIMB_ID");
				String picURL = rs.getString("PIC_URL");
				double amount = rs.getDouble("AMOUNT_REQ");
				Date dateReq = rs.getDate("DATE_REQ");
				String status = rs.getString("STATUS");
				int approveID = rs.getInt("APPR_BY");
				Date dateApprove = rs.getDate("DATE_APPR");
				
				reimbs.add(new Reimbursement(ID, empl_id, picURL, amount,
						dateReq, status, approveID, dateApprove));
			}
			
			con.close();
			
		} catch (IOException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return reimbs;
	}

	public Employee getEmployeeByEmail(String email) {
		Employee empl = null;
		
		try {
			Connection con = ConnectionUtil.getConnection();
			String sql = "SELECT * FROM ERS_EMPLOYEE WHERE EMAIL = ?";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, email);
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				int empl_id = rs.getInt("EMPL_ID");
				String pass = rs.getString("PASS");
				String first = rs.getString("FIRST");
				String last = rs.getString("LAST");
				Date bday = rs.getDate("BDAY");
				String title = rs.getString("TITLE");
				int managerID = rs.getInt("REPORTS_TO");
				
				empl = new Employee(empl_id, email, pass, first,
						last, bday, title, managerID);
			}
			
			con.close();
			
		} catch (IOException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return empl;
	}

	public Reimbursement getReimbursementByID(int ID) {
		Reimbursement reimb = null;
		
		try {
			Connection con = ConnectionUtil.getConnection();
			String sql = "SELECT * FROM ERS_REIMBURSEMENT WHERE REIMB_ID = ?";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, ID);
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				int empl_id = rs.getInt("REQ_BY");
				String picURL = rs.getString("PIC_URL");
				double amount = rs.getDouble("AMOUNT_REQ");
				Date dateReq = rs.getDate("DATE_REQ");
				String status = rs.getString("STATUS");
				int approveID = rs.getInt("APPR_BY");
				Date dateApprove = rs.getDate("DATE_APPR");
				
				reimb = new Reimbursement(ID, empl_id, picURL, amount,
						dateReq, status, approveID, dateApprove);
			}
			
			con.close();
			
		} catch (IOException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return reimb;
	}

	public int createEmployee(Employee empl) {
		int emplsCreated = 0;
		
		try {
			Connection con = ConnectionUtil.getConnection();
			String sql = "INSERT INTO ERS_EMPLOYEE VALUES(?, ?, ?, ?, ?, ?, ?, ?)";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, empl.getID());
			ps.setString(2, empl.getEmail());
			ps.setString(3, empl.getPass());
			ps.setString(4, empl.getFirst());
			ps.setString(5, empl.getLast());
			ps.setDate(6, empl.getBday());
			ps.setString(7, empl.getTitle());
			if(empl.getManagerID() != 0)
				ps.setInt(8, empl.getManagerID());
			else
				ps.setNull(8, Types.INTEGER);
			emplsCreated = ps.executeUpdate();
			
			con.close();
			
		} catch (IOException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return emplsCreated;
	}

	public int createReimbursement(Reimbursement reimb) {
		int reimbsCreated = 0;
		
		try {
			Connection con = ConnectionUtil.getConnection();
			String sql = "INSERT INTO ERS_REIMBURSEMENT VALUES(?, ?, ?, ?, ?, ?, ?, ?)";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, reimb.getID());
			ps.setInt(2, reimb.getRequestID());
			ps.setString(3, reimb.getPicURL());
			ps.setDouble(4, reimb.getAmountRequest());
			ps.setDate(5, reimb.getDateOfRequest());
			ps.setString(6, reimb.getStatus());
			ps.setInt(7, reimb.getApproveID());
			ps.setDate(8, reimb.getDateOfApprove());
			reimbsCreated = ps.executeUpdate();
			
			con.close();
			
		} catch (IOException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return reimbsCreated;
	}

	public int updateEmployee(Employee empl) {
		int emplsUpdated = 0;
		
		try {
			Connection con = ConnectionUtil.getConnection();
			con.setAutoCommit(false);
			String sql = "UPDATE ERS_EMPLOYEE " +
					"SET EMAIL = ?, " +
					"PASS = ?, " +
					"FIRST = ?, " +
					"LAST = ?, " +
					"BDAY = ?, " +
					"TITLE = ?, " +
					"REPORTS_TO = ? " +
					"WHERE EMPL_ID = ?";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, empl.getEmail());
			ps.setString(2, empl.getPass());
			ps.setString(3, empl.getFirst());
			ps.setString(4, empl.getLast());
			ps.setDate(5, empl.getBday());
			ps.setString(6, empl.getTitle());
			ps.setInt(7, empl.getManagerID());
			ps.setInt(8, empl.getID());
			emplsUpdated = ps.executeUpdate();
			
			con.commit();
			con.close();
			
		} catch (IOException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return emplsUpdated;
	}

	public int updateReimbursement(Reimbursement reimb) {
		int reimbsUpdated = 0;
		
		try {
			Connection con = ConnectionUtil.getConnection();
			con.setAutoCommit(false);
			String sql = "UPDATE ERS_REIMBURSEMENT " +
					"SET REQ_BY = ?, " +
					"PIC_URL = ?, " +
					"AMOUNT_REQ = ?, " +
					"DATE_REQ = ?, " +
					"STATUS = ?, " +
					"APPR_BY = ?, " +
					"DATE_APPR = ? " +
					"WHERE REIMB_ID = ?";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, reimb.getRequestID());
			ps.setString(2, reimb.getPicURL());
			ps.setDouble(3, reimb.getAmountRequest());
			ps.setDate(4, reimb.getDateOfRequest());
			ps.setString(5, reimb.getStatus());
			ps.setInt(6, reimb.getApproveID());
			ps.setDate(7, reimb.getDateOfApprove());
			ps.setInt(8, reimb.getID());
			reimbsUpdated = ps.executeUpdate();
			
			con.commit();
			con.close();
			
		} catch (IOException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return reimbsUpdated;
	}

	public int deleteEmployeeByID(int empl_id) {
		int emplsUpdated = 0;
		
		try {
			Connection con = ConnectionUtil.getConnection();
			con.setAutoCommit(false);
			String sql = "DELETE FROM ERS_EMPLOYEE WHERE EMPL_ID = ?";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, empl_id);
			emplsUpdated = ps.executeUpdate();
			
			con.commit();
			con.close();
			
		} catch (IOException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return emplsUpdated;
	}
}
