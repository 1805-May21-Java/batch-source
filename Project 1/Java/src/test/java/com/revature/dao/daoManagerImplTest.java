package com.revature.dao;

import static org.junit.Assert.*;

import java.sql.SQLException;
import java.util.logging.Logger;

import com.revature.pojos.Manager;

import org.junit.Test;

public class daoManagerImplTest {
	static daoManagerImpl dImplM = new daoManagerImpl();

	@Test
	public void saveNewManager() {
		int id = dImplM.insertNewManager(new Manager("Bob","hi@gmail.com","password"));
		assertEquals(dImplM.getManagerById(id).getName(), "Bob");
	}
	@Test
	public void updateOldManager() {
		 Manager manager = dImplM.getManagerById(1);
		 manager.setName("NewName");
		 dImplM.updateOldManager(manager);
		assertEquals(dImplM.getManagerById(1).getName(), "NewName");
		manager.setName("Holly");
		dImplM.updateOldManager(manager);
	}
	
	@Test(expected = SQLException.class)
	public void saveNewManagerNoName() {
		dImplM.insertNewManager(new Manager(null,"hi@gmail.com","password"));
	}
	
	@Test(expected = SQLException.class)
	public void saveNewManagerNoEmail() {
		dImplM.insertNewManager(new Manager("Bob",null,"password"));
	}
	
	@Test (expected = SQLException.class)
	public void saveNewManagerNoPassword() {
		dImplM.insertNewManager(new Manager("Bob","password",null));
	}
	
	@Test
	public void getManagerExistingId() {
		//known manager
		Manager manager = dImplM.getManagerById(1);
		System.out.println(manager.getName());
		assertEquals(manager.getName(),"Holly");
		}
	
	@Test(expected = NullPointerException.class)
	public void getManagerNoId() {
		dImplM.getManagerById(0);
	}
	@Test
	public void loginCorrectCredentials() {
		Manager manager = dImplM.managerLogin("query@java.com", "password");
		assertEquals(manager.getName(),"Holly");
	}
	@Test (expected = NullPointerException.class)
	public void loginBadEmail() {
		dImplM.managerLogin("nope", "password");
	}
	@Test (expected = NullPointerException.class)
	public void loginGoodUsernameBadPassword() {
		dImplM.managerLogin("query@java.com", "notAPassword");
	}
	@Test (expected = NullPointerException.class)
	public void deleteManagerExistingId() {
		Manager manager = new Manager("Hi","dummy","pass");
		int id = dImplM.insertNewManager(manager);
		dImplM.deleteManagerById(id);
		//Shouldn't work because manager shouldn't exist, get a null pointer exception
		dImplM.getManagerById(id);
	}
	@Test
	public void deleteManagerNonexistentId() {
		assertEquals(false,dImplM.deleteManagerById(-5));
	}
}
