package com.adora.access;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Before;
import org.junit.Test;

import com.adora.object.Account;
import com.adora.object.Customer;

public class TestAccountDao {

	private Customer customer;
	private List<Account> userAccount;
	private AccountDaoImpl adi = new AccountDaoImpl();
	
	
	@Test
	public void getUserAccountsTest() {
		
		userAccount = adi.getUserAccounts(customer);
		assert(userAccount.get(0).getAccountBalance() == 231.45);
	}
	
	@Test
	public void createNewAccountTest() {
		int numOfAccountsBefore = adi.getUserAccounts(customer).size();
		adi.addNewAccount(customer, new Account("Savings", 2.00));
		int numOfAccountsAfter = adi.getUserAccounts(customer).size();
		assert(numOfAccountsBefore + 1== numOfAccountsAfter);
	}
	
	@Test
	public void updateAccount() {
		userAccount = adi.getUserAccounts(customer);
		userAccount.get(1).setAccountBalance(21.50);
		int updated = adi.updateAccount(userAccount.get(1));
		

		assertEquals(updated, 1);
	}
	

}
