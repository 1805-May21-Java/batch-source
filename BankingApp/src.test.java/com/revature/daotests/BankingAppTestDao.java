package com.revature.daotests;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;

import com.revature.bankingapp.Account;
import com.revature.dao.AccountDaoImpl;

public class BankingAppTestDao {
	
	private Account account;
	private List<Account> accounts;
	private AccountDaoImpl adi = new AccountDaoImpl();
	

	@Test
	public void getAccountsTest() {
		accounts = adi.getAccounts();
		assertNotNull(accounts);
	}
	
	@Test
	public void getAccountByIdTest() {
		Account a = adi.getAccountById(23);
		assert(a.getUsername().equals("Sydney27"));
	}
	
	@Test
	public void createAccountTest() {
		account = new Account("apollo11", "houston", 0.0);
		adi.createAccount(account);
		assertNotNull(account.getId());
	}
	
	@Test
	public void updateAccountTest() {
		Account a = adi.getAccountById(23);
		a.setBalance(55);
		adi.updateAccount(a);
		assert(a.getBalance() == 55);
	}

}
