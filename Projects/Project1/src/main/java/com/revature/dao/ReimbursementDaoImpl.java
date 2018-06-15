package com.revature.dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.revature.pojos.Reimbursement;
import com.revature.util.ConnectionUtil;

public class ReimbursementDaoImpl implements ReimbursementDao
{

	@Override
	public List<Reimbursement> getReimbursements()
	{
		List<Reimbursement> reimbursements = new ArrayList<>();
		try
		{
			Connection con = ConnectionUtil.getConnection();
			String sql = "SELECT * FROM REIMBURSE";
			Statement s = con.createStatement();
			ResultSet rs = s.executeQuery(sql);
			
			while(rs.next())
			{
				int reimburseId = rs.getInt("REIMBURSE_ID");
				int requestBy = rs.getInt("REQUEST_BY");
				Double amount = rs.getDouble("AMOUNT");
				int aprroveBy = rs.getInt("APPROVE_BY");
				Date dateRequest = rs.getDate("DATE_REQUEST");
				Date dateApprove = rs.getDate("DATE_APPROVE");
				String status = rs.getString("STATUS");
				String url = rs.getString("URL");
				reimbursements.add(new Reimbursement(reimburseId, requestBy, amount, aprroveBy, dateRequest, dateApprove, status, url));
			}
			con.close();
			
		} catch (IOException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return reimbursements;
	}

	@Override
	public Reimbursement getReimbursementById(int id)
	{
		Reimbursement reimbursement = null;
		try {
			Connection con = ConnectionUtil.getConnection();
			String sql = "SELECT * FROM REIMBURSE WHERE REIMBURSE_ID = ?";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();	
			while(rs.next()) {
				int reimburseId = rs.getInt("REIMBURSE_ID");
				int requestBy = rs.getInt("REQUEST_BY");
				Double amount = rs.getDouble("AMOUNT");
				int aprroveBy = rs.getInt("APPROVE_BY");
				Date dateRequest = rs.getDate("DATE_REQUEST");
				Date dateApprove = rs.getDate("DATE_APPROVE");
				String status = rs.getString("STATUS");
				String url = rs.getString("URL");
				reimbursement = new Reimbursement(reimburseId, requestBy, amount, aprroveBy, dateRequest, dateApprove, status, url);
			}		
			con.close();

		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}	
		return reimbursement;
	}

	@Override
	public void createReimbursement(Reimbursement newReimbursement)
	{
		try {
			Connection con = ConnectionUtil.getConnection();
			String sql = "INSERT INTO REIMBURSE (REQUEST_BY, AMOUNT, APPROVE_BY, DATE_REQUEST, DATE_APPROVE, STATUS, URL) VALUES (?,?,?,?,?,?,?)";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, newReimbursement.getRequestBy());
			ps.setDouble(2, newReimbursement.getAmount());
			ps.setInt(3, newReimbursement.getApproveBy());
			ps.setDate(4, newReimbursement.getDateRequest());
			ps.setDate(5, newReimbursement.getDateApprove());
			ps.setString(6, newReimbursement.getStatus());
			ps.setString(7, newReimbursement.getUrl());
			ps.executeUpdate();
			
			con.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}


	@Override
	public void deleteReimbursementById(int id)
	{
	String sql = "DELETE FROM REIMBURSE WHERE REIMBURSE_ID = ?";
		
		try 
		{
			Connection con = ConnectionUtil.getConnection();
			con.setAutoCommit(false);
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, id);	
			ps.executeUpdate();
			con.commit();
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public void updateReimbursement(Reimbursement newReimbursement)
	{
		String sql = "UPDATE REIMBURSE "
				+ "SET REQUEST_BY = ?, "
				+ "AMOUNT = ?, "
				+ "APPROVE_BY = ?, "
				+ "DATE_REQUEST = ?, "
				+ "DATE_APPROVE = ?, "
				+ "STATUS = ?, "
				+"URL = ? "
				+ "WHERE REIMBURSE_ID = ?";
		try {
			Connection con = ConnectionUtil.getConnection();
			con.setAutoCommit(false);
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, newReimbursement.getRequestBy());
			ps.setDouble(2, newReimbursement.getAmount());
			ps.setInt(3, newReimbursement.getApproveBy());
			ps.setDate(4, newReimbursement.getDateRequest());
			ps.setDate(5, newReimbursement.getDateApprove());
			ps.setString(6, newReimbursement.getStatus());
			ps.setString(7, newReimbursement.getUrl());
			ps.setInt(8, newReimbursement.getReimburseId());
			
			ps.executeUpdate();
			con.commit();
			con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

}
