package com.adora.access;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Before;
import org.junit.Test;

import com.adora.object.Account;
import com.adora.object.User;

public class TestAccountDao {

	private User user;
	private List<Account> userAccount;
	private AccountDaoImpl adi = new AccountDaoImpl();
	
	@Before 
	public void getUser() {
		user = new User(1, "adorasmith", "password");
	}
	
	@Test
	public void getUserAccountsTest() {
		
		userAccount = adi.getUserAccounts(user);
		assert(userAccount.get(0).getAccountBalance() == 231.45);
	}
	
	@Test
	public void createNewAccountTest() {
		int numOfAccountsBefore = adi.getUserAccounts(user).size();
		adi.addNewAccount(user, new Account("Savings", 2.00));
		int numOfAccountsAfter = adi.getUserAccounts(user).size();
		assert(numOfAccountsBefore + 1== numOfAccountsAfter);
	}
	
	@Test
	public void updateAccount() {
		userAccount = adi.getUserAccounts(user);
		userAccount.get(1).setAccountBalance(21.50);
		int updated = adi.updateAccount(userAccount.get(1));
		

		assertEquals(updated, 1);
	}
	

}
