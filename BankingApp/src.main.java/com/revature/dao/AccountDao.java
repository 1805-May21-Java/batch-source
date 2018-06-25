package com.revature.dao;

import java.util.List;

import com.revature.models.Account;

public interface AccountDao {

	public List<Account> getAccounts();
	public Account getAccountById(int id);
	public void createAccount(Account account);
	public void updateAccount(Account account);
	public int deleteAccountById(int id);
	
}
