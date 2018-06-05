package com.adora.access;

import java.util.List;

import com.adora.object.Account;
import com.adora.object.User;

public interface AccountDao {
	
	// create
	public int addNewAccount(User user, Account account);
	
	// read
	public List<Account> getUserAccounts(User user);
	
	// update
	public int updateAccount(Account account);
	
	

}
