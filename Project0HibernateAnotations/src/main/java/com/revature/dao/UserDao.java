package com.revature.dao;

import java.util.List;
import java.util.Map;
import com.revature.pojos.User;

public interface UserDao
{
	public List<User> getUserInfo();
	public User getUserById(int id);
	public int createUser(User user);
	public void updateUser(User user);
	public void deleteUser(User user);
}
