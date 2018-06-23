package com.revature.dao;

import java.util.Date;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.*;


import com.revature.utils.HibernateUtil;

public class TransactionDaoImpl implements TransactionDao{

	public List<com.revature.pojos.Transaction> getTransactions() {
		Session s = HibernateUtil.getSession();
		List<com.revature.pojos.Transaction> transactions = s.createQuery("from Transaction").list();
		s.close();
		
		return transactions;
	}

	public List<com.revature.pojos.Transaction> getAccountTransactions(long acctNumber) {
		Session s = HibernateUtil.getSession();
		Query q = s.createQuery("from Transaction where associatedAccount = :acctVar");
		q.setLong("acctVar", acctNumber);
		List<com.revature.pojos.Transaction> transactions = q.list();
		s.close();
		
		return transactions;
	}

	public List<com.revature.pojos.Transaction> getAccountTransactions(long acctNumber, int max) {
		Session s = HibernateUtil.getSession();
		Query q = s.createQuery("from Transaction where associatedAccount = :acctVar");
		q.setLong("acctVar", acctNumber);
		List<com.revature.pojos.Transaction> transactions = q.list();
		if(transactions.size() <= max) {
			return transactions;
		}
		List<com.revature.pojos.Transaction> reducedList = new ArrayList<com.revature.pojos.Transaction>();
		for(int i = 0; i < max; i++) {
			reducedList.add(transactions.get(i));
		}
		s.close();
		
		return reducedList;
	}

	public int createTransaction(com.revature.pojos.Transaction action) {
		Session s = HibernateUtil.getSession();
		Transaction tx = s.beginTransaction();
		action.setTransactionDate(new Date());
		s.save(action);
		tx.commit();
		s.close();
		
		return 0;
	}

}
