package com.revature.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.hibernate.*;

import com.revature.pojos.Saving;
import com.revature.pojos.User;
import com.revature.util.HibernateUtil;

public class SavingDaoImpl implements SavingDao
{

	public List<Saving> getSaving()
	{
		Session s = HibernateUtil.getSession();
		List<Saving> savingList = s.createQuery("from Savings").list();
		s.close();
		return savingList;
	}

	public List<Saving> getSavingsByUserId(int id)
	{
		Session s = HibernateUtil.getSession();
		User user = (User) s.get(User.class, id);
		Query q = s.createQuery("from Savings where userId = :var");
		q.setInteger("var", user.getId());
		List<Saving> savings = q.list();

		s.close();
		
		return savings;
	}

	public int createSaving(Saving save)
	{
		Session s = HibernateUtil.getSession();
		Transaction tx = s.beginTransaction();
		int pk = Integer.parseInt(s.save(save).toString());
		tx.commit();
		s.close();
		
		return pk;
	}

	public void updateSaving(Saving save)
	{
		Session s = HibernateUtil.getSession();
		Transaction tx = s.beginTransaction();
		s.update(save);
		tx.commit();
		s.close();
	
	}

	public void deleteSaving(Saving save)
	{
		Session s = HibernateUtil.getSession();
		Transaction tx = s.beginTransaction();
		Saving sav = (Saving) s.get(Saving.class, save.getId());
		if(sav != null)
		{
			s.delete(sav);
		}
		tx.commit();
		s.close();
	}
	
}
