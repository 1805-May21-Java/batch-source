package com.revature.dao;

import java.util.List;

import com.revature.pojos.Transaction;

public interface TransactionDao {
	public List<Transaction> getTransactions ();
	public List<Transaction> getAccountTransactions(int acctNumber);
	public List<Transaction> getAccountTransactions(int acctNumber, int max);
	public int createTransaction(Transaction action);
	
	//won't need for this version of the app but may be useful in the future
	
	//public int updateTransaction(Transaction user);
	//public int deleteTransaction(int userId);
}
