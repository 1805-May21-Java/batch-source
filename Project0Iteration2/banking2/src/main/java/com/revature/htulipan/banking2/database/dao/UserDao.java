package com.revature.htulipan.banking2.database.dao;

import com.revature.htulipan.banking2.database.pojos.User;

public interface UserDao {
	
	public boolean userExists(String username);
	public boolean insertUser(User newUser);
	public User getUser(String username);
	public boolean correctPassword(String username, String password);
	
}
