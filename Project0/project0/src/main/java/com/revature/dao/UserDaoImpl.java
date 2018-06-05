package com.revature.dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import com.revature.pojos.User;
import com.revature.util.ConnectionUtil;

public class UserDaoImpl implements UserDao {
	public int createUser(User user) {
		int userCreated = 0;

		try {
			Connection con = ConnectionUtil.getConnection();
			String sql = "INSERT INTO BANK_USER (USERNAME, USER_PASSWORD) VALUES(?,?)";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, user.getUsername());
			ps.setString(2, user.getPassword());
			userCreated = ps.executeUpdate();
			con.close();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (SQLIntegrityConstraintViolationException e) {
			System.out.println("A user with that username already exists. Please try again with a different username.");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return userCreated;
	}

	@Override
	public User getUser(String username, String password) {
		User user = null;
		try {
			Connection con = ConnectionUtil.getConnection();
			String sql = "SELECT * FROM BANK_USER WHERE USERNAME=? AND USER_PASSWORD=?";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, username);
			ps.setString(2, password);
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				user = new User(username, password);
				System.out.println("Successfully logged in.");
			}
			
			if(user == null)
				System.out.println("Invalid username/password combination. Please try again");
			
			con.close();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return user;
	}
}
