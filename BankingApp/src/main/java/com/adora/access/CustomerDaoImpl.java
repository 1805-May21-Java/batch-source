package com.adora.access;



import java.util.List;


import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.adora.object.Customer;
import com.adora.util.HibernateUtil;

public class CustomerDaoImpl implements CustomerDao {

	
	
	@Override
	public List<Customer> getCustomers() {
		Session session = HibernateUtil.getSession();
		List<Customer> customers = session.createQuery("from Customer").list();
		session.close();
		return customers;
	}
	
	@Override
	public List<String> getUserNames() {
		Session session = HibernateUtil.getSession();
		List<String> userNames = session.createQuery("select C.customerName from Customer C").list();
		session.close();
		return userNames;
	}
	
	@Override
	public Customer getUserByCredentials( Customer customer) {
		Customer verfiedUser = new Customer();
		
		Session session = HibernateUtil.getSession();
		String hql = "from Customer where customer_name= :custName and customer_pass = :custPass";
		Query query = session.createQuery(hql);
		query.setParameter("custName", customer.getCustomerName());
		query.setParameter("custPass", customer.getPassword());
		List<Customer> customers = query.list();
		session.close();
		
		if(customers.size() > 0 ) {
			verfiedUser = customers.get(0);
		}
		
		return verfiedUser;
	}

	@Override
	public int createUser(Customer customer) {
		int userCreated = 0;
		
		Session session = HibernateUtil.getSession();
		Transaction tx = session.beginTransaction();
		userCreated = (Integer) session.save(customer);
		tx.commit();
		System.out.println(userCreated);
		session.close();
		
		return userCreated;
	}

	@Override
	public int updateUser(Customer customer) {
		int userUpdated = 1;
		Session session = HibernateUtil.getSession();
		Transaction tx = session.getTransaction();
		session.update(customer);
		tx.commit();
		session.close();
		return userUpdated;
	}

}
