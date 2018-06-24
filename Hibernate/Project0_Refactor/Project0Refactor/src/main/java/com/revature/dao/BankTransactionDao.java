package com.revature.dao;

import java.util.ArrayList;

import com.revature.models.BankTransaction;

public interface BankTransactionDao {
	public int createTransaction(BankTransaction transaction);
	public ArrayList<BankTransaction> getTransactions(String username);
}
