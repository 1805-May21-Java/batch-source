package com.revature.htulipan.banking2.database.dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.revature.htulipan.banking2.database.pojos.User;
import com.revature.htulipan.banking2.database.util.ConnectionUtil;

public class UserDaoImpl implements UserDao {

	public boolean userExists(String username) {
		
		String sql = "SELECT USERNAME FROM BANKUSER";

		try {
			Connection con = ConnectionUtil.getConnection();
			PreparedStatement pstatement = con.prepareStatement(sql);
			ResultSet rs = pstatement.executeQuery();

			while (rs.next()) {
				String un = rs.getString("USERNAME");
				if (un.equals(username)) return true;
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		} catch (IOException e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}

		return false;
	}

	public boolean insertUser(User newUser) {
		
		boolean executeResult = false;
		String sql = "INSERT INTO BANKUSER (USERNAME, USERPASSWORD) VALUES (?, ?)";
		
		try {
			Connection con = ConnectionUtil.getConnection();
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, newUser.getUsername());
			ps.setString(2,  newUser.getPassword());
			executeResult = ps.execute();
		} catch (SQLException e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		} catch (IOException e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
		
		return executeResult;
	}

	public User getUser(String username) {
		
		String un = "";
		String pw = "";
		
		String sql = "SELECT * FROM BANKUSER WHERE USERNAME = ?";
		
		try {
			Connection con = ConnectionUtil.getConnection();
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1,  username);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				un = rs.getString("USERNAME");
				pw = rs.getString("USERPASSWORD"); 
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		} catch (IOException e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
		
		User result = new User(un, pw);
		return result;
	}

	public boolean correctPassword(String username, String password) {
		return false;
	}

}