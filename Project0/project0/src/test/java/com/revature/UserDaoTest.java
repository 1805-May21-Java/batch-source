package com.revature;

import static org.junit.Assert.*;
import org.junit.BeforeClass;
import org.junit.Test;
import com.revature.dao.UserDaoImpl;
import com.revature.pojos.User;

public class UserDaoTest {
	static UserDaoImpl udi;
	
	@BeforeClass
	public static void setUpBeforeClass() {
		udi = new UserDaoImpl();
		User user = new User("testUser", "testPassword");
		udi.createUser(user);
	}

	@Test
	public void testCreateUser() {
		User user = new User("testUser2", "testPassword2");
		assertEquals(udi.createUser(user), 1);
	}
	
	@Test
	public void testCreateUserThatAlreadyExists() {
		User user = new User("testUser", "testPassword");
		assertEquals(udi.createUser(user), 0);
	}
	
	@Test
	public void testRightCredentials() {
		assertNotNull(udi.getUser("testUser", "testPassword"));
	}

	@Test
	public void testWrongCredentials() {
		assertNull(udi.getUser("testUser", "wrongPassword"));
	}
	
}
