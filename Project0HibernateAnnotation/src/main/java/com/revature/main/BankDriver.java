package com.revature.main;

import org.hibernate.Session;

import com.revature.menu.WelcomeMenu;
import com.revature.pojos.Client;
import com.revature.util.HibernateUtil;

public class BankDriver {
	
	//driver class for Tank Bank
	public static void main(String[] args) {
		//brings user to a menu asking if they already have an account
		//this leads the user through the entire menu system

		WelcomeMenu.Existing(new Client());
	}
}