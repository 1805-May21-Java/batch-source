package com.revature.bankingapp;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.revature.dao.AccountDaoImpl;
import com.revature.util.ConnectionUtil;

public class Driver {
	
	private static Scanner sc = new Scanner(System.in);
	private static Account session;
	private static ArrayList<Account> accounts;

	public static void main(String[] args) {
		
		try {
			Connection con = ConnectionUtil.getHardcodedConnection();
			//System.out.println(con.getMetaData().getDriverName());
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
		AccountDaoImpl adi = new AccountDaoImpl();
		
		Account acc = new Account("Rachel25", "password123");
		adi.createAccount(acc);
		
		List<Account> allAccounts = adi.getAccounts();
		for (Account a : allAccounts) {
			System.out.println(a);
		}
		
//		accounts = new ArrayList<Account>();
//		
//		// TODO: get data from database
//		// Read in data file with account info
//		String path = "src/com/revature/bankingapp/data.txt";
//		
//		BufferedReader br;
//		try {
//			br = new BufferedReader(new FileReader(path));
//			String line = br.readLine();
//			
//			// read data file
//			while (line != null) {
//				String[] arr = line.split(":"); // split lines on colon
//				Account user = new Account(arr[0], arr[1], Double.parseDouble(arr[2]));
//				accounts.add(user);
//				line = br.readLine();
//			}
//			br.close();
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
//
//		mainPage(); // start bank program
		
	}
	
	// Welcome screen
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
				Account account = new Account(username, password, 0.00); // set initial balance to zero
				session = account;
				accounts.add(account); // add new account to system
				
				// write new user data to text file
				String path = "src/com/revature/bankingapp/data.txt";
				BufferedWriter bw;
				try {
					bw = new BufferedWriter(new FileWriter(path, true));
					bw.write(username + ":" + password + ":0.00");
					bw.newLine();
					bw.flush();
					bw.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
				
				System.out.println("New account " + username + " created!");
				System.out.println("Logging you in...");
				System.out.println();
				dashboardPage(); // log in automatically
			}
		}
		
	}
	
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
		System.out.println();
		String input = sc.nextLine().toLowerCase(); // not case sensitive
		
		switch (input) {
		case "deposit":
			System.out.print("Enter deposit amount: ");
			System.out.println();
			double amount = Double.parseDouble(sc.nextLine());
			session.setBalance(session.getBalance() + amount); // add deposit amount to balance
			editValue(); // write value to file
			System.out.println("Transaction was successful!");
			System.out.println();
			dashboardMenu();
			break;
		case "withdraw":
			System.out.print("Enter withdrawal amount: ");
			System.out.println();
			double withdrawal = Double.parseDouble(sc.nextLine());
			if (withdrawal > session.getBalance()) { // check that amount being withdrawn isn't greater than the available balance
				System.out.println("ERROR: You don't have enough funds! Try again.");
				System.out.println();
			} else {
				session.setBalance(session.getBalance() - withdrawal); // subtract amount from balance
				editValue(); // write new value to file
				System.out.println("Transaction was successful!");
				System.out.println();
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
	
	// replace old balance value with new
	public static void editValue() {
		String path = "src/com/revature/bankingapp/data.txt";
		BufferedWriter bw;
		try {
			bw = new BufferedWriter(new FileWriter(path));

			// write all accounts into data file
			// this action clears the file before writing
			for (Account acc : accounts) {
				bw.write(acc.getUsername() + ":" + acc.getPassword() + ":" + acc.getBalance());
				bw.newLine();
			}
			bw.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
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
