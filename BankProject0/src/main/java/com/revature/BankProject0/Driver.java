package com.revature.BankProject0;

//yes our driver class now
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner; //unlike my failed attempt at using a file, we will exclusively use a scanner for this.
import com.revature.dao.*;
import com.revature.pojos.Account;

public class Driver {
	private static Scanner sc = new Scanner (System.in); //doing something different, this time the scanner is private and static
	private static Account currentAc; //current account variable
	private static AccountDAOImpl adi = new AccountDAOImpl(); //create instance of AccountDAOImpl
	private static int wrongUN = 0; //we are going to try something strange here, these int values show how many times a user can fail
	private static int wrongPW = 0; // at logging in before a safety check comes into play, locking them from a re-login
	public static void main(String[] args) {
		loginMenu();
		//*********
		//PROCEDURE
		//*********
		//here's how it will go
		//start with the login menu
		//prompt for creation of account or login
		//username, then password, up to four failed attempts
		//upon creation, balance starts at zero and user is entered into ACCOUNT table
		//upon successful login, go to transaction menu
		//deposit, withdraw, check balance, logout
		//this time, logging out only sends you to the transaction menu
		//main function only has loginMenu as first thing
		//***********************************************************
		//also a table for ACCOUNT needs to be created prior to this.
		//***********************************************************
	}
	public static void loginMenu() { //login menu, woo
		System.out.println("***WELCOME TO THE BANKING APP***");
		System.out.println("1. Login");
		System.out.println("2. Create a new account");
		System.out.println("Press 0 to quit");
		String choice = sc.nextLine(); //learning my lesson from the previous iteration, using String instead of int
		switch (choice) {
			case "1":
				login(); //1. Login
				break;
			case "2":
				createAccount(); //2. Create a new account
				break;
			case "0":
				System.out.println("Thank you for using the banking app.");
				System.exit(0); //Press 0 to quit
			default:
				System.out.println("ERR: Invalid input");
				loginMenu(); //well, we've gotta continue with the login somehow
				break;
		}
	}
	public static void login() { // 1
		String username;
		System.out.print("Please enter your username: ");
		username = sc.nextLine();
		currentAc = adi.getAccountById(username);
		if(currentAc == null) {
			System.out.println("Username does not exist in the database system.");
			System.out.println("Please log in again.");
			wrongUN++; //so when a user fails to input the proper username up to four times
			if(wrongUN == 4) {
				wrongUN = 0; //the wrongUN number is assigned back to 0
				System.out.println("You have made too many failed logins");
				System.out.println("Redirecting to login page");
				loginMenu(); //and the user is kicked back to the main menu
			}
			login(); //this restarts unless the condition is satisfied above
		}
		if(currentAc != null) {
			passwordPrompt(); //but now we go to the password prompt. Well done, you passed the first test
		}
	}
	public static void passwordPrompt() { //still part of 1
		System.out.print("Please enter your password: ");
		String password = sc.nextLine();
		if(!password.equals(currentAc.getPw())) {
			wrongPW++; //failsafe is done the same way as the other one
			System.out.println("Sorry, your password is not correct");
			if(wrongPW == 4) {
				wrongPW = 0;
				System.out.println("You have made too many failed logins");
				System.out.println("Redirecting to login page");
				loginMenu();
			}
			if(currentAc != null) {
				System.out.println("Please try again");
				passwordPrompt();
			}
		}
		if(currentAc != null) {
			System.out.println("Login Successful");
			System.out.println();
			System.out.println("***********************************************************");
			System.out.println("Welcome: " + currentAc.getUsr());
			System.out.println("***********************************************************");
			currentAc.setLoggedIn(true); //and the user is now set as isLoggedIn
			transactionMenu(); //now go to the transaction menu
		}
	}
	public static void createAccount() { // 2
		String usr, username, pw; // for creating an account, what else do we need?
		System.out.print("Please input your name: ");
		usr = sc.nextLine();
		username = getUsername(); //two separate functions for inputing username and password
		pw = getPassword();
		currentAc = new Account(usr, username, pw, 0, true); // new account created, the user's default balance upon creation is 0, and isLoggedIn is true
		adi.createAccount(currentAc); //using our DAO implementation
		System.out.println("***********************************************************");
		System.out.println("Welcome: " + currentAc.getUsr());
		System.out.println("***********************************************************");
		transactionMenu(); //they are immediately sent to the transaction menu for convenience
	}

	public static String getUsername() {
		String username = ""; //initialize to empty string
		System.out.print("Please enter a username (must be unique): "); //we'll add a safety check if it isn't unique
		List<Account> acctList = new ArrayList<>();
		acctList = adi.listAllAccounts(); //call this to find if a username exists
		username = sc.nextLine();
		for(Account a : acctList) {
			if(username.equals(a.getUsername())) {
				System.out.println("ERR: Username is already being used by another account");
				getUsername();
			}
		}
		return username;
	}
	public static String getPassword() {
		String pw = "";
		String pw2 = ""; // pw2 is the "confirm password" option
		System.out.print("Please enter your password: ");
		pw = sc.nextLine();
		System.out.print("Please confirm your password by typing it again: ");
		pw2 = sc.nextLine();
		if(!pw.equals(pw2)) {
			System.out.println("ERR: Passwords do not match, please re-input passwords again.");
			return getPassword();
		}
		return pw; //or return pw2, either one is fine
	}
	public static void transactionMenu() { //second menu
		System.out.println("1. View current balance"); //for convenience, an impatient user isn't gonna accidentally screw up a transaction in a weird way
		System.out.println("2. Deposit money");
		System.out.println("3. Withdraw money");
		//System.out.println("4. Delete account"); //attempted to do this if a user was going to delete their account, but figured out that this isn't required for the project
		System.out.println("Press 0 to log out");
		String choice = sc.nextLine();
		switch (choice) {
			case "1":
				System.out.printf("Current balance: $%.2f", currentAc.getBalance()); //hmm, never did use printf before
				System.out.println();
				transactionMenu(); // one thing I didn't do in the first iteration was continue with the menu. Actually this line may not be needed
				break;
			case "2":
				deposit(); //separate functions for deposit and withdraw
				break;
			case "3":
				withdraw();
				break;
			/*case "4":
				System.out.println("Are you sure you wish to delete your account?");
				System.out.println("Press 1 to delete your account");
				System.out.println("Press any other number to cancel");
				int confirm = sc.nextInt();
				if (confirm == 1) {
					adi.deleteAccount(currentAc.getUsername());
					System.out.println(currentAc.getUsername() + " has been removed from the system.");
					break;
				}
				else
					transactionMenu();
					break;*/
			case "0":
				System.out.println("You have successfully logged out");
				System.out.println();
				adi.updateAccount(currentAc); //make some updates and commit them
				currentAc = null; //also reinitialize this to null for anyone else who wants to log in
				loginMenu(); //and now we are back here
				break;
		}
	}
	public static void deposit() {
		System.out.print("Please enter an amount to deposit: ");
		try {
			int parser = currentAc.deposit(Float.parseFloat(sc.nextLine())); //trying another new thing with float, using the currentAc variable and parseFloat to avoid some errors. Also try/catch
			switch (parser) {
			case -1:
				System.out.println("ERR: Cannot deposit nonpositive amount.");
				transactionMenu(); break;
			case 0: loginMenu(); break; //-1 and 0 are invalid conditions 
			default: transactionMenu(); break; //default just takes you back to the menu
			}
		} catch (NumberFormatException e) { // this is where we need this exception
			System.out.println("ERR: Invalid input, please try again");
			transactionMenu();
		}
	}
	public static void withdraw() { //almost identical to the last one, so I copy it from there, but this is a withdrawal so I have to change that.
		System.out.print("Please enter an amount to withdraw: ");
		try {
			int parser = currentAc.withdraw(Float.parseFloat(sc.nextLine()));
			switch (parser) {
			case -1:
				System.out.println("ERR: Attempted to withdraw more than current balance.");
				transactionMenu(); break;
			case 0: loginMenu(); break;
			default: transactionMenu(); break;
			}
		} catch (NumberFormatException e) {//this is where we need this exception
			System.out.println("ERR: Invalid input, please try again");
			transactionMenu();
		}
	}
}	
