package com.revature.testing;

import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Random;

import org.junit.*;

import com.revature.dao.BankDaoImpl;
import com.revature.pojos.*;

public class BankTest {

	BankDaoImpl impl = new BankDaoImpl();
	Random r = new Random();
	
	User testUser = new User("test1", "pass"); // test User with 2 accounts, shown below
	Account testAccount1 = new Account(80641, 2000, "test"); // test Account 1
	Account testAccount2 = new Account(40813, 1000, "test2"); // test Account 2
	
	@Test
	public void testGetUsers() {
		ArrayList<User> users = impl.getUsers();
		Assert.assertTrue(!users.equals(new ArrayList<User>()));
	}

	@Test
	public void testGetAccounts() {
		ArrayList<Account> accounts = impl.getAccounts();
		Assert.assertTrue(!accounts.equals(new ArrayList<Account>()));
	}

	@Test
	public void testGetUserByName() {
		User test = impl.getUserByName(testUser.getUsername());
		
		Assert.assertEquals(testUser.getUsername(), test.getUsername());
		Assert.assertEquals(testUser.getPassword(), test.getPassword());
		Assert.assertTrue(test.getAccounts().size() > 0);
	}

	@Test
	public void testGetAccountByID() {
		Account test = impl.getAccountByID(testAccount1.getId());
		Assert.assertEquals(testAccount1.getId(), test.getId());
		Assert.assertEquals(testAccount1.getNickname(), test.getNickname());
		Assert.assertTrue(testAccount1.getBalance() == test.getBalance());
		Assert.assertTrue(test.getUsers().size() > 0);
		Assert.assertTrue(test.getTransactions().size() > 0);
	}

	@Test
	public void testCreateUser() {
		String username = "john jingleheimer schmidt";
		String password = "This 1z An aWes0m3 P4s5w0Rd!";
		User user = new User(username, password);
		
		impl.createUser(user);
		User userTest = impl.getUserByName(username);
		
		Assert.assertEquals(user, userTest);
		Assert.assertTrue(userTest.getAccounts().size() == 0);
	}

	@Test
	public void testCreateAccount() {
		int id = r.nextInt(999999999);
		double balance = r.nextDouble() * 200;
		String nickname = "nickname";
		Account account = new Account(id, balance, nickname);
		
		impl.createAccount(account);
		Account accountTest = impl.getAccountByID(id);
		
		Assert.assertEquals(account, accountTest);
		Assert.assertTrue(accountTest.getUsers().size() == 0);
		Assert.assertTrue(accountTest.getTransactions().size() == 0);
	}

	@Test
	public void testCreateTransaction() {
		String type = "test";
		String username = testUser.getUsername();
		double amount = 0.1;
		double balance = testAccount2.getBalance();
		int otherAccountID = testAccount1.getId();
		int accountID = testAccount2.getId();
		Transaction transaction = new Transaction(type, username, amount,
				balance, Date.valueOf(LocalDate.now()), otherAccountID);
		
		impl.createTransaction(transaction, accountID);
		Transaction transactionTest = impl.getAccountByID(accountID).getTransaction(0);
		
		Assert.assertEquals(transaction, transactionTest);
	}

	@Test
	public void testCreateLink() {
		String linkUser = testUser.getUsername();
		int linkID = testAccount1.getId();
		
		if(!testUser.getAccounts().contains(linkID)) {
			impl.createLink(linkUser, linkID);
			testUser = impl.getUserByName(testUser.getUsername());
			
			Assert.assertTrue(testUser.getAccounts().contains(linkID));
		}
	}

	@Test
	public void testUpdateUser() {
		String newPass = Integer.toString(r.nextInt(10000000));
		
		User test = impl.getUserByName(testUser.getUsername());
		test.setPassword(newPass);
		impl.updateUser(test);
		testUser = impl.getUserByName(testUser.getUsername());
		
		Assert.assertEquals(test, testUser);
	}

	@Test
	public void testUpdateAccount() {
		String newNickname = Integer.toString(r.nextInt(10000000));
		double newBalance = r.nextDouble() * 100000;
		
		Account test = impl.getAccountByID(testAccount1.getId());
		test.setBalance(newBalance);
		test.setNickname(newNickname);
		impl.updateAccount(test);
		testAccount1 = impl.getAccountByID(testAccount1.getId());
		
		Assert.assertEquals(test, testAccount1);
	}

	@Test
	public void testDeleteLink() {
		String linkUser = testUser.getUsername();
		int linkID = testAccount1.getId();
		
		if(testUser.getAccounts().contains(linkID)) {
			impl.deleteLink(linkUser, linkID);
			testUser = impl.getUserByName(testUser.getUsername());
			
			Assert.assertTrue(!testUser.getAccounts().contains(linkID));
		}
	}

}