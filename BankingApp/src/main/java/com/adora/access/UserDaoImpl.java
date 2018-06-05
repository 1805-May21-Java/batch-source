package com.adora.access;

import java.io.IOException;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.adora.object.User;
import com.adora.util.ConnectionUtil;

public class UserDaoImpl implements UserDao {

	
	
	@Override
	public List<User> getUsers() {
		List<User> userList = new ArrayList<User>();
		
		try (Connection conn = ConnectionUtil.getConnection()){
			String sql = "SELECT * FROM bankUser";
			Statement s = conn.createStatement();
			ResultSet result = s.executeQuery(sql);	

			while(result.next()) {
				int userId = result.getInt("user_id");
				String username = result.getString("user_name");
				String password = result.getString("user_pass");
				userList.add(new User(userId, username, password));
			}
			
			
		} catch (IOException | SQLException e) {
			e.printStackTrace();
		}
		
		return userList;
	}
	
	@Override
	public List<String> getUserNames() {
		List<String> userNames = new ArrayList<String>();
		
		try (Connection conn = ConnectionUtil.getConnection()){
			String sql = "SELECT user_name FROM bankUser";
			Statement s = conn.createStatement();
			ResultSet result = s.executeQuery(sql);
			
			while(result.next()) {
				
				String userName = result.getString("user_name");
				userNames.add(userName);
				
			}
		} catch (IOException | SQLException e) {
			e.printStackTrace();
		}
		
		return userNames;
	}
	
	@Override
	public User getUserByCredentials( User user) {
		User verfiedUser = new User();
		
		try (Connection conn = ConnectionUtil.getConnection()){
			String sql = "SELECT * FROM bankUser WHERE user_name = ? AND user_pass = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, user.getUsername());
			ps.setString(2,  user.getPassword());
			ResultSet result = ps.executeQuery();
			
			while(result.next()) {
				verfiedUser.setUserId(result.getInt("user_id"));
				verfiedUser.setUsername(result.getString("user_name"));
				verfiedUser.setPassword(result.getString("user_pass"));
			}
			
		} catch (IOException | SQLException e) {
			e.printStackTrace();
		}
		
		return verfiedUser;
	}

	@Override
	public int createUser(User user) {
		int userCreated = 0;
		
		
		try (Connection conn = ConnectionUtil.getConnection()){
			String sql = "{call insert_new_user_account(?, ?)}";
			CallableStatement cs = conn.prepareCall(sql);
			//register IN parameters
			cs.setString(1, user.getUsername());
			cs.setString(2, user.getPassword());
			
			userCreated =  cs.executeUpdate();
			
			
		} catch (IOException | SQLException e) {
			e.printStackTrace();
		}
		
		
		
		return userCreated;
	}

	@Override
	public int updateUser(User user) {
		int userUpdated = 0;
		
		
		try (Connection conn = ConnectionUtil.getConnection()){
			String sql = "UPDATE bankUser SET user_pass = ? WHERE user_id = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, user.getPassword());
			ps.setInt(2, user.getUserId());
			userUpdated = ps.executeUpdate();
			
		} catch (IOException | SQLException e) {
			e.printStackTrace();
		}
		
		return userUpdated;
	}

}
