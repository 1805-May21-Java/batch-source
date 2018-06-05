package com.revature.dao;

import java.io.IOException;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLDataException;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;

import com.revature.pojos.Account;
import com.revature.util.ConnectionUtil;

public class AccountDaoImpl implements AccountDao {

	@Override
	public int createAccount(String username) {
		int accountCreated = 0;

		try {
			Connection con = ConnectionUtil.getConnection();
			String sql = "INSERT INTO BANK_ACCOUNT (USERNAME) VALUES(?)";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, username);
			accountCreated = ps.executeUpdate();
			con.close();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (SQLIntegrityConstraintViolationException e) {
			System.out.println("Must create a user first.");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return accountCreated;
	}

	@Override
	public Account getAccount(String username) {
		Account account = null;
		try {
			Connection con = ConnectionUtil.getConnection();
			String sql = "SELECT * FROM BANK_ACCOUNT WHERE USERNAME=?";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, username);
			ResultSet rs = ps.executeQuery();

			while(rs.next()) { 
				int accountId = rs.getInt("ACCOUNT_ID");
				double balance = rs.getDouble("BALANCE");
				account = new Account(balance, username, accountId);
			}
			
			if(account == null)
				System.out.println("Could not find account. Please try again");
			
			con.close();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return account;
	}

	@Override
	public double getBalance(int accountId) {
		double balance = 0;
		
		try {
			Connection con = ConnectionUtil.getConnection();
			String sql = "{call get_balance (?, ?)}";
			CallableStatement stmt = con.prepareCall(sql);
			stmt.setInt(1, accountId);
			stmt.registerOutParameter(2, java.sql.Types.DOUBLE);
			stmt.execute();
			balance = stmt.getDouble(2);
			stmt.close();
			con.close();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return balance;
	}

	@Override
	public boolean updateBalance(int accountId, double amount, String username) {
		boolean success = false;
		try {
			Connection con = ConnectionUtil.getConnection();
			String sql = "UPDATE BANK_ACCOUNT SET BALANCE=? WHERE ACCOUNT_ID=?";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setDouble(1, amount);
			ps.setInt(2, accountId);
			ps.executeUpdate();
			con.close();
			success = true;
		} catch (IOException e) {
			e.printStackTrace();
		} catch (SQLDataException e) {
			System.out.println("The number you entered is too large.");
		} catch (SQLIntegrityConstraintViolationException e) {
			System.out.println("Insufficients funds.");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return success;	
	}
}
