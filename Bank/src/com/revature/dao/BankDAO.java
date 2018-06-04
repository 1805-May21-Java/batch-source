package com.revature.dao;

import java.util.ArrayList;
import java.util.LinkedList;

import com.revature.bank.*;
import com.revature.bank.User;

public interface BankDAO {
	
	public ArrayList<User> getUsers();
	public ArrayList<Account> getAccounts();
	
	public User getUserByName(String name);
	public Account getAccountByID(int id);
	
	public int createUser(User user);
	public int createAccount(Account account);
	public int createTransaction(Transaction transaction, int accountID);
	
	public int updateAccount(Account account);
	
	public int deleteUserByName(String name);
	public int deleteAccountByID(int accountID);
}
