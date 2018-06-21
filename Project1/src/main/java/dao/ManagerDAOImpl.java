package dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import model.Manager;
import utilities.ConnectionUtil;

public class ManagerDAOImpl implements ManagerDAO {

	public Manager getManagerById(int manId) {
		Manager man1 = new Manager();
		try {
			Connection con = ConnectionUtil.getConnection();
			String sql = "SELECT * FROM MANAGER WHERE MAN_ID = ?";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, manId);
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				int id = rs.getInt("MAN_ID");
				String email = rs.getString("MAN_EMAIL");
				String password = rs.getString("MAN_PASSWORD");
				String firstName = rs.getString("MAN_FIRSTNAME");
				String lastName = rs.getString("MAN_LASTNAME");
				String phone = rs.getString("MAN_PHONE");
				
				man1 = new Manager(id, email, password, firstName, lastName, phone);
				System.out.println(man1);
			}
			
			
		} catch (IOException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return man1;
	}

	public String getManagerByEmail(String manEmail) {
		Manager man1 = new Manager();
		try {
			Connection con = ConnectionUtil.getConnection();
			String sql = "SELECT * FROM MANAGER WHERE MAN_EMAIL = ?";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, manEmail);
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				int id = rs.getInt("MAN_ID");
				String email = rs.getString("MAN_EMAIL");
				String password = rs.getString("MAN_PASSWORD");
				String firstName = rs.getString("MAN_FIRSTNAME");
				String lastName = rs.getString("MAN_LASTNAME");
				String phone = rs.getString("MAN_PHONE");
				
				man1 = new Manager(id, email, password, firstName, lastName, phone);
				
			}
			
			
		} catch (IOException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return man1.getPassword();
	}

	public ArrayList<Manager> getManagers() {
		ArrayList<Manager> managers = new ArrayList<Manager>();
		
		try {
			Connection con = ConnectionUtil.getConnection();
			String sql = "SELECT * FROM MANAGER";
			PreparedStatement ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				int id = rs.getInt("MAN_ID");
				String email = rs.getString("MAN_EMAIL");
				String password = rs.getString("MAN_PASSWORD");
				String firstName = rs.getString("MAN_FIRSTNAME");
				String lastName = rs.getString("MAN_LASTNAME");
				String phone = rs.getString("MAN_PHONE");
				
				managers.add(new Manager(id, email, password, firstName, lastName, phone));
				//System.out.println(man1);
			}
			
			
		} catch (IOException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return managers;
	}

	@Override
	public int getManagerIdByEmail(String email) {
		int id = 0;
		
		try {
			Connection con = ConnectionUtil.getConnection();
			String sql = "SELECT MAN_ID FROM MANAGER WHERE MAN_EMAIL = ?";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, email);
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				 id = rs.getInt("MAN_ID");
				
				System.out.println(id);
			}
			
			
		} catch (IOException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return id;
	}

}
