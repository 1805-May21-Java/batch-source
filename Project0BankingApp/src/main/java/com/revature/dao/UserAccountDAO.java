package com.revature.dao;

import com.revature.model.UserAccount;

public interface UserAccountDAO {

	public int createUser(UserAccount user);
	public int updateUser(UserAccount user);
	public int deleteUser(int id);
	public String logInCheck(String email, String password);
	public UserAccount getUserByEmail(String email);
	
}
