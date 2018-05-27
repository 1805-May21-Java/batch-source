package com.revature;

import java.io.File;
import java.util.Iterator;
import java.util.Scanner;



public class Menu {
	//Contains all menu and navigation for Tank Bank
	
	static Scanner scan = new Scanner(System.in);
	Client client;
	
	public Menu() {
		super();
		Client client = new Client();
		}
	
	public Menu(Client client) {
		super();
		this.client = client;
	}
	
	//Asks the user if they have an existing account, and creates one if not
	public void existingAccount() {
		System.out.println("Welcome to Tank Bank, where we keep your money safe!");
		System.out.println(tank);
		System.out.println("Do you already have an account with us, or would you like to make a new one?");
		System.out.println("Type 1 for existing account, 2 to create a new one, or 3 to exit");
		switch (scan.nextLine()) {
		case "1":
			client = WriteReadBankAccount.getClient();
			selectAccount();
			break;
		case "2":
			//creates a new account, prompting user for information
			createClient();
		case "3":
			exit();
		default:
			System.out.println("Please enter 1 or 2!");
			existingAccount();
		}
	}
	
	//Client can select an existing account or create a new one
	private void selectAccount() {
		System.out.println("Select from existing accounts by typing the name of the account, "
				+ "or create a new one by typing 'new'");
		System.out.println("Type 'exit' at any time to exit");
		client.accounts.forEach(account -> System.out.println(account.getAccountName()+" $"+account.getBalence()));
		BankAccount account = inputAccount();
		accountAction(account);
		
	}
	
	private void accountAction(BankAccount bankAccount) {
		//menu to withdraw, deposit, or view balance
		System.out.println("Would you like to withdraw (1), deposit (2), view balance (3),"
				+ "select a differnt account(4), logout(5) or exit (6)?");
		switch (scan.nextLine()) {
		case "1":
			System.out.println("How much would you like to withdraw?");
			//gets double input
			double withdrawAmount = inputDouble();
			bankAccount.withdraw(withdrawAmount);
			//Withdraws the amount left in the account and prints the amount left
			System.out.println(String.format("%s, you have $%.2f in your account", 
					client.getUsername(),bankAccount.getBalence()));
			//Saves changes
			WriteReadBankAccount.saveClient(client);
			break;
			
		case "2":
			System.out.println("How much would you like to deposit?");
			//gets double input
			double depositAmount = inputDouble();
			bankAccount.deposit(depositAmount);
			//prints out the amount the user has 
			System.out.println(String.format("%s, you have $%.2f in your account", 
					client.getUsername(),bankAccount.getBalence()));
			//Saves changes
			WriteReadBankAccount.saveClient(client);
			break;
			
		case "3":
			//prints balance
			System.out.println(String.format("%s, you have $%.2f in your account", 
					client.getUsername(),bankAccount.getBalence()));
			break;
		case "4":
			//Lets user go back to select account screen
			selectAccount();
		case "5":
			//logs user out, then sends to login screen
			System.out.println("Logged out!");
			client = WriteReadBankAccount.getClient();
			selectAccount();
		case "6":
			//closes resources then exits
			scan.close();
			exit();
		default:
			//prints message, then runs the mainMenu method again
			System.out.println("I'm sorry, that wasn't one of our options!");
			break;
		}
		accountAction(bankAccount);
		
	}
	
	private void createClient() {
		//creates a new account, prompting the user for a username, password, and email address
		String username;
		client = new Client();
		do{
			System.out.println("Type 'exit' at any time to quit this process.");
			System.out.println("Please enter a username");
			username = inputUserPass();
			client.setUsername(username);
		}while(usernameFree(username));
		System.out.println("Great!  Now enter your password");
		client.setPassword(inputUserPass());
		if(username.equals("exit")) exit();
		System.out.println("Awesome.  Now enter your email address");
		client.setEmail(inputEmail());
		if(username.equals("exit")) exit();
		
		System.out.println("You're all set up!");
		WriteReadBankAccount.saveClient(client);
		selectAccount();
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
			//exits if user entered "exit"
			if(entry.equals("exit")) exit();
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
				//exits if user entered "exit"
				if(entry.equals("exit")) exit();
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
		
		//user entry for selecting an existing account or opening a new one
		private BankAccount inputAccount() {
			while(scan.hasNext()) {
				String entry = scan.nextLine();
				//exits if the user entered 'exit'
				if(entry.equals("exit")) exit();
				if(entry.equals("new")) {
					//creates new account
					
					System.out.println("What is the name of your new account?");
					String accountName = scan.nextLine();
					//Capitalizes first letter, both for formality
					//And if the user is a jerk and tries to call the account 'exit', it will change to 'Exit'
					accountName = accountName.substring(0, 1).toUpperCase() + accountName.substring(1);
					//adds the new account to the client's list of accounts
					BankAccount bankAccount = new BankAccount(0,accountName);
					client.addNewAccount(bankAccount);
					return bankAccount;
				}else {
					for(BankAccount account : client.accounts) {
						if(entry.equals(account.getAccountName())) {
							return account;
						}
					}
				}
				System.out.println("Invalid account name!  Enter another name, or type 'new' for a new account");
			}
			//Should never reach here
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
		
		//Exits program, static protected so other classes in the package can use it
		static protected void exit() {
			System.out.println("Have a good day!");
			System.exit(0);
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