package com.revature.dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.revature.pojos.BankAccount;
import com.revature.pojos.BankAccount;
import com.revature.util.ConnectionUtil;

public class BankAccountDaoImp implements BankAccountDao
{


	public BankAccountDaoImp()
	{
		// TODO Auto-generated constructor stub
	}
	
	

	@Override
	public List<BankAccount> getBankAccounts()
	{
		List<BankAccount> bankAccounts = new ArrayList<>();
		try
		{
			Connection con = ConnectionUtil.getConnection();
			String sql = "SELECT * FROM BANKACCOUNTS";
			Statement s = con.createStatement();
			ResultSet rs = s.executeQuery(sql);
			
			while(rs.next())
			{
				String accountId = rs.getString("ACCOUNT_ID");
				String userId = rs.getString("USER_ID");
				Double balance = rs.getDouble("BALANCE");
				bankAccounts.add(new BankAccount(accountId, userId, balance));
			}
			con.close();
			
		} catch (IOException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return bankAccounts;
	}

	@Override
	public List<BankAccount> getBankAccountsByUserId(String newUserId)
	{
		List<BankAccount> bankAccounts = new ArrayList<>();
		try {
			Connection con = ConnectionUtil.getConnection();
			String sql = "SELECT * FROM BANKACCOUNTS WHERE USER_ID = ?";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, newUserId);
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				String accountId = rs.getString("ACCOUNT_ID");
				String userId = rs.getString("USER_ID");
				Double balance = rs.getDouble("BALANCE");
				 bankAccounts.add(new BankAccount(accountId, userId, balance));
			}
			
			con.close();

		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		return bankAccounts;

	}

	@Override
	public BankAccount getBankAccountById(String newAccountId)
	{
		BankAccount bankAccount = null;
		
		try {
			Connection con = ConnectionUtil.getConnection();
			String sql = "SELECT * FROM BANKACCOUNTS WHERE ACCOUNT_ID = ?";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, newAccountId);
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				String accountId = rs.getString("ACCOUNT_ID");
				String userId = rs.getString("USER_ID");
				Double balance = rs.getDouble("BALANCE");
				bankAccount = new BankAccount(userId, userId, balance);
			}
			
			con.close();

		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		return bankAccount;
	}

	@Override
	public void createBankAccount(BankAccount newBankAccount)
	{
		try {
			Connection con = ConnectionUtil.getConnection();
			String sql = "INSERT INTO BANKACCOUNTS (ACCOUNT_ID, USER_ID, BALANCE) VALUES (?,?,?)";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, newBankAccount.getAccountId());
			ps.setString(2, newBankAccount.getUserId());
			ps.setDouble(3, newBankAccount.getBalance());
			ps.executeUpdate();
			
			con.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		
	}

	@Override
	public void updateBankAccount(BankAccount newBankAccount)
	{
		String sql = "UPDATE BANKACCOUNTS "
				+ "SET ACCOUNT_ID = ?, "
				+ "USER_ID = ?, "
				+ "BALANCE = ? "
				+ "WHERE ACCOUNT_ID = ?";
		try {
			Connection con = ConnectionUtil.getConnection();
			con.setAutoCommit(false);
			PreparedStatement pstatement = con.prepareStatement(sql);
			pstatement.setString(1, newBankAccount.getAccountId());
			pstatement.setString(2, newBankAccount.getUserId());
			pstatement.setDouble(3, newBankAccount.getBalance());
			pstatement.setString(4, newBankAccount.getAccountId());
			pstatement.executeUpdate();
			con.commit();
			con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public void deleteBankAccountById(String accountId)
	{
		String sql = "DELETE FROM BANKACCOUNTS WHERE ACCOUNT_ID = ?";
		
		try 
		{
			Connection con = ConnectionUtil.getConnection();
			con.setAutoCommit(false);
			PreparedStatement pstatement = con.prepareStatement(sql);
			pstatement.setString(1, accountId);	
			pstatement.executeUpdate();
			con.commit();
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

}
