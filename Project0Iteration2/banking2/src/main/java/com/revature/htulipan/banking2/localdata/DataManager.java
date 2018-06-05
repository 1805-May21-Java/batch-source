package com.revature.htulipan.banking2.localdata;

import java.util.ArrayList;

import com.revature.htulipan.banking2.database.dao.AccountDaoImpl;
import com.revature.htulipan.banking2.database.dao.UserDaoImpl;
import com.revature.htulipan.banking2.database.pojos.Account;
import com.revature.htulipan.banking2.database.pojos.User;

public class DataManager {
	private UserDaoImpl udi = new UserDaoImpl();
	private AccountDaoImpl adi = new AccountDaoImpl();
	
	public boolean usernameExists(String in) {
		return udi.userExists(in);
	}
	
	public void createUser(User newUser) {
		udi.insertUser(newUser);
	}
	
	public User getUser(String username, String password) {
		User result = udi.getUser(username);
		return (result.getPassword().equals(password)) ? result : null;
	}
	
	public void createAccount(String username, String accountname) {
		adi.createAccount(username, accountname);
	}
	
	public void updateAccount(Account a) {
		adi.updateAccount(a);
	}
	
	public boolean accountExists(String username, String accountname) {
		return adi.accountExists(username, accountname);
	}
	
	public ArrayList<Account> getUserAccounts(String username) {
		return adi.getUserAccounts(username);
	}
}
