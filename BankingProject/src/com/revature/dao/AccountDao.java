package com.revature.dao;

import java.util.List;

import com.revature.bank.Account;

public interface AccountDao {
	public List<Account> getAllAccounts();
	public Account getAccountById(String uname);
	public int CreateAccount(Account acct);
	public int updateAccount(Account acct);
	public int deleteAccount(String uname);
}
