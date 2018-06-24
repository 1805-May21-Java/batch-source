package com.revature.dao;

import java.util.List;

import com.revature.pojos.Customer;

public interface CustomerDao {
	
	public List<Customer> getCustomers();
	public Customer getCustomerByUsername(String username);
	public int createCustomer(Customer customer);
	public int getBalanceByUsername(String username);
	public void changeBalance(Customer customer);

}
