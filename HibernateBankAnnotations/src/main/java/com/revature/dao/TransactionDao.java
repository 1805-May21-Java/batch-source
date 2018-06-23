package com.revature.dao;

import java.util.List;


public interface TransactionDao {
	public List<com.revature.pojos.Transaction> getTransactions ();
	public List<com.revature.pojos.Transaction> getAccountTransactions(long acctNumber);
	public List<com.revature.pojos.Transaction> getAccountTransactions(long acctNumber, int max);
	public int createTransaction(com.revature.pojos.Transaction action);
	
	//won't need for this version of the app but may be useful in the future
	
	//public int updateTransaction(Transaction user);
	//public int deleteTransaction(int userId);
}
