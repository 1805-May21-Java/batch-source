package com.revature;

import java.io.File;
import java.util.Scanner;



public class Menu {
	//Contains all menu and navigation for Tank Bank
	
	static Scanner scan = new Scanner(System.in);
	BankAccount bankAccount;
	
	public Menu() {
		super();
		bankAccount = new BankAccount();
		}
	
	public Menu(BankAccount bankAccount) {
		super();
		this.bankAccount = bankAccount;
	}
	
	//Asks the user if they have an existing account, and creates one if not
	public void existingAccount() {
		System.out.println("Welcome to Tank Bank, where we keep your money safe!");
		System.out.println(tank);
		System.out.println("Do you already have an account with us, or would you like to make a new one?");
		System.out.println("Type 1 for existing account, 2 to create a new one");
		switch (scan.nextLine()) {
		case "1":
			bankAccount = GetBankAccount.getAccount();
			mainMenu();
			break;
		case "2":
			//creates a new account, prompting user for information
			this.createBankAccount();
		default:
			System.out.println("Please enter 1 or 2!");
			existingAccount();
		}
	}
	
	public void mainMenu() {
		//menu to withdraw, deposit, or view balance
		System.out.println("Would you like to withdraw (1), deposit (2), view balance (3), logout(4) or exit (5)?");
		switch (scan.nextLine()) {
		case "1":
			System.out.println("How much would you like to withdraw?");
			//gets double input
			double withdrawAmount = inputDouble();
			bankAccount.withdraw(withdrawAmount);
			//Withdraws the amount left in the account and prints the amount left
			System.out.println(String.format("%s, you have $%.2f in your account", 
					bankAccount.getUsername(),bankAccount.getBalence()));
			//Saves changes
			SaveBankAccount.save(bankAccount);
			break;
			
		case "2":
			System.out.println("How much would you like to deposit?");
			//gets double input
			double depositAmount = inputDouble();
			bankAccount.deposit(depositAmount);
			//prints out the amount the user has 
			System.out.println(String.format("%s, you have $%.2f in your account", 
					bankAccount.getUsername(),bankAccount.getBalence()));
			//Saves changes
			SaveBankAccount.save(bankAccount);
			break;
			
		case "3":
			//prints balance
			System.out.println(String.format("%s, you have $%.2f in your account", 
					bankAccount.getUsername(),bankAccount.getBalence()));
			break;
		case "4":
			//logs user out, then sends to login screen
			bankAccount.setLoggedIn(false);
			System.out.println("Logged out!");
			//creates a transition to the message that will appear in the getAccount method
			System.out.print("To login again, ");
			bankAccount = GetBankAccount.getAccount();
			mainMenu();
		case "5":
			//closes resources then exits
			System.out.println("Have a good day!");
			scan.close();
			System.exit(0);
		default:
			//prints message, then runs the mainMenu method again
			System.out.println("I'm sorry, that wasn't one of our options!");
			break;
		}
		mainMenu();
		
	}
	
	public void createBankAccount() {
		//creates a new account, prompting the user for a username, password, and email address
		String username;
		do{
			System.out.println("Please enter a username");
			username = inputUserPass();
			bankAccount.setUsername(username);
		}while(usernameFree(username));
		System.out.println("Great!  Now enter your password");
		bankAccount.setPassword(inputUserPass());
		System.out.println("Awesome.  Now enter your email address");
		bankAccount.setEmail(inputEmail());
		bankAccount.setLoggedIn(true);
		
		System.out.println("You're all set up!");
		SaveBankAccount.save(bankAccount);
		mainMenu();
	}
	
	//makes sure user enters a double
	private double inputDouble() {
		while(scan.hasNext()) {
			try{
				double var = Double.valueOf(scan.nextLine());
				return var;
			}catch (NumberFormatException e) {
				System.out.println("Enter a valid number!");
			}
		}
		//should never get here
		return 0;
	}
	
	//validates username and password
	private String inputUserPass() {
		while(scan.hasNext()) {
			String entry = scan.nextLine();
			//makes sure there are no spaces
			if(!entry.contains(" ")) {
				return entry;
			}else {
				System.out.println("Please enter one word!");
			}
		}
		//should never get here
		return null;
	}
	
	//validates email address
		private String inputEmail() {
			while(scan.hasNext()) {
				String entry = scan.nextLine();
				//makes sure there are no spaces, there is an '@', and there is a '.'
				if( (!entry.contains(" ")) && entry.contains(".") && entry.contains("@")) {
					return entry;
				}else {
					System.out.println("Please enter a valid email address!");
				}
			}
			//should never get here
			return null;
		}
		
		//checks if that username is already taken
		private boolean usernameFree(String username) {
			String path = "src/com/revature/accounts/"+username+".txt";
			//returns true if file exist (meaning the username has been taken), true otherwise
			if(new File(path).exists())
			{
				//if taken, print message and return true so the loop continues
				System.out.println("Sorry, username has already been taken!");
				return true;
			}else {
				return false;
			}
		}
		
		//tank ascii to print on welcome screen
	private static String tank = 
			"  $         			    \n"+ 
			" $$$     					\n"+ 
			"$	   .--._____,		\n"+
			" $$$    .-='=='==-,		\n"+
			"    $	(O_o_o_o_o_O)		\n"+
			" $$$						\n"+
			"  $";
}