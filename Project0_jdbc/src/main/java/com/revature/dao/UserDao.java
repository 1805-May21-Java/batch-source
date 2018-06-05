package com.revature.dao;

import java.util.List;

import com.revature.pojos.User;

public interface UserDao
{

	List<User> getUsers();
	User getUserById(String id);
	User getUserByName(String name);
	Boolean isUserNameExist(String newName);
	Boolean isAuthenticated(String newName, String newPassword);
	int rowSize();
	void createUser(User user);
	void updateUser(User user);
	void deleteUserById(String id);
	
}
