package com.revature.bank;

import java.text.DecimalFormat;
import java.util.Scanner;

import com.revature.bank.BankInfo.Account;

/*
 * Bank Menu class for all interactive functionality
 * 
 * Handles information stored in a BankInfo object and prints prompts to the user
 */

public class BankMenu {

	// input scanner and decimal formatter for dollar values
	private static final Scanner input = new Scanner(System.in);
	private static final DecimalFormat df = new DecimalFormat("#0.00");
	
	private BankInfo bankInfo;
	
	public BankMenu() {
		super();
		bankInfo = new BankInfo();
	}
	
	public BankMenu(BankInfo bankInfo) {
		this.bankInfo = bankInfo;
	}
	
	// searches through the accounts for the String argument user
	// returns true if the username is available, false otherwise
	private boolean isAvailable(String user) {
		boolean avail = true;
		for(int i = 0; i < bankInfo.getAccounts().size() && avail; i++) {
			if(user.equals(bankInfo.getAccounts().get(i).getUser())) 
				avail = false;
		}
		return avail;
	}
	
	// searches through the accounts for the String argument user
	// returns the index of the Account with username user, -1 if not found
	private int findAccount(String user) {
		int acc = -1;
		for(int i = 0; i < bankInfo.getAccounts().size(); i++) {
			if(user.equals(bankInfo.getAccounts().get(i).getUser())) {
				acc = i;
				break;
			}
		}
		return acc;
	}
	
	// creates an Account object with the information given by the user
	// user input of Enter through the prompts returns the user to the home screen
	public void createLogin() {
		System.out.println("\nPlease enter the following information.");
		System.out.println("(or press Enter through the prompts to return to the Home screen)");
		System.out.print("\nUsername / email - ");
		String newUser = input.nextLine();
		
		while(!isAvailable(newUser)) {
			System.out.println("\nThis username / email is already linked to an account.");
			
			System.out.print("\nUsername / email - ");
			newUser = input.nextLine();
		}
		
		// possible password specifications
		System.out.print("Password - ");
		String newPass = input.nextLine();
		
		System.out.print("Repeat Password - ");
		String newPass2 = input.nextLine();
		
		while(!newPass.equals(newPass2)) {
			System.out.println("\nPasswords do not match.\n");
			
			System.out.print("Password - ");
			newPass = input.nextLine();
			
			System.out.print("Repeat Password - ");
			newPass2 = input.nextLine();
		}
		
		if(!(newUser.equals("") && newPass.equals("") && newPass2.equals(""))) {
			Account r = bankInfo.new Account(newUser, newPass);
			bankInfo.addAccount(r);
			System.out.println("\nYour account has been created. Thank you for joining Boulos Bank!");
		}
		
		printHome();
	}
	
	// compares user input to the accounts stored in bankInfo
	// if user and pass match account details, user gains access to the account's profile
	// user input of Enter through the prompts returns the user to the home screen
	public void logIn() {
		System.out.println("\nPlease enter your information.");
		System.out.println("(or press Enter through the prompts to return to the Home screen)");
		int acc = -1;
		do {
			System.out.print("\nUsername / email - ");
			String loginUser = input.nextLine();
			acc = findAccount(loginUser);
			System.out.print("Password - ");
			String loginPass = input.nextLine();
						
			if(loginUser.equals("") && loginPass.equals("")) {
				printHome();
				break;
			}
			else if(acc == -1) {
				System.out.println("\nUsername / email is not linked to an account. Please try again");
			}
			else if(!bankInfo.getAccounts().get(acc).getPass().equals(loginPass)) {
				System.out.println("\nPassword is incorrect. Please try again.");
			}
			else {
				bankInfo.setAccountNumber(acc);
				printLoginScreen(bankInfo.getAccounts().get(acc));
				break;
			}
		} while(true);
	}
	
	// prints the home screen, along with all possible options for the user
	// methods called by this method usually end with a printHome() call
	// or a printLoginScreen() call to keep the program running
	public void printHome() {
		System.out.println("\nWelcome to Boulos Bank!");
		System.out.println("Your premier banking solution in the Reston area!\n");
		System.out.println("[L] - Log in");
		System.out.println("[R] - Register");
		System.out.println("[Q] - Quit");
		
		System.out.print("\nOption: ");
		String option = input.nextLine();
		boolean optionChosen = false;
		
		while(!optionChosen) {
			if(option.length() != 1) {
				System.out.println("\nInvalid option.");
				
				System.out.print("\nOption: ");
				option = input.nextLine();
			}
			
			else {
				optionChosen = true;
				switch(Character.toUpperCase(option.charAt(0))) {
				case 'L':
					logIn();
					break;
				case 'R':
					createLogin();
					break;
				case 'Q':
					System.out.println("\nSee you soon!");
					break;
				default:
					optionChosen = false;
					System.out.println("\nInvalid option.");
					
					System.out.print("\nOption: ");
					option = input.nextLine();
				}
			}
		}
	}
	
	// prints the account information screen, along with all possible options for the user
	// methods called by this method usually end with a printLoginScreen() call
	// or a printHome() call to keep the program running
	public void printLoginScreen(Account account) {
		System.out.println("\nBank Account information for - " + account.getUser());
		System.out.println("[W] - Withdraw money");
		System.out.println("[D] - Deposit money");
		System.out.println("[C] - Check balance");
		System.out.println("[L] - Log out");
		
		System.out.print("\nOption: ");
		String option = input.nextLine();
		boolean optionChosen = false;
		
		while(!optionChosen) {
			if(option.length() != 1) {
				System.out.println("\nInvalid option.");
				
				System.out.print("\nOption: ");
				option = input.nextLine();
			}
			
			else {
				optionChosen = true;
				switch(Character.toUpperCase(option.charAt(0))) {
				case 'W':
					withdraw(account);
					break;
				case 'D':
					deposit(account);
					break;
				case 'C':
					showBankAccountInfo(account);
					break;
				case 'L':
					System.out.println("\nLogging out...");
					bankInfo.setAccountNumber(-1);
					printHome();
					break;
				default:
					optionChosen = false;
					System.out.println("\nInvalid option.");
					
					System.out.print("\nOption: ");
					option = input.nextLine();
				}
			}
		}
	}
	
	// shows the username and balance for the account in the argument
	public void showBankAccountInfo(BankInfo.Account account) {
		System.out.println("\nUsername - " + account.getUser());
		System.out.println("Balance: $" + df.format(account.getBalance()));
		printLoginScreen(account);
	}
	
	// prompts the user for the withdrawal value and notifies the user of their account balance
	// modifies the value in the account provided in the argument
	public void withdraw(BankInfo.Account account) {
		System.out.println("\nCurrent balance: $" + df.format(account.getBalance()));
		System.out.print("\nWithdrawal Amount: $");
		String withdraw = input.nextLine();
		double amount = Double.parseDouble(withdraw);
		
		if(amount > account.getBalance()) {
			System.out.println("\nInsufficient funds.");
			amount = account.getBalance();
		}
		
		account.setBalance(account.getBalance() - amount);
		
		System.out.println("\nWithdrew $" + df.format(amount));
		System.out.println("Remaining balance: $" + df.format(account.getBalance()));
		printLoginScreen(account);
	}
	
	// prompts the user for the deposit value and notifies the user of their account balance
	// modifies the value in the account provided in the argument
	public void deposit(BankInfo.Account account) {
		System.out.println("\nCurrent balance: $" + df.format(account.getBalance()));
		System.out.print("\nDeposit Amount: $");
		String deposit = input.nextLine();
		double amount = Double.parseDouble(deposit);
		
		account.setBalance(account.getBalance() + amount);
		
		System.out.println("\nDeposited $" + df.format(amount));
		System.out.println("New balance: $" + df.format(account.getBalance()));
		printLoginScreen(account);
	}
}
