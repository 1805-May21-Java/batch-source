package com.revature.main;

import java.util.List;

import com.revature.dao.CustomerDao;
import com.revature.dao.CustomerDaoImpl;
import com.revature.pojos.Customer;

public class Driver {
	
	public static void main(String[] args) {
		
		CustomerDao cd = new CustomerDaoImpl();
		List<Customer> customers = cd.getCustomers();
		for(Customer c: customers) {
			System.out.println(c);
		}
		
	}

}
