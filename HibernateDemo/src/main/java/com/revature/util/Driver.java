package com.revature.util;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import com.revature.models.Cave;

public class Driver {
	
	public static void main(String[] args) {
		Session s = HibernateUtil.getSession();
		List<Cave> caves = s.getNamedQuery("findCaveByName").setString("nameVar", "Howe Caverns").list();
		for (Cave c : caves) {
			System.out.println(c);
		}
		s.close();
		
	}

}
