package com.adora.app;
import java.util.List;
import java.util.Scanner;

public class BankMenu {
	
	private static String border = "******************************";
	private static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		System.out.println(border);
		System.out.println("*  Welcome to Bank of Adora  *");
		System.out.println(border);

		displayMainMenu();
		

	}
	
	
	private static void displayMainMenu() {
		int option = 0;
		int tries = 0;
		
		// loop for main menu
		while (true) {
			try {	
				System.out.println();
				System.out.println(border);
				System.out.println("*          Main Menu         *");
				System.out.println(border);
				String mainMenu = String.format("[1] Login with existing account\n"
						+ "[2] Create a new account\n[3] Close app");
				System.out.println(mainMenu);
				
				option = Integer.parseInt(sc.nextLine());
				
				switch(option) {
				case 1: 
					tries = 0;
					loginMenu();
					break;
				case 2:
					tries = 0;
					createAccountMenu();
					break;
				case 3: 
					System.out.println("Thank you for using Bank of Adora. Goodbye.");
					return;
				default:
					System.out.println(option + " is not a valid menu option.");
				}
				
			} catch (NumberFormatException e) {
	
				System.out.println("Please enter one of the menu options.");
				
			} finally {
				tries++;
				if(tries >= 3) {
					System.out.println("Please try again later. Goodbye.");
					return;
				} 
			}	
		}	
	}

	
	private static void loginMenu() {

		int tries = 0;
		
		String username, password;
		System.out.println();
		System.out.println(border);
		System.out.println("*         Login Menu         *");
		System.out.println(border);
		
		while(true) {
			
			System.out.println();
			System.out.print("Username: ");
			username = sc.nextLine();
			System.out.print("Password: ");
			password = sc.nextLine();
			
			LoginManager.login(username, password);
			
			if(LoginManager.isLoggedIn()) {
				chooseAccountMenu();
				return;
			} else {
				tries++;
				if(tries >= 3) {
					System.out.println("Invalid username/password. Too many attempts. Try again later.");
					return;
				}
				System.out.println("The username and/or password provided was invalid. Try again.");
			}	
		}
	}
	
	
	

	
	private static void chooseAccountMenu() {

		System.out.println();
		System.out.println();
		System.out.println(border);
		System.out.println("*         Account Menu         *");
		System.out.println(border);
		
		
		List<String> accounts = AccountManager.getAccountList();
		
		//choosing an account menu
		
		int accountIndex = -1;
		boolean loggedIn =  true;
		
		while (loggedIn) {
			int i = 1;
			System.out.println("Please choose an account: ");
			for(String account : accounts) {
				System.out.println(String.format("[%02d] %s", i, account));
				i++;
			}
			
			System.out.println(String.format("[%02d] Logout", i));
			try {
				accountIndex = Integer.parseInt(sc.nextLine());
				if(accountIndex > 0 && accountIndex  <= accounts.size()) {
					AccountManager.setCurrentAccount(accountIndex - 1);
					loggedIn = accessAccountMenu();
				} else if (accountIndex == (accounts.size() + 1)){
					LoginManager.logout();
					return;
				} else
					System.out.println("That was not a valid option. Please try again.\n");
				
			} catch (NumberFormatException e) {
				System.out.println("That was not a valid option. Please try again.\n");
			} 
			
		}
		LoginManager.logout();
	}

	

	private static boolean accessAccountMenu() {
		
		boolean loggedIn = true;
		
		System.out.println();
		System.out.println();
		System.out.println(border);
		System.out.println("*     Account Actions    *");
		System.out.println(border);
		
		while(loggedIn) {
		
			
			
			System.out.println("Please choose a menu option.");
			System.out.println("[1] View balance");
			System.out.println("[2] Deposit money");
			System.out.println("[3] Withdraw money");
			System.out.println("[4] Swith accounts");
			System.out.println("[5] Log out");
			
			try {
				int option = Integer.parseInt(sc.nextLine());
				
				switch(option) {
				case 1: 
					System.out.println(String.format("The current balance is $%.2f\n", AccountManager.getBalance()));
					break;
				case 2:
					System.out.println("How much would you like to deposit?");
					try {
						double amount = Double.parseDouble(sc.nextLine());
						AccountManager.deposit(amount);
					} catch (NumberFormatException e) {
						System.out.println("That was not a valid number. Withdrawal not processed.\n");
					}
					break;
				case 3:
					System.out.println("How much would you like to withdraw?");
					try {
						double amount = Double.parseDouble(sc.nextLine());
						AccountManager.withdraw(amount);
					} catch (NumberFormatException e) {
						System.out.println("That was not a valid number. Withdrawal not processed.\n");
					}
				break;
				case 4: 
					return true;
				case 5:
					return false;
				default:
					System.out.println("You did not enter a valid option.");
					break;
				}
				
			} catch (NumberFormatException e) {
				System.out.println("That was not a valid option. Please try again.");
			} finally {
				
			}
		}
		
		
		
		return false;
	}
	
	/**
	 * This method contains the logic for the menu loop for creating a new account
	 */
	private static void createAccountMenu() {
		System.out.println();
		System.out.println("Create a new account");
		
		System.out.println();
		System.out.println("Username must be more than 5 characters long and have no spaces.");
		System.out.println("Password must be at least 8 characters long and have no spaces\n");
		System.out.print("Please enter a username: ");
		String username = sc.nextLine();
		
		
		// user name validation loop
		boolean validUsername = false;
		int tries = 0;
		while(!validUsername) {
			
			validUsername = LoginManager.isValidUsername(username);
			if(validUsername) 
				continue;
			else {
				tries++;
				if(tries > 2) {
					System.out.println("Please try again later.");
					return;
				}
				System.out.print("Enter a user name: ");
				username = sc.nextLine();
			}
		}
		
		// user password validation loop
		boolean match =false, validPassword = false;
		System.out.println("Please enter a password:");
		String password = sc.nextLine();
		String confirmPassword = "";
		tries = 0;
		while(!match) {	
			while(!validPassword) {
				validPassword = LoginManager.isValidPassword(password);
				
				if(validPassword) {
					continue;
				} else {
					tries++;
					if(tries > 2) {
						System.out.println("Please try again later.");
						return;
					}
					System.out.println("Enter a password");
					password = sc.nextLine();
				}
			}
			
			System.out.println("Please confirm the password:");
			confirmPassword = sc.nextLine();
			
			if(password.compareTo(confirmPassword) != 0) {
				System.out.println("Passwords did not match. Try again later.");
				return;
			} else {
				match = true;
			}
		}
		
		// add user to database
		LoginManager.addUser(username, password);
	}
}
