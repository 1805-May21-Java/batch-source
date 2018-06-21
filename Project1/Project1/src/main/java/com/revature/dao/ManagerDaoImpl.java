package com.revature.dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import com.revature.pojos.Manager;
import com.revature.util.ConnectionUtil;

public class ManagerDaoImpl implements ManagerDao {

	@Override
	public Manager getManager(String email, String password) {
		Manager manager = null;
		try {
			Connection con = ConnectionUtil.getConnection();
			String sql = "SELECT * FROM MANAGER WHERE EMAIL=? AND MANAGER_PASSWORD=?";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, email);
			ps.setString(2, password);
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				manager = new Manager(email, password);
				System.out.println("Successfully logged in.");
			}
			
			if(manager == null)
				System.out.println("Invalid username/password combination. Please try again");
			
			con.close();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return manager;
	}

}
