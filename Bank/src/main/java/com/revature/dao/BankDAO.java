package com.revature.dao;

import java.util.ArrayList;
import java.util.List;

import com.revature.bank.*;
import com.revature.bank.User;

/*
 * Data Access Object interface for interaction with SQL database
 * 
 * Not sure how to reimplement the Link creation functionality in Hibernate
 */
public interface BankDAO {
	
	public ArrayList<User> getUsers();
	public ArrayList<Account> getAccounts();
	
	public User getUserByName(String name);
	public Account getAccountByID(int id);
	
	public String createUser(User user);
	public int createAccount(Account account);
	public int createTransaction(Transaction transaction, int accountID);
//	public int createLink(String username, int accountID);
	
	public void updateUser(User user);
	public void updateAccount(Account account);
	
	public void deleteUserByName(String name);
	public void deleteAccountByID(int accountID);
//	public int deleteLink(String username, int accountID);
}
