package com.revature.dao;
import java.util.*;
import com.revature.pojos.Saving;
import com.revature.util.ConnectionUtil;
import java.io.IOException;
import java.sql.*;

public class SavingDaoImpl implements SavingDao
{
	//This method gets the data from the table and populates a hash map with it
	@Override
	public Map<Integer, Saving> getSaving()
	{
		Map<Integer,Saving> savingMap = new HashMap<Integer,Saving>();
		try
		{
			Connection con = ConnectionUtil.getConnection();
			String sql = "SELECT* FROM Saving";
			Statement s = con.createStatement();
			ResultSet rs = s.executeQuery(sql);
			
			//Using the result set method next to iterate through the table and put the data into a hash map of objects
			while(rs.next())
			{
				int savingId = rs.getInt("Saving_ID");
				double balance = rs.getDouble("BALANCE");
				int userId = rs.getInt("USER_ID");
				Integer Id = new Integer(userId);
				
				savingMap.put(Id, new Saving(savingId, balance, userId));
			}
			
		}
		catch (IOException | SQLException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return savingMap;
	}

	//This method gets a row from the table using the id
	@Override
	public Saving getSavingById(int id)
	{
		Saving save = null;
		try
		{
			Connection con = ConnectionUtil.getConnection();
			String sql = "SELECT* FROM SAVING WHERE USER_ID = ?";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			
			while(rs.next())
			{
				int savingId = rs.getInt("SAVING_ID");
				double balance = rs.getDouble("BALANCE");
				int userId = rs.getInt("USER_ID");
				
				save = new Saving(savingId, balance, userId);
			}
		}
		catch (IOException | SQLException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return save;
	}

	//This method creates a new row in the table
	@Override
	public int createSaving(Saving save)
	{
		int savingCreated = 0;
		try
		{
			Connection con = ConnectionUtil.getConnection();
			String sql = "INSERT INTO SAVING(BALANCE, USER_ID) VALUES(?, ?)";
			PreparedStatement ps = con.prepareStatement(sql);
		
			ps.setDouble(1, save.getBalance());
			ps.setInt(2, save.getUserId());
			
			savingCreated = ps.executeUpdate();
		}
		catch (IOException | SQLException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return savingCreated;
	}

	//THis method updates a row in the table
	@Override
	public int updateSaving(Saving save)
	{
		int savingUpdated = 0;
		String sql = "UPDATE SAVING SET BALANCE = ? WHERE SAVING_ID = ?";
		try
		{
			Connection con = ConnectionUtil.getConnection();
			con.setAutoCommit(false);
			PreparedStatement ps = con.prepareStatement(sql);

			ps.setDouble(1, save.getBalance());
			ps.setInt(2, save.getId());
			
			savingUpdated = ps.executeUpdate();
			con.commit();
		}
		catch (IOException | SQLException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return savingUpdated;
	}

	//This method deletes a row in the table
	@Override
	public int deleteSaving(Saving save)
	{
		int rowsUpdated = 0;
		String sql ="DELETE FROM SAVING WHERE SAVING_ID = ?";
		try
		{
			Connection con = ConnectionUtil.getConnection();
			con.setAutoCommit(false);
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, save.getUserId());
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
