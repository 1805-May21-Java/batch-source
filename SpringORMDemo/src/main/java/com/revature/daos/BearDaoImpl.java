package com.revature.daos;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.revature.models.Bear;

@Repository
//@Transactional
public class BearDaoImpl implements BearDao {
	
	@Autowired
	private SessionFactory sf;

	@Transactional(propagation=Propagation.MANDATORY)
	public List<Bear> getBears() {
		Session s = sf.getCurrentSession();
		List<Bear> bears = s.createQuery("from Bear").list();
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
		// TODO Auto-generated method stub
		return null;
	}

	public List<Bear> getSBears() {
		// TODO Auto-generated method stub
		return null;
	}

	public void printCount() {
		// TODO Auto-generated method stub
		
	}

	public List<Bear> findBearByName(String name) {
		// TODO Auto-generated method stub
		return null;
	}

}
