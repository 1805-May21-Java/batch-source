package com.revature.revaturebankingapp;

import java.io.IOException;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.revature.pojos.Employee;
import com.revature.utilities.ConnectionUtil;

public class UserDAOImpl implements UserDAO {

	
	//Method to create user
	@Override
	public int createUser(User user) {
		int userCreated = 0;
		
		try {
			Connection con = ConnectionUtility.getConnection();
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

	//Method to update user
	@Override
	public int updateUser(User user) {
		int userCreated = 0;
		
		try {
			Connection con = ConnectionUtility.getConnection();
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

	//Method to delete user
	@Override
	public int deleteUser(int id) {
		int userCreated = 0;
		
		try {
			Connection con = ConnectionUtility.getConnection();
			String sql = "DELETE FROM RBA_USER WHERE USERID = ?";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, id);
			
			userCreated = ps.executeUpdate();
			
		} catch (IOException | SQLException e) {
			e.printStackTrace();
		}
		
		return userCreated;
	}
	//Method to login user
	@Override
	public String logInCheck(String email, String password) {
		String passwordCheck= "";
		
		try {
			Connection con = ConnectionUtility.getConnection();
			String sql = "SELECT EMAIL, PASSWORD FROM RBA_USER WHERE EMAIL=?";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, email);
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				passwordCheck = rs.getString("PASSWORD");
				return passwordCheck;
			}
	
			
		} catch (IOException | SQLException e) {
			e.printStackTrace();
		}
		
		return passwordCheck;
	}
	//Method to return user by email input
	@Override
	public User getUserByEmail(String email) {
		User user1 = null;
		
		try {
			Connection con = ConnectionUtil.getConnection();
			String sql = "SELECT * FROM RBA_USER WHERE EMAIL = ?";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1,  email);
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				int userID = rs.getInt("USERID");
				String password = rs.getString("PASSWORD");
				String firstname = rs.getString("FIRSTNAME");
				String lastname = rs.getString("LASTNAME");
				
				user1 = new User(userID, email, password, firstname, lastname);
			}
			
			
		} catch (IOException | SQLException e1) {
			e1.printStackTrace();
		}
		return user1;
	}

}
