package com.revature.dao;

import java.util.Map;
import com.revature.pojos.User;

public interface UserDao
{
	public Map<String,User> getUserInfo();
	public User getUserById(int id);
	public int createUser(User user);
	public int updateUser(User user);
	public int deleteUser(User user);
}
