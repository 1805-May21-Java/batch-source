package com.Revature.Dao;

import com.Revature.pojos.BankAccount;
import com.Revature.pojos.UserProfile;

public interface BankAccountDao {
	// Method for getting the next account number in sequence
	public int getNextAccountNumber() throws Exception;

	// To create a bank account connected to a user profile
	public int createBankAccount(UserProfile user, BankAccount acc) throws Exception;

	// Add a user profile to an existing bank account
	public int addProfileToBankAccount(UserProfile user, BankAccount acc) throws Exception;

	// Returns an existing bank account
	public BankAccount getBankAccount(int id) throws Exception;

	// Updates a bank accounts balance
	public int updateBankAccount(BankAccount acc) throws Exception;

	// Deletes a single bank account
	public int deleteBankAccount(int id) throws Exception;

	// Withdraws from a bank Account
	public int withdrawFromBank(BankAccount acc, float val) throws Exception;

	// Deposit into an account
	public int depositToBank(BankAccount acc, float val) throws Exception;

	// Attempts to transfer money between accounts
	public int transferMoneyBetweenAccounts(BankAccount src, BankAccount dest, float val) throws Exception;
}
