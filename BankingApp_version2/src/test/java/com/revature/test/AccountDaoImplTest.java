package com.revature.test;

import static org.junit.Assert.*;
import org.junit.Assert;
import org.junit.Test;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.HashMap;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import com.revature.dao.AccountDaoImpl;
import com.revature.pojos.Account;
import com.revature.util.ConnectionUtil;

//Test all methods in class AccountDaoImpl
public class AccountDaoImplTest {
	
	//Opens up Connection to database before any test methods
	//are executed, so the test methods need to only connect to it.
	@BeforeClass
	public static void createConnection() {
		try {
			Connection con = ConnectionUtil.getConnection();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	
	@Test
	public void testGetAccounts() throws IOException, SQLException {
		HashMap<String, Account> accounts = null;
		AccountDaoImpl ad1 = new AccountDaoImpl();
		accounts = ad1.getAccounts();
		Assert.assertNotNull(accounts);
	}
	
	@Test
	public void testGetAccountByUsername() throws IOException, SQLException {
		AccountDaoImpl ad1 = new AccountDaoImpl();
		Account account = ad1.getAccountByUsername("rojas23");
		Assert.assertNotNull(account);
	}
	
	@Test
	public void testCreateAccount() throws IOException, SQLException {
		AccountDaoImpl ad1 = new AccountDaoImpl();
		Account account = new Account("test1", "password", 5, 10);
		ad1.createAccount(account);
		Account accountCopy = ad1.getAccountByUsername("test1");
		Assert.assertNotNull(accountCopy);
	}
	
	@Test
	public void testUpdateAccount() {
		AccountDaoImpl ad1 = new AccountDaoImpl();
		Account account = new Account("test", "password", 5, 10);
		ad1.createAccount(account);
		account.depositFunds(500, "CHECKING");
		ad1.updateAccount(account);
		Account accountCopy = ad1.getAccountByUsername("test");
		Assert.assertTrue(accountCopy.getChecking() == 505);
	}
	
	@Test
	public void testDeleteByUsername() {
		AccountDaoImpl ad1 = new AccountDaoImpl();
		int rowsDeleted = ad1.deleteAccountByUsername("test1");
		Assert.assertTrue(rowsDeleted == 1);
	}
	
	@Test
	public void testDepositFunds() {
		AccountDaoImpl ad1 = new AccountDaoImpl();
		ad1.depositFunds("test", "CHECKING", 15);
		Account account = ad1.getAccountByUsername("test");
		Assert.assertTrue(account.getChecking() == 520);
	}
	
	@Test
	public void testWithDrawFunds() {
		AccountDaoImpl ad1 = new AccountDaoImpl();
		ad1.withDrawFunds("test", "SAVINGS", 7);
		Account account = ad1.getAccountByUsername("test");
		Assert.assertTrue(account.getSavings() == 3);
	}
	
	//Closes the Connection after all test methods have been executed
	@AfterClass
	public static void closeConnection() {
		try {
			Connection con = ConnectionUtil.getConnection();
			con.close();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	
	

}
