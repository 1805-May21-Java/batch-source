package com.revature.dao;

import java.util.List;

import com.revature.bank.Account;
import com.revature.bank.Transaction;

public interface TransactionDao {
	
	public List<Transaction> getAllTransactions(Account account);

}
