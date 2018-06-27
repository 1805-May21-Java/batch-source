package com.revature.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.revature.models.Bear;
import com.revature.util.HibernateUtil;

@Repository
public class BearDaoImpl implements BearDao {

	@Override
	public List<Bear> getBears() {
		Session s = HibernateUtil.getSession();
		List<Bear> bears = s.createQuery("from Bear").list();
		s.close();
		return bears;
	}

	@Override
	public Bear getBearById(int id) {
		Session s = HibernateUtil.getSession();
		Bear b = (Bear) s.get(Bear.class, id);
		s.close();
		return b;
	}

	@Override
	public int createBear(Bear b) {
		Session s = HibernateUtil.getSession();
		Transaction tx = s.beginTransaction();
		s.save(b);
		tx.commit();
		s.close();
		return 0;
	}

	@Override
	public void updateBear(Bear b) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteBear(Bear b) {
		// TODO Auto-generated method stub
		
	}

	@Override
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

	@Override
	public void printCount() {
		Session s = HibernateUtil.getSession();
		Criteria c = s.createCriteria(Bear.class);
		c.setProjection(Projections.rowCount());
		List rows = c.list();
		System.out.println(rows.get(0));
		s.close();	
	}

	@Override
	public List<Bear> findBearByName(String name) {
		Session s = HibernateUtil.getSession();
		Query q = s.createSQLQuery("SELECT * FROM BEAR WHERE BEAR_NAME = ?").addEntity(Bear.class);
		q.setString(0, name);
		List<Bear> bears = q.list();
		return bears;
	}
	
	
	
	
	
	

}
