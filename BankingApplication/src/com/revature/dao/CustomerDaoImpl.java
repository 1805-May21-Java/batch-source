package com.revature.dao;

import java.io.*;
import java.sql.*;
import java.util.*;

import com.revature.pojos.Customer;
import com.revature.util.ConnectionUtil;

public class CustomerDaoImpl implements CustomerDao{
	
	@Override
	public List<Customer> getCustomers() {
		List<Customer> customers = new ArrayList<Customer>();
		
		String sql = "SELECT * FROM CUSTOMER";
		
		try {
			Connection con = ConnectionUtil.getConnection();
			Statement s = con.createStatement();
			ResultSet rs = s.executeQuery(sql);
			while(rs.next()) {
				String username = rs.getString("USERNAME");
				String password = rs.getString("PASSWORD");
				int balance = rs.getInt("BALANCE");
				customers.add(new Customer(username, password, balance));
			}
			rs.close();
			con.close();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return customers;
	}
	@Override
	public Customer getCustomerByUsername(String username) {
		Customer c = null;
		
		try {
			Connection con = ConnectionUtil.getConnection();
			String sql = "SELECT * FROM CUSTOMER WHERE USERNAME = ?";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, username);
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				String user = rs.getString("USERNAME");
				String password = rs.getString("PASSWORD");
				int balance = rs.getInt("BALANCE");
				
				c = new Customer(user, password, balance);
			}
			rs.close();
			ps.close();
			con.close();

		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		return c;
	}
	@Override
	public int createCustomer(Customer customer) {
		int customerCreated = 0;
		
		try {
			Connection con = ConnectionUtil.getConnection();
			String sql = "INSERT INTO CUSTOMER (USERNAME, PASSWORD, BALANCE) VALUES (?,?,?)";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, customer.getUsername());
			ps.setString(2, customer.getPassword());
			ps.setInt(3, customer.getBalance());
			customerCreated = ps.executeUpdate();
			ps.close();
			con.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return customerCreated;
	}
	@Override
	public int changeBalance(Customer customer) {
		int customersUpdated = 0;
		String sql = "UPDATE CUSTOMER "
				+ "SET BALANCE = ?"
				+ "WHERE USERNAME = ?";
		try {
			Connection con = ConnectionUtil.getConnection();
			con.setAutoCommit(false);
			PreparedStatement pstatement = con.prepareStatement(sql);
			pstatement.setInt(1, customer.getBalance());
			pstatement.setString(2, customer.getUsername());
			customersUpdated = pstatement.executeUpdate();
			con.commit();
			con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return customersUpdated;
		
	}
	
	@Override
	public int getBalanceByUsername(String username) {
		int balance = 0;
		
		try {
			Connection con = ConnectionUtil.getConnection();
			String sql = "SELECT BALANCE FROM CUSTOMER WHERE USERNAME = ?";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, username);
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				int userBalance = rs.getInt("BALANCE");
				
				balance = userBalance;
			}
			rs.close();
			ps.close();
			con.close();

		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		return balance;
	}

}
