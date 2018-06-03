package com.revature.dao;

import java.util.List;

import com.revature.pojos.Account;

public interface AccountDao {
	public List<Account> getAccounts();
	public Account getAccountByNumber(long accountNumber);
	public int createAccount(Account account, int userId);
	public int updateAccount(Account accont);
	public int deleteAccount(int acccountNumber);
}
