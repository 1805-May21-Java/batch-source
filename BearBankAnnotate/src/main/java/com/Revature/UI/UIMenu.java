package com.Revature.UI;

import java.util.List;
import java.util.Scanner;

import com.Revature.BankExceptions.InsufficientFunds;
import com.Revature.Dao.BankAccountDao;
import com.Revature.Dao.BankAccountHibernate;
import com.Revature.Dao.UserProfileDao;
import com.Revature.Dao.UserProfileHibernate;
import com.Revature.pojos.BankAccount;
import com.Revature.pojos.UserProfile;

//Implements runnable purely to identify entry point of app
public class UIMenu implements Runnable {
	private Scanner in;
	private UserProfile currentUser;
	private UserProfileDao userDao;
	private BankAccountDao bankDao;

	// Define all different options for user input
	private static final String LOGIN = "login";
	private static final String CREATE = "create";
	private static final String QUIT = "quit";
	private static final String HELP = "help";

	private static final String BALANCE = "balance";
	private static final String WITHDRAW = "withdraw";
	private static final String DEPOSIT = "deposit";
	private static final String TRANSFER = "transfer";
	private static final String ADD = "add";
	private static final String CLOSE = "close";
	private static final String LOGOUT = "logout";
	private static final String PWD = "pwd";
	private static final String DELETE = "delete";

	// Define string lists for options based on user location
	private String[] loginOptions = { LOGIN + "\t\tLogin to existing account", CREATE + "\t\tCreate a new account",
			QUIT + "\t\tQuit the application", HELP + "\t\tReprint this message" };

	private String[] accountOptions = { CREATE + "\t\tCreate a new bank account",
			BALANCE + "\t\tCheck balance of an account", WITHDRAW + "\tWithdraw from an account",
			DEPOSIT + "\t\tDeposit to an account", TRANSFER + "\tTransfer money to another bank account",
			ADD + "\t\tAdd another user to an account", CLOSE + "\t\tCloses a bank account", LOGOUT + "\t\tLogout",
			PWD + "\t\tChange password", DELETE + "\t\tDelete current user", QUIT + "\t\tQuit the application",
			HELP + "\t\tReprint this message" };

	// Create a ui menu object requires dao objects to interact with the db
	public UIMenu() {
		super();
		userDao = new UserProfileHibernate();
		bankDao = new BankAccountHibernate();
		in = new Scanner(System.in);
	}

	// Prints list of options
	private void printOptions(String[] opts) {
		for (String opt : opts) {
			System.out.println(opt);
		}
	}

	// Method for creating a new user profile
	private void createAccount() {
		System.out.print("New Username: ");
		String username = in.nextLine();
		System.out.print("Password: ");
		String password = in.nextLine();

		try {
			// checks if there is a user with that username present
			// true means there is a user that exists already
			if (userDao.checkUsername(username)) {
				System.out.println("Username taken");
			} else { // Attempt to create a user profile
				userDao.createUserProfile(new UserProfile(username, password));
				System.out.println("Profile created successfully");
			}
		} catch (Exception e) {
			 e.printStackTrace();
			System.out.println("We encountered an error");
		}
	}

	// Attempt to login
	private boolean login() {
		boolean rval = false;

		System.out.print("Username: ");
		String username = in.nextLine();
		System.out.print("Password: ");
		String password = in.nextLine();

		try {
			currentUser = userDao.getUserProfile(username, password); // Returns the user
			if (currentUser != null) { // Checks if login was successful based on dao return value
				rval = true;
				System.out.println("Login successful");
			} else {
				System.out.println("Login failed");
			}
		} catch (Exception e) {
			// e.printStackTrace();
			System.out.println("We encountered an error");
		}
		return rval;
	}

	private boolean deleteUserProfile() {
		if (currentUser == null) {
			return false;
		}

		System.out.print("Are you sure you want to delete user (y,n): ");
		String inp = null;
		do {
			inp = in.nextLine();
			if (inp.equals("n")) {
				return false;
			}
		} while (!inp.equals("y")); // Verify user wants to delete his profile

		try {
			// Attempts to delete the current user
			userDao.deleteUserProfile(currentUser.getUsername());
			currentUser = null;
			System.out.println("User deleted");
		} catch (Exception e) {
			System.out.println("We encountered an error");
		}

		return true;
	}

	private void createBankAccount() {
		// Is not needed as the user should never reach this location
		// in the application with a null current user
		if (currentUser == null) {
			return;
		}

		try {
			// Attempts to create a new bank account
			// Should not fail as the user should exist in this scenario
			int pk = bankDao.createBankAccount(null, new BankAccount(0,0f));
			currentUser.getAccounts().add(bankDao.getBankAccount(pk));
//			bankDao.createBankAccount(currentUser, new BankAccount(bankDao.getNextAccountNumber(), 0f));
			userDao.updateUserProfile(currentUser);
			currentUser=userDao.getUserProfile(currentUser.getUsername(), currentUser.getPassword());
			System.out.println("Account creation successful");
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("We encountered an error");
		}
	}

	private void checkBalance() {
		// Is unneccessary
		if (currentUser == null) {
			return;
		}

		try {
			// Attempts to get all bank accounts
			// Under the current user
			List<BankAccount> accList = currentUser.getAccounts();
			if (accList.size() == 0) {
				System.out.println("You do not have any bank accounts");
				return;
			}

			// Prints all bank account numbers and balances
			// Either this or have the user select a
			// specific bank account by number
			// which would require more input
			for (BankAccount acc : accList) {
				System.out.println(acc);
			}
		} catch (Exception e) {
			System.out.println("We encountered an error");
		}
	}

	private void deleteBankAccount() {
		if (currentUser == null) {
			return;
		}

		try {
			// Gets all bank accounts to display the balance and account number
			// so the user can select an account to close
			List<BankAccount> accList = currentUser.getAccounts();
			if (accList.size() == 0) {
				System.out.println("You do not have any accounts to delete");
				return;
			}

			// Output all user owned accounts
			for (BankAccount acc : accList) {
				System.out.println(acc);
			}

			System.out.print("\nAccount Number: ");
			String inp = in.nextLine();
			int accNumber = Integer.parseInt(inp);

			BankAccount toBeClosed = bankDao.getBankAccount(accNumber);
			if (toBeClosed == null) {
				System.out.println("Account was not found");
				return;
			}

			if (accList.contains(toBeClosed) && toBeClosed.getBalance() == 0) {
				bankDao.deleteBankAccount(toBeClosed.getAccountNumber());
				currentUser=userDao.getUserProfile(currentUser.getUsername(), currentUser.getPassword());
				System.out.println("Account deleted");
			} else {
				System.out.println("Account is not empty");
				System.out.println("Empty account before closing");
			}
		} catch (NumberFormatException e) {
			System.out.println("Invalid Input");
		} catch (Exception e) {
			System.out.println("We encountered an error");
		}
	}

	private void withdraw() {
		if (currentUser == null) {
			return;
		}

		try {
			// Gets all bank accounts owned by current User
			List<BankAccount> accList = currentUser.getAccounts();

			if (accList.size() == 0) {
				System.out.println("You do not have any bank accounts");
				return;
			}

			for (BankAccount acc : accList) {
				System.out.println(acc);
			}

			// Gets desired account number and the amount
			System.out.print("\nAccount Number: ");
			String inp = in.nextLine();
			System.out.print("Amount: $");
			String val = in.nextLine();

			int accNumber = Integer.parseInt(inp);
			float amount = Float.parseFloat(val);

			if (amount < .01) { // Verifies the amount is valid
				System.out.println("Invalid Amount");
				return;
			}

			BankAccount acc = bankDao.getBankAccount(accNumber); // Gets bank account

			// If acc is null, if statement will return false
			if (accList.contains(acc)) { // Checks if the account is owned by currentUser
				bankDao.withdrawFromBank(acc, amount);
				currentUser=userDao.getUserProfile(currentUser.getUsername(), currentUser.getPassword());
				System.out.println("Withdraw Successful");
			} else { // Generic message to the user
				System.out.println("Account was not found");
			}
		} catch (InsufficientFunds e) {
			System.out.println("Insufficient Funds");
		} catch (NumberFormatException e) {
			System.out.println("Invalid Input");
		} catch (Exception e) {
			System.out.println("We encountered an error");

		}
	}

	private void deposit() {
		if (currentUser == null) {
			return;
		}

		try {
			// Get all accounts owned by current User
			List<BankAccount> accList = currentUser.getAccounts();

			if (accList.size() == 0) {
				System.out.println("You do not have any bank accounts");
				return;
			}

			for (BankAccount acc : accList) {
				System.out.println(acc);
			}

			System.out.print("\nAccount Number: ");
			String inp = in.nextLine();
			System.out.print("Amount: $");
			String val = in.nextLine();

			int accNumber = Integer.parseInt(inp);
			float amount = Float.parseFloat(val);

			if (amount < .01) { // Validate amount
				System.out.println("Invalid Amount");
				return;
			}

			BankAccount acc = bankDao.getBankAccount(accNumber);

			if (accList.contains(acc)) {
				bankDao.depositToBank(acc, amount);
				currentUser=userDao.getUserProfile(currentUser.getUsername(), currentUser.getPassword());
				System.out.println("Deposit Successful");
			} else {
				System.out.println("Account was not found");
			}
		} catch (InsufficientFunds e) {
			System.out.println("Insufficient Funds");
		} catch (NumberFormatException e) {
			System.out.println("Invalid Input");
		} catch (Exception e) {
			System.out.println("We encountered an error");
		}
	}

	private void transfer() {
		if (currentUser == null) {
			return;
		}

		try {
			List<BankAccount> accList = currentUser.getAccounts();

			if (accList.size() == 0) { // Check is user owns any accounts
				System.out.println("You do not have any bank accounts");
				return;
			}

			for (BankAccount acc : accList) {
				System.out.println(acc);
			}

			/*
			 * Destination bank account does not need to be owned by current user but user
			 * does need to know the account number
			 */

			System.out.print("\nSource Account Number: ");
			String srcId = in.nextLine();
			System.out.print("Destination Account Number: ");
			String destId = in.nextLine();
			System.out.print("Amount: $");
			String val = in.nextLine();

			int srcNumber = Integer.parseInt(srcId);
			int destNumber = Integer.parseInt(destId);
			float amount = Float.parseFloat(val);

			if (amount < .01) { // Validate amount
				System.out.println("Invalid Amount");
				return;
			}

			BankAccount src = bankDao.getBankAccount(srcNumber);
			BankAccount dest = bankDao.getBankAccount(destNumber);

			if (src == null || dest == null || !accList.contains(src)) { // Check that all accounts were found and src
																			// is owned by user
				System.out.println("Acount(s) not found");
				return;
			}

			bankDao.transferMoneyBetweenAccounts(src, dest, amount);
			currentUser=userDao.getUserProfile(currentUser.getUsername(), currentUser.getPassword());

			System.out.println("Transfer Successful");

		} catch (InsufficientFunds e) {
			System.out.println("Insufficient Funds");
		} catch (NumberFormatException e) {
			System.out.println("Invalid Input");
			return;
		} catch (Exception e) {
			System.out.println("We encountered an error");
			// e.printStackTrace();
			return;
		}
	}

	private void addUserToAccount() {
		if (currentUser == null) {
			return;
		}

		try {
			List<BankAccount> accList = currentUser.getAccounts();

			if (accList.size() == 0) { // Checks for accounts
				System.out.println("You do not have any bank accounts");
				return;
			}

			for (BankAccount acc : accList) {
				System.out.println(acc);
			}

			// Asks the user for account to join
			System.out.print("\nAccount Number: ");
			String val = in.nextLine();
			// Get other user profiles credentials
			// Signifies consent of account join
			System.out.print("Joiner Username: ");
			String username = in.nextLine();
			System.out.print("Joiner Password: ");
			String password = in.nextLine();

			int accNumber = Integer.parseInt(val);

			UserProfile joiner = userDao.getUserProfile(username, password);
			BankAccount acc = bankDao.getBankAccount(accNumber);
			// Verifies that all info was entered correction
			if (joiner == null) { // Validates login of joiner
				System.out.println("Login Failed");
			} else if (joiner.equals(currentUser)) {
				System.out.println("Invalid User"); //You cannot add yourself to an account
			} else if (acc == null || !accList.contains(acc)) {
				/*
				 * checks ownership of the account attempting to be joined
				 */
				System.out.println("Account was not found");
			} else {
				joiner.getAccounts().add(acc);
				userDao.updateUserProfile(joiner);
				currentUser=userDao.getUserProfile(currentUser.getUsername(), currentUser.getPassword());
				System.out.println("User added successfully");
			}

		} catch (NumberFormatException e) {
			System.out.println("Invalid Input");
		} catch (Exception e) {
			System.out.println("We encountered an error");
		}
	}

	private void changePwd() {
		if (currentUser == null) {
			return;
		}

		System.out.print("Old Password: ");
		String oldPass = in.nextLine(); // Verifies the old password

		if (!oldPass.equals(currentUser.getPassword())) {
			System.out.println("Incorrect Password");
		} else {
			System.out.print("New Password: ");
			String newPass = in.nextLine();
			currentUser.setPassword(newPass); // Updates password
			try {
				userDao.updateUserProfile(currentUser); // updates db
				currentUser=userDao.getUserProfile(currentUser.getUsername(), newPass);
				System.out.println("Password Change Successful");
			} catch (Exception e) {
				System.out.println("We encountered an error");
			}
		}
	}

	// Returns true/false based on whether the user has quite or has moved through
	// the application
	public boolean loginScreen() {
		printOptions(loginOptions);
		String inp = null;

		while (true) {
			System.out.print("\nCommand: ");
			inp = in.nextLine().toLowerCase(); // Gets next command

			switch (inp) {
			case QUIT:
				return false; // Exit login screen
			case LOGIN:
				if (login()) {
					return true; // If failed login, stay on current Screen
				}
				break;
			case CREATE:
				createAccount();
				break;
			case HELP:
				printOptions(loginOptions);
				break;
			default:
				System.out.println("Invalid input");
				break;
			}
		}
	}

	public boolean accountScreen() {
		printOptions(accountOptions);
		String inp = null;
		while (true) {
			System.out.print("\nCommand: ");
			inp = in.nextLine().toLowerCase();

			switch (inp) {
			case CREATE:
				createBankAccount();
				break;
			case BALANCE:
				checkBalance();
				break;
			case WITHDRAW:
				withdraw();
				break;
			case DEPOSIT:
				deposit();
				break;
			case TRANSFER:
				transfer();
				break;
			case ADD:
				addUserToAccount();
				break;
			case CLOSE:
				deleteBankAccount();
				break;
			case PWD:
				changePwd();
				break;
			case DELETE:
				if (deleteUserProfile())
					return true;
				break;
			case LOGOUT:
				currentUser = null;
				return true;
			case QUIT:
				return false;
			case HELP:
				printOptions(accountOptions);
				break;
			default:
				System.out.println("Invalid input");
				break;
			}
		}
	}

	@Override
	public void run() { // Main entry point
		while (true) {
			if (!loginScreen()) {
				System.out.println("Goodbye");
				return;
			}

			System.out.println();

			if (!accountScreen()) {
				System.out.println("Goodbye");
				return;
			}

			System.out.println();
		}
	}

	public static void main(String args[]) {
		UIMenu ui = new UIMenu();
		ui.run();
	}

}
