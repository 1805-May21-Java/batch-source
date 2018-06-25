package com.adora.access;

import java.util.List;

import com.adora.object.Account;
import com.adora.object.Customer;

public interface AccountDao {
	
	// create
	public int addNewAccount(Customer customer, Account account);
	
	// read
	public List<Account> getUserAccounts(Customer customer);
	
	// update
	public int updateAccount(Account account);
	
	

}
