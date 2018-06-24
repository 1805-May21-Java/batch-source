package com.revature.dao;

import com.revature.models.BankUser;

public interface BankUserDao {
	public String createUser(BankUser user);
	public BankUser getUser(String username, String password);
}
