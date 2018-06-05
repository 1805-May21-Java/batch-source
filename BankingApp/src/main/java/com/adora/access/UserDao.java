package com.adora.access;

import java.util.List;

import com.adora.object.User;

public interface UserDao {
	
	// create
	public int createUser(User user);
	
	// read
	public User getUserByCredentials(User user);
	public List<User> getUsers();
	public List<String> getUserNames();
	
	//update
	public int updateUser(User user);
	
}
