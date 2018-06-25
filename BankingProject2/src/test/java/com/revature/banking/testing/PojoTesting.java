package com.revature.banking.testing;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;

import org.junit.Test;

import com.revature.assignment.pojos.Access;
import com.revature.assignment.pojos.Account;
import com.revature.assignment.pojos.BankAccount;

public class PojoTesting {
	
	@Test
	public void accountLogInTest() {
		Access access=new Access();
		Account account=access.logIn("nick", "solo");
		
		//Correct credentials return an instance of Account
		assertNotNull(account);
		
		//Incorrect credentials return null
		account=access.logIn("nck", "solo");
		assertNull(account);
	}
	
	@Test
	public void accountSignUp() {
		Access access=new Access();
		Account account=access.signUp("nick", "solo");
		
		//If username already exists, the object should be null
		assertNull(account);
	}
	
	@Test
	public void bankAccountOperations() {
		Access access=new Access();
		Account account=access.logIn("nick", "solo");
		ArrayList<BankAccount> bankAccounts=account.getBankAccounts();
		BankAccount test=bankAccounts.get(0);
		
		assertTrue(test.depsoit(100.00));
		assertFalse(test.depsoit(-10.00));
		
		//If the account has enough, it should return true
		assertTrue(test.withdraw(5.0));
		
		//Should return false if the given number is negative
		assertFalse(test.withdraw(-5.0));
		
		//Should return false if the given number is more than the account balance
		assertFalse(test.withdraw(50000.00));
	}

}
