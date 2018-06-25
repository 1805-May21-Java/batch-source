package com.adora.access;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Before;
import org.junit.Test;

import com.adora.access.CustomerDaoImpl;
import com.adora.object.Customer;

public class TestUserDao {

	private List<Customer> userList;
	private List<String> userNameList;
	private CustomerDaoImpl udi = new CustomerDaoImpl();
	

	@Test
	public void testCreateUser() {
		int success = udi.createUser(new Customer("blahblahblah6", "passpass"));
		System.out.println(success);
		assert(success != 0);
	}

	
	@Before 
	public void populateUserLists() {
		userList = udi.getCustomers();
		userNameList = udi.getUserNames();
		
	}
	
	@Test
	public void testGetUsers() {
		assert( userList.size() > 0 );
	}
	
	@Test
	public void testUpdateAccount() {
		int updated = 0;
		Customer customer = userList.get(0);
		customer.setPassword("testupdatepasswod");
		updated = udi.updateUser(customer);
		assertEquals(updated, 1);
	}
	
	@Test
	public void testGetUserNames() {
		assert(userNameList.size() > 0);
	}
	
}
