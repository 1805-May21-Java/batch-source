package com.revature.test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.revature.bank.Account;

public class AccountTest {
	
	private static Account account;
	
	@BeforeClass
	public static void setUp() {
		account = new Account();
		account.setLoggedIn(true);
	}

	@Before
	public void resetBal() {
		account.setBalance(0);
	}
	@Test
	public void testDeposit() {
		float amount = 10.0f;
		account.deposit(amount);
		assertEquals(amount,account.getBalance(),.5f);
	}

	@Test
	public void testWithdraw() {
		account.setBalance(10);
		float amount = 10f;
		account.withdraw(amount);
		assertEquals(0, account.getBalance(),.5f);
	}
	
	@Test
	public void testOverdraw() {
		account.setBalance(10);
		assertEquals(-1, account.withdraw(20));
	}
	
	@Test
	public void testNegativeDeposit() {
		assertEquals(-1, account.deposit(-10));
	}
}
