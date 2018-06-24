package com.revature.dao;


import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.revature.bank.Account;
import com.revature.util.HibernateUtil;

public class AccountDaoImpl implements AccountDao {

	@Override
	public List<Account> getAllAccounts() {
		List<Account> accounts = new ArrayList<>();
		
		Session session = HibernateUtil.getSession();
		String hql = "from Account";
		Query q = session.createQuery(hql);
		accounts = q.list();
		return accounts;
	}

	@Override
	public Account getAccountById(String uname) {
		Account account = null;
		Session session = HibernateUtil.getSession();
		String hql = "from Account where username=:userVar";
		Query q = session.createQuery(hql);
		q.setString("userVar", uname);
		if(!q.list().isEmpty()) account = (Account) q.list().get(0);
		return account;
	}

	@Override
	public String CreateAccount(Account acct) {
		Session session = HibernateUtil.getSession();
		Transaction tx = session.beginTransaction();
		String actPk = (String) session.save(acct);
		tx.commit();
		session.close();
		return actPk;
	}

	@Override
	public void updateAccount(Account acct) {
		
		Session s = HibernateUtil.getSession();
		Transaction tx = s.beginTransaction();
		s.update(acct);
		tx.commit();
		s.close();
	}

	@Override
	public void deleteAccount(String uname) {
		
		Session s = HibernateUtil.getSession();
		Transaction tx = s.beginTransaction();
		Account acct = (Account) s.get(Account.class, uname);
		if (acct != null) {
			s.delete(acct);
		}
		tx.commit();
		s.close();
	}

}
