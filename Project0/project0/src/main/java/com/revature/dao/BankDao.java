package com.revature.dao;

import java.util.ArrayList;
import com.revature.pojos.Account;
import com.revature.pojos.User;

public interface BankDao {
	public ArrayList<User> getUsers();
	public ArrayList<Account> getAccounts();
}
