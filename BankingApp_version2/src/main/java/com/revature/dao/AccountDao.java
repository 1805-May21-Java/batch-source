package com.revature.dao;

import java.util.HashMap;

import com.revature.pojos.Account;

public interface AccountDao {
	
	public HashMap<String, Account> getAccounts();
	
	public Account getAccountByUsername(String username);
	
	public int createAccount(Account newAccount);
	
	public int updateAccount(Account newAccount);
	
	public int deleteAccountByUsername(String username);
	
	public void depositFunds(String username, String accountType, double amount);
	
	public void withDrawFunds(String username, String accountType, double amount);

}
