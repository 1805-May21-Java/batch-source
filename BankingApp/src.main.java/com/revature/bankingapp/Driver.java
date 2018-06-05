package com.revature.bankingapp;

import java.util.List;
import java.util.Scanner;

import com.revature.dao.AccountDaoImpl;

public class Driver {
	
	private static Scanner sc = new Scanner(System.in);
	private static Account session;
	private static List<Account> accounts;
	private static AccountDaoImpl adi;

	public static void main(String[] args) {
		
		adi = new AccountDaoImpl(); 
		
		accounts = adi.getAccounts(); // pull persisted data from database
		
		//adi.deleteAccountById(2);
		
		mainPage(); // start bank program
		
	}
	
	/*
	 * 
	 * MAIN PAGE
	 * 
	 */
	public static void mainPage() {
		System.out.println("*******************************");
		System.out.println("*                             *");
		System.out.println("*  Welcome to Revature Bank!  *");
		System.out.println("*                             *");
		System.out.println("*******************************");
		System.out.println();
		
		loginMenu(); // call up navigation
	}
	
	// Displays the navigation options on the main page
	public static void loginMenu() {
		// navigation menu
		System.out.println("Navigate using the following commands:");
		System.out.println();
		System.out.println("      Enter \"login\" to login.");
		System.out.println("      Enter \"new\" to create a new account.");
		System.out.println("      Enter \"exit\" to end the program.");
		System.out.println();
		
		// Get user input
		System.out.print("Select an option: ");
		String input = sc.nextLine().toLowerCase(); // not case sensitive
		System.out.println();
		if (input.equals("login")) {
			loginPage(); // log in
		} else if (input.equals("new")) {
			System.out.println("Creating new account...");
			System.out.println();
			newUserPage(); // create new user
		} else if (input.equals("exit")) {
			System.out.println("Goodbye!"); // quit program
		} else {
			System.out.println("ERROR: Input was not valid. Try again.");
			System.out.println();
			loginMenu(); // refresh menu when invalid input is entered
		}
	}
	
	/*
	 * 
	 * LOGIN PAGE
	 * 
	 */
	public static void loginPage() {
		System.out.println("****************");
		System.out.println("*              *");
		System.out.println("*  User Login  *");
		System.out.println("*              *");
		System.out.println("****************");
		System.out.println();
		loginForm();
	}
	
	public static void loginForm() {
		// get username and password from user
		System.out.println("All fields are case sensitive.\n");
		System.out.print("      Enter username (or \"cancel\" to return to main page): ");
		String username = sc.nextLine(); // case sensitive
		System.out.println();
		
		if (username.equals("cancel")) {
			mainPage(); // return to main page
		} else if (listContains(username)){ // check if user exists in system
			System.out.print("      Enter password (or \"cancel\" to return to main page): ");
			String password = sc.nextLine(); // case sensitive
			System.out.println();
			
			if (password.equals("cancel")) {
				mainPage(); // return to main page
			} else if (password.equals(session.getPassword())) {
				System.out.println("Logging you in...");
				System.out.println();
				dashboardPage(); // log in
			} else { // password is invalid
				System.out.println("ERROR: Invalid username/password combo. Try again.");
				System.out.println();
				loginForm();
			}
		} else {
			System.out.println("ERROR: User does not exist. Try again.");
			System.out.println();
			loginForm();
		}
	}
	
	/*
	 * 
	 * NEW USER PAGE
	 * 
	 */
	public static void newUserPage() {
		System.out.println("*********************");
		System.out.println("*                   *");
		System.out.println("*  Create New User  *");
		System.out.println("*                   *");
		System.out.println("*********************");
		System.out.println();
		newUserForm();
	}
	
	public static void newUserForm() {
		// get username and password from user
		System.out.println("All fields are case sensitive.\n");
		System.out.print("      Enter a username (or \"cancel\" to return to main page): ");
		String username = sc.nextLine(); // case sensitive
		System.out.println();
				
		if (username.equals("cancel")) {
			mainPage(); // return to main page
		} else if (listContains(username)){ // check if user already exists in system
			session = null;
			System.out.println("ERROR: User \"" + username + "\" already exists. Try a different username.");
			System.out.println();
			newUserForm();
		} else { // username is unique
			System.out.print("      Enter password (or \"cancel\" to return to main page): ");
			String password = sc.nextLine(); // case sensitive
			System.out.println();
			
			if (password.equals("cancel")) {
				mainPage(); // return to main page
			} else {
				Account account = new Account(username, password, 0.0); // set initial balance to zero
				session = account;
				accounts.add(account); // add new account to system
				
				adi.createAccount(account); // insert new account into database
				
				System.out.println("New account " + username + " created!");
				System.out.println("Logging you in...");
				System.out.println();
				dashboardPage(); // log in automatically
			}
		}
		
	}
	
	/*
	 * 
	 * DASHBOARD PAGE
	 * 
	 */
	public static void dashboardPage() {
		System.out.println("***************");
		System.out.println("*             *");
		System.out.println("*  Dashboard  *");
		System.out.println("*             *");
		System.out.println("***************");
		System.out.println();
		dashboardMenu();
	}
	
	// displays navigation option on dashboard page
	public static void dashboardMenu() {
		// navigation menu
		System.out.println("Navigate using the following commands:");
		System.out.println();
		System.out.println("      Enter \"deposit\" to deposit funds.");
		System.out.println("      Enter \"withdraw\" to withdraw funds.");
		System.out.println("      Enter \"balance\" to check current balance.");
		System.out.println("      Enter \"logout\" to return to login screen.");
		System.out.println();
		
		// get user input
		System.out.print("Select an option: ");
		String input = sc.nextLine().toLowerCase(); // not case sensitive
		
		switch (input) {
		case "deposit":
			
			double amount = 0;
			while (true) {
				System.out.print("Enter deposit amount: ");
				try {
					amount = Double.parseDouble(sc.nextLine());
					if (isValidInput(amount)) {
						session.setBalance(session.getBalance() + amount); // add deposit to session account
						adi.updateAccount(session); // update account in database after deposit
						System.out.println("Transaction was successful!");
						System.out.println();
					} 
					break;
				} catch (NumberFormatException e) {
					System.out.println("ERROR: Input was not a valid number. Try again.");
					System.out.println();
				} 
			}
			dashboardMenu();
			break;
		case "withdraw":
			
			double withdrawal = 0; 
			while (true) {
				System.out.print("Enter withdrawal amount: ");
				try {
					withdrawal = Double.parseDouble(sc.nextLine());
					if (isValidInput(withdrawal)) {
						if (withdrawal > session.getBalance()) { // check that amount being withdrawn isn't greater than the available balance
							System.out.println("ERROR: You don't have enough funds! Try again.");
							System.out.println();
						} else {
							session.setBalance(session.getBalance() - withdrawal); // subtract amount from balance
							
							adi.updateAccount(session); // update account in database after withdrawal
							
							System.out.println("Transaction was successful!");
							System.out.println();
						}
					}
					break;
				} catch (NumberFormatException e) {
					System.out.println("ERROR: Input was not a valid number. Try again.");
					System.out.println();
				} 
			}
			dashboardMenu();
			break;
		case "balance":
			System.out.println("Current balance is $" + String.format("%,.2f", session.getBalance()));
			System.out.println();
			dashboardMenu(); // always refresh menu
			break;
		case "logout":
			System.out.println("Logging you out...");
			System.out.println();
			session = null;
			mainPage();
			break;
		default:
			System.out.println("ERROR: Input was not valid. Try again.");
			System.out.println();
			dashboardMenu();
			break;
		}
	}
	
	// performs various checks on deposits/withdrawals to determine if they are valid
	public static boolean isValidInput(double input) {
		if (input > Integer.MAX_VALUE) {
			System.out.println("ERROR: Amount is too large a number. Try again.");
			System.out.println();
			return false;
		}
		
		if (input < 0.01) {
			System.out.println("ERROR: Invalid amount. Try again.");
			System.out.println();
			return false;
		}

		return true;
	}
	
	public static boolean listContains(String username) {
		// iterate thru user accounts
		for (Account account : accounts) {
			if (account.getUsername().equals(username)) {
				session = account; // set current session user
				return true;
			}
		}
		return false;
	}
	

}
