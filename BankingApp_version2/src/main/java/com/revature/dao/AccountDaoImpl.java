package com.revature.dao;

import java.io.IOException;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;

import com.revature.pojos.Account;
import com.revature.util.ConnectionUtil;

public class AccountDaoImpl implements AccountDao{

	//Generates a HashMap which will be used in AppDriver.java
	//to access user information in the main method.
	@Override
	public HashMap<String, Account> getAccounts() {
		HashMap<String, Account> bankData = new HashMap<String, Account>();
		try {
			Connection con = ConnectionUtil.getConnection();
			String sql = "SELECT * FROM ACCOUNTS";
			//Uses Statement
			Statement s = con.createStatement();
			ResultSet rs = s.executeQuery(sql);
			
			while(rs.next()) {
				String username = rs.getString("USERNAME");
				String password = rs.getString("PASSWORD");
				double checking = rs.getDouble("CHECKING");
				double savings = rs.getDouble("SAVINGS");
				bankData.put(username, new Account(username, password, 
						checking, savings));
			}
			
			//con.close();
			
		} catch (IOException e) {
			
			e.printStackTrace();
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		return bankData;
		
	}

	@Override
	public Account getAccountByUsername(String username) {
		Account user = null;
		
		try {
			Connection con = ConnectionUtil.getConnection();
			String sql = "SELECT * FROM ACCOUNTS WHERE USERNAME = ?";
			//Uses PreparedStatement
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, username);
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				String rowUsername = rs.getString("USERNAME");
				String password = rs.getString("PASSWORD");
				double checking = rs.getDouble("CHECKING");
				double savings = rs.getDouble("SAVINGS");
				user = new Account(rowUsername, password, checking, savings);
			}
			
			//con.close();
			
		} catch (IOException e) {
			
			e.printStackTrace();
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
		return user;
	}

	@Override
	public int createAccount(Account newAccount) {
		int accountsCreated = 0;
		
		try {
			Connection con = ConnectionUtil.getConnection();
			String sql = "INSERT INTO ACCOUNTS VALUES(?,?,?,?)";
			//Uses PreparedStatement
			PreparedStatement pStatement = con.prepareStatement(sql);
			pStatement.setString(1, newAccount.getUsername());
			pStatement.setString(2, newAccount.getPassword());
			pStatement.setDouble(3, newAccount.getChecking());
			pStatement.setDouble(4, newAccount.getSavings());
			accountsCreated = pStatement.executeUpdate();
			//con.close();
			
		} catch (IOException e) {
			
			e.printStackTrace();
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
		return accountsCreated;
	}

	@Override
	public int updateAccount(Account newAccount) {
		int accountsUpdated = 0;
		
		try {
			Connection con = ConnectionUtil.getConnection();
			con.setAutoCommit(false);
			String sql = "UPDATE ACCOUNTS "
					+ "SET PASSWORD = ?, "
					+ "CHECKING = ?, "
					+ "SAVINGS = ?"
					+ " WHERE USERNAME = ?";
			//Uses PreparedStatement
			PreparedStatement pStatement = con.prepareStatement(sql);
			pStatement.setString(1, newAccount.getPassword());
			pStatement.setDouble(2, newAccount.getChecking());
			pStatement.setDouble(3, newAccount.getSavings());
			pStatement.setString(4, newAccount.getUsername());
			accountsUpdated = pStatement.executeUpdate();
			con.commit();
			//con.close();
		} catch (IOException e) {
			
			e.printStackTrace();
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
		return accountsUpdated;
	}

	@Override
	public int deleteAccountByUsername(String username) {
		int accountsDeleted = 0;
			
		try {
			Connection con = ConnectionUtil.getConnection();
			con.setAutoCommit(false);
			String sql = "DELETE FROM ACCOUNTS WHERE USERNAME = ?";
			//Uses PreparedStatement
			PreparedStatement pStatement = con.prepareStatement(sql);
			pStatement.setString(1, username);
			accountsDeleted = pStatement.executeUpdate();
			con.commit();
			//con.close();
			
		} catch (IOException e) {
			
			e.printStackTrace();
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
		
		return accountsDeleted;
	}

	@Override
	public void depositFunds(String username, String accountType, double amount) {
		
		try {
			Connection con = ConnectionUtil.getConnection();
			String sql = "{call DEPOSIT(?, ?, ?)}";
			//Uses CallableStatement
			CallableStatement cs = con.prepareCall(sql);
			cs.setString(1, username);
			cs.setString(2, accountType);
			cs.setDouble(3, amount);
			cs.execute();
			//con.close();
			
		} catch (IOException e) {
			
			e.printStackTrace();
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
		
	}

	@Override
	public void withDrawFunds(String username, String accountType, double amount) {
		
		try {
			Connection con = ConnectionUtil.getConnection();
			String sql = "{call WITHDRAW(?, ?, ?)}";
			//Uses CallableStatement
			CallableStatement cs = con.prepareCall(sql);
			cs.setString(1, username);
			cs.setString(2, accountType);
			cs.setDouble(3, amount);
			cs.execute();
			//con.close();
			
		} catch (IOException e) {
			
			e.printStackTrace();
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
	}
	
	

}
