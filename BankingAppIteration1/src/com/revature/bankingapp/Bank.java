package com.revature.bankingapp;

import java.util.*;
import java.io.*;

import com.revature.exceptions.NegativeNumberException;

/*
 * 
 * TODO: 	See if there is a better way to protect the account class without extending Account.
 * 			If that's possible I could Implement a Teller class that would contain all the 
 * 			functionality that Bank currently has, and making this more abstract and leaving Bank 
 * 			as a serialized container. That Teller class will have access to protected functions 
 * 			of both Bank and Account
 * 
 */
public class Bank extends Account implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 6548117781629084430L;
	private static final String dataPath = "./src/com/revature/data/Bank_Data.ser";
	private static final String name = "Bank Bank";
	
	private static Bank myBank;
	static Scanner sc = new Scanner(System.in);
	
	private ArrayList<Account> accounts;
	private int currentUser;
	private boolean loggedOut;
	
	
	
	private Bank() {
		super();
		
		accounts = new ArrayList<Account>();
	}
	
	
	public void open() {
		boolean keepGoing = true;
		do {
			newSession();
			String option;
			
			while(true) {
				System.out.println("Would you like to start a new session?");
				System.out.println("Enter 'y' for yes or 'n' for no");
				option = Bank.sc.nextLine();
				if(option.toLowerCase().equals("y")) {
					keepGoing = true;
					break;
				} else if(option.toLowerCase().equals("n")) {
					keepGoing = false;
					break;
				} else {
					System.out.println("Could not recognize input.");
				}
			}
		} while(keepGoing);
		System.out.println("The bank is closed!");
	}
	
	private void newSession() {
		this.currentUser = -1;
		
		System.out.println("New Session");
		System.out.println("Welcome to " + name + "!");
		
		System.out.println("Would you like to: ");
		this.loggedOut=false;
		idMenu();
		
		while(!loggedOut) {
			System.out.println("What would you like to do with us at " + name + "?");
			transaction();
		}
	}
	
	private void idMenu() {
		String option;
		System.out.println("    (1) login");
		System.out.println("    (2) create an account");
		System.out.println("Enter 1 or 2. Enter 0 to Exit");
		option = sc.nextLine();
		try {
			switch(Integer.parseInt(option)) {
			case 0:
				logout();
				break;
			case 1:
				if(accounts.isEmpty()) {
					System.out.println("Sorry, we're new. Create an account");
					createAccount();
					break;
				}
				login();
				break;
			case 2:
				createAccount();
				break;
			default:
				throw new NumberFormatException();
			}
		} catch (NumberFormatException e) {
			System.out.println("Sorry, that was an incorrect value. Here are your options: ");
			idMenu();
		}
		
	}
	
	private void transaction() {
		String option;
		System.out.println("    (1) Deposit");
		System.out.println("    (2) Withdraw");
		System.out.println("    (3) View Balance");
		System.out.println("Enter 1, 2, or 3. Enter 0 to logout");
		option = sc.nextLine();
		try {
			switch(Integer.parseInt(option)) {
			case 0:
				logout();
				break;
			case 1:
				deposit();
				break;
			case 2:
				withdraw();
				break;
			case 3:
				viewBalance();
				break;
			default:
				throw new NumberFormatException();
			}
		} catch (NumberFormatException e) {
			System.out.println("Sorry, that was an incorrect value. Here are your options: ");
			transaction();
		}
		
		serialize();
		
	}
	
	private void createAccount() {
		System.out.println("Enter an email or username: ");
		String username;
		while(true) {
			username = sc.nextLine();
			if(accounts.isEmpty()) {
				break;
			}
			boolean used = false;
			for(Account person: accounts) {
				if(username.toLowerCase().equals(person.getUsername())) {
					System.out.println("Sorry, username or email is taken. Please enter another: ");
					used = true;
					break;
				}
			}
			if(used) {
				continue;
			}
			break;
		}
		
		System.out.println("Enter a password: ");
		String password;
		String confirmPassword;
		while(true) {
			password = sc.nextLine();
			System.out.println("Confirm password by typing it again: ");
			confirmPassword = sc.nextLine();
			if(!confirmPassword.equals(password)) {
				System.out.println("Password doesn't match!");
				System.out.println("Re-enter password: ");
				continue;
			}
			break;
		}
		
		
		accounts.add(new Account(username.toLowerCase(), password, 0));
		serialize();
		newCurrentUser(new Account(username.toLowerCase(), password, 0));
		
	}
	
	private void login() {
		String username;
		String password;
		boolean match;
		while(true) {
			System.out.println("Enter your username/email: ");
			username = sc.nextLine();
			System.out.println("Enter your password: ");
			password = sc.nextLine();
			match = false;
			for(Account person : accounts) {
				if(username.toLowerCase().equals(person.getUsername()) && password.equals(person.getPassword())) {
					match = true;
					newCurrentUser(person);
					break;
				}
			}
			
			if(match) {
				break;
			}
			System.out.println("Username or password didn't match. Please try again.");
		}
	}
	
	
	
	private void logout() {
		this.loggedOut = true;
		System.out.println("Thank you for banking with us at " + name + "!");
	}
	
	private void deposit() {
		String amountString;
		float amount;
		while(true) {
			System.out.println("How much would you like to deposit?");
			amountString = sc.nextLine();
			try {
				amount = Float.parseFloat(amountString);
				if(amount < 0) {
					throw new NegativeNumberException();
				}
				break;
			} catch(NumberFormatException e) {
				System.out.println("Sorry, that's an invalid input");
			} catch (NegativeNumberException e) {
				System.out.println("Sorry, you can't deposit negative money.");
			}
		}
		
		accounts.get(currentUser).addToBalance(amount);
		System.out.println("We've added $" + amount + " to your account!");
		System.out.println("Your balance is $" + accounts.get(currentUser).getBalance());
	}
	
	private void withdraw() {
		String amountString;
		float amount;
		while (true) {
			System.out.println("You have $" + accounts.get(currentUser).getBalance() + " in your account.");
			System.out.println("How much would you like to withdraw?");
			amountString = sc.nextLine();
			try {
				amount = Float.parseFloat(amountString);
				if(accounts.get(currentUser).getBalance() - amount < 0) {
					throw new NegativeNumberException();
				}
				break;
			} catch(NumberFormatException e) {
				System.out.println("Sorry, that's an invalid input");
			} catch (NegativeNumberException e) {
				System.out.println("Sorry, you can't withdraw more than what's in your account.");
			}
		}
		
		accounts.get(currentUser).removeFromBalance(amount);
		System.out.println("We've removed $" + amount + " to your account!");
		System.out.println("Your balance is $" + accounts.get(currentUser).getBalance());	
	}
	
	private void viewBalance() {
		System.out.println("Your balance is $" + accounts.get(currentUser).getBalance());
	}
	
	private void newCurrentUser(Account person) {
		for(int i = 0; i < accounts.size(); i++) {
			if(person.getUsername().equals(accounts.get(i).getUsername())) {
				this.currentUser = i;
			}
		}
	}
	
	private static void serialize() {
		try {
			FileOutputStream fos = new FileOutputStream(dataPath);
			ObjectOutputStream oos = new ObjectOutputStream(fos);
			oos.writeObject(myBank);
			oos.close();
			fos.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	//Implementing as a singleton
	public static Bank getInstance() {
		if(myBank == null) {
			try {
				FileInputStream fis = new FileInputStream(dataPath);
				ObjectInputStream ois = new ObjectInputStream(fis);
				
				myBank = (Bank) ois.readObject();
				
				ois.close();
				fis.close();
			} catch (IOException e) {
				e.printStackTrace();
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}
		}
		return (myBank == null) ? (myBank = new Bank()) : myBank;
	}

	@Override
	public Object clone() throws CloneNotSupportedException {
		throw new CloneNotSupportedException();
	}
	
}
