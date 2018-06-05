package com.revature.htulipan.banking2.database.dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.revature.htulipan.banking2.database.pojos.Account;
import com.revature.htulipan.banking2.database.util.ConnectionUtil;

public class AccountDaoImpl implements AccountDao {

	public int createAccount(String user, String accountName) {
		
		String sql = "INSERT INTO BANKACCOUNT (CREATOR, ACCOUNTNAME, BALANCE) VALUES (?, ?, ?)";
		int numInserted = 0;
		
		try {
			Connection con = ConnectionUtil.getConnection();
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1,  user);
			ps.setString(2, accountName);
			ps.setFloat(3,  0.0f);
			numInserted = ps.executeUpdate();
			
		} catch (SQLException e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		} catch (IOException e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
		
		return 0;
	}

	public int updateAccount(Account updatedAccount) {
		
		String sql = "UPDATE BANKACCOUNT SET BALANCE = ? WHERE ACCOUNTNAME = ? AND CREATOR = ?";
		int numUpdated = 0;
		try {
			Connection con = ConnectionUtil.getConnection();
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setFloat(1, updatedAccount.getBalance());
			ps.setString(2,  updatedAccount.getAccountName());
			ps.setString(3,  updatedAccount.getOwner());
			numUpdated =  ps.executeUpdate();
		} catch (SQLException e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		} catch (IOException e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
		return numUpdated;
		
	}
	
	public boolean accountExists(String username, String accountname) {
		
		String sql = "SELECT ACCOUNTNAME FROM BANKACCOUNT WHERE CREATOR = ?";

		try {
			Connection con = ConnectionUtil.getConnection();
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, username);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				String an = rs.getString("ACCOUNTNAME");
				if (an.equals(accountname)) return true;
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		} catch (IOException e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}

		return false;
		
	}
	
	public ArrayList<Account> getUserAccounts(String username) {
		
		String sql = "SELECT ACCOUNTNAME, CREATOR, BALANCE FROM BANKACCOUNT WHERE CREATOR = ?";
		ArrayList<Account> resultList = new ArrayList<Account>();
		
		try {
			Connection con = ConnectionUtil.getConnection();
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, username);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Account ac = new Account();
				ac.setOwner(rs.getString("CREATOR"));
				ac.setAccountName(rs.getString("ACCOUNTNAME"));
				ac.setBalance(rs.getFloat("BALANCE"));
				resultList.add(ac);
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		} catch (IOException e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
		
		return resultList;
	}

}
