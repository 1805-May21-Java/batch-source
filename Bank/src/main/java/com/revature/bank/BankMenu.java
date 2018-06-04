package com.revature.bank;

import java.sql.Date;
import java.text.DecimalFormat;
import java.time.LocalDate;
import java.util.*;

import com.revature.dao.BankDAOImpl;

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
	private BankDAOImpl dao;
	
	public BankMenu() {
		super();
		dao = new BankDAOImpl();
		bankInfo = new BankInfo();
	}
	
	public BankMenu(BankInfo bankInfo) {
		super();
		dao = new BankDAOImpl();
		this.bankInfo = bankInfo;
	}
	
	/*
	 * Searches through the user table for the String argument user
	 * 
	 * Returns true if the username is available, false otherwise
	 */
	private boolean isAvailable(String user) {
		if(dao.getUserByName(user) == null)
			return true;
		return false;
	}
	
	// searches through the accounts for the String argument user
	// returns the index of the Account with username user, -1 if not found
	/* private int findAccount(String user) {
		int acc = -1;
		for(int i = 0; i < bankInfo.getAccounts().size(); i++) {
			if(user.equals(bankInfo.getAccounts().get(i).getUser())) {
				acc = i;
				break;
			}
		}
		return acc;
	} */
	
	/* Creates a User object with the information given by the user
	 * then persists the data in the SQL database
	 * 
	 * User input of Enter through any of the prompts voids the process
	 */
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
		
		if(!(newUser.equals("") || newPass.equals("") || newPass2.equals(""))) {
			User r = new User(newUser, newPass);
			dao.createUser(r);
			System.out.println("\nYour account has been created. Thank you for joining Boulos Bank!");
		}
		
		printHome();
	}
	
	/*
	 * Compares user input to the user records in the SQL database
	 * 
	 * If user and pass match record details, user gains access to the user profile
	 * 
	 * User input of Enter through any of the prompts voids the process
	 */
	public void logIn() {
		do {
			System.out.println("\nPlease enter your information.");
			System.out.println("(or press Enter through the prompts to return to the Home screen)");
			
			System.out.print("\nUsername / email - ");
			String loginUser = input.nextLine();
			System.out.print("Password - ");
			String loginPass = input.nextLine();
			
			User user = dao.getUserByName(loginUser);
						
			if(loginUser.equals("") || loginPass.equals("")) {
				printHome();
				break;
			}
			else if(user == null) {
				System.out.println("\nUsername / email is not linked to an account. Please try again.");
			}
			else if(!user.getPass().equals(loginPass)) {
				System.out.println("\nPassword is incorrect. Please try again.");
			}
			else {
				bankInfo.setUser(user);
				printUserScreen(user);
				break;
			}
		} while(true);
	}
	
	/*
	 * Prints the home screen, along with all possible options for the user
	 *  
	 * Methods called by this method usually end with a printHome() call
	 * or a printLoginScreen() call to keep the program running
	 */
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
					System.exit(0);
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
	
	/*
	 * Opens new bank account with the user information provided
	 * 
	 * Persists the new account information, along with the link to the user,
	 * in the SQL database
	 */
	public void openNewAccount() {
		Random r = new Random();
		
		System.out.println("\nThank you for placing your trust in Boulos Bank!");
		
		System.out.println("\nYou may specify a nickname for this new account.");
		System.out.println("(Press Enter to skip this step)");
		System.out.print("\nNickname: ");
		
		String nickname = input.nextLine();
		
		if(nickname.equals(""))
			nickname = null;
		
		int accountID = r.nextInt(90000) + 10000;
		while(dao.getAccountByID(accountID) != null)
			accountID = r.nextInt(90000) + 10000;
		
		System.out.println("\nPlease confirm this account creation.");
		System.out.println("New Account #" + accountID);
		if(!nickname.equals(null))
			System.out.println("Nickname - " + nickname);
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
			Account acc = new Account(accountID, 0, nickname);
			dao.createAccount(acc);
			dao.createLink(bankInfo.getUser().getUser(), accountID);
			
			dao.createTransaction(new Transaction("Open", bankInfo.getUser().getUser(), 0,
					acc.getBalance(), Date.valueOf(LocalDate.now()), acc.getId()), acc.getId());
			
			System.out.println("\nSuccessfully opened new Account #" + accountID);
			System.out.println("You may now access the Account menu for this account.");
		}
		else
			System.out.println("\nAccount opening cancelled.");
		
		printUserScreen(dao.getUserByName(bankInfo.getUser().getUser()));
	}
	
	/*
	 * Opens new bank account with the user information provided
	 * 
	 * Persists the new account information, along with the link to the user,
	 * in the SQL database
	 */
	public void changePassword() {
		System.out.print("\nPassword - ");
		String newPass = input.nextLine();
		
		System.out.print("Repeat Password - ");
		String newPass2 = input.nextLine();
		
		if(!newPass.equals("") && !newPass2.equals("")) {
			while(!newPass.equals(newPass2)) {
				System.out.println("\nPasswords do not match.\n");
				
				System.out.print("Password - ");
				newPass = input.nextLine();
				
				System.out.print("Repeat Password - ");
				newPass2 = input.nextLine();
			}
			
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
				User newUser = bankInfo.getUser();
				newUser.setPass(newPass);
				dao.updateUser(newUser);
				
				System.out.println("\nPassword successfully updated. For security purposes, you must log in again");
				logIn();
			}
			else
				System.out.println("\nPassword update cancelled.");
		}
		
		printUserScreen(dao.getUserByName(bankInfo.getUser().getUser()));
	}
	/*
	 * Prints the user information screen, along with all possible options for the user
	 *
	 * Methods called by this method usually end with a print[something]() call
	 * to keep the program running
	 */
	public void printUserScreen(User user) {
		System.out.println("\nHello, " + user.getUser() + "!");
		
		boolean optionChosen = false;
		
		while(!optionChosen) {
			System.out.println();
			
			for(int i = 0; i < user.getAccounts().size(); i++) {
				Account acc_i = dao.getAccountByID(user.getAccounts().get(i));
				System.out.print("[" + (i + 1) + "] - ");
				
				if(acc_i.getNickname() != "")
					System.out.print(acc_i.getNickname());
				else
					System.out.print("Account #" + acc_i.getId());
				
				System.out.println(" | $" + df.format(acc_i.getBalance()));
				
				if(i == user.getAccounts().size() - 1)
					System.out.println();
			}
			
			System.out.println("[A] - Open new account");
			System.out.println("[P] - Change password");
			System.out.println("[L] - Log out");
			
			System.out.print("\nOption: ");
			String option = input.nextLine();

			if(option.length() == 0)
				System.out.println("\nInvalid option.");
			
			else if(Character.isDigit(option.charAt(0))) {
				optionChosen = true;
				int acc = -1;
				
				try {
					acc = Integer.parseInt(option);
				} catch(NumberFormatException e) {
					optionChosen = false;
					System.out.println("\nInvalid option.");
				}
				
				if(optionChosen) {
					if(acc < 1 || acc > user.getAccounts().size()) {
						optionChosen = false;
						System.out.println("\nInvalid option.");
					}
					else {
						printAccountScreen(dao.getAccountByID(user.getAccounts().get(acc - 1)));
					}
				}
			}
			
			else {
				optionChosen = true;
				
				switch(Character.toUpperCase(option.charAt(0))) {
				case 'A':
					openNewAccount();
					break;
				case 'P':
					changePassword();
					break;
				case 'L':
					System.out.println("\nLogging out...");
					bankInfo.setUser(null);
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
	
	public void printAccountScreen(Account account) {
		System.out.println("\nAccount #" + account.getId() + "\n");
		
		System.out.println("[A] - Add user to account");
		System.out.println("[R] - Remove user from account");
		System.out.println("[N] - Change or set account nickname");
		System.out.println("[W] - Withdraw money");
		System.out.println("[D] - Deposit money");
		System.out.println("[T] - Make a transfer");
		System.out.println("[I] - Account information");
		System.out.println("[H] - Show account history");
		System.out.println("[B] - Back");
		
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
				case 'A':
//					addUser(account);
					break;
				case 'R':
//					removeUser(account);
					break;
				case 'N':
//					changeNickname(account);
					break;
				case 'W':
					withdraw(dao.getAccountByID(account.getId()));
					break;
				case 'D':
					deposit(dao.getAccountByID(account.getId()));
					break;
				case 'T':
					transfer(dao.getAccountByID(account.getId()));
					break;
				case 'I':
					showBankAccountInfo(account);
					break;
				case 'H':
					accountHistory(account);
					break;
				case 'B':
					printUserScreen(bankInfo.getUser());
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
	
	/*
	 * Shows the username and balance for the account in the argument
	 * 
	 * Returns to account information screen when done
	 */
	public void showBankAccountInfo(Account account) {
		System.out.println("\nAccount holders - ");
		
		for(int i = 0; i < account.getUsers().size(); i++) {
			if(i != 0)
				System.out.print(", ");
			System.out.print(account.getUsers().get(i));
		}
		
		System.out.println("\nBalance: $" + df.format(account.getBalance()));
		printAccountScreen(account);
	}
	
	/*
	 * Prompts the user for the withdrawal value and notifies the user of their account balance
	 * 
	 * Persists the data for a successful withdrawal in the SQL database
	 * 
	 * Creates a Transaction record for the account upon a successful withdrawal
	 * 
	 * Returns to account information screen when done
	 */
	public void withdraw(Account account) {
		System.out.println("\nCurrent balance: $" + df.format(account.getBalance()));
		System.out.print("\nWithdrawal Amount: $");
		String withdraw = input.nextLine();
		
		try {
			double amount = Double.parseDouble(withdraw);
		
			if(amount > account.getBalance()) {
				System.out.println("\nInsufficient funds.");
				amount = account.getBalance();
			}
			else if(amount < 0.01)
				System.out.println("\nInvalid withdrawal amount.");
			else {
				account = dao.getAccountByID(account.getId());
				account.setBalance(account.getBalance() - amount);
				dao.updateAccount(account);
				dao.createTransaction(new Transaction("Withdrawal", bankInfo.getUser().getUser(), amount,
						account.getBalance(), Date.valueOf(LocalDate.now()), account.getId()), account.getId());
				
				System.out.println("\nSuccessfully withdrew $" + df.format(amount));
				System.out.println("Remaining balance: $" + df.format(account.getBalance()));
			}
		} catch (NumberFormatException e) {
			System.out.println("\nInvalid input. Returning to main menu...");
		} finally {
			printAccountScreen(dao.getAccountByID(account.getId()));
		}
	}
	
	/*
	 * Prompts the user for the deposit value and notifies the user of their account balance
	 *
	 * Persists the data for a successful deposit in the SQL database
	 * 
	 * Creates a Transaction record for the account upon a successful deposit
	 * 
	 * Returns to account information screen when done
	 */
	public void deposit(Account account) {
		System.out.println("\nCurrent balance: $" + df.format(account.getBalance()));
		System.out.print("\nDeposit Amount: $");
		String deposit = input.nextLine();
		try {
			double amount = Double.parseDouble(deposit);
			
			if(amount < 0.01)
				System.out.println("\nInvalid deposit amount.");
			else {
				account = dao.getAccountByID(account.getId());
				account.setBalance(account.getBalance() + amount);
				dao.updateAccount(account);
				dao.createTransaction(new Transaction("Deposit", bankInfo.getUser().getUser(), amount,
						account.getBalance(), Date.valueOf(LocalDate.now()), account.getId()), account.getId());
				
				System.out.println("\nSuccessfully deposited $" + df.format(amount));
				System.out.println("New balance: $" + df.format(account.getBalance()));
			}
		} catch(NumberFormatException e) {
			System.out.println("\nInvalid input. Returning to main menu...");
		} finally {
			printAccountScreen(dao.getAccountByID(account.getId()));
		}
	}
	
	/*
	 * Prompts the user for all information related to transfers
	 * 
	 * Modifies the balances of both accounts related to the transfer in the SQL server
	 * 
	 * Creates a Transaction record for each account upon a successful transfer
	 * 
	 * Returns to account information screen when done
	 */
	public void transfer(Account account) {
		System.out.println("\nCurrent balance: $" + df.format(account.getBalance()));
		System.out.println("Please enter the Account # of the account you wish to transfer to.");
		int transferAccount;
		
		try {
			do {
				System.out.print("\nAccount # - ");
				String transferInput = input.nextLine();
				transferAccount = Integer.parseInt(transferInput);
							
				if(transferInput.equals("")) {
					printAccountScreen(account);
					break;
				}
				else if(dao.getAccountByID(transferAccount) == null) {
					System.out.println("\nAccount # is not linked to an account. Please try again.");
				}
				else if(dao.getAccountByID(transferAccount).getId() == account.getId())
					System.out.println("\nCannot transfer money to the same account.");
				else
					break;
			} while(true);
			
			System.out.print("\nTransfer Amount to Account #" + transferAccount + ": $");
			String transfer = input.nextLine();

			double amount = Double.parseDouble(transfer);
		
			if(amount > account.getBalance())
				System.out.println("\nInsufficient funds. Transfer cancelled.");
			else if(amount < 0.01)
				System.out.println("\nInvalid transfer amount.");
			else {
				System.out.println("\nPlease confirm this transfer.");
				System.out.println("\nAmount: $" + df.format(amount));
				System.out.println("From Account #" + account.getId());
				System.out.println("To Account #" + transferAccount);
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
					account = dao.getAccountByID(account.getId());
					Account otherAccount = dao.getAccountByID(transferAccount);
					
					account.setBalance(account.getBalance() - amount);
					otherAccount.setBalance(otherAccount.getBalance() + amount);
					
					dao.updateAccount(account);
					dao.updateAccount(otherAccount);
					
					dao.createTransaction(new Transaction("TransferTo", bankInfo.getUser().getUser(), amount,
							account.getBalance(), Date.valueOf(LocalDate.now()), otherAccount.getId()), account.getId());
					dao.createTransaction(new Transaction("TransferFrom", bankInfo.getUser().getUser(), amount,
							otherAccount.getBalance(), Date.valueOf(LocalDate.now()), account.getId()), otherAccount.getId());
					
					System.out.println("\nSuccessfully transfered $" + df.format(amount) + " to Account #" + transferAccount);
					System.out.println("Remaining balance: $" + df.format(account.getBalance()));
				}
				else
					System.out.println("\nTransfer cancelled.");
			}
		} catch(NumberFormatException e) {
			System.out.println("\nInvalid input. Returning to main menu...");
		} finally {
			printAccountScreen(dao.getAccountByID(account.getId()));
		}
	}
	
	/*
	 * Prints the account history in Transactions three at a time
	 * 
	 * Prompts user to navigate through remaining Transactions using a ListIterator
	 * 
	 * Returns to account information screen when done
	 */
	// 
	// 
	public void accountHistory(Account account) {
		if(account.getTransactions().size() == 0) {
			System.out.println("\nNo transaction history for Account #" + account.getId());
		}
		else {
			System.out.println("\nAccount History for Account #" + account.getId() + ":");
			ListIterator<Transaction> lt = account.getTransactions().listIterator();
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
		
		printAccountScreen(dao.getAccountByID(account.getId()));
	}
}
