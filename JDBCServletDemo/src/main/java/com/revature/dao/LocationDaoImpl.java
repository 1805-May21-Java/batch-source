package com.revature.dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.revature.pojos.Department;
import com.revature.pojos.Location;
import com.revature.util.ConnectionUtil;

public class LocationDaoImpl implements LocationDao {

	@Override
	public List<Location> getLocations() {
		List<Location> locations = new ArrayList<Location>();
		String sql = "SELECT * FROM LOCATIONS";
		
		try {
			Connection con = ConnectionUtil.getConnection();
			Statement s = con.createStatement();
			ResultSet rs = s.executeQuery(sql);
			while(rs.next()) {
				int id = rs.getInt("LOCATION_ID");
				String street = rs.getString("STREET");
				String city = rs.getString("CITY");
				String state = rs.getString("STATE");
				int zipcode = rs.getInt("ZIPCODE");
				locations.add(new Location(id, street, city, state, zipcode));
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return locations;
	}

	@Override
	public Location getLocationById(int id) {
		Location l = null;
		String sql = "SELECT * FROM LOCATIONS WHERE LOCATION_ID = ?";
		
		try {
			Connection con = ConnectionUtil.getConnection();
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				String street = rs.getString("STREET");
				String city = rs.getString("CITY");
				String state = rs.getString("STATE");
				int zipcode = rs.getInt("ZIPCODE");
				l = new Location(id, street, city, state, zipcode);
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return l;
	}

	@Override
	public int createLocation(Location location) {
		int locationsCreated = 0;
		
		try {
			Connection con = ConnectionUtil.getConnection();
			String sql = "INSERT INTO LOCATIONS (STREET, CITY, STATE, ZIPCODE) VALUES (?,?,?,?)";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, location.getStreet());
			ps.setString(2, location.getStreet());
			ps.setString(3, location.getState());
			ps.setInt(4, location.getZipcode());
			locationsCreated = ps.executeUpdate();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return locationsCreated;
	}

	@Override
	public int updateLocation(Location location) {
		int locationsUpdated = 0;
		String sql = "UPDATE LOCATIONS "
				+ "SET STREET = ?, "
				+ "CITY = ?, "
				+ "STATE = ?,"
				+ "ZIPCODE = ?"
				+ "WHERE LOCATION_ID = ?";
		try {
			Connection con = ConnectionUtil.getConnection();
			con.setAutoCommit(false);
			PreparedStatement pstatement = con.prepareStatement(sql);
			pstatement.setString(1, location.getStreet());
			pstatement.setString(2, location.getCity());
			pstatement.setString(3, location.getState());
			pstatement.setInt(4, location.getZipcode());
			pstatement.setInt(5, location.getId());
			locationsUpdated = pstatement.executeUpdate();
			con.commit();
			con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return locationsUpdated;
	}

	@Override
	public int deleteLocationById(int id) {
int rowsUpdated = 0;
		
		String sql = "DELETE FROM LOCATIONS WHERE LOCATION_ID = ?";
		
		try {
			Connection con = ConnectionUtil.getConnection();
			PreparedStatement pstatement = con.prepareStatement(sql);
			pstatement.setInt(1, id);	
			rowsUpdated = pstatement.executeUpdate();
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return rowsUpdated;
	}

}
