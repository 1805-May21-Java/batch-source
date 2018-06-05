package com.revature.dao;

import java.io.IOException;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.revature.pojos.User;
import com.revature.util.ConnectionUtil;

public class UserDaoImpl implements UserDao
{

	public UserDaoImpl()
	{
	
	}

	@Override
	public List<User> getUsers()
	{
		
		List<User> users = new ArrayList<>();
		try
		{
			Connection con = ConnectionUtil.getConnection();
			String sql = "SELECT * FROM USERS";
			Statement s = con.createStatement();
			ResultSet rs = s.executeQuery(sql);
			
			while(rs.next())
			{
				String userId = rs.getString("USER_ID");
				String userName = rs.getString("USER_NAME");
				String userPassword = rs.getString("USER_PASSWORD");
				Double userBalance = rs.getDouble("BALANCE");
				users.add(new User(userId, userName, userPassword, userBalance));
			}
			con.close();
			
		} catch (IOException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return users;

	}

	@Override
	public User getUserById(String id)
	{
		User user = null;
		
		try {
			Connection con = ConnectionUtil.getConnection();
			String sql = "SELECT * FROM USERS WHERE USER_ID = ?";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, id);
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				String userId = rs.getString("USER_ID");
				String userName = rs.getString("USER_NAME");
				String userPassword = rs.getString("USER_PASSWORD");
				Double userBalance = rs.getDouble("BALANCE");
				
				user = new User(userId, userName, userPassword, userBalance);
			}
			
			con.close();

		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		return user;
	}

	@Override
	public void createUser(User newUser)
	{
		
		try {
			Connection con = ConnectionUtil.getConnection();
			String sql = "INSERT INTO USERS (USER_ID, USER_NAME, USER_PASSWORD, BALANCE) VALUES (?,?,?,?)";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, newUser.getUserId());
			ps.setString(2, newUser.getUserName());
			ps.setString(3, newUser.getPassword());
			ps.setDouble(4, newUser.getBalance());
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
	public void updateUser(User newUser)
	{
		String sql = "UPDATE USERS "
				+ "SET USER_ID = ?, "
				+ "USER_NAME = ?, "
				+ "USER_PASSWORD = ?, "
				+ "BALANCE = ? "
				+ "WHERE USER_ID = ?";
		try {
			Connection con = ConnectionUtil.getConnection();
			con.setAutoCommit(false);
			PreparedStatement pstatement = con.prepareStatement(sql);
			pstatement.setString(1, newUser.getUserId());
			pstatement.setString(2, newUser.getUserName());
			pstatement.setString(3, newUser.getPassword());
			pstatement.setDouble(4, newUser.getBalance());
			pstatement.setString(5, newUser.getUserId());
			pstatement.executeUpdate();
			con.commit();
			con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public void deleteUserById(String id)
	{
		String sql = "DELETE FROM USERS WHERE USER_ID = ?";
		
		try 
		{
			Connection con = ConnectionUtil.getConnection();
			con.setAutoCommit(false);
			PreparedStatement pstatement = con.prepareStatement(sql);
			pstatement.setString(1, id);	
			pstatement.executeUpdate();
			con.commit();
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public User getUserByName(String name) {
		User user = null;
		
		try {
			Connection con = ConnectionUtil.getConnection();
			String sql = "SELECT * FROM USERS WHERE USER_NAME = ?";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, name);
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				String userId = rs.getString("USER_ID");
				String userName = rs.getString("USER_NAME");
				String userPassword = rs.getString("USER_PASSWORD");
				Double userBalance = rs.getDouble("BALANCE");
				
				user = new User(userId, userName, userPassword, userBalance);
			}
			
			con.close();

		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		return user;
	}

	@Override
	public Boolean isUserNameExist(String newName) {
		try {
			Connection con = ConnectionUtil.getConnection();
			String sql = "SELECT * FROM USERS WHERE USER_NAME = ?";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, newName);
			ResultSet rs = ps.executeQuery();
			
			if(rs.next()) {
				return true;
			}else
			{
				return false;
			}
			
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		return false;
	}

	@Override
	public Boolean isAuthenticated(String newName, String newPassword) {
		try {
			Connection con = ConnectionUtil.getConnection();
			String sql = "SELECT * FROM USERS WHERE USER_NAME = ? AND USER_PASSWORD = ? ";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, newName);
			ps.setString(2, newPassword);
			ResultSet rs = ps.executeQuery();
		
			if(rs.next()) {
				return true;
			}else
			{
				return false;
			}
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		return false;
	}

	@Override
	public int rowSize() {
		
		int count=0;
		try
		{
			Connection con = ConnectionUtil.getConnection();
			String sql = "SELECT max(USER_ID) FROM USERS";
			Statement s = con.createStatement();
			ResultSet rs = s.executeQuery(sql);
			
			while(rs.next())
			{
				count = rs.getInt(1);
			}
			con.close();
			
		} catch (IOException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return count;

	}
	
	public int callable()
	{
		try {
		int size=0;
		Connection con = ConnectionUtil.getConnection();
		String sql = "{call ROW_SIZE(?)}";
		CallableStatement cs = con.prepareCall(sql);
		cs.setInt(1, size);
	
		cs.execute();
		con.close();
		return size;
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	return 0;
	}

}
