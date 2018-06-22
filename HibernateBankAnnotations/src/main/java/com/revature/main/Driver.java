package com.revature.main;

import org.hibernate.Session;

import com.revature.utils.HibernateUtil;

public class Driver {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Session s = HibernateUtil.getSession();
		s.close();
		System.out.println("Done"); 
	}

}
