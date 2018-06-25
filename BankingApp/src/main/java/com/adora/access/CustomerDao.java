package com.adora.access;

import java.util.List;

import com.adora.object.Customer;

public interface CustomerDao {
	
	// create
	public int createUser(Customer customer);
	
	// read
	public Customer getUserByCredentials(Customer customer);
	public List<Customer> getCustomers();
	public List<String> getUserNames();
	
	//update
	public int updateUser(Customer customer);
	
}
