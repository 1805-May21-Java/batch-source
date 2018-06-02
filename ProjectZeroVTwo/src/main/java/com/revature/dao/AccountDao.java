package com.revature.dao;

import java.util.*;

import com.revature.pojos.*;

public interface AccountDao
{
	public void createAccount(String username);
	public void changePassword(String username, String password);
	public Account logIn(String username);
	public Account logIn(String username, String password);
	public void changeBalance(String username, double value);
	public double getBalance(String username);
	public boolean isValidUsername(String username);
	public boolean hasPassword(String username);
	public boolean accountsExist();
}
