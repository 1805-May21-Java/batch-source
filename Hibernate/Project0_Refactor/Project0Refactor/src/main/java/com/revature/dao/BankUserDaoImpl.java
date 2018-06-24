package com.revature.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.revature.models.BankUser;
import com.revature.util.HibernateUtil;

public class BankUserDaoImpl implements BankUserDao {

	@Override
	public String createUser(BankUser user) {
		Session s = HibernateUtil.getSession();
		Transaction tx = s.beginTransaction();
		String username = (String) s.save(user);
		tx.commit();
		s.close();
		return username;
	}

	@Override
	public BankUser getUser(String username, String password) {
		Session s = HibernateUtil.getSession();
		String hql ="from BankUser where BANK_USERNAME = :nameVar and USER_PASSWORD = :passwordVar";
		Query q = s.createQuery(hql);
		q.setString("nameVar", username);
		q.setString("passwordVar", password);
		List<BankUser> users = q.list();
		BankUser u = null;
		if (!users.isEmpty()) {
			u = users.get(0);
		}
		return u;
	}

}
