package com.revature.dao;



import org.junit.Test;

public class daoInterfaceImplTest {

	@Test
	public void loginExistsTest() {
		DaoInterfaceImpl dImpl = new DaoInterfaceImpl();
		//testing when a username/password combination exists.  Should not return a null object
		assert(!(dImpl.login("Jay", "Feldman")==null));
	}
	
	@Test
	public void correctUsernameIncorrectPassword() {
		DaoInterfaceImpl dImpl = new DaoInterfaceImpl();
		//testing when a username exists, password does not.  Should return a null object
		assert((dImpl.login("Jay", "fiburten")==null));
	}
	
	@Test
	public void incorrectUsernameIncorrectPassword() {
		DaoInterfaceImpl dImpl = new DaoInterfaceImpl();
		//testing when a username does not exist.  Should return null
		assert((dImpl.login("guterstan", "fiburten")==null));
	}
}
