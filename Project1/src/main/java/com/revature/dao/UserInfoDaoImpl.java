package com.revature.dao;
import java.sql.*;
import java.util.*;
import java.io.*;
import com.revature.pojos.*;
import com.revature.util.*;

public class UserInfoDaoImpl implements UserInfoDao
{
	@Override
	public Map<String,UserInfo> getUserInfo()
	{
		Map<String,UserInfo> userInfoMap = new HashMap<String,UserInfo>();
		try
		{
			Connection con = ConnectionUtil.getConnection();
			String sql = "SELECT* FROM USER_INFO";
			Statement s = con.createStatement();
			ResultSet rs = s.executeQuery(sql);
			
			while(rs.next())
			{
				int userId = rs.getInt("USER_ID");
				int isManager = rs.getInt("IS_MANAGER");
				int managerId = rs.getInt("MANAGER_ID");
				String userName = rs.getString("USERNAME");
				String userPw = rs.getString("PW");
				String firstName = rs.getString("FIRSTNAME");
				String lastName = rs.getString("LASTNAME");
				String email = rs.getString("EMAIL");
				String phone = rs.getString("PHONE");
				String address = rs.getString("ADDRESS");
				String state = rs.getString("STATE");
				int zipCode = rs.getInt("ZIPCODE");
					
				userInfoMap.put(userName, new UserInfo(userId, isManager, managerId, userName, userPw, firstName, lastName, email, phone, address, state, zipCode));
			}
			
		}
		catch (IOException | SQLException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return userInfoMap;
	}
	
	@Override
	public UserInfo getUserById(int id)
	{
		UserInfo ui = null;
		try
		{
			Connection con = ConnectionUtil.getConnection();
			String sql = "SELECT * FROM USER_INFO WHERE USER_ID = ?";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			
			while(rs.next())
			{
				int userId = rs.getInt("USER_ID");
				int isManager = rs.getInt("IS_MANAGER");
				int managerId = rs.getInt("MANAGER_ID");
				String userName = rs.getString("USERNAME");
				String userPw = rs.getString("PW");
				String firstName = rs.getString("FIRSTNAME");
				String lastName = rs.getString("LASTNAME");
				String email = rs.getString("EMAIL");
				String phone = rs.getString("PHONE");
				String address = rs.getString("ADDRESS");
				String state = rs.getString("STATE");
				int zipCode = rs.getInt("ZIPCODE");
					
				ui = new UserInfo(userId, isManager, managerId, userName, userPw, firstName, lastName, email, phone, address, state, zipCode);
			}
		}
		catch (IOException | SQLException e)
		{
			e.printStackTrace();
		}
		return ui;
	}
	
	@Override
	public int updateUser(UserInfo ui)
	{
		int userUpdated = 0;
		
		try
		{
			Connection con = ConnectionUtil.getConnection();
			String sql = "UPDATE USER_INFO SET USERNAME = ?, FIRSTNAME= ?, LASTNAME = ?, EMAIL = ?, PW = ?, PHONE = ?, ADDRESS = ?, STATE = ?, ZIPCODE = ? WHERE USER_ID = ?";
			con.setAutoCommit(false);
			PreparedStatement ps = con.prepareStatement(sql);
	
			ps.setString(1, ui.getUsername());
			ps.setString(2, ui.getFirstName());
			ps.setString(3, ui.getLastName());
			ps.setString(4, ui.getEmail());
			ps.setString(5, ui.getPw());
			ps.setString(6, ui.getPhone());
			ps.setString(7, ui.getAddress());
			ps.setString(8, ui.getState());
			ps.setInt(9, ui.getZipCode());
			ps.setInt(10, ui.getId());
			
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

	
	@Override
	public int createUser(UserInfo ui)
	{
		int userCreated = 0;
		try
		{
			Connection con = ConnectionUtil.getConnection();
			String sql = "INSERT INTO USER_INFO(IS_MANAGER,USERNAME,PW,FIRSTNAME,LASTNAME,EMAIL,PHONE,ADDRESS,STATE,ZIPCODE)  VALUES(0,?, ?, ?, ?, ?, ?, ?, ?, ?)";
			PreparedStatement ps = con.prepareStatement(sql);
			con.setAutoCommit(false);
			ps.setString(1, ui.getUsername());
			ps.setString(2, ui.getPw());
			ps.setString(3, ui.getFirstName());
			ps.setString(4, ui.getLastName());
			ps.setString(5, ui.getEmail());
			ps.setString(6, ui.getPhone());
			ps.setString(7, ui.getAddress());
			ps.setString(8, ui.getState());
			ps.setInt(9, ui.getZipCode());
			
			userCreated = ps.executeUpdate();
			con.commit();
		}
		catch (IOException | SQLException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return userCreated;
	}
	
	@Override
	public int deleteUser(UserInfo ui)
	{
		int rowsUpdated = 0;
		String sql = "DELETE FROM USER_INFO WHERE USER_ID = ?";
	
		try
		{
			Connection con = ConnectionUtil.getConnection();
			con.setAutoCommit(false);
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, ui.getId());
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
