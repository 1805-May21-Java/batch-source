package com.revature.controllers;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.revature.intercom.AccountClient;
import com.revature.models.Account;
import com.revature.models.Customer;

@RestController
public class CustomerController {
	
	protected Logger logger = Logger.getLogger(CustomerController.class.getName());
	
	private List<Customer> customers;
	
	@Autowired
	AccountClient accountClient;
	
	public CustomerController() {
		customers = new ArrayList<>();
		customers.add(new Customer(1, "John Smith", "jsmith@gmail.com", null));
		customers.add(new Customer(2, "Harry Cane", "gouk@gmail.com", null));
		customers.add(new Customer(3, "Austin Post", "postM@yahoo.com", null));
		customers.add(new Customer(4, "Aubrey Graham", "drake@scorpion.com", null));
	}
	
	@GetMapping
	public List<Customer> getAll() {
		logger.info("Customer.findAll()");
		return customers;
	}
	
	@GetMapping(value="{customerId}")
	public Customer findByCustomerId(@PathVariable("customerId") int customerId) {
		logger.info("Customer.findByCustomerId()");
		Customer customer = customers.stream().filter(cust -> cust.getCustomerId() == customerId).findFirst().get();
		//here we want to populate our customer's accounts with the information available in the account service
		List<Account> accounts = accountClient.getAccounts(customerId);
		customer.setAccounts(accounts);
		return customer;
		
	}

	

}
