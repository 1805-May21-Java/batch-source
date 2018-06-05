package com.revature;

import static org.junit.Assert.*;
import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import com.revature.dao.AccountDaoImpl;
import com.revature.dao.UserDaoImpl;
import com.revature.pojos.Account;
import com.revature.pojos.Bank;
import com.revature.pojos.User;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class AccountDaoTest {
	static AccountDaoImpl adi;
	static UserDaoImpl udi;
	static Account account;
	static User user;
	
	@BeforeClass
	public static void setUpBeforeClass() {
		adi = new AccountDaoImpl();
		udi = new UserDaoImpl();
		user = udi.getUser("testUser", "testPassword");
		adi.createAccount(user.getUsername());
		account = adi.getAccount("testUser");
		User user2 = udi.getUser("testUser2", "testPassword2");
		adi.createAccount(user2.getUsername());
	}
	
	@Test
	public void aTestCreateAccountWithUserThatDoesNotExist() {
		assertEquals(adi.createAccount("jjj"), 0);
	}
	
	@Test
	public void bTestGetAccountThatExists() {
		assertNotNull(adi.getAccount("testUser"));
	}

	
	@Test
	public void cTestGetAccountThatDoesNotExist() {
		assertNull(adi.getAccount("hans"));
	}
	
	@Test
	public void dTestDeposit() {
		account.deposit(account.getAccountId(), 50.0, user.getUsername());
		assertEquals(adi.getBalance(account.getAccountId()), 50, 0.01);
	}
	
	@Test
	public void eTestGetBalance() {
		assertEquals(adi.getBalance(account.getAccountId()), 50.0, 0.01);
	}
	
	@Test
	public void fTestWithdraw() {
		account.withdraw(account.getAccountId(), 20.0, user.getUsername());
		assertEquals(adi.getBalance(account.getAccountId()), 30, 0.01);
		assertEquals(account.withdraw(account.getAccountId(), 2000.0, user.getUsername()), false);
	}
	
	@Test
	public void gTestTransfer() {
		assertEquals(Bank.transfer(account.getAccountId(), 5.0, "testUser2", account.getUsername()), true);
		assertEquals(adi.getBalance(account.getAccountId()), 25, 0.01);
		assertEquals(Bank.transfer(account.getAccountId(), 5.0, "testUser3", account.getUsername()), false);
		assertEquals(Bank.transfer(account.getAccountId(), 555.55, "testUser2", account.getUsername()), false);

	}
}
