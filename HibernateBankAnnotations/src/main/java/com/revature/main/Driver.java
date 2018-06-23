package com.revature.main;

import org.hibernate.Session;

import com.revature.actors.Teller;
import com.revature.utils.HibernateUtil;

public class Driver {	
	public static void main(String[] args) {
		Session s = HibernateUtil.getSession();
		s.close();
		Teller myTeller = new Teller();
		myTeller.open();
	}

}
