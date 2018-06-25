package com.adora.app;

import java.util.List;

import com.adora.access.CustomerDao;
import com.adora.access.CustomerDaoImpl;
import com.adora.object.Customer;

public class LoginManager {

	private static CustomerDao udi = new CustomerDaoImpl();
	private static List<String> userNames;
	private static Customer currentUser;
	
	
	static boolean isValidUsername(String username) {
		
		if(username.length() < 5) {
			System.out.println("Username must be at least 5 characters.");
			return false;
		}
		if(username.split(" ").length != 1) {
			System.out.println("The username must not contain spaces.");
			return false;
		}
		if(username.compareTo(username.trim()) != 0) {
			System.out.println("The username must not contain spaces.");
			return false;
		}
		if(getUserNames().contains(username)) {
			System.out.println("That username is already in use.");
			return false;
		}
			
		
		return true;
		
	}
	
	
	static boolean isValidPassword(String password) {
		
		if(password.length() < 8) {
			System.out.println("Password must be at least 8 characters.");
			return false;
		}
		if(password.split(" ").length != 1) {
			System.out.println("Password cannot contain spaces.");
			return false;
		}
		if(password.compareTo(password.trim()) != 0) {
			System.out.println("Password cannot contain spaces.");
			return false;
		}
		
		return true;
	}
	
	
	static boolean addUser(String username, String password) {
		
		Customer customer = new Customer(username, password);
		int success = udi.createUser(customer);
		
		if(success == 0) {
			System.out.println("User was not added. Try again later.\n\n");
			return false;
		} else {
			System.out.println("User successfully added. Returning to main menu.\n\n");
			return true;
		}
	}
	
	
	static void login (String username, String password) {
		currentUser = udi.getUserByCredentials(new Customer(username, password));
	}
	static void logout () {
		currentUser = null;
		userNames = null;
		
		AccountManager.clearAccount();
	}
	static Customer getCurrentUser() {
		return currentUser;
	}
	
	static boolean isLoggedIn() {
		if(currentUser.getCustomerId() == 0)
			return false;
		return true;
	}
	
	
	private static List<String> getUserNames() {
		
		if(userNames == null) {
			userNames = udi.getUserNames();
		}
		return userNames;
	}

}
