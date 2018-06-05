package com.revature.dao;

import java.util.ArrayList;

import com.revature.pojos.Transaction;

public interface TransactionDao {
	public int createTransaction(String type, double amount, String username);
	public ArrayList<Transaction> getTransactions(String username);
}
