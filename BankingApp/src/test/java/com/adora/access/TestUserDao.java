package com.adora.access;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Before;
import org.junit.Test;

import com.adora.access.UserDaoImpl;
import com.adora.object.User;

public class TestUserDao {

	private List<User> userList;
	private List<String> userNameList;
	private UserDaoImpl udi = new UserDaoImpl();
	

	@Test
	public void testCreateUser() {
		int success = udi.createUser(new User("blahblahblah6", "passpass"));
		System.out.println(success);
		assert(success != 0);
	}

	
	@Before 
	public void populateUserLists() {
		userList = udi.getUsers();
		userNameList = udi.getUserNames();
		
	}
	
	@Test
	public void testGetUsers() {
		assert( userList.size() > 0 );
	}
	
	@Test
	public void testUpdateAccount() {
		int updated = 0;
		User user = userList.get(0);
		user.setPassword("testupdatepasswod");
		updated = udi.updateUser(user);
		assertEquals(updated, 1);
	}
	
	@Test
	public void testGetUserNames() {
		assert(userNameList.size() > 0);
	}
	
}
