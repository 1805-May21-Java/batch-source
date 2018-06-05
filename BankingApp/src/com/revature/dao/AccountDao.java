package com.revature.dao;

import java.util.List;

import com.revature.bankingapp.Account;

public interface AccountDao {

	public List<Account> getAccounts();
	public Account getAccountById(int id);
	public int createAccount(Account account);
	public int updateAccount(Account account);
	public int deleteAccountById(int id);
	
}
