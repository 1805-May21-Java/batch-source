package com.revature.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.revature.models.BankAccount;
import com.revature.models.BankUser;
import com.revature.util.HibernateUtil;

public class BankAccountDaoImpl implements BankAccountDao {
	@Override
	public int createAccount(BankAccount account) {
		Session s = HibernateUtil.getSession();
		Transaction tx = s.beginTransaction();
		int accountPK = (int) s.save(account);
		tx.commit();
		s.close();
		return accountPK;
	}

	@Override
	public BankAccount getAccount(String username) {
		Session s = HibernateUtil.getSession();
		String hql ="from BankAccount where BANK_USERNAME = :nameVar";
		Query q = s.createQuery(hql);
		q.setString("nameVar", username);
		List<BankAccount> accounts = q.list();
		BankAccount a = null;
		if (!accounts.isEmpty()) {
			a = accounts.get(0);
		}
		return a;
	}

	@Override
	public void updateBalance(BankAccount account) {
		Session s = HibernateUtil.getSession();
		Transaction tx = s.beginTransaction();		
		s.update(account);
		tx.commit();
		s.close();
	}

}
