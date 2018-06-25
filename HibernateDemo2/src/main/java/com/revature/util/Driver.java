package com.revature.util;

import java.sql.Date;

import org.hibernate.Session;

import com.revature.models.*;

public class Driver {

	public static void main(String[] args) {
		Session session = HibernateUtil.getSession();
		
		Cave c1 = new Cave("Mammoth Caves");
		Cave c2 = new Cave("Lurey Caverns");
		Cave c3 = new Cave("Howe Caverns");
		
		Bear b1 = Bear("Smokey", Date.valueOf("1916-07-04"), c1);
		Bear b2 = Bear("Boo", Date.valueOf(""), c3);
		Bear b3 = Bear("Papa", Date.valueOf(""), c2);
		Bear b4 = Bear("Yogi", Date.valueOf(""), c1);

	}

}
