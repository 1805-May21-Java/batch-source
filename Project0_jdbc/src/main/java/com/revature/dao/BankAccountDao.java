package com.revature.dao;

import java.util.List;

import com.revature.pojos.BankAccount;
import com.revature.pojos.User;

public interface BankAccountDao
{

	List<BankAccount> getBankAccounts();
	List<BankAccount> getBankAccountsByUserId(String userId);
	BankAccount getBankAccountById(String accountId);
	void createBankAccount(BankAccount bankAccount);
	void updateBankAccount(BankAccount bankAccount);
	void deleteBankAccountById(String id);
}
