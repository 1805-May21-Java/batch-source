package com.Revature.util;

import org.hibernate.Session;

public class Driver {

	public static void main(String[] args) throws Exception {
		Session s = HibernateUtil.getSession();
		s.close();
	}

}
