package com.revature.htulipan.project0hibernate.daos;

import com.revature.htulipan.project0hibernate.models.BankUser;

public interface BankUserDao {
	
	public boolean userExists(String username);
	public boolean insertUser(BankUser newUser);
	public BankUser getUser(String username);
	
}
