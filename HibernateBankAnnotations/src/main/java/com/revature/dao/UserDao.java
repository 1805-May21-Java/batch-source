package com.revature.dao;

import java.util.List;

import com.revature.pojos.User;

public interface UserDao {
	public List<User> getUsers ();
	public User getUserById(int userId);
	public int createUser(User user);
	public int updateUser(User user);
	public int deleteUser(int userId);
}
