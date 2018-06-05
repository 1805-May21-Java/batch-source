package com.revature.junit;

import static org.junit.Assert.*;

import org.junit.Test;

import com.revature.dao.CustomerDaoImpl;
import com.revature.pojos.Customer;

public class JUnitTest {
	
	CustomerDaoImpl cdi = new CustomerDaoImpl();
	Customer c = new Customer("Tester", "testPass", 200);	
	
	@Test
	public void testGetBalanceByUsername() {
		int test = cdi.getBalanceByUsername(c.getUsername());
		assertEquals(200, test);
	}
	
	@Test
	public void testGetCustomerByUsername() {
		Customer test = cdi.getCustomerByUsername(c.getUsername());
		assertEquals(c, test);
	}
	
	

}
