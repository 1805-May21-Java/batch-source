package com.revature.menus;

import java.util.List;

import com.revature.actors.Teller;
import com.revature.dao.UserDaoImpl;
import com.revature.exceptions.NoSuchOptionException;
import com.revature.pojos.User;
import com.revature.utils.*;

public class LoginMenu implements Menu{
	// Used to get list of users
	private UserDaoImpl udi;
	// Used to get input from a singleton scanner
	private BankScanner scan;	
	// access to object who instantiated this menu;
	private Teller myTeller;
	
	public LoginMenu(Teller myTeller) {
		super();
		this.udi = new UserDaoImpl();
		this.scan = BankScanner.getInstance();
		this.myTeller = myTeller;
	}
	public boolean navigate() {
		boolean finishedWithMenu = false;
		do {
			System.out.println("Would you like to login or create a new user account?\n"
							 + "    (1)Login\n"
							 + "    (2)Create New User\n"
							 + "Enter 1, or 2. Enter 0 to exit.");
			String option = this.scan.next();
			try {
				switch(Integer.parseInt(option)) {
				case 0: 
					return false;
				case 1:
					finishedWithMenu = login();
					break;
				case 2:
					finishedWithMenu = createUser();
					break;
				default:
					throw new NoSuchOptionException();
				}
			} catch (NumberFormatException e) {
				// If the string can't parse into an integer, this is displayed
				System.out.println("Sorry, we couldn't read that. Please try again.\n");
			} catch (NoSuchOptionException e) {
				// If the user inputs an invalid option, this is displayed 
				System.out.println("Sorry, that wasn't an option. Please try again.\n");
			}
		} while (!finishedWithMenu);
		return true;
	}
	
	private boolean login() {
		List<User> myUsers = this.udi.getUsers();
		if(myUsers.isEmpty()) {
			System.out.println("Sorry we're new, there aren't any accounts here.\n"
							 + "Please make a new one.\n");
			return createUser();
		}
		
		String username;
		String password;
		
		boolean match = false;
		do {
			System.out.println("Enter your username or email: ");
			do {
				username = this.scan.next().toUpperCase();
			} while (username.isEmpty());
			System.out.println("Enter your password: ");
			password = this.scan.next();
			for(User u: myUsers) {
				if((username.equals(u.getUsername()) || username.equals(u.getEmail())) && password.equals(u.getPassword())) {
					match = true;
					this.myTeller.setCurrentUsersId(u.getUserId());
					break;
				}
			}
			
			if(!match) {
				boolean answer = GeneralConfirmation.check("Username or password didn't match. Do you want to try again?");
				if(answer == false) {
					return false;
				}
			}
		} while(!match);
		return true;
	}
	
	private boolean createUser() {
		List<User> myUsers = this.udi.getUsers();
		String email;
		String username;
		String password;
		String passwordConfirmation;
		
		boolean associated;
		do {
			System.out.println("Please enter your email: ");
			email = this.scan.next();
			associated = false;
			if(myUsers.isEmpty()) {
				break;
			}
			
			for(User u : myUsers) {
				if(email.contains(" ")) {
					System.out.println("Sorry, an email shouldn't have a space in it.");
					associated = true;
					boolean cont = GeneralConfirmation.check("Would you like to try another email?");
					if(cont == false) {
						return false;
					}
					break;
				}
				
				if(email.toUpperCase().equals(u.getEmail())) {
					System.out.println("Sorry, that email is already asscoiated with an account");
					associated = true;
					boolean cont = GeneralConfirmation.check("Would you like to try another email?");
					if(cont == false) {
						return false;
					}
					break;
				}
			}
		} while(associated);
		
		boolean used;
		do {
			System.out.println("Please enter a username: ");
			username = this.scan.next();
			used = false;
			if(myUsers.isEmpty()) {
				break;
			}
			
			for(User u : myUsers) {
				if(username.contains(" ")) {
					System.out.println("Sorry, a username shouldn't have a space in it.");
					used = true;
					boolean cont = GeneralConfirmation.check("Would you like to try another username?");
					if(cont == false) {
						return false;
					}
					break;
				}
				if(username.toUpperCase().equals(u.getUsername())) {
					System.out.println("Sorry that username is taken.");
					used = true;
					boolean cont = GeneralConfirmation.check("Would you like to try a different one?");
					if(cont == false) {
						return false;
					}
					break;
				}
			}
		} while (used);
		
		boolean validPassword = false;
		do {
			System.out.println("Please enter a password: ");
			password = this.scan.next();
			if(password.contains(" ")) {
				System.out.println("Sorry, a password shouldn't contain spaces.");
				boolean cont = GeneralConfirmation.check("Would you like to try another password?");
				if(cont == false) {
					return false;
				}
				continue;
			}
			
			System.out.println("Confirm your password: ");
			passwordConfirmation = this.scan.next();
			
			if(passwordConfirmation.equals(password)) {
				validPassword = true;
			} else {
				System.out.println("Confirmation didn't match.");
				boolean cont = GeneralConfirmation.check("Would you like to try again?");
				if(cont == false) {
					return false;
				}
				validPassword = false;
			}
		} while (!validPassword);
		
		
		this.udi.createUser(new User(username.toUpperCase(), email.toUpperCase(), password));
		myUsers = this.udi.getUsers();
		for(User u : myUsers) {
			if(username.toUpperCase().equals(u.getUsername())) {
				this.myTeller.setCurrentUsersId(u.getUserId());
				break;
			}
		}
		return true;
	}
}
