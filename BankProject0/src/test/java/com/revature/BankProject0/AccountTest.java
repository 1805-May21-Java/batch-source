package com.revature.BankProject0;
//the tests here use an arbitrary number for withdrawing over the current balance
//as well as depositing of a non-positive amount of money
import static org.junit.Assert.*;
//expected to fail at least one of these tests
import org.junit.Test;
import org.junit.BeforeClass;
import org.junit.Before;
import com.revature.pojos.Account;
public class AccountTest {
	private static Account ac;
	@BeforeClass
	public static void setup() { // setup a test before class is run
		ac = new Account();
		ac.setLoggedIn(true);
	}
	@Before
	public void resetBalance() { // balance to be reset to 0 upon creation of new account
		ac.setBalance(0);
	}
	
	@Test
	public void testDeposit() { //two test functions for testing deposits and withdrawals
		float amount = 10.0f;
		ac.deposit(amount);
		assertEquals(amount, ac.getBalance(),.5f);
	}
	@Test
	public void testWithdraw() {
		ac.setBalance(20); //for withdrawal, set the balance to some arbitrary number
		float amount = 20.0f;
		ac.withdraw(amount);
		assertEquals(amount, ac.getBalance(),.5f);
	}
	@Test
	public void testWithdrawOverBalance() { //tests the condition if the balance is less than amount withdrawn
		ac.setBalance(10);
		assertEquals(-1, ac.withdraw(20)); // 10 > 20, so the condition evals to -1 for the switch in the main program
	}
	@Test
	public void testNonpositiveDeposit() { //tests for non-positive amount being deposited
		assertEquals(-1, ac.deposit(-2)); //again, using an arbitrary value
	}

}
