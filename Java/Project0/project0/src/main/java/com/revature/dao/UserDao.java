package com.revature.dao;

import com.revature.pojos.User;

public interface UserDao {
	public int createUser(User user);
	public User getUser(String username, String password);
}
