package com.revature.dao;
import java.util.*;
import java.sql.*;
import java.io.IOException;
import com.revature.pojos.Checking;
import com.revature.util.ConnectionUtil;

public class CheckingDaoImpl implements CheckingDao
{
	//This method fetches the data from the table and puts into a hash map
	@Override
	public Map<Integer, Checking> getChecking()
	{
		Map<Integer,Checking> checkingMap = new HashMap<Integer,Checking>();
		try
		{
			Connection con = ConnectionUtil.getConnection();
			String sql = "SELECT* FROM CHECKING";
			Statement s = con.createStatement();
			ResultSet rs = s.executeQuery(sql);
			
			//Use the next method from result set to iterate through the table and put the data into a hash map of objects
			while(rs.next())
			{
				int checkingId = rs.getInt("CHECKING_ID");
				double balance = rs.getDouble("BALANCE");
				int userId = rs.getInt("USER_ID");
				Integer Id = new Integer(userId);
				
				checkingMap.put(Id, new Checking(checkingId, balance, userId));
			}
			
		}
		catch (IOException | SQLException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return checkingMap;
	}

	//This method gets one row in the table using the id
	@Override
	public Checking getCheckingById(int id)
	{
		Checking check = null;
		try
		{
			Connection con = ConnectionUtil.getConnection();
			String sql = "SELECT* FROM CHECKING WHERE USER_ID = ?";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			
			while(rs.next())
			{
				int checkingId = rs.getInt("CHECKING_ID");
				double balance = rs.getDouble("BALANCE");
				int userId = rs.getInt("USER_ID");
				
				check = new Checking(checkingId, balance, userId);
			}
		}
		catch (IOException | SQLException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return check;
	}
	
	//This method creates a new row in the table
	@Override
	public int createChecking(Checking check)
	{
		int checkingCreated = 0;
		try
		{
			Connection con = ConnectionUtil.getConnection();
			String sql = "INSERT INTO CHECKING(BALANCE, USER_ID) VALUES(?, ?)";
			PreparedStatement ps = con.prepareStatement(sql);
		
			ps.setDouble(1, check.getBalance());
			ps.setInt(2, check.getUserId());
			
			checkingCreated = ps.executeUpdate();
		}
		catch (IOException | SQLException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return checkingCreated;
	}

	//This method updates a row
	@Override
	public int updateChecking(Checking check)
	{
		int checkingUpdated = 0;
		String sql = "UPDATE CHECKING SET BALANCE = ? WHERE CHECKING_ID = ?";
		try
		{
			Connection con = ConnectionUtil.getConnection();
			con.setAutoCommit(false);
			PreparedStatement ps = con.prepareStatement(sql);
			
			ps.setDouble(1, check.getBalance());
			ps.setInt(2, check.getId());
			
			checkingUpdated = ps.executeUpdate();
			con.commit();
		}
		catch (IOException | SQLException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return checkingUpdated;
	}

	//This method deletes a row
	@Override
	public int deleteChecking(Checking check)
	{
		int rowsUpdated = 0;
		String sql ="DELETE FROM CHECKING WHERE CHECKING_ID = ?";
		try
		{
			Connection con = ConnectionUtil.getConnection();
			con.setAutoCommit(false);
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, check.getUserId());
			rowsUpdated = ps.executeUpdate();
			con.commit();
			
		}
		catch (IOException | SQLException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return rowsUpdated;
	}
	
}
