package com.revature.dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.revature.bank.Account;

public class AccountDaoImpl implements AccountDao {

	@Override
	public List<Account> getAllAccounts() {
		List<Account> accounts = new ArrayList<>();
		try {
			Connection connection = ConnectionUtil.getConnection();
			String sql = "select * from bank_account";
			Statement statement = connection.createStatement();
			ResultSet rSet = statement.executeQuery(sql);
			while(rSet.next()) {
				accounts.add(new Account(rSet.getString("ACCT_OWNER"),rSet.getString("USERNAME"),
						rSet.getString("ACCT_PASSWORD"),rSet.getFloat("BALANCE"),false));
			}
			connection.close();
		} catch (IOException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return accounts;
	}

	@Override
	public Account getAccountById(String uname) {
		Account account = null;
		try {
			Connection connection = ConnectionUtil.getConnection();
			String sql = "SELECT * FROM bank_account WHERE USERNAME = ?";
			PreparedStatement statement = connection.prepareStatement(sql);
			statement.setString(1, uname);
			ResultSet rSet = statement.executeQuery();
			while(rSet.next()) {
				account = new Account(rSet.getString("ACCT_OWNER"),rSet.getString("USERNAME"),
						rSet.getString("ACCT_PASSWORD"),rSet.getFloat("BALANCE"),false);
			}
			connection.close();
		} catch (IOException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return account;
	}

	@Override
	public int CreateAccount(Account acct) {
		int acctCreated = 0;
		try {
			Connection connection = ConnectionUtil.getConnection();
			String sql = "Insert into Bank_Account (username, acct_owner, balance, acct_password) values(?,?,?,?)";
			PreparedStatement pStatement = connection.prepareStatement(sql);
			pStatement.setString(1, acct.getUsername());
			pStatement.setString(2, acct.getOwner());
			int temp = (int) (acct.getBalance()*100);
			float temp2 = (float)(temp)/100;	//This ensures that there's only 2 decimal places in the number
			pStatement.setFloat(3, acct.getBalance());
			pStatement.setString(4, acct.getPassword());
			acctCreated = pStatement.executeUpdate();
			connection.close();
			
		} catch(IOException | SQLException e) {
			e.printStackTrace();
		}
		return acctCreated;
	}

	@Override
	public int updateAccount(Account acct) {
		int acctUpdated = 0;
		try {
			Connection connection = ConnectionUtil.getConnection();
			connection.setAutoCommit(false);
			String sql = "Update Bank_Account set"
					+ " acct_owner=?, balance=?, acct_password=?"
					+" where username=?";
			PreparedStatement pStatement = connection.prepareStatement(sql);
			pStatement.setString(4, acct.getUsername());
			pStatement.setString(1, acct.getOwner());
			int temp = (int) (acct.getBalance()*100);
			float temp2 = (float)(temp)/100;	//This ensures that there's only 2 decimal places in the number
			pStatement.setFloat(2, temp2);
			pStatement.setString(3, acct.getPassword());
			acctUpdated = pStatement.executeUpdate();
			connection.commit();
			connection.close();
			
		} catch(IOException | SQLException e) {
			e.printStackTrace();
		}
		return acctUpdated;
	}

	@Override
	public int deleteAccount(String uname) {
		int rowsUpdated = 0;
		
		String sql = "DELETE FROM BANK_ACCOUNT WHERE USERNAME = ?";
		
		try {
			Connection con = ConnectionUtil.getConnection();
			con.setAutoCommit(false);
			PreparedStatement pstatement = con.prepareStatement(sql);
			pstatement.setString(1, uname);	
			rowsUpdated = pstatement.executeUpdate();
			con.commit();
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return rowsUpdated;
	}

}
