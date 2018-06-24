package com.revature.dao;
import com.revature.util.HibernateUtil;

import java.util.List;
import org.hibernate.*;
import com.revature.pojos.User;

public class UserDaoImpl implements UserDao
{

	public List<User> getUserInfo()
	{
		Session s = HibernateUtil.getSession();
		List<User> userList = s.createQuery("from User").list();
		s.close();
		return userList;
	}

	public User getUserById(int id)
	{
		Session s = HibernateUtil.getSession();
		User user = (User) s.get(User.class, id);
		return user;
	}

	public int createUser(User user)
	{
		Session s = HibernateUtil.getSession();
		Transaction tx = s.beginTransaction();
		int pk = Integer.parseInt(s.save(user).toString());
		tx.commit();
		s.close();
		return pk;
	}

	public void updateUser(User user)
	{
		Session s = HibernateUtil.getSession();
		Transaction tx = s.beginTransaction();
		s.update(user);
		s.close();

	}

	public void deleteUser(User user)
	{
		Session s = HibernateUtil.getSession();
		Transaction tx = s.beginTransaction();
		User u = (User) s.get(User.class, user.getId());
		if(u != null)
		{
			s.delete(u);
		}
		tx.commit();
		s.close();

	}

}
