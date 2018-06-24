package com.revature.dao;

import java.io.*;
import java.sql.*;
import java.util.*;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.revature.pojos.Customer;
import com.revature.util.HibernateUtil;

public class CustomerDaoImpl implements CustomerDao{
	
	public List<Customer> getCustomers() {
		Session s = HibernateUtil.getSession();
		String hql = "from Customer";
		Query q = s.createQuery(hql);
		List <Customer> customers = q.list();
		s.close();
		return customers;
	}
	public Customer getCustomerByUsername(String username) {
		Session s = HibernateUtil.getSession();
		Customer c = (Customer) s.get(Customer.class, username);
		s.close();
		return c;

	}
	public int createCustomer(Customer customer) {
		Session s = HibernateUtil.getSession();
		Transaction tx = s.beginTransaction();
		int customerPK = Integer.parseInt(s.save(customer).toString());
		tx.commit();
		s.close();
		return customerPK;
	}
	public void changeBalance(Customer customer) {
		Session s = HibernateUtil.getSession();
		Transaction tx = s.beginTransaction();
		s.update(customer);
		tx.commit();
		s.close();		
	}
	public int getBalanceByUsername(String username) {
		Session s = HibernateUtil.getSession();
		Customer c = (Customer) s.get(Customer.class, username);
		return c.getBalance();
	}

}