package com.revature.util;

import java.sql.Date;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.revature.dao.BearDao;
import com.revature.dao.BearDaoImpl;
import com.revature.dao.CaveDao;
import com.revature.dao.CaveDaoImpl;
import com.revature.models.Bear;
import com.revature.models.Beehive;
import com.revature.models.Cave;

public class Driver {

	public static void main(String[] args) {
		/*
		Session s = HibernateUtil.getSession();
		
		Cave c1 = new Cave("Mammoth Caves");
		Cave c2 = new Cave("Lurey Caverns");
		Cave c3 = new Cave("Howe Caverns");
		
		Bear b1 = new Bear("Smokey",Date.valueOf("1916-07-04"),c1);
		Bear b2 = new Bear("Boo", Date.valueOf("2000-09-02"), c3);
		Bear b3 = new Bear("Papa", Date.valueOf("1950-09-02"), c2);
		Bear b4 = new Bear("Yogi", Date.valueOf("1960-09-02"), c1);
		
		Beehive bh1 = new Beehive(20);
		Beehive bh2 = new Beehive(35);
		Beehive bh3 = new Beehive(10);
		
		b1.addBeehive(bh1);
		b1.addBeehive(bh2);
		b2.addBeehive(bh1);
		b2.addBeehive(bh3);
		b3.addBeehive(bh2);
		b4.addBeehive(bh3);
		
		Transaction tx = s.beginTransaction();
		
		s.save(bh1);
		s.save(bh2);
		s.save(bh3);
		
		s.save(c1);
		s.save(c2);
		s.save(c3);
		
		s.save(b1);
		s.save(b2);
		s.save(b3);
		s.save(b4);
		
		tx.commit();
		
		s.close();
		*/
		
		CaveDao cd = new CaveDaoImpl();
		BearDao bd = new BearDaoImpl();
		/*
		List<Cave> caves = cd.getCaves();
		for(Cave c: caves) {
			System.out.println(c);
		}
	
		System.out.println(cd.getCaveById(5));
		
		
		Cave newCave = new Cave(8, "Cool New Cave");
		//int pk = cd.createCave(newCave);
		//System.out.println(pk);
		
		newCave.setName("Even cooler even newer cave");
		cd.updateCave(newCave);
		
		
		cd.deleteCaveById(8);
		
		List<Bear> bears = bd.getBears();
		for(Bear b: bears) {
			System.out.println(b);
		}
		
		Cave c = cd.getCaveByName("Mammoth Caves");
		System.out.println(c);
		
		
		System.out.println(bd.getBearsByCave(4));
		
		
		List<Bear> bears = bd.getSBears();
		for(Bear b: bears) {
			System.out.println(b);
		}
		
		bd.printCount();
		
		
		List<Bear> bears = bd.findBearByName("Smokey");
		for(Bear b: bears) {
			System.out.println(b);
		}
		*/
		
		List<Bear> bears = bd.getBears();
		for(Bear b: bears) {
			System.out.println(b);
		}
		System.out.println(bd.getBearById(21));
		System.out.println(bd.createBear(new Bear("Harriet", Date.valueOf("1960-09-02"),null)));
		
		System.out.println("done");

	}

}
