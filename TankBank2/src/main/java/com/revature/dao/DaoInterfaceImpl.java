package com.revature.dao;

import java.io.IOException;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.ArrayList;

import com.revature.pojos.BankAccount;
import com.revature.pojos.Client;
import com.revature.pojos.Transaction;
import com.revature.util.ConnectionUtil;

//implements the interface for storing and retrieving data from the database
public class DaoInterfaceImpl implements daoInterface {

	@Override
	public void getAccountsFromClient(Client client) {
		//gets all accounts associated with a client
		try(Connection connection = ConnectionUtil.getConnection()){
			//uses the linking account to find all account ID's associated with a username
			String sql = String.format("SELECT %s FROM %s WHERE %s = ?", 
					BankContract.ACCOUNT_ID,
					BankContract.CLIENT_BANK_TABLE_NAME,
					BankContract.LINKING_USERNAME);
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, client.getUsername());
			ResultSet resultSet = preparedStatement.executeQuery();
			while(resultSet.next()) {
				//For a single account ID from the previous query, finds the row with the same ID 
				//and puts the info into a bank account object
				String sql2 = String.format("SELECT %s, %s, %s FROM %s WHERE %s = ?",
					BankContract.BALANCE,
					BankContract.ACCOUNT_NAME,
					BankContract.ACCOUNT_ID,
					BankContract.ACCOUNT_TABLE_NAME,
					BankContract.ACCOUNT_ID);
				PreparedStatement preparedStatement2 = connection.prepareStatement(sql2);
				preparedStatement2.setString(1, resultSet.getString(BankContract.LINKING_BANK_ID));
				ResultSet resultSet2 = preparedStatement2.executeQuery();
				while(resultSet2.next()) {
					//adds that bank account object to the client's arraylist of accounts
					 client.addNewAccount(new BankAccount(
							 resultSet2.getDouble(BankContract.BALANCE),
							 resultSet2.getString(BankContract.ACCOUNT_NAME),
							 resultSet2.getInt(BankContract.ACCOUNT_ID),
							client));
					}
		}
		}catch (SQLException | IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	public Client login(String username, String password) {
		try(Connection connection = ConnectionUtil.getConnection()){
			//matches login and password ID
			String sql = String.format("SELECT %s, %s, %s FROM %s",
					BankContract.USERNAME,
					BankContract.PASSWORD,
					BankContract.EMAIL,
					BankContract.CLIENT_TABLE_NAME);
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			ResultSet resultSet = preparedStatement.executeQuery();
			while(resultSet.next()) {
				if((resultSet.getString(BankContract.USERNAME)).equals(username)) {
					if(resultSet.getString(BankContract.PASSWORD).equals(password)) {
						//if username and password match, create new client with info from database
						Client client = new Client();
						client.setUsername(username);
						client.setPassword(password);
						client.setEmail(resultSet.getString(BankContract.EMAIL));
						getAccountsFromClient(client);
						return client;
					}else {
						//matching username, but wrong password
						//usernames are unique, so no possible match after this
						System.out.println("Invalid password!");
						return null;
					}
				}
				
			}
			//if here, user has gone through whole database 
			//without finding a username equivalent to what they entered 
			System.out.println("Username not found!");
		} catch (SQLException | IOException e) {
			e.printStackTrace();
			return null;
		}
		//should never get here
		return null;
	}

	@Override
	public double getBalance(int bankId) {
		try(Connection connection = ConnectionUtil.getConnection()){
			//gets the balance from an account
			String sql = String.format("SELECT %s FROM %s WHERE %s = ?",
					BankContract.BALANCE,
					BankContract.ACCOUNT_TABLE_NAME,
					BankContract.ACCOUNT_ID);
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setInt(1, bankId);
			ResultSet resultSet = preparedStatement.executeQuery();
			while(resultSet.next()) {
				return resultSet.getDouble(BankContract.BALANCE);
				}
		} catch (SQLException | IOException e) {
			e.printStackTrace();
		}
		return 0;
	}
	@Override
	public boolean saveNewAccount(BankAccount bankAccount, Client client) {
		try(Connection connection = ConnectionUtil.getConnection()){
			//if here, this is the first time this account has been created and a new row is inserted
			String sql = String.format("BEGIN INSERT INTO %s (%s, %s) VALUES(?,?) RETURNING %s INTO ?;END;", 
					BankContract.ACCOUNT_TABLE_NAME,
					BankContract.BALANCE,
					BankContract.ACCOUNT_NAME,
					BankContract.ACCOUNT_ID);
			//Callable statement is done to be able to return the auto-generated bank ID 
			CallableStatement callableStatement = connection.prepareCall(sql);
			callableStatement.setDouble(1, bankAccount.getBalence());
			callableStatement.setString(2, bankAccount.getAccountName());
			callableStatement.registerOutParameter(3, Types.NUMERIC);
			callableStatement.execute();
			bankAccount.setBankId(callableStatement.getInt(3));
			//Autogenerated ID added to the account's instance variables
			
			//Creates a transaction record of the account being created
			String transactionMessage = "Account created.  Balance $0.";
			recordTransation(new Transaction(bankAccount,transactionMessage,
					new Date(System.currentTimeMillis()),client.getUsername()));
			return true;
			
		} catch (SQLException | IOException e) {
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public boolean saveOldAccount(BankAccount bankAccount, Client client) {
		try(Connection connection = ConnectionUtil.getConnection()){
			//if here, this is an old account that is being updated
			String sql = String.format("UPDATE %s SET %s = ? WHERE %s = ?", 
					BankContract.ACCOUNT_TABLE_NAME,BankContract.BALANCE,BankContract.ACCOUNT_ID);
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setDouble(1, bankAccount.getBalence());
			preparedStatement.setInt(2,bankAccount.getBankId());
			preparedStatement.execute();
			
			//Creates a transaction of change to account
			String transactionMessage = "Balance: $"+bankAccount.getBalence();
			recordTransation(new Transaction(bankAccount,transactionMessage,
					new Date(System.currentTimeMillis()),client.getUsername()));
			
			//If reaches here, SQL statements executed without error
			return true;
		} catch (SQLException | IOException e) {
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public boolean saveNewClient(Client client) {
		try(Connection connection = ConnectionUtil.getConnection()){
			//if here, this is the first time this client has been created and a new row is inserted
			String sql = String.format("INSERT INTO %s (%s, %s, %s) VALUES(?,?,?)", 
					BankContract.CLIENT_TABLE_NAME,
					BankContract.USERNAME,
					BankContract.PASSWORD,
					BankContract.EMAIL);
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, client.getUsername());
			preparedStatement.setString(2,client.getPassword());
			preparedStatement.setString(3,client.getEmail());
			return preparedStatement.execute();
		} catch (SQLException | IOException e) {
			e.printStackTrace();
			return false;
		}
	}
	
	@Override
	public boolean saveOldClient(Client client) {
		//functionality to change username, password, and email not yet implemented
		return false;
	}
	
	@Override
	public boolean saveAccountClientLink(BankAccount bankAccount, Client client) {
		try(Connection connection = ConnectionUtil.getConnection()){
			//if here, this is the first time this account has been created and a new row is inserted
			String sql = String.format("INSERT INTO %s (%s, %s) VALUES(?,?)", 
					BankContract.CLIENT_BANK_TABLE_NAME,
					BankContract.LINKING_USERNAME,
					BankContract.LINKING_BANK_ID);
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, client.getUsername());
			preparedStatement.setInt(2, bankAccount.getBankId());
			return (preparedStatement.execute());
		} catch (SQLException | IOException e) {
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public boolean userNameExists(String newUserName) {
		try(Connection connection = ConnectionUtil.getConnection()){
			//checks if an entered username already exists, returns true if it is there already
			String sql = String.format("SELECT * FROM %s WHERE %s = ?", 
					BankContract.CLIENT_TABLE_NAME,
					BankContract.USERNAME);
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, newUserName);
			ResultSet resultSet = preparedStatement.executeQuery();
			while(resultSet.next()) {
				//If in the loop, that means there is a resultSet, meaning the query returned a result
				//that would only happen if the username already exists
				return true;
			}
			//if here, the loop was never entered, so no matching username exists
			return false;
		} catch (SQLException | IOException e) {
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public boolean recordTransation(Transaction transaction) {
		//Saves the result of a transaction and the client who made it in the log table
		try(Connection connection = ConnectionUtil.getConnection()){
			String sql = String.format("INSERT INTO %s (%s, %s, %s, %s) VALUES(?,?,?,?)", 
					BankContract.LOG_TABLE_NAME,
					BankContract.LOG_BANK_ID,
					BankContract.LOG_USERNAME,
					BankContract.LOG_MESSAGE,
					BankContract.LOG_DATE);
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setInt(1, transaction.getBankAccount().getBankId());
			preparedStatement.setString(2, transaction.getClientUsername());
			preparedStatement.setString(3, transaction.getTransactionMessage());
			preparedStatement.setDate(4, transaction.getDate());
			return (preparedStatement.execute());
		} catch (SQLException | IOException e) {
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public ArrayList<Transaction> getTransactions(BankAccount bankAccount) {
		//gets all transactions from a bank account
		ArrayList<Transaction> transactionList = new ArrayList<>();
		try(Connection connection = ConnectionUtil.getConnection()){
			String sql = String.format("SELECT * FROM %s WHERE %s = ?", 
					BankContract.LOG_TABLE_NAME,
					BankContract.ACCOUNT_ID);
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setInt(1, bankAccount.getBankId());
			ResultSet resultSet = preparedStatement.executeQuery();
			while(resultSet.next()) {
				transactionList.add(new Transaction(
						bankAccount,
						resultSet.getString(BankContract.LOG_MESSAGE),
						resultSet.getDate(BankContract.LOG_DATE),
						resultSet.getString(BankContract.LOG_USERNAME)
						));
			}
			return transactionList;
		} catch (SQLException | IOException e) {
			e.printStackTrace();
			return null;
		}
	}
}
