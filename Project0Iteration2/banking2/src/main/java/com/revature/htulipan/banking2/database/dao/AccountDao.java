package com.revature.htulipan.banking2.database.dao;

import java.util.ArrayList;

import com.revature.htulipan.banking2.database.pojos.Account;

public interface AccountDao {
	
	public int createAccount(String user, String accountName);
	public int updateAccount(Account updatedAccount);
	public boolean accountExists(String username, String accountname);
	public ArrayList<Account> getUserAccounts(String username);
	
}
