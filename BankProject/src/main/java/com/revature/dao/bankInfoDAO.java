package com.revature.dao;

import java.util.List;

import com.revature.bankpojos.*;

public interface bankInfoDAO
{

	List<User> getUsers();
	User getUserById(String id);
	User getUserByName(String name);
	Boolean doesExist(String newName);
	Boolean doAuthenticate(String newName, String newPassword);
	int size();
	void createUser(User user);
	void updateUser(User user);	
}