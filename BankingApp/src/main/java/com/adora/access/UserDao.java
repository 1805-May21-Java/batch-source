package com.adora.access;

import java.util.List;

import com.adora.object.User;

public interface UserDao {
	public List<User> getUsers();
	public List<String> getUserNames();
	public User getUserByCredentials(User user);
	public int createUser(User user);
	public int updateUser(User user);
}
