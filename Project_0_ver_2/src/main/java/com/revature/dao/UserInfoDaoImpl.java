package com.revature.dao;
import java.io.IOException;
import java.sql.*;
import java.util.*;
import com.revature.pojos.UserInfo;
import com.revature.util.ConnectionUtil;

public class UserInfoDaoImpl implements UserInfoDao
{

	//This method gets the data from the table and inputs it into a hash map
	@Override
	public Map<String,UserInfo> getUserInfo()
	{
		Map<String,UserInfo> uip = new HashMap<String,UserInfo>();
		try
		{
			Connection con = ConnectionUtil.getConnection();
			String sql = "SELECT* FROM USERINFO";
			Statement s = con.createStatement();
			ResultSet rs = s.executeQuery(sql);
			
			while(rs.next())
			{
				int userId = rs.getInt("USER_ID");
				String userName = rs.getString("USER_NAME");
				String userEmail = rs.getString("USER_EMAIL");
				String userPw = rs.getString("USER_PW");
				
				uip.put(userName, new UserInfo(userId, userName, userEmail, userPw));
			}
			
		}
		catch (IOException | SQLException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return uip;
	}

	//This method gets a row from the table by using the id
	@Override
	public UserInfo getUserById(int id)
	{
		UserInfo ui = null;
		try
		{
			Connection con = ConnectionUtil.getConnection();
			String sql = "SELECT * FROM USERINFO WHERE USER_ID = ?";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			
			while(rs.next())
			{
				int userId = rs.getInt("USER_ID");
				String userName = rs.getString("USER_NAME");
				String userEmail = rs.getString("USER_EMAIL");
				String userPw = rs.getString("USER_PW");
				
				ui = new UserInfo(userId, userName, userEmail, userPw);
			}
		}
		catch (IOException | SQLException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return ui;
	}

	//This method adds a new row of data into the table
	@Override
	public int createUser(UserInfo user)
	{
		int userCreated = 0;
		try
		{
			Connection con = ConnectionUtil.getConnection();
			String sql = "INSERT INTO USERINFO(USER_NAME, USER_EMAIL, USER_PW) VALUES(?, ?, ?)";
			PreparedStatement ps = con.prepareStatement(sql);
		
			ps.setString(1, user.getUsername());
			ps.setString(2, user.getEmail());
			ps.setString(3, user.getPw());
			
			userCreated = ps.executeUpdate();
		}
		catch (IOException | SQLException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return userCreated;
	}

	//This method updates a row in the table
	@Override
	public int updateUser(UserInfo user)
	{
		int userUpdated = 0;
		String sql = "UPDATE USERINFO SET USER_NAME = ?, USER_EMAIL = ?, USER_PW = ? WHERE USER_ID = ?";
		try
		{
			Connection con = ConnectionUtil.getConnection();
			con.setAutoCommit(false);
			PreparedStatement ps = con.prepareStatement(sql);
	
			ps.setString(1, user.getUsername());
			ps.setString(2, user.getEmail());
			ps.setString(3, user.getPw());
			ps.setInt(4, user.getId());
			
			userUpdated = ps.executeUpdate();
			con.commit();
		}
		catch (IOException | SQLException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return userUpdated;
	}

	//This method deletes a row in the table
	@Override
	public int deleteUser(UserInfo user)
	{
		int rowsUpdated = 0;
		String sql = "DELETE FROM USERINFO WHERE USER_ID = ?";
	
		try
		{
			Connection con = ConnectionUtil.getConnection();
			con.setAutoCommit(false);
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, user.getId());
			System.out.println("UserImpl id "+ user.getId());
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
