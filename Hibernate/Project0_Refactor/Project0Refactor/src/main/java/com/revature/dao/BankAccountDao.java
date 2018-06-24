package com.revature.dao;

import com.revature.models.BankAccount;
import com.revature.models.BankUser;

public interface BankAccountDao {
	public int createAccount(BankAccount account);
	public BankAccount getAccount(String username);
	public void updateBalance(BankAccount account);
}
