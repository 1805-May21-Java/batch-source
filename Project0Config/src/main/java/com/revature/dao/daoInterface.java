package com.revature.dao;

import java.util.ArrayList;
import com.revature.pojos.*;

public interface daoInterface {
	
	public void getAccountsFromClient(Client client);
	public Client login(String username, String password);
	public double getBalance(int bankId);
	public boolean saveOldClient(Client client);
	public boolean saveNewClient(Client client);
	public boolean saveNewAccount(BankAccount bankAccount, Client client);
	public boolean saveOldAccount(BankAccount bankAccount,Client client);
	public boolean saveAccountClientLink(BankAccount bankAccount,Client client);
	public boolean userNameExists(String newUserName);
	public boolean recordTransation(Transaction transaction);
	public ArrayList<Transaction> getTransactions(BankAccount bankAccount);
}
