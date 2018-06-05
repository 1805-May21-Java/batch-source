package com.revature.test;

import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.Test;

import com.revature.pojos.Account;

//JUnit that test methods in class Account
//Only tests methods related to the interface AccountActions
public class AccountTest {
	
	@Test
	public void testDepositFunds() {
		Account account = new Account("testing1", "password1", 50, 50);
		account.depositFunds(50, "Savings");
		Assert.assertTrue(account.getSavings() == 100);
	}
	
	@Test
	public void withDrawFundsTest() {
		Account account = new Account("testing2", "password2", 20, 31);
		account.withDrawFunds(30, "Checking");
		Assert.assertTrue(account.getChecking() == 20);
		account.withDrawFunds(30, "Savings");
		Assert.assertTrue(account.getSavings() == 1);
	}
	
	
	@Test
	public void logOnTest() {
		Account account = new Account("testing3", "password3", 40, 40);
		Assert.assertFalse(account.isUserLoggedOn());
		account.logOn();
		Assert.assertTrue(account.isUserLoggedOn());
	}
	
	@Test
	public void logOffTest() {
		Account account = new Account("testing4", "password4", 60, 70);
		account.logOn();
		account.logOff();
		Assert.assertFalse(account.isUserLoggedOn());
	}

}
