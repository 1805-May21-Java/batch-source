package com.revature.dao;
import java.sql.*;
import java.io.*;
import java.util.*;
import com.revature.pojos.*;
import com.revature.util.ConnectionUtil;

public class ReimbursementDaoImpl implements ReimbursementDao
{
	@Override
	public List<Reimbursement> getReimbursementInfo()
	{
		List<Reimbursement> reimInfoList = new ArrayList<Reimbursement>();
		try
		{
			Connection con;
			con = ConnectionUtil.getConnection();
			String sql = "SELECT* FROM REIMBURSEMENTS";
			Statement s = con.createStatement();
			ResultSet rs = s.executeQuery(sql);
			
			while(rs.next())
			{
				int reimbursementId = rs.getInt("REIMB_ID");
				String reason = rs.getString("REASON");
				double amount = rs.getDouble("AMOUNT");
				int isPending = rs.getInt("PENDING");
				int resolvedBy = rs.getInt("RESOLVED_BY_MANAGER");
				int userId = rs.getInt("USER_ID");
				
				reimInfoList.add(new Reimbursement(reimbursementId, reason, amount, userId, isPending, resolvedBy));
			}
		}
		catch (IOException | SQLException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return reimInfoList;
	}
	
	@Override
	public List<Reimbursement> getResolvedReimbursementInfo()
	{
		List<Reimbursement> reimInfoList = new ArrayList<Reimbursement>();
		try
		{
			Connection con;
			con = ConnectionUtil.getConnection();
			String sql = "SELECT* FROM REIMBURSEMENTS WHERE PENDING = 0";
			Statement s = con.createStatement();
			ResultSet rs = s.executeQuery(sql);
			
			while(rs.next())
			{
				int reimbursementId = rs.getInt("REIMB_ID");
				String reason = rs.getString("REASON");
				double amount = rs.getDouble("AMOUNT");
				int isPending = rs.getInt("PENDING");
				int resolvedBy = rs.getInt("RESOLVED_BY_MANAGER");
				int userId = rs.getInt("USER_ID");
				
				reimInfoList.add(new Reimbursement(reimbursementId, reason, amount, isPending, resolvedBy, userId));
			}
		}
		catch (IOException | SQLException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return reimInfoList;
	}
	
	@Override
	public List<Reimbursement> getReimbursementById(int id)
	{
		List<Reimbursement> reimInfoList = new ArrayList<Reimbursement>();

		try
		{
			Connection con = ConnectionUtil.getConnection();
			String sql = "SELECT * FROM REIMBURSEMENTS WHERE USER_ID = ?";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			
			while(rs.next())
			{
				int reimbursementId = rs.getInt("REIMB_ID");
				String reason = rs.getString("REASON");
				double amount = rs.getDouble("AMOUNT");
				int isPending = rs.getInt("PENDING");
				int resolvedBy = rs.getInt("RESOLVED_BY_MANAGER");
				int userId = rs.getInt("USER_ID");
				reimInfoList.add(new Reimbursement(reimbursementId, reason, amount, isPending, resolvedBy, userId));
			}
		}
		catch (IOException | SQLException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return reimInfoList;
	}
	
	@Override
	public List<Reimbursement> getResolvedReimbursementById(int id)
	{
		List<Reimbursement> reimInfoList = new ArrayList<Reimbursement>();

		try
		{
			Connection con = ConnectionUtil.getConnection();
			String sql = "SELECT * FROM REIMBURSEMENTS WHERE USER_ID = ? AND PENDING = 0";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			
			while(rs.next())
			{
				int reimbursementId = rs.getInt("REIMB_ID");
				String reason = rs.getString("REASON");
				double amount = rs.getDouble("AMOUNT");
				int isPending = rs.getInt("PENDING");
				int resolvedBy = rs.getInt("RESOLVED_BY_MANAGER");
				int userId = rs.getInt("USER_ID");
				reimInfoList.add(new Reimbursement(reimbursementId, reason, amount, isPending, resolvedBy, userId));
			}
		}
		catch (IOException | SQLException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return reimInfoList;
	}
	
	@Override
	public int updateReimbursement(Reimbursement re)
	{
		int reimbursementUpdated = 0;
		
		try
		{
			Connection con = ConnectionUtil.getConnection();
			String sql = "UPDATE REIMBURSEMENTS SET PENDING = 0, RESOLVED_BY_MANAGER = ? WHERE REIMB_ID = ?";
			con.setAutoCommit(false);
			PreparedStatement ps = con.prepareStatement(sql);
			
			ps.setInt(1, re.getUserId());
			ps.setInt(2, re.getId());
			
			reimbursementUpdated = ps.executeUpdate();
			con.commit();
		}
		catch (IOException | SQLException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return reimbursementUpdated;
	}
	
	@Override
	public int createReimbursement(Reimbursement re)
	{
		int reimbursementCreated = 0;
		try
		{
			Connection con =  ConnectionUtil.getConnection();
			String sql = "INSERT INTO REIMBURSEMENTS(REASON, AMOUNT, PENDING, RESOLVED_BY_MANAGER, USER_ID) VALUES(?,?,1,NULL,?)";
			con.setAutoCommit(false);
			PreparedStatement ps = con.prepareStatement(sql);
			
			ps.setString(1, re.getReason());
			ps.setDouble(2, re.getAmount());
			ps.setInt(3, re.getUserId());
			
			reimbursementCreated = ps.executeUpdate();
			con.commit();
		}
		catch (IOException | SQLException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return reimbursementCreated;
	}
}
