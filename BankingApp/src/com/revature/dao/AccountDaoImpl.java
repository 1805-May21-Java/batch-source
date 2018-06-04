package com.revature.dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.revature.bankingapp.Account;
import com.revature.util.ConnectionUtil;

public class AccountDaoImpl implements AccountDao {

	@Override
	public List<Account> getAccounts() {
		
		List<Account> accountList = new ArrayList<Account>();
		
		// connect to the database
		try {
			Connection con = ConnectionUtil.getConnection();
			String sql = "SELECT * FROM ACCOUNT"; // get all entries in Account
			Statement s = con.createStatement();
			ResultSet rs = s.executeQuery(sql);
			
			// loop thru result set and add to accountList
			while (rs.next()) {
				int accountId = rs.getInt("ACC_ID");
				String username = rs.getString("ACC_USERNAME");
				String password = rs.getString("ACC_PASSWORD");
				double balance = rs.getDouble("ACC_BALANCE");
				
				accountList.add(new Account(accountId, username, password, balance));
			}
			con.close();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return accountList;
	}

	
	@Override
	public Account getAccountById(int id) {
		
		Account a = null;
		
		try {
			Connection con = ConnectionUtil.getConnection();
			String sql = "SELECT * FROM ACCOUNT WHERE ACC_ID = ?"; // select desired account
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				int accountId = rs.getInt("ACC_ID");
				String username = rs.getString("ACC_USERNAME");
				String password = rs.getString("ACC_PASSWORD");
				double balance = rs.getDouble("ACC_BALANCE");
				
				a = new Account(accountId, username, password, balance);
			}
			con.close();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return a;
	}

	@Override
	public int createAccount(Account account) {
		
		int accountCreated = 0;
		try {
			Connection con = ConnectionUtil.getConnection();
			String sql = "INSERT INTO ACCOUNT (ACC_USERNAME, ACC_PASSWORD, ACC_BALANCE) VALUES (?,?,?)";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, account.getUsername());
			ps.setString(2, account.getPassword());
			ps.setDouble(3, account.getBalance());
			accountCreated = ps.executeUpdate();
			con.close();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return accountCreated;
	}

}
