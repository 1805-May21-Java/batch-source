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
		//try/catch block is used to catch any possible IOException and SQLException
		try {
			//Connection con is used to create a Statement instance
			//using String sql to retrive all rows from table ACCOUNTS
			Connection con = ConnectionUtil.getConnection();
			String sql = "SELECT * FROM ACCOUNTS";
			//Uses Statement
			Statement s = con.createStatement();
			//ResultSet rs stores result of Statement
			ResultSet rs = s.executeQuery(sql);
			//rs is iterated over and values are retrieved and stored into
			//HashMap bankData
			while(rs.next()) {
				String username = rs.getString("USERNAME");
				String password = rs.getString("PASSWORD");
				double checking = rs.getDouble("CHECKING");
				double savings = rs.getDouble("SAVINGS");
				bankData.put(username, new Account(username, password, 
						checking, savings));
			}
			
		} catch (IOException e) {
			
			e.printStackTrace();
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		return bankData;
		
	}
	
	//Returns an instance of Account using data retrieved from
	//executing a PreparedStatement, using String username to
	//specify database query
	@Override
	public Account getAccountByUsername(String username) {
		Account user = null;
		
		try {
			Connection con = ConnectionUtil.getConnection();
			String sql = "SELECT * FROM ACCOUNTS WHERE USERNAME = ?";
			//PreparedStatement is created using the Connection con
			PreparedStatement ps = con.prepareStatement(sql);
			//PreparedStatment is passed username and then executed.
			ps.setString(1, username);
			ResultSet rs = ps.executeQuery();
			//Result set is iterated and data retrieved to create a 
			//new Account object.
			while(rs.next()) {
				String rowUsername = rs.getString("USERNAME");
				String password = rs.getString("PASSWORD");
				double checking = rs.getDouble("CHECKING");
				double savings = rs.getDouble("SAVINGS");
				user = new Account(rowUsername, password, checking, savings);
			}
			
		} catch (IOException e) {
			
			e.printStackTrace();
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
		return user;
	}

	@Override
	public int createAccount(Account newAccount) {
		//This will return the number of rows created in the database.
		//Should return 1 if user account does not exist
		int accountsCreated = 0;
		
		try {
			//accountExist is created by calling getAccountByUsername
			//if object remains null, then it does not exist in the table.
			//else a print statement notifying the user of its existance is given.
			Account accountExist = getAccountByUsername(newAccount.getUsername());
			if(accountExist == null) {
				Connection con = ConnectionUtil.getConnection();
				String sql = "INSERT INTO ACCOUNTS VALUES(?,?,?,?)";
				//Uses PreparedStatement to insert all values from newAccount
				//via the Getter methods.
				PreparedStatement pStatement = con.prepareStatement(sql);
				pStatement.setString(1, newAccount.getUsername());
				pStatement.setString(2, newAccount.getPassword());
				pStatement.setDouble(3, newAccount.getChecking());
				pStatement.setDouble(4, newAccount.getSavings());
				//PreparedStatement is then executed
				accountsCreated = pStatement.executeUpdate();
			}else {
				System.out.println("Account already exist in the database");
			}	
		} catch (IOException e) {
			
			e.printStackTrace();
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		//number of rows created is returned.
		return accountsCreated;
	}

	//Method updates existing account if present in the database
	//(Not used in project main, but included for complete DAO implementation).
	@Override
	public int updateAccount(Account newAccount) {
		int accountsUpdated = 0;
		
		try {
			Connection con = ConnectionUtil.getConnection();
			//Auto commit is set to false to prevent uncalled commits
			con.setAutoCommit(false);
			String sql = "UPDATE ACCOUNTS "
					+ "SET PASSWORD = ?, "
					+ "CHECKING = ?, "
					+ "SAVINGS = ?"
					+ " WHERE USERNAME = ?";
			//Used PreparedStatement and filled it with values from newAccount
			PreparedStatement pStatement = con.prepareStatement(sql);
			pStatement.setString(1, newAccount.getPassword());
			pStatement.setDouble(2, newAccount.getChecking());
			pStatement.setDouble(3, newAccount.getSavings());
			pStatement.setString(4, newAccount.getUsername());
			//PreparedStatment is executed and commited.
			accountsUpdated = pStatement.executeUpdate();
			con.commit();
		} catch (IOException e) {
			
			e.printStackTrace();
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		//returns number of rows updated in the database.
		return accountsUpdated;
	}

	//Deletes an account from the database, where the row's USERNAME column
	//matches String username
	@Override
	public int deleteAccountByUsername(String username) {
		int accountsDeleted = 0;
			
		try {
			Connection con = ConnectionUtil.getConnection();
			//Auto commit set to false to prevent uncalled commits
			con.setAutoCommit(false);
			String sql = "DELETE FROM ACCOUNTS WHERE USERNAME = ?";
			//Used PreparedStatement and filled the ? with username.
			PreparedStatement pStatement = con.prepareStatement(sql);
			pStatement.setString(1, username);
			//PreparedStatement is executed and committed
			accountsDeleted = pStatement.executeUpdate();
			con.commit();
		} catch (IOException e) {
			
			e.printStackTrace();
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		//returns number of rows deleted from database
		return accountsDeleted;
	}

	//Method calls procedure DEPOSIT from the database via a CallableStatement
	@Override
	public void depositFunds(String username, String accountType, double amount) {
		
		try {
			Connection con = ConnectionUtil.getConnection();
			String sql = "{call DEPOSIT(?, ?, ?)}";
			//Used CallableStatement and filled it with the values from the
			//parameter arguments.
			CallableStatement cs = con.prepareCall(sql);
			cs.setString(1, username);
			cs.setString(2, accountType);
			cs.setDouble(3, amount);
			//Executes the CallableStatement
			cs.execute();
		} catch (IOException e) {
			
			e.printStackTrace();
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
	}

	//Method calls procedure WITHDRAW from the database via a CallableStatement
	@Override
	public void withDrawFunds(String username, String accountType, double amount) {
		
		try {
			Connection con = ConnectionUtil.getConnection();
			String sql = "{call WITHDRAW(?, ?, ?)}";
			//Used CallableStatement and filled it with values from the
			//parameter arguments.
			CallableStatement cs = con.prepareCall(sql);
			cs.setString(1, username);
			cs.setString(2, accountType);
			cs.setDouble(3, amount);
			//Executes the CallableStatement
			cs.execute();
		} catch (IOException e) {
			
			e.printStackTrace();
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
	}

}
