package com.revature.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;

import com.revature.models.Bear;
import com.revature.util.HibernateUtil;

public class BearDaoImpl implements BearDao {

	public List<Bear> getBears() {
		Session s = HibernateUtil.getSession();
		List<Bear> bears = s.createQuery("from Bear").list();
		s.close();
		return bears;
	}

	public Bear getBearById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	public int createBear(Bear b) {
		// TODO Auto-generated method stub
		return 0;
	}

	public void updateBear(Bear b) {
		// TODO Auto-generated method stub
		
	}

	
	public void deleteBear(Bear b) {
		// TODO Auto-generated method stub
		
	}

	
	public List<Bear> getBearsByCave(int caveId) {
		Session s = HibernateUtil.getSession();
		Query q = s.getNamedQuery("findBearByCave");
		q.setInteger("caveVar", caveId);
		List<Bear> bears = q.list();
		return bears;
	}
	
	public List<Bear> getSBears() {
		Session s = HibernateUtil.getSession();
		Criteria c = s.createCriteria(Bear.class);
		c.add(Restrictions.like("name", "S%"));
		c.addOrder(Order.asc("name"));
		c.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
		List<Bear> sBears = c.list();
		s.close();
		return sBears;
	}

	
	public void printCount() {
		Session s = HibernateUtil.getSession();
		Criteria c = s.createCriteria(Bear.class);
		c.setProjection(Projections.rowCount());
		List rows = c.list();
		System.out.println(rows.get(0));
		s.close();	
	}

	
	public List<Bear> findBearByName(String name) {
		Session s = HibernateUtil.getSession();
		Query q = s.createSQLQuery("SELECT * FROM BEAR WHERE BEAR_NAME = ?").addEntity(Bear.class);
		q.setString(0, name);
		List<Bear> bears = q.list();
		return bears;
	}
	
	
	
	
	
	

}