package com.adora.app;
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
				//go to account menu
				System.out.println("you are logged in.");
				
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
	
	
	

	
//	private static void accountMenu(BankAccount account) {
//		int option;
//		boolean loggedIn = true;
//		
//		System.out.println();
//		System.out.println();
//		System.out.println(border);
//		System.out.println("*       Account Menu       *");
//		System.out.println(border);
//		System.out.println("Please choose one of the following options");
//		
//		while (loggedIn) {
//			
//		String accountMenu = String.format("[1] View balance\n[2] Deposit money\n[3] Withdraw money\n[4] Logout");
//		System.out.println(accountMenu);
//			try {
//				option = Integer.parseInt(sc.nextLine());
//				
//				switch(option) {
//					case 1: 
//						account.viewBalance();
//						break;
//					case 2:
//						account.depositMoney();
//						break;
//					case 3: 
//						account.withdrawMoney();
//						break;
//					case 4:
//						AccountRetriever.update(account);
//						loggedIn = false;
//						break;
//					default: 
//						System.out.println("That is not a valid menu option.");
//				}
//				
//				
//			} catch (NumberFormatException e) {
//				System.out.println("Please enter one of the menu options");
//			} 
//		}
//	}

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
