package com.revature.dao;

import java.util.HashMap;

import com.revature.pojos.Account;

//Interface AccountDao is used to ensure that Account DAO Implementation
//will carry out all necessary actions, main retrieving from and writing 
//to the database.
public interface AccountDao {
	
	public HashMap<String, Account> getAccounts();
	
	public Account getAccountById(int id);
	
	public int createAccount(Account newAccount);
	
	public int updateAccount(Account newAccount);
	
	public int deleteAccountById(int id);
	
	//public void depositFunds(int id, String accountType, double amount);
	
	//public void withDrawFunds(int id, String accountType, double amount);

}
