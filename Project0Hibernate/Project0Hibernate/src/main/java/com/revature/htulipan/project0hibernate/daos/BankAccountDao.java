package com.revature.htulipan.project0hibernate.daos;

import java.util.ArrayList;

import com.revature.htulipan.project0hibernate.models.BankAccount;

public interface BankAccountDao {
	
	public int createAccount(String user, String accountName);
	public int updateAccount(BankAccount updatedAccount);
	public boolean accountExists(String username, String accountname);
	public ArrayList<BankAccount> getUserAccounts(String username);
	
}
