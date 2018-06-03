package com.revature.dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.revature.pojos.User;
import com.revature.util.ConnectionUtil;

public class UserDaoImpl implements UserDao{

	public List<User> getUsers() {
		List<User> userList= new ArrayList<User>();
		
		try {
			Connection conn = ConnectionUtil.getConnection();
			
			String userTable = "SELECT * FROM BANKUSER";
			Statement s = conn.createStatement();
			ResultSet rs = s.executeQuery(userTable);
			while(rs.next()) {
				int userId = rs.getInt("USERID");
				String username = rs.getString("USERNAME");
				String email = rs.getString("USEREMAIL");
				String password = rs.getString("USERPASSWORD");
				List<Long> linkedAccounts = new ArrayList<Long>();
				
				String accts = "SELECT ACCTNUMBER FROM BANKUSER_BANKACCOUNT WHERE USERID = ?";
				PreparedStatement ps = conn.prepareStatement(accts);
				ps.setLong(1, userId);
				ResultSet psrs = ps.executeQuery();
				while (psrs.next()) {
					linkedAccounts.add(psrs.getLong("ACCTNUMBER"));					
				}
				
				userList.add(new User(userId, username, email, password, linkedAccounts));
			}
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}		
		return userList;
	}

	public User getUserById(int userId) {
		User u = null;
		
		try {
			Connection conn = ConnectionUtil.getConnection();
			String sql = "SELECT * FROM BANKUSER WHERE USERID = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, userId);
			ResultSet rs = ps.executeQuery();
			
			while (rs.next()) {
				String username = rs.getString("USERNAME");
				String email = rs.getString("USEREMAIL");
				String password = rs.getString("USERPASSWORD");
				List<Long> linkedAccounts = new ArrayList<Long>();
				
				String accts = "SELECT ACCTNUMBER FROM BANKUSER_BANKACCOUNT WHERE USERID = ?";
				PreparedStatement ps2 = conn.prepareStatement(accts);
				ps2.setLong(1, userId);
				ResultSet rs2 = ps2.executeQuery();
				while (rs2.next()) {
					linkedAccounts.add(rs2.getLong("ACCTNUMBER"));					
				}
				
				u = new User(userId, username, email, password, linkedAccounts);
			}
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return u;
	}

	public int createUser(User user) {
		int userCreated = 0;
		try {
			Connection conn = ConnectionUtil.getConnection();
			String sql = "INSERT INTO BANKUSER (USERNAME, USEREMAIL, USERPASSWORD) VALUES(?,?,?)";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, user.getUsername());
			ps.setString(2, user.getEmail());
			ps.setString(3,  user.getPassword());
			userCreated = ps.executeUpdate();
			
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return userCreated;
	}

	public int updateUser(User user) {
		int userUpdated = 0;
		try {
			Connection conn = ConnectionUtil.getConnection();
			conn.setAutoCommit(false);
			String sql = "UPDATE BANKUSER " +
							"SET USERNAME = ?, USEREMAIL = ?, USERPASSWORD = ? " +
							"WHERE USERID = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, user.getUsername());
			ps.setString(2, user.getEmail());
			ps.setString(3,  user.getPassword());
			ps.setInt(4, user.getUserId());
			userUpdated = ps.executeUpdate();
			conn.commit();
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return userUpdated;
	}

	public int deleteUser(int userId) {
		int userDeleted = 0;
		try {
			Connection conn = ConnectionUtil.getConnection();
			conn.setAutoCommit(false);
			String sql = "DELETE FROM BANKUSER WHERE USERID = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1,  userId);
			userDeleted = ps.executeUpdate();
			conn.commit();
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return userDeleted;
	}
}
