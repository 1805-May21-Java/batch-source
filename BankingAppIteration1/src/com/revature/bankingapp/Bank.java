package com.revature.bankingapp;

import java.util.*;
import java.io.*;

import com.revature.exceptions.NegativeNumberException;
import com.revature.exceptions.NoSuchOptionException;

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
	// Used to serialize the Bank so that data can persist between uses
	private static final long serialVersionUID = 6548117781629084430L;
	// The path were the serialized bank data will be stored
	private static final String dataPath = "./src/com/revature/data/Bank_Data.ser";
	// Just a silly little string for when I come up with a name for this bank
	private static final String name = "Bank Bank";
	
	
	// Used to implement Bank as a singleton so that no more than one of this bank can exist
	private static Bank myBank;
	// Used for user input
	static Scanner sc = new Scanner(System.in);
	
	
	// Stores account information in an ArrayList
	private ArrayList<Account> accounts;
	// Stores the index of the current user
	private int currentUser;
	
	
	// Used to indicate that when the user is finished interacting with the bank
	private boolean loggedOut;
	
	
	// Constructor private in order to maintain a singleton
	private Bank() {
		super();
		
		// Keeps bank from throwing a NullReferenceException at runtime
		accounts = new ArrayList<Account>();
	}
	
	/*
	 * 
	 * open() is one of three public methods of the Bank class that loops through some
	 * input validation and allows for users to use the bank back to back.
	 * 
	 */
	public void open() {
		// do/while loop used to check if more users want to use the bank.
		boolean keepGoing = true;
		do {
			// Starts a new bank session
			newSession();
			// Used to store user input 
			String option;
			
			// Continues to loop until a valid yes or no is entered by the used
			boolean validYesNo = false;
			do {
				System.out.println("Would you like to start a new session?");
				System.out.println("Enter 'y' for yes or 'n' for no");
				// Read scanner for user input
				option = sc.nextLine();
				if(option.toLowerCase().equals("y")) {
					// If 'y' is entered a new session will begin
					keepGoing = true;
					validYesNo = true;
				} else if(option.toLowerCase().equals("n")) {
					//	If 'n' is entered we will exit the outer loop to close the bank and end the program
					keepGoing = false;
					validYesNo = true;
				} else {
					System.out.println("Could not recognize input.");
				}
			} while(!validYesNo);
		} while(keepGoing);
		System.out.println("The bank is closed!");
	}
	
	/*
	 * 
	 * This is a separate function outside of open since it could be called a lot.
	 * Previously this was the initial loop that would interact with the user, but 
	 * that was achieved with recursive functions which would eventually over populate
	 * the heap memory.
	 * 
	 */
	private void newSession() {
		// Cleans the previous user's Account ArrayList index
		this.currentUser = -1;
		// Resets the previous user's logged out status
		this.loggedOut=false;
		
		System.out.println("New Session");
		System.out.println("Welcome to " + name + "!");
		
		System.out.println("Would you like to: ");
		// Calls the flow control menu for the user to identify themselves or make a new account
		idMenu();
		
		/*
		 * 
		 *  User can exit before signing in or creating an account, if that's the case 
		 *  the transaction loop will not even start. If the user chooses to continue this
		 *  will loop until the user logs out. 
		 *  
		 */
		while(!loggedOut) {
			System.out.println("What would you like to do with us at " + name + "?");
			// Flow control menu to indicate user's desired transaction. This allows them to 
			// make several transactions without having to sign in each time.
			transaction();
		}
	}
	
	/*
	 * 
	 * This is the menu for identifying the user. They have the option to log in, but if there are no
	 * accounts listed in the account ArrayList, it will prompt the user to create an account. 
	 * 
	 */
	private void idMenu() {
		// Used to store user input
		String option;
		
		// Loop until a definitive menu option is chosen
		boolean finishedWithMenu = false;
		do {
			System.out.println("    (1) login");
			System.out.println("    (2) create an account");
			System.out.println("Enter 1 or 2. Enter 0 to Exit");
			// Read input from scanner
			option = sc.nextLine();
			// Put inside a try/catch to make sure that if a non0integer is enters, we can handle it
			try {
				// Parses input into an integer
				switch(Integer.parseInt(option)) {
				case 0:
					// Marks loggedOut as true and says by to user
					logout();
					// Indicate that a menu option has been chosen
					finishedWithMenu = true;
					break;
				case 1:
					// If nothing is in the accounts ArrayList and the user tries to log in, they will be
					// prompted to create a new account
					if(accounts.isEmpty()) {
						System.out.println("Sorry, we're new. Create an account");
						// Calls the method that guide the user to create an account
						createAccount();
						// Indicates that a menu option has been chosen
						finishedWithMenu = true;
						break;
					}
					// If there are users in the array, the login in method will be called to guide the user
					// to accessing their account
					login();
					// Indicates that a menu option has been chosen 
					finishedWithMenu = true;
					break;
				case 2:
					// Calls the method to guide the user in creating an account
					createAccount();
					// Indicates that a menu option has been chosen
					finishedWithMenu = true;
					break;
				default:
					// Throws a custom exception to tell the user that they input an invalid option
					throw new NoSuchOptionException();
				}
			} catch (NumberFormatException e) {
				// If the string can't parse into an integer, this is displayed
				System.out.println("Sorry, we couldn't read that. Here are your options: ");
			} catch (NoSuchOptionException e) {
				// If the user inputs an invalid option, this is displayed 
				System.out.println("Sorry, that wasn't an option. Here ar your choices: ");
			}
			// If the menu was never identified as finished, it will loop
		}while(!finishedWithMenu);
	}
	
	/*
	 * 
	 * This is the method called the lead the user through the flow control of transactions.
	 * Previously achieved loop through recursive calls, but realized that could grow and fill
	 * the heap. Previously it was a few lines shorter, but this works better in worst case
	 * scenarios. 
	 * 
	 */
	private void transaction() {
		// Used to store user input
		String option;
		
		// Loops until a definitive transaction option is chosen
		boolean finishedWithTransaction = false;
		do {
			System.out.println("    (1) Deposit");
			System.out.println("    (2) Withdraw");
			System.out.println("    (3) View Balance");
			System.out.println("Enter 1, 2, or 3. Enter 0 to logout");
			// Reads user input from scanner
			option = sc.nextLine();
			try {
				// Parses string into integer to read options
				switch(Integer.parseInt(option)) {
				case 0:
					// Logs the user out if they so choose
					logout();
					// Indicates a menu option has been chosen
					finishedWithTransaction = true;
					break;
				case 1:
					// Guides the user through depositing money
					deposit();
					// Indicates a menu option has been chosen
					finishedWithTransaction = true;
					break;
				case 2:
					// Guides the user through withdrawing money
					withdraw();
					// Indicates a menu option has been chosen
					finishedWithTransaction = true;
					break;
				case 3:
					// Gives the user their balance
					viewBalance();
					// Indicates a menu option has been chosen
					finishedWithTransaction = true;
					break;
				default:
					// If an invalid option is entered, we will throw an exception
					throw new NoSuchOptionException();
				}
			} catch (NumberFormatException e) {
				// Displays when we can't parse the string into an integer
				System.out.println("Sorry, we couldn't read that. Here are your options: ");
			} catch (NoSuchOptionException e) {
				// Tells the user that the gave us an invalid option
				System.out.println("Sorry, that was an invalid option. Here are your choices: ");
			}
			// If no valid transaction option was chosen, we will loop
		} while(!finishedWithTransaction);
		
		// When the transaction is finished, serialize this class into the file indicated.
		serialize();
	}
	
	/*
	 * 
	 * This is the method that guides the user through creating an account. It does checks to see if
	 * the username has been taking, and makes sure that the password the user inputs is the one they 
	 * want by making them enter it twice.
	 * 
	 */
	private void createAccount() {
		System.out.println("Enter an email or username: ");
		// Used to store the new user's username
		String username;
		
		// Loops until a unique username is created
		boolean used = false;
		do {
			// Reads from the scanner
			username = sc.nextLine();
			// If there is no one in the accounts list yet, skip checking for a unique name
			if(accounts.isEmpty()) {
				break;
			}
			// In case the user reenters the loop, we reset the used marker
			used = false;
			// Goes through every account in the ArrayList
			for(Account person: accounts) {
				// If there is a match, we tell the user, and make them choose a new username
				if(username.toLowerCase().equals(person.getUsername())) {
					System.out.println("Sorry, username or email is taken. Please enter another: ");
					used = true;
					break;
				}
			}
			// If the username is unique, we exit the loop
		} while (used);
		
		System.out.println("Enter a password: ");
		// Stores user's password
		String password;
		// Stores confirmation of user's password
		String confirmPassword;
		
		// Loops until password and confirmPassword match
		boolean validPassword = false;
		do {
			// Reads from scanner
			password = sc.nextLine();
			System.out.println("Confirm password by typing it again: ");
			// Reads from scanner again
			confirmPassword = sc.nextLine();
			if(!confirmPassword.equals(password)) {
				System.out.println("Password doesn't match!");
				System.out.println("Re-enter password: ");
				// If they don't match, tell the user to re-do their password information
				validPassword = false;
			} else {
				// If they do match, the user can continue
				validPassword = true;
			}
		} while(!validPassword);
		
		
		// Add this user to the accounts ArrayList
		accounts.add(new Account(username.toLowerCase(), password, 0));
		// Serialize the class now that a new account has been created
		serialize();
		// Get the current users index in the ArrayList
		newCurrentUser(new Account(username.toLowerCase(), password, 0));
	}
	
	/*
	 * 
	 * This method signs the user into their account. Each time sign in fails, we ask the user 
	 * if they want to try again or just exit. This accounts for users who try to log in but 
	 * don't have an account.
	 * 
	 */
	private void login() {
		// Stores user's username
		String username;
		// Stores user's password
		String password;
		
		// Loops until a user logs in with correct information
		boolean match = false;
		do {
			System.out.println("Enter your username/email: ");
			// Reads from the scanner
			username = sc.nextLine();
			System.out.println("Enter your password: ");
			// Reads from the scanner
			password = sc.nextLine();
			// Checks each account if the username and password match
			for(Account person : accounts) {
				if(username.toLowerCase().equals(person.getUsername()) && password.equals(person.getPassword())) {
					// If they do match, indicate that and set the current user to that account
					match = true;
					newCurrentUser(person);
				}
			}
			//If there was no match, ask the user to try again
			if(!match) {
				
				String option;
				boolean validYesNo = false;
				do {
					System.out.println("Username or password didn't match. Do you want to try again?");
					System.out.println("Enter 'y' for yes or 'n' for no");
					option = sc.nextLine();
					if(option.toLowerCase().equals("y")) {
						//if yes, continue
						validYesNo = true;
					} else if(option.toLowerCase().equals("n")) {
						// If no, just log out
						validYesNo = true;
						// Set match to true so that we don't loop
						match = true;
						// Log out
						logout();
					} else {
						// If neither a 'y' or 'n' are entered, ask them to try again.
						System.out.println("Could not recognize input.");
					}
				} while(!validYesNo);
			}
		} while(!match);
	}
	
	
	/*
	 * 
	 * This is a very simple method that sets the loggedOut flag. This allows any other method to call
	 * it so that you can exit from anywhere during your time with the bank.
	 * 
	 */
	private void logout() {
		// Sets loggerOut flag to true
		this.loggedOut = true;
		System.out.println("Thank you for banking with us at " + name + "!");
	}
	
	
	/*
	 * 
	 * This method guides the user through making a deposit. It does data validation to 
	 * make sure that the user doesn't try to give the bank negative money.
	 * 
	 */
	private void deposit() {
		// Stores the string user input
		String amountString;
		// Stores the converted string input
		float amount = 0;
		
		// Loops until a valid deposit is made
		boolean validDeposit = false;
		do {
			System.out.println("How much would you like to deposit?");
			// Reads from scanner
			amountString = sc.nextLine();
			try {
				// Parses stored string input
				amount = Float.parseFloat(amountString);
				// Checks if the amount is negative
				if(amount < 0) {
					// Throws a custom exception if so
					throw new NegativeNumberException();
				}
				// If no exceptions are made, the user entered a valid deposit
				validDeposit = true;
			} catch(NumberFormatException e) {
				// Tells the user that they gave a non-float
				System.out.println("Sorry, that's an invalid input");
			} catch (NegativeNumberException e) {
				// Tells the user they can't give the bank negative money
				System.out.println("Sorry, you can't deposit negative money.");
			}
			// Exits once validDeposit is set true
		} while(!validDeposit);
		
		// Adds the amount to the account's balance
		accounts.get(currentUser).addToBalance(amount);
		// Tells the user how much money they deposited
		System.out.println("We've added $" + amount + " to your account!");
		// Tells the user their current balance
		viewBalance();
	}
	
	/*
	 * 
	 * This method guides the user through money withdrawl, validating that they don't withdraw
	 * more money than they have on their account
	 * 
	 */
	private void withdraw() {
		// Used to store string input
		String amountString;
		// Used to store parsed string 
		float amount = 0;
		
		// Loops until a valid withdrawl is made
		boolean validWithdrawl = false;
		do{
			// Tell the user how much money they have in their account so they don't withdraw too much
			viewBalance();
			System.out.println("How much would you like to withdraw?");
			// Reads from the scanner
			amountString = sc.nextLine();
			try {
				// Parse input into a float
				amount = Float.parseFloat(amountString);
				// If the user tries to pull out more than their balance throw an exception
				if(accounts.get(currentUser).getBalance() - amount < 0) {
					throw new NegativeNumberException();
				}
				// If the amount is parsed and validation for over withdrawing is passed, the user can continue
				validWithdrawl = true;
			} catch(NumberFormatException e) {
				// Displayed when something other than a number is entered
				System.out.println("Sorry, that's an invalid input");
			} catch (NegativeNumberException e) {
				// Displayed when the user withdraws too much
				System.out.println("Sorry, you can't withdraw more than what's in your account.");
			}
		} while(!validWithdrawl);
		
		// Removes money from balance
		accounts.get(currentUser).removeFromBalance(amount);
		// Confirms how much has been withdrawn
		System.out.println("We've removed $" + amount + " to your account!");
		// Tells the user how much money they have after the transaction
		viewBalance();
	}
	
	/*
	 * 
	 * A simple method that just tells the user how much money they have
	 * 
	 */
	private void viewBalance() {
		System.out.println("Your balance is $" + accounts.get(currentUser).getBalance());
	}
	
	/*
	 * 
	 * Method to set the current user's index to be referenced. It takes in the account and then
	 * searches for it in the accounts ArrayList. Validation to see if this user is in the ArraList
	 * is done before calling this method
	 * 
	 */
	private void newCurrentUser(Account person) {
		for(int i = 0; i < accounts.size(); i++) {
			if(person.getUsername().equals(accounts.get(i).getUsername())) {
				// Set currentUser
				this.currentUser = i;
			}
		}
	}
	
	/*
	 * 
	 * This method is used to persist the Bank through several runs of this program
	 * 
	 */
	private static void serialize() {
		try {
			// Create a FileOutPutStream from the data path indicated
			FileOutputStream fos = new FileOutputStream(dataPath);
			// Create an ObjectOutputStream from the FileOutPutStream
			ObjectOutputStream oos = new ObjectOutputStream(fos);
			// Write the object into the file
			oos.writeObject(myBank);
			// Close both resources
			oos.close();
			fos.close();
		} catch (IOException e) {
			// If something goes wrong, print the stack trace
			e.printStackTrace();
		}
	}
	
	/*
	 * 
	 * This allows you to get an instance of the singleton
	 * 
	 */
	public static Bank getInstance() {
		// If no bank has been established, get one from the file
		if(myBank == null) {
			try {
				// Create a FileInputStream from the data path
				FileInputStream fis = new FileInputStream(dataPath);
				// Create an ObjectOutPutStream from the FilInputStream
				ObjectInputStream ois = new ObjectInputStream(fis);
				
				// Create new bank object and store it in the bank instance
				myBank = (Bank) ois.readObject();
				
				// Close resources
				ois.close();
				fis.close();
				
			//If anything goes wrong, print stack traces
			} catch (IOException e) {
				e.printStackTrace();
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}
		}
		// Return the instance of bank either created or stored previously
		return myBank;
	}

	/*
	 * 
	 * Used to maintain the singleton by not allowing a clone from this class
	 * 
	 */
	@Override
	public Object clone() throws CloneNotSupportedException {
		throw new CloneNotSupportedException();
	}
	
}
