package com.revature.dao;

import java.util.List;

import com.revature.models.User;

public interface UserDao
{

	List<User> getUsers();
	User getUserById(int id);
	User getUserByName(String name);
	Boolean isUserNameExist(String newName);
	Boolean isAuthenticated(String newName, String newPassword);
	
	void createUser(User user);
	void updateUser(User user);
	void deleteUserById(int id);
	
}
