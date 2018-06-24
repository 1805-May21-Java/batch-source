package com.revature.dao;

import java.util.List;

import com.revature.bank.Account;

public interface AccountDao {
	public List<Account> getAllAccounts();
	public Account getAccountById(String uname);
	public String CreateAccount(Account acct);
	public void updateAccount(Account acct);
	public void deleteAccount(String uname);
}
