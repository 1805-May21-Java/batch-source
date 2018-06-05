package com.revature.banktest;

import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Random;

import org.junit.*;

import com.revature.bank.*;
import com.revature.dao.BankDAOImpl;

public class BankDAOImplTest {

	BankDAOImpl dao = new BankDAOImpl();
	Random r = new Random();
	
	User testUser = new User("test1", "pass"); // test User with 2 accounts, shown below
	Account testAccount1 = new Account(80641, 2000, "test"); // test Account 1
	Account testAccount2 = new Account(40813, 1000, "test2"); // test Account 2
	
	@Test
	public void testGetUsers() {
		ArrayList<User> users = dao.getUsers();
		Assert.assertTrue(!users.equals(new ArrayList<User>()));
	}

	@Test
	public void testGetAccounts() {
		ArrayList<Account> accounts = dao.getAccounts();
		Assert.assertTrue(!accounts.equals(new ArrayList<Account>()));
	}

	@Test
	public void testGetUserByName() {
		User test = dao.getUserByName(testUser.getUser());
		
		Assert.assertEquals(testUser.getUser(), test.getUser());
		Assert.assertEquals(testUser.getPass(), test.getPass());
		Assert.assertTrue(test.getAccounts().size() > 0);
	}

	@Test
	public void testGetAccountByID() {
		Account test = dao.getAccountByID(testAccount1.getId());
		Assert.assertEquals(testAccount1.getId(), test.getId());
		Assert.assertEquals(testAccount1.getNickname(), test.getNickname());
		Assert.assertTrue(testAccount1.getBalance() == test.getBalance());
		Assert.assertTrue(test.getUsers().size() > 0);
		Assert.assertTrue(test.getTransactions().size() > 0);
	}

	@Test
	public void testCreateUser() {
		String username = Integer.toString(r.nextInt(10000000));
		String password = Integer.toString(r.nextInt(10000000));
		User user = new User(username, password);
		
		dao.createUser(user);
		User userTest = dao.getUserByName(username);
		
		Assert.assertEquals(user, userTest);
		Assert.assertTrue(userTest.getAccounts().size() == 0);
	}

	@Test
	public void testCreateAccount() {
		int id = r.nextInt(90000) + 10000;
		double balance = r.nextDouble() * 10000;
		String nickname = Integer.toString(r.nextInt(10000000));
		Account account = new Account(id, balance, nickname);
		
		dao.createAccount(account);
		Account accountTest = dao.getAccountByID(id);
		
		Assert.assertEquals(account, accountTest);
		Assert.assertTrue(accountTest.getUsers().size() == 0);
		Assert.assertTrue(accountTest.getTransactions().size() == 0);
	}

	@Test
	public void testCreateTransaction() {
		String type = "test";
		String username = testUser.getUser();
		double amount = 0.1;
		double balance = testAccount2.getBalance();
		int otherAccountID = testAccount1.getId();
		int accountID = testAccount2.getId();
		Transaction transaction = new Transaction(type, username, amount,
				balance, Date.valueOf(LocalDate.now()), otherAccountID);
		
		dao.createTransaction(transaction, accountID);
		Transaction transactionTest = dao.getAccountByID(accountID).getTransaction(0);
		
		Assert.assertEquals(transaction, transactionTest);
	}

	@Test
	public void testCreateLink() {
		String linkUser = testUser.getUser();
		int linkID = testAccount1.getId();
		
		if(!testUser.getAccounts().contains(linkID)) {
			dao.createLink(linkUser, linkID);
			testUser = dao.getUserByName(testUser.getUser());
			
			Assert.assertTrue(testUser.getAccounts().contains(linkID));
		}
	}

	@Test
	public void testUpdateUser() {
		String newPass = Integer.toString(r.nextInt(10000000));
		
		User test = dao.getUserByName(testUser.getUser());
		test.setPass(newPass);
		dao.updateUser(test);
		testUser = dao.getUserByName(testUser.getUser());
		
		Assert.assertEquals(test, testUser);
	}

	@Test
	public void testUpdateAccount() {
		String newNickname = Integer.toString(r.nextInt(10000000));
		double newBalance = r.nextDouble() * 100000;
		
		Account test = dao.getAccountByID(testAccount1.getId());
		test.setBalance(newBalance);
		test.setNickname(newNickname);
		dao.updateAccount(test);
		testAccount1 = dao.getAccountByID(testAccount1.getId());
		
		Assert.assertEquals(test, testAccount1);
	}

	@Test
	public void testDeleteLink() {
		String linkUser = testUser.getUser();
		int linkID = testAccount1.getId();
		
		if(testUser.getAccounts().contains(linkID)) {
			dao.deleteLink(linkUser, linkID);
			testUser = dao.getUserByName(testUser.getUser());
			
			Assert.assertTrue(!testUser.getAccounts().contains(linkID));
		}
	}

}
