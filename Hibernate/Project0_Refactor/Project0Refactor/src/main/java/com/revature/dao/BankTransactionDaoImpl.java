package com.revature.dao;

import java.util.ArrayList;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.revature.models.BankTransaction;
import com.revature.util.HibernateUtil;

public class BankTransactionDaoImpl implements BankTransactionDao {

	@Override
	public int createTransaction(BankTransaction transaction) {
		Session s = HibernateUtil.getSession();
		Transaction tx = s.beginTransaction();
		int transactionPK = (int) s.save(transaction);
		tx.commit();
		s.close();
		return transactionPK;
	}

	@Override
	public ArrayList<BankTransaction> getTransactions(String username) {
		Session s = HibernateUtil.getSession();
		String hql ="from BankTransaction where BANK_USERNAME = :nameVar order by TRANSACTION_ID desc";
		Query q = s.createQuery(hql);
		q.setString("nameVar", username);
		ArrayList<BankTransaction> transcations = (ArrayList<BankTransaction>) q.list();
		return transcations;
	}

}
