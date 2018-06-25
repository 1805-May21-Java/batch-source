package com.revature.dao;


import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.revature.models.User;
import com.revature.util.HibernateUtil;

public class UserDaoImpl implements UserDao
{

	public UserDaoImpl()
	{
	
	}

	@Override
	public List<User> getUsers()
	{
		
		List<User> users = new ArrayList<>();
		Session s = HibernateUtil.getSession();
		users = s.createQuery("from USER_TABLE").list();
		s.close();
		return users;

	}

	@Override
	public User getUserById(int id)
	{
		User user = null;
		Session s = HibernateUtil.getSession();
		user = (User) s.get(User.class, id);
		s.close();
		
		return user;
	}

	@Override
	public void createUser(User newUser)
	{
		
		Session s = HibernateUtil.getSession();
		Transaction tx = s.beginTransaction();
		s.save(newUser);
		tx.commit();
		s.close();

	}

	@Override
	public void updateUser(User newUser)
	{
		Session s = HibernateUtil.getSession();
		Transaction tx = s.beginTransaction();
		s.update(newUser);
		tx.commit();
		s.close();
		
	}

	@Override
	public void deleteUserById(int id)
	{
		Session s = HibernateUtil.getSession();
		Transaction tx = s.beginTransaction();
		User user = (User) s.get(User.class, id);
		if(user!=null)
		{
			s.delete(user);
		}


		tx.commit();
		s.close();
		
	}

	@Override
	public User getUserByName(String name) {
		User user = null;
		Session s = HibernateUtil.getSession();
		Query q = s.createSQLQuery("SELECT * FROM USER_TABLE WHERE USER_NAME = ?").addEntity(User.class);
		q.setString(0, name);
		List<User> users = q.list();
		user = users.get(0);
			
		return user;
	}

	@Override
	public Boolean isUserNameExist(String newName) {		
		Session s = HibernateUtil.getSession();
		Query q = s.createSQLQuery("SELECT * FROM USER_TABLE WHERE USER_NAME = ?").addEntity(User.class);
		q.setString(0, newName);
		List<User> users = q.list();
		if(users.size()!=0) return true;
		else return false;
	}

	@Override
	public Boolean isAuthenticated(String newName, String newPassword) {
		
		Session s = HibernateUtil.getSession();
		Query q = s.createSQLQuery("SELECT * FROM USER_TABLE WHERE USER_NAME = ? AND USER_PASSWORD= ? ").addEntity(User.class);
		q.setString(0, newName);
		q.setString(1, newPassword);
		List<User> users = q.list();
		if(users.size()!=0) return true;
		else return false;
	}

	
	
	
}
