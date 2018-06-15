package com.revature.main;
import com.revature.pojos.User;
import com.revature.pojos.Role;
import com.revature.dao.FullDAOImpl;
public class Main {
	public static void main(String[] args) {
		FullDAOImpl fdi = new FullDAOImpl();
		System.out.println(fdi.listEmployees());
	}
}
