package com.revature.dao;

import java.io.IOException;
import java.sql.*;

import java.util.ArrayList;
import java.util.LinkedList;

import com.revature.bank.*;
import com.revature.util.ConnectionUtil;

public class BankDAOImpl implements BankDAO {

	public ArrayList<User> getUsers() {
		ArrayList<User> userList = new ArrayList<User>();
		try {
			Connection con = ConnectionUtil.getConnection();
			String sql = "SELECT * FROM BANK_USER";
			PreparedStatement ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery(sql);
			
			while(rs.next()) {
				ArrayList<Integer> accounts = new ArrayList<Integer>();
				
				String name = rs.getString("NAME");
				String pass = rs.getString("PASS");
				
				sql = "SELECT ACCOUNT_ID FROM BANK_LINK WHERE USER_NAME = ?";
				ps = con.prepareStatement(sql);
				ps.setString(1, name);
				ResultSet rs2 = ps.executeQuery();
				
				while(rs2.next()) {
					accounts.add(rs2.getInt("ACCOUNT_ID"));
				}
				
				userList.add(new User(name, pass, accounts));
			}
			
			con.close();
			
		} catch (IOException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return userList;
	}

	public ArrayList<Account> getAccounts() {
		ArrayList<Account> accountList = new ArrayList<Account>();
		try {
			Connection con = ConnectionUtil.getConnection();
			String sql = "SELECT * FROM BANK_ACCOUNT";
			PreparedStatement ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				ArrayList<String> users = new ArrayList<String>();
				LinkedList<Transaction> transactions = new LinkedList<Transaction>();
				
				int id = rs.getInt("ACCOUNT_ID");
				double balance = rs.getDouble("BALANCE");
				String nickname = rs.getString("NICKNAME");
				
				sql = "SELECT USER_NAME FROM BANK_LINK WHERE ACCOUNT_ID = ?";
				ps = con.prepareStatement(sql);
				ps.setInt(1, id);
				ResultSet rs2 = ps.executeQuery();
				
				while(rs2.next()) {
					users.add(rs2.getString("USER_NAME"));
				}
				
				sql = "SELECT * FROM BANK_TRANSACTION WHERE ACCOUNT_ID = ?";
				ps = con.prepareStatement(sql);
				ps.setInt(1, id);
				ResultSet rs3 = ps.executeQuery();
				
				while(rs3.next()) {
					String type = rs3.getString("TYPE");
					String user = rs3.getString("USERNAME");
					double amount = rs3.getDouble("AMOUNT");
					double transactionBalance = rs3.getDouble("BALANCE");
					Date date = rs3.getDate("DATE_MADE");
					int other = rs3.getInt("OTHER_ACCOUNT_ID");
					transactions.add(new Transaction(type, user, amount, transactionBalance, date, other));
				}
				
				accountList.add(new Account(id, balance, nickname, users, transactions));
			}
			
			con.close();
			
		} catch (IOException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return accountList;
	}

	public User getUserByName(String name) {
		User user = null;
		
		try {
			Connection con = ConnectionUtil.getConnection();
			String sql = "SELECT * FROM BANK_USER WHERE NAME = ?";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, name);
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				ArrayList<Integer> accounts = new ArrayList<Integer>();
				
				String pass = rs.getString("PASS");
				
				sql = "SELECT ACCOUNT_ID FROM BANK_LINK WHERE USER_NAME = ?";
				ps = con.prepareStatement(sql);
				ps.setString(1, name);
				ResultSet rs2 = ps.executeQuery();
				
				while(rs2.next()) {
					accounts.add(rs2.getInt("ACCOUNT_ID"));
				}
				
				user = new User(name, pass, accounts);
			}
			
			con.close();
			
		} catch (IOException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return user;
	}
	
	public Account getAccountByID(int id) {
		Account account = null;
		try {
			Connection con = ConnectionUtil.getConnection();
			String sql = "SELECT * FROM BANK_ACCOUNT WHERE ACCOUNT_ID = ?";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				ArrayList<String> users = new ArrayList<String>();
				LinkedList<Transaction> transactions = new LinkedList<Transaction>();
				
				double balance = rs.getDouble("BALANCE");
				String nickname = rs.getString("NICKNAME");
				
				sql = "SELECT USER_NAME FROM BANK_LINK WHERE ACCOUNT_ID = ?";
				ps = con.prepareStatement(sql);
				ps.setInt(1, id);
				ResultSet rs2 = ps.executeQuery();
				
				while(rs2.next()) {
					users.add(rs2.getString("USER_NAME"));
				}
				
				sql = "SELECT * FROM BANK_TRANSACTION WHERE ACCOUNT_ID = ?";
				ps = con.prepareStatement(sql);
				ps.setInt(1, id);
				ResultSet rs3 = ps.executeQuery();
				
				while(rs3.next()) {
					String type = rs3.getString("TYPE");
					String user = rs3.getString("USERNAME");
					double amount = rs3.getDouble("AMOUNT");
					double transactionBalance = rs3.getDouble("BALANCE");
					Date date = rs3.getDate("DATE_MADE");
					int other = rs3.getInt("OTHER_ACCOUNT_ID");
					transactions.add(new Transaction(type, user, amount, transactionBalance, date, other));
				}
				
				account = new Account(id, balance, nickname, users, transactions);
			}
			
			con.close();
			
		} catch (IOException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return account;
	}

	public int createUser(User user) {
		int usersCreated = 0;
		
		try {
			Connection con = ConnectionUtil.getConnection();
			String sql = "INSERT INTO BANK_USER VALUES(?, ?)";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, user.getUser());
			ps.setString(2, user.getPass());
			usersCreated = ps.executeUpdate();
			
			con.close();
			
		} catch (IOException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return usersCreated;
	}

	public int createAccount(Account account) {
		int accountsCreated = 0;
		
		try {
			Connection con = ConnectionUtil.getConnection();
			String sql = "INSERT INTO BANK_ACCOUNT VALUES(?, ?, ?)";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, account.getId());
			ps.setDouble(2, account.getBalance());
			ps.setString(3, account.getNickname());
			accountsCreated = ps.executeUpdate();
			
			con.close();
			
		} catch (IOException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return accountsCreated;
	}

	public int createTransaction(Transaction transaction, int accountID) {
		int transactionsCreated = 0;
		
		try {
			Connection con = ConnectionUtil.getConnection();
			String sql = "INSERT INTO BANK_TRANSACTION(TYPE, ACCOUNT_ID, USERNAME, "
					+ "AMOUNT, BALANCE, DATE_MADE, OTHER_ACCOUNT_ID) VALUES(?, ?, ?, ?, ?, ?, ?)";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, transaction.getType());
			ps.setInt(2, accountID);
			ps.setString(3, transaction.getUser());
			ps.setDouble(4, transaction.getAmount());
			ps.setDouble(5, transaction.getBalance());
			ps.setDate(6, transaction.getDate());
			ps.setInt(7, transaction.getOtherAccount());
			transactionsCreated = ps.executeUpdate();
			
			con.close();
			
		} catch (IOException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return transactionsCreated;
	}

	public int updateAccount(Account account) {
		int accountsUpdated = 0;
		
		try {
			Connection con = ConnectionUtil.getConnection();
			con.setAutoCommit(false);
			String sql = "UPDATE BANK_ACCOUNT "
					+ "SET BALANCE = ?, "
					+ "NICKNAME = ?, "
					+ "WHERE ACCOUNT_ID = ?";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setDouble(1, account.getBalance());
			ps.setString(2, account.getNickname());
			ps.setInt(3, account.getId());
			accountsUpdated = ps.executeUpdate();
			
			con.commit();
			con.close();
			
		} catch (IOException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return accountsUpdated;
	}

	public int deleteUserByName(String name) {
		int rowsUpdated = 0;
		
		try {
			Connection con = ConnectionUtil.getConnection();
			con.setAutoCommit(false);
			String sql = "DELETE FROM BANK_USER WHERE NAME = ?";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, name);
			rowsUpdated = ps.executeUpdate();
			
			con.commit();
			con.close();
			
		} catch (IOException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return rowsUpdated;
	}

	public int deleteAccountByID(int accountID) {
		int rowsUpdated = 0;
		
		try {
			Connection con = ConnectionUtil.getConnection();
			con.setAutoCommit(false);
			String sql = "DELETE FROM BANK_ACCOUNT WHERE ACCOUNT_ID = ?";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, accountID);
			rowsUpdated = ps.executeUpdate();
			
			con.commit();
			con.close();
			
		} catch (IOException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return rowsUpdated;
	}

}
