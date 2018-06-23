package com.revature.dao;

import java.util.List;

import org.hibernate.*;

import com.revature.pojos.User;
import com.revature.utils.HibernateUtil;

public class UserDaoImpl implements UserDao{

	public List<User> getUsers() {
		Session s = HibernateUtil.getSession();
		List<User> users = s.createQuery("from User").list();
		s.close();
		
		return users;
	}

	public User getUserById(int userId) {
		Session s = HibernateUtil.getSession();
		User user = (User) s.get(User.class, userId);
		s.close();
		
		return user;
	}

	public int createUser(User user) {
		Session s = HibernateUtil.getSession();
		Transaction tx = s.beginTransaction();
		int pk = Integer.parseInt(s.save(user).toString());
		tx.commit();
		s.close();
		
		return pk;
	}

	public int updateUser(User user) {
		Session s = HibernateUtil.getSession();
		Transaction tx = s.beginTransaction();
		s.update(user);
		tx.commit();
		s.close();
		
		return 1;
	}

	public int deleteUser(int userId) {
		Session s = HibernateUtil.getSession();
		Transaction tx = s.beginTransaction();
		User user = (User) s.get(User.class, userId);
		if(user != null) {
			s.delete(user);
		}
		tx.commit();
		s.close();
		
		return 1;
	}

}
