package com.adora.app;

import java.util.List;

import com.adora.access.UserDaoImpl;
import com.adora.object.User;

public class LoginManager {

	private static UserDaoImpl udi = new UserDaoImpl();
	private static List<String> userNames;
	private static User currentUser;
	
	
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
		
		User user = new User(username, password);
		int success = udi.createUser(user);
		
		if(success == 0) {
			System.out.println("User was not added. Try again later.\n\n");
			return false;
		} else {
			System.out.println("User successfully added. Returning to main menu.\n\n");
			return true;
		}
	}
	
	
	static void login (String username, String password) {
		currentUser = udi.getUserByCredentials(new User(username, password));
	}
	
	static int getCurrentUser() {
		return currentUser.getUserId();
	}
	
	static boolean isLoggedIn() {
		if(currentUser.getUserId() == 0)
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
