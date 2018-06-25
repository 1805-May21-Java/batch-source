package com.adora.app;

import java.util.List;

import com.adora.access.CustomerDao;
import com.adora.access.CustomerDaoImpl;
import com.adora.object.Customer;

public class HBMDriver {

	public HBMDriver() {
	}
	
	public static void main(String args[]) {
		CustomerDao udi = new CustomerDaoImpl();
		List<Customer> customers = udi.getCustomers();
		System.out.println(customers.toString());
	}

}
