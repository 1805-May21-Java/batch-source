package com.Revature.pkg;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.text.NumberFormat;
import java.util.Scanner;
	
public class driver {
	//Methods used for serializing the bank
	public static boolean writeBank(String path, Bank b) { 
		File file = new File(path);
		if (!file.exists()) {
			try {
				file.createNewFile(); //If bank has not been saved yet, create file
			} catch (IOException e) { 
				return false; //Return false on failed save
			}		
		}

		try (FileOutputStream fw = new FileOutputStream(file); ObjectOutputStream os = new ObjectOutputStream(fw);) {
			os.writeObject(b); //Writes bank to file in try with resources
		} catch (Exception e) {
			return false; //return false on saving bank
		}
		
		//Bank save success
		return true;
	}

	public static Bank readBank(String path) { //Reads bank from file
		Bank b = null;
		try (FileInputStream fr = new FileInputStream(path); ObjectInputStream os = new ObjectInputStream(fr);) {
			//Try with resources
			b = (Bank) os.readObject();
			//read in bank
		} catch (Exception e) {
			return null; //return null on failure to read bank
		}

		return b; //Return bank
	}

	//Prints all valid commands to the console
	public static void printCmds() {
		System.out.println("create\t\tCreate an account");
		System.out.println("delete\t\tDelete your account");
		System.out.println("login\t\tLog into an existing account");
		System.out.println("logout\t\tLog out of current account");
		System.out.println("deposit\t\tDeposit funds into current account");
		System.out.println("withdraw\tWithdraw funds from current account");
		System.out.println("balance\t\tView your current balance");
		System.out.println("passwd\t\tChange password");
		System.out.println("quit\t\tTo quit the application");
		System.out.println("help\t\tDisplays this message");
	}

	//Login attempt from user command
	public static Client login(Scanner sc, Client c, Bank b) {
		if (c != null) { //If the client is already logged in
			System.out.println("You are already logged in");
			return c;
		}

		System.out.print("Username: ");
		String username = sc.nextLine();
		System.out.print("Password: ");
		String password = sc.nextLine();

		Client newC = b.login(username, password); //Ask bank for a client with these credentials
		
		//Output success or failure
		if (newC == null) {
			System.out.println("Login failed");
		} else {
			System.out.println("Login success");
		}

		return newC; //Returns either null or valid client
	}

	public static void logout(Client c) {
		//Logs client out
		if (c == null) {
			System.out.println("You are not logged in");
		} else {
			System.out.println("Logged out");
		}
	}

	public static Client createAccount(Scanner sc, Client c, Bank b) {
		if (c != null) { //If you are already logged in, you cannot make an account
			System.out.println("You are already logged in");
			return c;
		}

		System.out.print("New Username: ");
		String username = sc.nextLine();
		System.out.print("Desired Password: ");
		String password = sc.nextLine();

		Client newC = b.createUser(username,password); //Validates the success of account creation

		if (newC == null) {
			System.out.println("Creation failed");
		} else {
			System.out.println("Creation success");
		}
		return newC;
	}

	public static void deposit(Scanner sc, Client c, Bank b) {
		if (c == null) { //Verify client is logged in
			System.out.println("You are not logged in");
			return;
		}

		System.out.print("Enter amount to deposit: ");
		String amount = sc.nextLine();

		try {
			boolean resp = b.deposit(c, Float.parseFloat(amount)); //Attempts to deposit amount
			if (resp) { //Output result
				System.out.println("Deposit Success");
			} else {
				System.out.println("Deposit Failure");
			}
		} catch (NumberFormatException e) {
			System.out.println("Invalid input");
		}
	}

	//Similar to deposit
	public static void withdraw(Scanner sc, Client c, Bank b) {
		if (c == null) {
			System.out.println("You are not logged in");
			return;
		}

		System.out.print("Enter amount to withdraw: ");
		String amount = sc.nextLine();

		try {
			boolean resp = b.withdraw(c, Float.parseFloat(amount));
			if (resp) {
				System.out.println("Withdraw Success");
			} else {
				System.out.println("Withdraw Failure");
			}
		} catch (NumberFormatException e) {
			System.out.println("Invalid input");
		}
	}

	//Checks balance of account
	public static void balance(Client c) {
		if (c == null) {
			System.out.println("You are not logged in");
		} else {
			System.out.println("Current balance: " + NumberFormat.getCurrencyInstance().format(c.getMoney()));
		}
	}

	//Changes password of account
	//Operation does not require bank
	//If you are already logged in
	//Requesting a password change from the bank is unnecessary
	public static void passwd(Scanner sc , Client c ) {
		if ( c == null ) {
			System.out.println("You are not logged in");
			return;
		}
		
		//Validates current password		
		System.out.print("Current Password: ");
		String password = sc.nextLine();
		if ( !password.equals(c.getPassword())) {
			System.out.println("Incorrect password");
			return;
		}
		
		System.out.print("New Password: ");
		String newPassword = sc.nextLine();
		
		c.setPassword(newPassword);
		
		System.out.println("Password change sucess");
	}
	
	//Delete account
	public static Client delete(Scanner sc , Client c , Bank b ) {
		if ( c == null ) {
			System.out.println("You are not logged in");
			return null;
		}
		//Get user validation
		System.out.print("Are you sure you want to delete " + c.getUsername()+"'s account? (y/n): ");
		while ( true ) { //Continue until the user says yes or no to account deletion
			String resp = sc.nextLine();
			if ( resp.equals("y")) {
				b.deleteAccount(c);
				System.out.println("Account deleted");
				return null;
			} else if ( resp.equals("n")) {
				System.out.println("Account not deleted");
				return c;
			}
		}
	}
	
	public static void main(String args[]) {
		Bank b = null;
		//Either hard coded path to bank for argument provided one
		String path = (args.length==0)?".\\content":args[0];
		b = readBank(path); //Attempts to read in the bank
		if (b == null) { //If bank read failed, assume the bank has never been saved
			System.out.println("No bank info on file");
			System.out.println("Initializing new Bank");
			b = new Bank();
		}

		Scanner sc = new Scanner(System.in);
		Client currentClient = null; //Client is not logged in

		printCmds(); //Print commands
		
		
		/*
		 * currentClient variable is used to track the state of the user
		 * if null, user is not logged into a valid client account
		 * return values of methods are assigned to currentClient
		 * to keep state up to date
		 */
		
		while (true) {
			System.out.println();
			String cmd = sc.nextLine().toLowerCase();

			switch (cmd) {
			case "quit": //Quits the app
				return;
			case "help": //Prints user commands
				printCmds();
				break;
			case "create": //Attempts to create an account
				currentClient = createAccount(sc, currentClient, b);
				break;
			case "delete": //Deletes account
				currentClient = delete(sc,currentClient,b);
				break;
			case "login":
				currentClient = login(sc, currentClient, b);
				break;
			case "logout":
				logout(currentClient);
				currentClient = null;
				break;
			case "deposit":
				deposit(sc, currentClient, b);
				break;
			case "withdraw":
				withdraw(sc, currentClient, b);
				break;
			case "balance":
				balance(currentClient);
				break;
			case "passwd":
				passwd(sc,currentClient);
				break;
			default:
				System.out.println("Invalid input");
			}
			writeBank(path, b); //After each transaction, bank is saved
		}
	}
}
