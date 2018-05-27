package com.revature.bank;

import java.text.DecimalFormat;
import java.time.LocalDate;
import java.util.ListIterator;
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
		System.out.println("\nHello, " + account.getUser() + "!");
		System.out.println("[W] - Withdraw money");
		System.out.println("[D] - Deposit money");
		System.out.println("[T] - Make a transfer");
		System.out.println("[C] - Check balance");
		System.out.println("[H] - Show account history");
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
				case 'T':
					transfer(account);
					break;
				case 'C':
					showBankAccountInfo(account);
					break;
				case 'H':
					accountHistory(account);
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
	// returns to account information screen when done
	public void showBankAccountInfo(BankInfo.Account account) {
		System.out.println("\nUsername - " + account.getUser());
		System.out.println("Balance: $" + df.format(account.getBalance()));
		printLoginScreen(account);
	}
	
	// prompts the user for the withdrawal value and notifies the user of their account balance
	// modifies the value in the account provided in the argument
	// creates a Transaction record for the account upon a successful withdrawal
	// returns to account information screen when done
	public void withdraw(BankInfo.Account account) {
		System.out.println("\nCurrent balance: $" + df.format(account.getBalance()));
		System.out.print("\nWithdrawal Amount: $");
		String withdraw = input.nextLine();
		
		try {
			double amount = Double.parseDouble(withdraw);
		
			if(amount > account.getBalance()) {
				System.out.println("\nInsufficient funds.");
				amount = account.getBalance();
			}
			
			if(amount < 0)
				System.out.println("\nCannot withdraw a negative amount of money.");
			else {
				account.setBalance(account.getBalance() - amount);
				account.addTransaction(bankInfo.new 
						Transaction("Withdrawal", "", amount, account.getBalance(), LocalDate.now()));
				
				System.out.println("\nSuccessfully withdrew $" + df.format(amount));
				System.out.println("Remaining balance: $" + df.format(account.getBalance()));
			}
		} catch (NumberFormatException e) {
			System.out.println("\nInvalid input. Returning to main menu...");
		} finally {
			printLoginScreen(account);
		}
	}
	
	// prompts the user for the deposit value and notifies the user of their account balance
	// modifies the value in the account provided in the argument
	// creates a Transaction record for the account upon a successful deposit
	// returns to account information screen when done
	public void deposit(BankInfo.Account account) {
		System.out.println("\nCurrent balance: $" + df.format(account.getBalance()));
		System.out.print("\nDeposit Amount: $");
		String deposit = input.nextLine();
		try {
			double amount = Double.parseDouble(deposit);
			
			if(amount < 0)
				System.out.println("\nCannot deposit a negative amount of money.");
			else {
				account.setBalance(account.getBalance() + amount);
				account.addTransaction(bankInfo.new 
						Transaction("Deposit", "", amount, account.getBalance(), LocalDate.now()));
				
				System.out.println("\nSuccessfully deposited $" + df.format(amount));
				System.out.println("New balance: $" + df.format(account.getBalance()));
			}
		} catch(NumberFormatException e) {
			System.out.println("\nInvalid input. Returning to main menu...");
		} finally {
			printLoginScreen(account);
		}
	}
	
	// prompts the user for all information related to transfers
	// modifies the balances of both accounts related to the transfer
	// creates a Transaction record for each account upon a successful transfer
	// returns to account information screen when done
	public void transfer(BankInfo.Account account) {
		System.out.println("\nCurrent balance: $" + df.format(account.getBalance()));
		System.out.println("Please enter the username / email of the account you wish to transfer to.");
		int acc = -1;
		String transferUser;
		
		do {
			System.out.print("\nUsername / email - ");
			transferUser = input.nextLine();
			acc = findAccount(transferUser);
						
			if(transferUser.equals("")) {
				printLoginScreen(account);
				break;
			}
			else if(acc == -1) {
				System.out.println("\nUsername / email is not linked to an account. Please try again");
			}
			else
				break;
		} while(true);
		
		System.out.print("\nTransfer Amount to " + transferUser + ": $");
		String transfer = input.nextLine();
		try {
			double amount = Double.parseDouble(transfer);
		
			if(amount > account.getBalance())
				System.out.println("\nInsufficient funds. Transfer cancelled.");
			else if(amount < 0)
				System.out.println("\nCannot transfer a negative amount of money.");
			else {
				System.out.println("\nPlease confirm this transfer.");
				System.out.println("\nAmount: $" + df.format(amount));
				System.out.println("From: " + account.getUser());
				System.out.println("To: " + transferUser);
				boolean confirm = false;
				
				do {
					System.out.print("\nIs this correct? (Y / N) - ");
					String confirmation = input.nextLine();
								
					if(confirmation.length() != 1)
						System.out.println("\nPlease enter Y or N.");
					else if(Character.toUpperCase(confirmation.charAt(0)) == 'N') {
						break;
					}
					else if(Character.toUpperCase(confirmation.charAt(0)) == 'Y') {
						confirm = true;
						break;
					}
					else
						System.out.println("\nPlease enter Y or N.");
				} while(true);
				
				if(confirm) {
					account.setBalance(account.getBalance() - amount);
					bankInfo.getAccount(acc).setBalance(bankInfo.getAccount(acc).getBalance() + amount);
					account.addTransaction(bankInfo.new 
							Transaction("TransferTo", transferUser, amount, account.getBalance(), LocalDate.now()));
					bankInfo.getAccount(acc).addTransaction(bankInfo.new 
							Transaction("TransferFrom", account.getUser(), amount,
									bankInfo.getAccount(acc).getBalance(), LocalDate.now()));
					
					System.out.println("\nSuccessfully transfered $" + df.format(amount) + " to " + transferUser);
					System.out.println("Remaining balance: $" + df.format(account.getBalance()));
				}
				else
					System.out.println("\nTransfer cancelled.");
			}
		} catch(NumberFormatException e) {
			System.out.println("\nInvalid input. Returning to main menu...");
		} finally {
			printLoginScreen(account);
		}
	}
	
	// prints the account history in Transactions three at a time
	// prompts user to navigate through remaining Transactions using a ListIterator
	// returns to account information screen when done
	public void accountHistory(BankInfo.Account account) {
		if(account.getTransactions().size() == 0) {
			System.out.println("\nNo transaction history for " + account.getUser());
		}
		else {
			System.out.println("\nAccount History for " + account.getUser() + ":");
			ListIterator<BankInfo.Transaction> lt = account.getTransactions().listIterator();
			int idx = 0;
			int endIdx = 0;
			
			do {
				System.out.println("\n===============================================");
				if(endIdx > idx)
					do {
						lt.previous();
					} while(lt.previousIndex() >= idx);
				for(int i = idx; i < idx + 3 && lt.hasNext(); i++) {
					System.out.println(lt.next().toString());
					System.out.println("===============================================");
					endIdx = i;
				}
				
				if(idx > 0) {
					System.out.print("1...");
				}
				System.out.print((idx + 1) + " - " + (endIdx + 1));
				if(endIdx < account.getTransactions().size() - 1) {
					System.out.print("..." + account.getTransactions().size());
				}
			
				boolean noInput = true;
				char option = '1';
				do{
					System.out.println("\n");
					if(idx > 0)
						System.out.println("[P] - Previous");
					if(endIdx < account.getTransactions().size() - 1)
						System.out.println("[N] - Next");
					System.out.println("[E] - Exit");
					
					System.out.print("\nOption: ");
					String confirmation = input.nextLine();
					
					if(!confirmation.equals(null) || !confirmation.equals(""))
						option = Character.toUpperCase(confirmation.charAt(0));
								
					if(confirmation.length() != 1)
						System.out.print("\nPlease enter a valid option.");
					else if(option == 'P' && idx > 0) {
						idx -= 3;
						noInput = false;
					}
					else if(option == 'N' && endIdx < account.getTransactions().size() - 1) {
						idx += 3;
						noInput = false;
					}
					else if(option == 'E') {
						noInput = false;
					}
					else
						System.out.print("\nPlease enter a valid option.");
				} while(noInput);
				
				if(option == 'E')
					break;
			} while(true);
		}
		
		printLoginScreen(account);
	}
}
