package com.revature.banking;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class FlowControll {
	
	// Variable to check if an Invalid Entry message needs to be printed
	private boolean error=false;
	
	// Scanner to get user input
	private Scanner scanner=new Scanner(System.in);
	
	// Variable to hold users choices
	private String which;
	
	// Account object to be used when someone signs in
	private Account account;
	
	// SerialzeData object for reading and writing data between the program and the file
	private SerializeData serialize=new SerializeData("Accounts.ser");
	
	// ArrayList to hold the accounts from the file
	private ArrayList<Account> accounts=serialize.deserialize();
	
	// Constructor that calls to the super()
	public FlowControll() {
		super();
	}
	
	/*
	 * This method is used to create a Main Menu where the program starts
	 * 
	 * It gives the user the choices of signing in, signing up, or exiting the program
	 * 
	 * The first two options call the clear method (which simply clears out 
	 * previous inputs and prints from the console) and then their own respective
	 * methods that represent other menus.
	 * 
	 * The third simply prints a good bye message and lets the program terminate
	 * 
	 * Any input other than 1, 2, or 3 will result in the the console being cleared, an error message being 
	 * printed, and mainMenu is then called again
	 * 
	 */
	public void mainMenu() {
		clear();
		System.out.println("Welcom to Java Banking Application!");
		System.out.println();
		System.out.println("1. Sign In");
		System.out.println("2. Sign Up");
		System.out.println("3. Exit");
		
		which=scanner.nextLine();
		switch(which) {
		case "1":
			clear();
			signIn();
			break;
		case "2":
			clear();
			signUp();
			break;
		case "3":
			clear();
			System.out.println("GoodBye, thank you fore using Java Banking Application!");
			break;
		default:
			error=true;
			clear();
			mainMenu();
			break;
		}
			
	}
	/*
	 * This method is used to create an Account Menu, or logged in menu, that gives the user options in viewing
	 * and editing their bank balance
	 * 
	 * Each choice clears the console and calls its own method, except 4 which sets account to null and calls the
	 * mainMenu method (effectively logging the user out)
	 * 
	 * An invalid entry will cause the console to be cleared, an error printed, 
	 * and accountMenu to be called again
	 */
	public void accountMenu() {
		String which;
		
		System.out.println("Account Menu");
		System.out.println();
		System.out.println("1. Check Balance");
		System.out.println("2. Make Deposit");
		System.out.println("3. Make Withdraw");
		System.out.println("4. Log Out");
		
		which=scanner.nextLine();
		switch(which) {
		case "1":
			clear();
			checkBalance();
			break;
		case "2":
			clear();
			makeDeposit();
			break;
		case "3":
			clear();
			makeWithdraw();
			break;
		case "4":
			account=null;
			mainMenu();
			break;
		default:
			clear();
			System.out.println("Invalid Entry");
			accountMenu();
			
		}
		
	}
	/*
	 * This method is used to help a user sign up with a username/email and password
	 * 
	 * It prompts the user to enter both twice, in order to assure that they are correct
	 * 
	 * It also checks to makes sure that the username/email is not already in use
	 * 
	 * 
	 */
	public void signUp() {
		// Variables
		String email;
		boolean exists=false;
		accounts=(serialize.deserialize()==null)?new ArrayList<Account>():serialize.deserialize();
		
		String password;
		String secondPassword;
		
		// Print out for the menu
		System.out.println("Sign Up with Java Banking Application!");
		System.out.println();
		
		// Get email information
		System.out.print("Enter email/username: ");
		email=scanner.nextLine();
		System.out.print("Re-Enter email/username: ");
		
		//Checks each saved account, to see if the username already exists
		for(Account account : accounts) {
			if(account.compareEmail(email)) {
				exists=true;
				break;
			}
		}
		
		/*
		 * If the username doesn't already exist, and the second email entry matches the first,
		 * the method prints out messages to get the password, checking that the second equals the first
		 */
		if(exists==false && email.equals(scanner.nextLine())) {
			do {
				System.out.println();
				System.out.print("Enter password: ");
				password=scanner.nextLine();
				System.out.print("Re-Enter password: ");
				secondPassword=scanner.nextLine();
				if(!password.equals(secondPassword)) {
					clear();
					System.out.println("Passwords did not match");
				}
				else
					clear();
			}while(password.equals(secondPassword)==false);
			
			// If email and password are created successfully, a new account object is created and added to the 
			// Data file
			//
			// The user is then redirected to the accountMenu
			account=new Account(email, password);
			accounts.add(account);
			serialize.serialize(accounts);
			accounts.clear();
			System.out.println("Successful! Welcome to Java Banking Application "+email);
			accountMenu();
			}
			// If the email is alread in use or the emails typed didn't match, a message is printed, and the 
			// signUp method is called again
			else {
				clear();
				if(exists)
					System.out.println("Email already in use");
				else
					System.out.println("Emails did not match");
				System.out.println();
				signUp();
			}
		
	}
	
	/*
	 * This method creates a signIn method to assist the user in signing in to their account
	 */
	public void signIn() {
		// Variables
		String email;
		String password;
		
		// Prompts user to type in email/username
		System.out.print("Email/Username: ");
		email=scanner.nextLine();
		System.out.println();
		
		// Prompts user to type in password
		System.out.print("Password: ");
		password=scanner.nextLine();
		
		// Method that checks whether their is an account that has this email/username, password pair
		account=checkAccounts(email, password);
		
		// If their is an account with this information, go to accountMenu
		if(account!=null) {
			clear();
			accountMenu();
		}
		
		// Otherwise, a do while loop and switch case is used to inform the user that they entered wrong 
		// Email/Username or password, and gives them the option to go back to the main menu
		else {
			clear();
			// Prints message and gets user input to see what to do
			// Continually loops until user provides a legitimate choice
			System.out.println("Email or username is incorrect");
			do {
				System.out.println("Return to Main Menu?");
				System.out.println("1. Yes");
				System.out.println("2. No, try again");
				which=scanner.nextLine();
				if(which.equals("1")==false && which.equals("2")==false) {
					clear();
					System.out.println("Invalid entry");
				}
			}while(which.equals("1")==false && which.equals("2")==false);
			// Switch case to take user to the main menu, or to try to sign in again
			switch(which) {
			case "1":
				mainMenu();
				break;
			case "2":
				signIn();
				break;
			}
		}
		
		
		
	}
	
	// Process to clear the console and keep things looking clean
	private void clear() {
		try {
			int clear = new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
		} catch (InterruptedException | IOException e) {
			e.printStackTrace();
		}
		 
		if(error==true) {
			error();
			error=false;
			System.out.println();
		}
	}
	
	
	// Method to print a simple error message
	private void error() {
		System.out.println("Invalid Entry");
	}
	
	// Loops through the saved accounts on the Data file, and checks if they have login information that matches
	// The user input
	private Account checkAccounts(String email, String password) {
		Account currentAccount=null;
		accounts=serialize.deserialize();
		// If there has been no information saved to the file, the method deserialize above returns null, which
		// throws an exception when I try to loop though the ArrayList accounts, so I call a try with an empty 
		// catch to simply say, its empty so skip this part
		try {
			for(Account a:accounts) {
				if(a.compareEmail(email) && a.comparePassword(password)) {
					currentAccount=a;
					break;
				}	
			}
		}catch(Exception e) {
			
		}
		
		return currentAccount;
		
	}
	
	// Method to check the users current balance
	private void checkBalance() {
		System.out.printf("You current account balance is $%.2f",account.getBalance());
		System.out.println();
		System.out.println("Press Enter to return to Account Menu");
		which=scanner.nextLine();
		clear();
		accountMenu();
		
	}
	
	// Method to make a withdrawal from the users balance
	private void makeWithdraw() {
		Double amount=0.0;
		boolean fundsAvailable = false;
		System.out.println("How much would you like to withdraw?");
		// This try catch block basically checks if the user input is a double, if not the catch block prints 
		// an error message and calls the makeWithdraw method again
		try {
			amount=scanner.nextDouble();
			fundsAvailable=account.makeWithdraw(amount);
		}catch(Exception e) {
			clear();
			System.out.println("Invalid Entry");
			makeWithdraw();
		}
		
		// If there is enough money to meet the withdraw request, the account information is updated in the 
		// Data file, and after hitting enter the user is taken back to accpuntMenu
		if(fundsAvailable) {
			accounts.remove(account);
			accounts.add(account);
			serialize.serialize(accounts);
			
			System.out.printf("You withdrew $%.2f successfully, your balance is now $%.2f", amount, account.getBalance());
			which=scanner.nextLine();
			System.out.println();
			System.out.println();
			System.out.println("Press Enter to return to Account Menu");
			which=scanner.nextLine();
			clear();
			accountMenu();
		}
		// If the funds were insufficient, an message displaying the balance is printed and 
		// a do while loop and switch case are used to get user input to decide if they want to try the withdraw
		// Again or go back to the AccountMenu
		else {
			System.out.println("You do not have sufficent funds to withdraw that amount.");
			System.out.printf("Your balance is only $%.2f",account.getBalance());
			System.out.println();
			which=scanner.nextLine();
			do {
				System.out.println("Would you like to try again?");
				System.out.println("1. Yes");
				System.out.println("2. No");
				which=scanner.nextLine();
				if(which.equals("1")==false && which.equals("2")==false) {
					clear();
					System.out.println("Invalid Entry");
				}
			}while(which.equals("1")==false && which.equals("2")==false);
			
			switch(which) {
			case "1":
				clear();
				makeWithdraw();
				break;
			case "2":
				clear();
				accountMenu();
			}
		}
	}
	
	// Mehthod to deposite money into the bank account
	private void makeDeposit() {
		System.out.println("How much would you like to deposit?");
		which=scanner.nextLine();
		// Try catch block tests that the user given input is valid
		// If not, the catch block catches it and calls the makeDeposit method again
		try {
			account.makeDeposit(Double.parseDouble(which));
		}catch(Exception e) {
			clear();
			System.out.println("Invalid Entry");
			makeDeposit();
		}
		
		// Update Data file
		accounts.remove(account);
		accounts.add(account);
		serialize.serialize(accounts);
		
		// Print success message and, after user hits enter, returns them to the Account Menu
		System.out.printf("Deposit made successfully. Balance is now $%.2f", account.getBalance());
		System.out.println();
		System.out.println("Press Enter to return to Account Menu");
		which=scanner.nextLine();
		clear();
		accountMenu();
	}
}
