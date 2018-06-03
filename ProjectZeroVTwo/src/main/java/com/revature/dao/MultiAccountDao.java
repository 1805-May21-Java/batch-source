package com.revature.dao;

import com.revature.pojos.*;

public interface MultiAccountDao
{
	public MultiAccount getAccountByType(String type, String username);
	public double getAccountBalance(String type, String username);
	public void createAccount(String type, String username);
	public void changeBalance(String type, String username, double value);
	public boolean acctsExits();
	public boolean isValidType(String type, String username);
	public boolean accountTypeExists(String type, String username);
}
