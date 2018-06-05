package com.revature.dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.revature.model.Account;
import com.revature.model.UserAccount;
import com.revautre.util.ConnectionUtil;


public class AccountDAOImpl implements AccountDAO {

	@Override
	public void updateBalance(int accountid, double balance) {
		int accountCreated = 0;
		
		try {
			Connection con = ConnectionUtil.getConnection();
			String sql = "UPDATE RBA_ACCOUNT SET BALANCE = ? WHERE ACCOUNTID = ?";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setDouble(2, accountid);
			ps.setDouble(1, balance);
			
			
			accountCreated = ps.executeUpdate();
			
		} catch (IOException | SQLException e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public double balanceInquiry(int id) {
		double accountBalance = 0;
		
		try {
			Connection con = ConnectionUtil.getConnection();
			String sql = "SELECT BALANCE FROM RBA_ACCOUNT WHERE ACCOUNTID = ?";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				accountBalance = rs.getDouble("BALANCE");
			}
			
		} catch (IOException | SQLException e) {
			e.printStackTrace();
		}
		//System.out.println(accountBalance);
		
		return accountBalance;
	}

	@Override
	public ArrayList<Account> getAccountsByUserId(UserAccount user) {
			ArrayList<Account> accounts = new ArrayList<Account>();
		
		try {
			Connection con = ConnectionUtil.getConnection();
			String sql = "SELECT * FROM RBA_ACCOUNT WHERE USERID = ?";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1,  user.getAccountid());
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				accounts.add(new Account(rs.getInt("ACCOUNTID"), rs.getString("ACCOUNTTYPE"), rs.getDouble("BALANCE"), rs.getInt("USERID")));
			}
			
			for (Account a : accounts) {
			    System.out.println(a);
			}
			
		} catch (IOException | SQLException e1) {
			e1.printStackTrace();
		}
		return accounts;
		
	}

	@Override
	public void addAccount(Account account) {
		int accountCreated = 0;
		
		try {
			Connection con = ConnectionUtil.getConnection();
			String sql = "INSERT INTO RBA_ACCOUNT (ACCOUNTID, ACCOUNTTYPE, BALANCE, USERID) VALUES (?,?,?,?)";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, account.getAccountid());
			ps.setString(2, account.getAccounttype());
			ps.setDouble(3, account.getBalance());
			ps.setInt(4, account.getUserid());
			
			accountCreated = ps.executeUpdate();
			
		} catch (IOException | SQLException e) {
			e.printStackTrace();
		}
		
	}

	
	
}
