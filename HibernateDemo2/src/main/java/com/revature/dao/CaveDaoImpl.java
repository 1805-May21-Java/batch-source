package com.revature.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.revature.models.Cave;
import com.revature.util.HibernateUtil;

public class CaveDaoImpl implements CaveDao{

	@Override
	public List<Cave> getCaves() {
		Session s = HibernateUtil.getSession();
		String hql = "from Cave";
		Query q = s.createQuery(hql);
		List<Cave> caves = q.list();
		return caves;
	}

	@Override
	public Cave getCaveById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int createCave(Cave c) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void updatedCave(Cave c) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteCaveById(int id) {
		Session s = HibernateUtil.getSession();
		Transaction tx = s.beginTransaction();
		Cave c = (Cave) s.get(Cave.class, id);
		if(c != null) {
			s.delete(c);//if we use load, c wouldn't be null(an exception would have been thrown instead)
		}
		tx.commit();
		s.close();
		
	}

}
