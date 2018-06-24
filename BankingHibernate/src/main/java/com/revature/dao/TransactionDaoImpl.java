package com.revature.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import com.revature.bank.Account;
import com.revature.bank.Transaction;
import com.revature.util.HibernateUtil;

public class TransactionDaoImpl implements TransactionDao {

	@Override
	public List<Transaction> getAllTransactions(Account account) {
		List<Transaction> transactions = new ArrayList<>();
		Session session = HibernateUtil.getSession();
		String hql = "from Transaction where acctName =:nameVar";
		Query q = session.createQuery(hql);
		q.setString("nameVar", account.getUsername());
		transactions = q.list();
		return transactions;
	}

	@Override
	public int addTransaction(Transaction t) {
		
		Session session = HibernateUtil.getSession();
		org.hibernate.Transaction tx = session.beginTransaction();
		int actPk = (int) session.save(t);
		tx.commit();
		session.close();
		return actPk;
	}

}
