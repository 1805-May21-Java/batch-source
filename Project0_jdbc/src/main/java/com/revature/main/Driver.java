package com.revature.main;

import java.util.ArrayList;
import java.util.List;

import com.revature.dao.UserDaoImpl;
import com.revature.pojos.User;

public class Driver
{

	public Driver()
	{
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args)
	{
		UserDaoImpl imp = new UserDaoImpl();
		List<User> users = new ArrayList<>();
		users = imp.getUsers();
		for(User user: users)
		{
			System.out.println(user.toString());
		}
		User user = imp.getUserById("1");
		System.out.println(user.toString());
		User newUser = new User("4", "LongBn", "password");
		imp.updateUser(newUser);
	}

}
