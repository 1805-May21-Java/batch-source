package com.revature.dao;

import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;

import com.revature.model.UserAccount;
import com.revautre.util.ConnectionUtil;

public class UserAccountDAOImpl implements UserAccountDAO {
	
	@Override
	public int createUser(UserAccount user) {
		int userCreated = 0;
		
		try {
			Connection con = ConnectionUtil.getConnection();
			String sql = "INSERT INTO RBA_USER (EMAIL, PASSWORD, FIRSTNAME, LASTNAME) VALUES (?,?,?,?)";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, user.getEmail());
			ps.setString(2, user.getPassword());
			ps.setString(3, user.getFirstname());
			ps.setString(4, user.getLastname());
			
			userCreated = ps.executeUpdate();
			
		} catch (IOException | SQLException e) {
			e.printStackTrace();
		}
		
		return userCreated;
	}

	@Override
	public int updateUser(UserAccount user) {
		int userCreated = 0;
		
		try {
			Connection con = ConnectionUtil.getConnection();
			String sql = "UPDATE RBA_USER "
	 				+ "SET EMAIL = ?, "
	 				+ "PASSWORD = ?, "
	 				+ "FIRSTNAME = ?, "
	 				+ "LASTNAME = ? "
	 				+ "WHERE USERID = ?";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, user.getEmail());
			ps.setString(2, user.getPassword());
			ps.setString(3, user.getFirstname());
			ps.setString(4, user.getLastname());
			ps.setInt(5, user.getAccountid());
			
			userCreated = ps.executeUpdate();
			
		} catch (IOException | SQLException e) {
			e.printStackTrace();
		}
		
		return userCreated;
	}

	@Override
	public int deleteUser(int id) {
		int userCreated = 0;
		
		try {
			Connection con = ConnectionUtil.getConnection();
			String sql = "DELETE FROM RBA_USER WHERE USERID = ?";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, id);
			
			userCreated = ps.executeUpdate();
			
		} catch (IOException | SQLException e) {
			e.printStackTrace();
		}
		
		return userCreated;
	}

	@Override
	public String logInCheck(String email, String password) {
		String passwordCheck= "";
		
		try {
			Connection con = ConnectionUtil.getConnection();
			String sql = "SELECT EMAIL, PASSWORD FROM RBA_USER WHERE EMAIL=?";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, email);
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				passwordCheck = rs.getString("PASSWORD");
				return passwordCheck;
			}
			//con.close();
			
			
		} catch (IOException | SQLException e) {
			e.printStackTrace();
		}
		
		return passwordCheck;
	}

	@Override
	public UserAccount getUserByEmail(String email) {
		UserAccount user1 = null;
		
		try {
			Connection con = ConnectionUtil.getConnection();
			String sql = "SELECT * FROM USERACCOUNT WHERE EMAIL = ?";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1,  email);
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				int userID = rs.getInt("USERID");
				String password = rs.getString("PASSWORD");
				String firstname = rs.getString("FIRSTNAME");
				String lastname = rs.getString("LASTNAME");
				
				user1 = new UserAccount(userID, email, password, firstname, lastname);
			}
			
			
		} catch (IOException | SQLException e1) {
			e1.printStackTrace();
		}
		return user1;
	}

}
