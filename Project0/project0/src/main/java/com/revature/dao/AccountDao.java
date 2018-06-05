package com.revature.dao;

import com.revature.pojos.Account;

public interface AccountDao {
	public int createAccount(String username);
	public Account getAccount(String username);
	public double getBalance(int accountId);
	public boolean updateBalance(int accountId, double amount, String username);
}
