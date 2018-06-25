package com.revature.htulipan.project0hibernate.ui;

import java.util.ArrayList;

import com.revature.htulipan.project0hibernate.localdata.DataManager;
import com.revature.htulipan.project0hibernate.models.BankAccount;
import com.revature.htulipan.project0hibernate.models.BankUser;

public class BankingSession {
	private final int BASE_MENU = 0;
	private final int CREATE_USERNAME = 1;
	private final int CREATE_PASSWORD = 2;
	private final int LOGIN_USERNAME = 3;
	private final int LOGIN_PASSWORD = 4;
	private final int LOGGED_MENU = 5;
	private final int CHOOSE_MENU = 6;
	private final int CREATE_ACCOUNT = 7;
	private final int DEPOSIT = 8;
	private final int WITHDRAW = 9;
	private final int LOGOUT = 10;
	private final int WAITING = 11;
	private final int WAITING2 = 12;
	
	private ArrayList<BankAccount> accounts = new ArrayList<BankAccount>();
	private BankUser user = null;
	private BankAccount account = null;
	
	private DataManager dataManager = new DataManager();
	
	private boolean exiting = false;
	private boolean waiting = false;
	private int activity = BASE_MENU;
	private StringBuilder displayText = new StringBuilder();
	
	public BankingSession() {
		super();
	}
	
	public boolean isExiting() {
		return exiting;
	}
	
	public boolean isWaiting() {
		return waiting;
	}
	
	public String getDisplayText() {
		StringBuilder result = new StringBuilder();
		switch (activity) {
		case BASE_MENU:
			result.append("NOT LOGGED IN\n\n");
			result.append(baseMenu);
			result.append("ENTER YOUR CHOICE: ");
			break;
			
		case CREATE_USERNAME:
			result.append("NOT LOGGED IN\n\n");
			result.append("ENTER YOUR DESIRED USERNAME: ");
			break;
		
		case CREATE_PASSWORD:
			result.append("NOT LOGGED IN\n\n");
			result.append("ENTER YOUR DESIRED PASSWORD: ");
			break;
			
		case LOGIN_USERNAME:
			result.append("NOT LOGGED IN\n\n");
			result.append("ENTER YOUR USERNAME: ");
			break;
			
		case LOGIN_PASSWORD:
			result.append("NOT LOGGED IN\n\n");
			result.append("ENTER YOUR PASSWORD: ");
			break;
			
		case LOGGED_MENU:
			result.append("LOGGED IN AS: " + user.getUsername() + "\n");
			result.append(getLoggedMenu());
			result.append("ENTER YOUR CHOICE: ");
			break;
		
		case CHOOSE_MENU:
			result.append("LOGGED IN AS: " + user.getUsername() + "\n");
			result.append("INTERACTING WITH ACCOUNT: " + account.getAccountName() + "\n");
			result.append("BALANCE: " + account.getBalance() + "\n");
			result.append(chooseMenu);
			result.append("ENTER YOUR CHOICE: ");
			break;
		
		case CREATE_ACCOUNT:
			result.append("LOGGED IN AS: " + user.getUsername() + "\n\n");
			result.append("ENTER DESIRED ACCOUNT NAME: ");
			break;
		
		case DEPOSIT:
			result.append("LOGGED IN AS: " + user.getUsername() + "\n");
			result.append("INTERACTING WITH ACCOUNT: " + account.getAccountName() + "\n");
			result.append("BALANCE: " + account.getBalance() + "\n\n");
			result.append("SELECT DEPOSIT AMOUNT: ");
			break;
		
		case WITHDRAW:
			result.append("LOGGED IN AS: " + user.getUsername() + "\n");
			result.append("INTERACTING WITH ACCOUNT: " + account.getAccountName() + "\n");
			result.append("BALANCE: " + account.getBalance() + "\n\n");
			result.append("SELECT WITHDRAW AMOUNT: ");
			break;
			
		case WAITING:
			result.append("WAITING");
			break;
		
		case WAITING2:
			result.append("WAITING ... ");
			break;
		}
		
		displayText.append(result.toString());
		String output = displayText.toString();
		displayText.setLength(0);
		return output;
		
	}
	
	public void interpretInput(String input) {
		switch (activity) {
		case BASE_MENU:
			interpretBaseMenuInput(input);
			break;
			
		case CREATE_USERNAME:
			interpretCreateUsernameInput(input);
			break;
		
		case CREATE_PASSWORD:
			interpretCreatePasswordInput(input);
			break;
		
		case LOGIN_USERNAME:
			interpretLoginUsernameInput(input);
			break;
		
		case LOGIN_PASSWORD:
			interpretLoginPasswordInput(input);
			break;
		
		case LOGGED_MENU:
			interpretLoggedMenuInput(input);
			break;
		
		case CHOOSE_MENU:
			interpretChooseMenuInput(input);
			break;
		
		case CREATE_ACCOUNT:
			interpretCreateAccountMenuInput(input);
			break;
			
		case DEPOSIT:
			interpretDepositInput(input);
			break;
		
		case WITHDRAW:
			interpretWithdrawInput(input);
			break;
		}
		
		System.out.print("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
	}
	
	private void logout() {
		if (user != null) {
			// dataManager.storeData();
		}
	}
	
	private void interpretBaseMenuInput(String in) {
		
		try {
			int i = Integer.parseInt(in);
			if (i == 1) {
				activity = LOGIN_USERNAME;
			} else if (i == 2) {
				activity = CREATE_USERNAME;
			} else if (i == 3) {
				activity = LOGOUT;
				logout();
				exiting = true;
			} else {
				throw new NumberFormatException();
			}
		} catch (NumberFormatException nfe) {
			displayText.append("THE INPUT \"" + in + "\" IS NOT VALID.\n\n");
		}
		
	}
	
	private void interpretCreateUsernameInput(String in) {
		
		if (!in.matches("[a-zA-Z0-9]+")) {
			displayText.append("THE USERNAME \"" + in + "\" IS NOT ALPHANUMERIC.\n\n");
			activity = BASE_MENU;
		} else if (dataManager.usernameExists(in)) {
			displayText.append("THE USERNAME \"" + in + "\" IS ALREADY IN USE.\n\n");
			activity = BASE_MENU;
		} else {
			user = new BankUser();
			user.setUsername(in);
			activity = CREATE_PASSWORD;
		}
		
	}
	
	private void interpretCreatePasswordInput(String in) {
		
		user.setPassword(in);
		dataManager.createUser(user);
		displayText.append("ACCOUNT CREATION SUCCESSFUL. YOU MAY NOW LOG IN.\n\n");
		activity = BASE_MENU;
		
	}
	
	private void interpretLoginUsernameInput(String in) {
		
		if (!dataManager.usernameExists(in)) {
			displayText.append("THE USERNAME \"" + in + "\" DOES NOT MATCH ANY RECORDS.\n\n");
			activity = BASE_MENU;
		} else {
			user = new BankUser();
			user.setUsername(in);
			activity = LOGIN_PASSWORD;
		}
		
	}
	
	private void interpretLoginPasswordInput(String in) {
		
		BankUser fetchedUser = dataManager.getUser(user.getUsername(), in);
		if (fetchedUser == null) {
			displayText.append("THAT USERNAME/PASSWORD COMBINATION DOES NOT MATCH ANY RECORDS. \n\n");
			activity = BASE_MENU;
		} else {
			user = fetchedUser;
			displayText.append("LOGIN SUCCESSFUL.\n\n");
			activity = LOGGED_MENU;
		}
		
	}
	
	private void interpretLoggedMenuInput(String in) {
		int numAccounts = accounts.size();
		try {
			int i = Integer.parseInt(in);
			if (i > 0 && i <= numAccounts) {
				activity = CHOOSE_MENU;
				account = accounts.get(i-1);
			} else if (i == (numAccounts+1)) {
				activity = CREATE_ACCOUNT;
			} else if (i == (numAccounts+2)) {
				activity = BASE_MENU;
				logout();
			} else {
				throw new NumberFormatException();
			}
		} catch (NumberFormatException nfe) {
			displayText.append("THE INPUT \"" + in + "\" IS NOT VALID.\n\n");
		}
		
	}
	
	private void interpretChooseMenuInput(String in) {
		
		try {
			int i = Integer.parseInt(in);
			if (i == 1) {
				activity = DEPOSIT;
			} else if (i == 2) {
				activity = WITHDRAW;
			} else if (i == 3) {
				dataManager.updateAccount(account);
				account = null;
				activity = LOGGED_MENU;
			} else {
				throw new NumberFormatException();
			}
		} catch (NumberFormatException nfe) {
			displayText.append("THE INPUT \"" + in + "\" IS NOT VALID.\n\n");
		}
	}
	
	private void interpretCreateAccountMenuInput(String in) {
		boolean nameInUse = false;
		for (BankAccount a : accounts) {
			if (a.getAccountName().equals(in)) nameInUse = true;
		}
		
		if (nameInUse) {
			displayText.append("THE ACCOUNT NAME \"" + in + "\" IS ALREADY IN USE FOR THIS USER.\n\n");
			activity = LOGGED_MENU;
		} else if (!in.matches("[a-zA-Z0-9]+")) {
			displayText.append("THE ACCOUNT NAME \"" + in + "\" IS NOT ALPHANUMERIC.\n\n");
			activity = LOGGED_MENU;
		} else {
			dataManager.createAccount(user.getUsername(), in);
			displayText.append("ACCOUNT \"" + in + "\" SUCCESSFULLY CREATED.\n\n");
			activity = LOGGED_MENU;
		}
		
	}
	
	private void interpretDepositInput(String in) {
		
		try {
			float f = Float.parseFloat(in);
			if (f < 0) {
				displayText.append("CANNOT DEPOSIT A NEGATIVE VALUE.\n\n");
			} else {
				displayText.append("DEPOSIT OF " + in + " SUCCESSFUL.\n\n");
				account.setBalance(account.getBalance() + f);
			}
		} catch (NumberFormatException nfe) {
			displayText.append("THE INPUT \"" + in + "\" IS NOT VALID.\n\n");
		}
		activity = CHOOSE_MENU;
		
	}
	
	private void interpretWithdrawInput(String in) {
		
		try {
			float f = Float.parseFloat(in);
			if (f < 0) {
				displayText.append("CANNOT WITHDRAW A NEGATIVE VALUE.\n\n");
			} else if (f > account.getBalance()) {
				displayText.append("THERE IS NOT ENOUGH IN THIS ACCOUNT TO COMPLETE THAT WITHDRAWAL.\n\n");
			} else {
				account.setBalance(account.getBalance() - f);
				displayText.append("WITHDRAWAL OF " + in + " SUCCESSFUL.\n\n");
			}
		} catch (NumberFormatException nfe) {
			displayText.append("THE INPUT \"" + in + "\" IS NOT VALID.\n\n");
		}
		activity = CHOOSE_MENU;
		
	}
	
	private String getLoggedMenu() {
		accounts = dataManager.getUserAccounts(user.getUsername());
		
		StringBuilder result = new StringBuilder();
		int option = 1;
		for (BankAccount a : accounts) {
			result.append(option++);
			result.append(") ");
			result.append("Interact With Account \"");
			result.append(a.getAccountName());
			result.append("\"\n");
		}
		result.append(option++ + ") Create New Account\n");
		result.append(option + ") Logout\n");
		return result.toString();
	}
	
	private final String baseMenu = 
			"1) Log In To Existing Account\n"
			+ "2) Create A New Account\n"
			+ "3) Exit\n";
	
	private final String chooseMenu = 
			"1) Deposit\n"
			+ "2) Withdraw\n"
			+ "3) Back\n";
}
