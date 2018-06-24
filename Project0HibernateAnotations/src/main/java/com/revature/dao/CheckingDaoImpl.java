package com.revature.dao;

import java.util.List;
import org.hibernate.*;

import com.revature.pojos.Checking;
import com.revature.pojos.Saving;
import com.revature.pojos.User;
import com.revature.util.HibernateUtil;

public class CheckingDaoImpl implements CheckingDao
{

	public List<Checking> getChecking()
	{
		Session s = HibernateUtil.getSession();
		List<Checking>checkList = s.createQuery("from Checking").list();
		s.close();
		
		return checkList;
	}

	public List<Checking> getCheckingByUserId(int id)
	{
		Session s = HibernateUtil.getSession();
		User user = (User) s.get(User.class, id);
		Query q = s.createQuery("from Checking where userId = :var");
		q.setInteger("var", user.getId());
		List<Checking> checking = q.list();
		return checking;
	}

	public int createChecking(Checking check)
	{
		Session s = HibernateUtil.getSession();
		Transaction tx = s.beginTransaction();
		int pk = Integer.parseInt(s.save(check).toString());
		tx.commit();
		s.close();
		return pk;
	}

	public void updateChecking(Checking check)
	{
		Session s = HibernateUtil.getSession();
		Transaction tx = s.beginTransaction();
		s.update(check);
		tx.commit();
		s.close();
		
	}

	public void deleteChecking(Checking check)
	{
		Session s = HibernateUtil.getSession();
		Transaction tx = s.beginTransaction();
		Checking c = (Checking) s.get(Checking.class, check.getId());
		if(c != null)
		{
			s.delete(c);
		}
		tx.commit();
		s.close();
		
	}
	
}
