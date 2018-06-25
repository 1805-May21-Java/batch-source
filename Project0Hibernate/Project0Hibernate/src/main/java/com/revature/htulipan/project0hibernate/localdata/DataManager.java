package com.revature.htulipan.project0hibernate.localdata;

import java.util.ArrayList;

import com.revature.htulipan.project0hibernate.daos.AccountDaoImpl;
import com.revature.htulipan.project0hibernate.daos.UserDaoImpl;
import com.revature.htulipan.project0hibernate.models.BankAccount;
import com.revature.htulipan.project0hibernate.models.BankUser;

public class DataManager {
	private UserDaoImpl udi = new UserDaoImpl();
	private AccountDaoImpl adi = new AccountDaoImpl();
	
	public boolean usernameExists(String in) {
		return udi.userExists(in);
	}
	
	public void createUser(BankUser newUser) {
		udi.insertUser(newUser);
	}
	
	public BankUser getUser(String username, String password) {
		BankUser result = udi.getUser(username);
		return (result.getPassword().equals(password)) ? result : null;
	}
	
	public void createAccount(String username, String accountname) {
		adi.createAccount(username, accountname);
	}
	
	public void updateAccount(BankAccount a) {
		adi.updateAccount(a);
	}
	
	public boolean accountExists(String username, String accountname) {
		return adi.accountExists(username, accountname);
	}
	
	public ArrayList<BankAccount> getUserAccounts(String username) {
		return adi.getUserAccounts(username);
	}
}
