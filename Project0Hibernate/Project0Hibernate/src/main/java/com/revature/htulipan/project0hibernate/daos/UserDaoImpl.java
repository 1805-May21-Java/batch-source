package com.revature.htulipan.project0hibernate.daos;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.revature.htulipan.project0hibernate.models.BankUser;
import com.revature.htulipan.project0hibernate.util.HibernateUtil;

public class UserDaoImpl implements BankUserDao {

	public boolean userExists(String username) {
		Session s = HibernateUtil.getSession();
		List<BankUser> users = s.createQuery("from BankUser").list();
		System.out.println(users);
		for (BankUser u : users) {
			if (u.getUsername().equals(username)) {
				return true;
			}
		}
		s.close();
		return false;
	}

	public boolean insertUser(BankUser newUser) {
		Session s = HibernateUtil.getSession();
		Transaction tx = null;
		try {
			tx = s.beginTransaction();
			s.save(newUser);
			tx.commit();
		} catch (Exception e) {
			if (tx != null)
				tx.rollback();
			e.printStackTrace();
			return false;
		} finally {
			s.close();
		}
		return true;
	}

	public BankUser getUser(String username) {
		Session s = HibernateUtil.getSession();
		
		String hql = "from BankUser where username = :nameVar";
		Query q = s.createQuery(hql);
		q.setString("nameVar", username);
		
		BankUser user = null;
		List<BankUser> users = new ArrayList<BankUser>();
		try {
			users = q.list();
			if (users.size() == 1) {
				user = users.get(0);
			}
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		} finally {
			s.close();
		}
		
		return user;
	}

}
