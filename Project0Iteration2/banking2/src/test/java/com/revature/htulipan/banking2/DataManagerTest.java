package com.revature.htulipan.banking2;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Random;

import org.junit.Assert;
import org.junit.Test;

import com.revature.htulipan.banking2.database.pojos.Account;
import com.revature.htulipan.banking2.database.pojos.User;
import com.revature.htulipan.banking2.localdata.DataManager;

public class DataManagerTest {
	
	/*
	 * 
	public boolean usernameExists(String in) {
		return udi.userExists(in);
	}
	
	public void createUser(User newUser) {
		udi.insertUser(newUser);
	}
	
	public User getUser(String username, String password) {
		User result = udi.getUser(username);
		return (result.getPassword().equals(password)) ? result : null;
	}
	
	public void createAccount(String username, String accountname) {
		adi.createAccount(username, accountname);
	}
	
	public void updateAccount(Account a) {
		adi.updateAccount(a);
	}
	
	public boolean accountExists(String username, String accountname) {
		return adi.accountExists(username, accountname);
	}
	
	public ArrayList<Account> getUserAccounts(String username) {
		return adi.getUserAccounts(username);
	}
	 */
	
	DataManager dm = new DataManager();
	Random r = new Random();
	int numAccounts;
	Account known = null;
	
	@Test
	public void testUsernameExists() {
		// should not exist
		boolean exists = dm.usernameExists("shouldnotexist");
		Assert.assertFalse(exists);
		
		// should exist
		exists = dm.usernameExists("TESTUSER1");
		Assert.assertTrue(exists);
	}
	
	@Test
	public void testCreateUser() {
		// Create a new user with new random-ish credentials
		User nu = new User();
		
		String username = "testuser" + r.nextInt(1000);
		String password = "testpass" + r.nextInt(1000);
		nu.setUsername(username);
		nu.setPassword(password);
		dm.createUser(nu);
		
		// Check if it exists
		boolean exists = dm.usernameExists(username);
		Assert.assertTrue(exists);
	}
	
	@Test
	public void testGetUser() {
		User comp = new User();
		comp.setUsername("TESTUSER1");
		comp.setPassword("TU1PASS");
		
		// Test if getting a user with a given name and pass gets the right user
		User got = dm.getUser("TESTUSER1", "TU1PASS");
		Assert.assertEquals(comp, got);
		
		// Test if getting a user with the wrong password returns null
		got = dm.getUser("TESTUSER1", "WRONGPASS");
		Assert.assertNull(got);
	}
	
	@Test
	public void testAccountExists() {
		// Check if a known account exists
		boolean exists = dm.accountExists("TESTUSER1", "TU1FIRSTACCOUNT");
		Assert.assertTrue(exists);
		
		// Check if an account known not to exist exists
		exists = dm.accountExists("TESTUSER1", "shouldnotexist");
		Assert.assertFalse(exists);
	}
	
	@Test
	public void testGetUserAccounts() {
		ArrayList<Account> list = dm.getUserAccounts("TESTUSER1");
		numAccounts = list.size();
		known = null;
		for (Account a : list) {
			if (a.getAccountName().equals("TU1FIRSTACCOUNT")) {
				known = a;
			}
		}
		
		// Check if a know account is one the list
		Assert.assertNotNull(known);
		
	}
	
	/*
	@Test
	public void testCreateAccount() {
		// Create a new account
		String accountName = "testaccount" + r.nextInt(1000);
		dm.createAccount("TESTUSER1", accountName);
		
		// Check if it exists
		boolean exists = dm.accountExists("TESTUSER1", accountName);
		
		// Check if getting all user's accounts gives a new list size one greater
		ArrayList<Account> list = dm.getUserAccounts("TESTUSER1");
		Assert.assertTrue(list.size() == (numAccounts+1));
	}
	*/
	
	
	/*
	@Test
	public void testUpdateAccount() {
		String knownBefore = known.toString();
		
		Account na = new Account();
		na.setOwner("TESTUSER1");
		na.setAccountName("TU1FIRSTACCOUNT");
		na.setBalance(10093.43f);
		
		dm.updateAccount(na);
		
		ArrayList<Account> list = dm.getUserAccounts("TESTUSER1");
		known = null;
		for (Account a : list) {
			if (a.getAccountName().equals("TU1FIRSTACCOUNT")) {
				known = a;
			}
		}
		
		String knownAfter = known.toString();
		
		Assert.assertTrue(knownBefore.equals(knownAfter));
	}
	*/
	

}
