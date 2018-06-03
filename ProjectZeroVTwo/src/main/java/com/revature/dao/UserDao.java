package com.revature.dao;

import java.util.*;

import com.revature.pojos.*;

public interface UserDao
{
	public List<MultiAccount> getAccountsByUser(String username);
	public boolean nameExists(String username);
	public boolean isValidName(String username);
	public void changePassword(String password, String username);
	public void createUser(String username);
	public List<String> getAcctTypByName(String name);
	public User logIn(String username);
	public User logIn(String username, String password);
	public boolean hasPassword(String name);
	public boolean usersExist();
	public boolean hasAccounts(String username);
}
