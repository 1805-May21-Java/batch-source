package com.revature.htulipan.banking.project0;

import com.sun.xml.internal.ws.util.StringUtils;

public class BankingSession {
	private final int BASE_MENU = 0;
	private final int CREATE_USERNAME = 1;
	private final int CREATE_PASSWORD = 2;
	private final int LOGIN_USERNAME = 3;
	private final int LOGIN_PASSWORD = 4;
	private final int LOGGED_MENU = 5;
	private final int DEPOSIT = 6;
	private final int WITHDRAW = 7;
	private final int LOGOUT = 8;
	
	private BankingAccount account = null;
	private DataFileManager dataManager = new DataFileManager();
	private boolean exitStatus = true;
	private int activity = BASE_MENU;
	private StringBuilder displayText = new StringBuilder();
	
	public BankingSession() {
		super();
		
	}
	
	public boolean getExitStatus() {
		return exitStatus;
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
			result.append("LOGGED IN AS: " + account.getUsername() + "\n");
			result.append("BALANCE: " + account.getBalance() + "\n\n");
			result.append(loggedMenu);
			result.append("ENTER YOUR CHOICE: ");
			break;
		
		case DEPOSIT:
			result.append("LOGGED IN AS: " + account.getUsername() + "\n");
			result.append("BALANCE: " + account.getBalance() + "\n\n");
			result.append("SELECT DEPOSIT AMOUNT: ");
			break;
		
		case WITHDRAW:
			result.append("LOGGED IN AS: " + account.getUsername() + "\n");
			result.append("BALANCE: " + account.getBalance() + "\n\n");
			result.append("SELECT WITHDRAW AMOUNT: ");
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
			try {
				int i = Integer.parseInt(input);
				if (i == 1) {
					activity = LOGIN_USERNAME;
				} else if (i == 2) {
					activity = CREATE_USERNAME;
				} else if (i == 3) {
					activity = LOGOUT;
					logout();
					exitStatus = false;
				} else {
					throw new NumberFormatException();
				}
			} catch (NumberFormatException nfe) {
				displayText.append("THE INPUT \"" + input + "\" IS NOT VALID.\n\n");
			}
			break;
			
		case CREATE_USERNAME:
			if (!input.matches("[a-zA-Z0-9]+")) {
				displayText.append("THE USERNAME \"" + input + "\" IS NOT ALPHANUMERIC.\n\n");
				activity = BASE_MENU;
			} else if (dataManager.usernameExists(input)) {
				displayText.append("THE USERNAME \"" + input + "\" IS ALREADY IN USE.\n\n");
				activity = BASE_MENU;
			} else {
				account = new BankingAccount();
				account.setUsername(input);
				activity = CREATE_PASSWORD;
			}
			break;
		
		case CREATE_PASSWORD:
			account.setPassword(input);
			account.setBalance(0f);
			dataManager.storeAccount(account);
			//  account = null;
			displayText.append("ACCOUNT CREATION SUCCESSFUL. YOU MAY NOW LOG IN.\n\n");
			activity = BASE_MENU;
			break;
		
		case LOGIN_USERNAME:
			if (!dataManager.usernameExists(input)) {
				displayText.append("THE USERNAME \"" + input + "\" DOES NOT MATCH ANY RECORDS.\n\n");
				activity = BASE_MENU;
			} else {
				account = new BankingAccount();
				account.setUsername(input);
				activity = LOGIN_PASSWORD;
			}
			break;
		
		case LOGIN_PASSWORD:
			BankingAccount fetchedAccount = dataManager.getAccount(account.getUsername(), input);
			if (fetchedAccount == null) {
				displayText.append("THAT USERNAME/PASSWORD COMBINATION DOES NOT MATCH ANY RECORDS. \n\n");
				activity = BASE_MENU;
			} else {
				account = fetchedAccount;
				displayText.append("LOGIN SUCCESSFUL.\n\n");
				activity = LOGGED_MENU;
			}
			break;
		
		case LOGGED_MENU:
			try {
				int i = Integer.parseInt(input);
				if (i == 1) {
					activity = DEPOSIT;
				} else if (i == 2) {
					activity = WITHDRAW;
				} else if (i == 3) {
					activity = BASE_MENU;
					logout();
				} else {
					throw new NumberFormatException();
				}
			} catch (NumberFormatException nfe) {
				displayText.append("THE INPUT \"" + input + "\" IS NOT VALID.\n\n");
			}
			break;
		
		case DEPOSIT:
			try {
				float f = Float.parseFloat(input);
				if (f < 0) {
					displayText.append("CANNOT DEPOSIT A NEGATIVE VALUE.\n\n");
				} else {
					displayText.append("DEPOSIT OF " + input + " SUCCESSFUL.\n\n");
					account.deposit(f);
				}
			} catch (NumberFormatException nfe) {
				displayText.append("THE INPUT \"" + input + "\" IS NOT VALID.\n\n");
			}
			activity = LOGGED_MENU;
			break;
		
		case WITHDRAW:
			try {
				float f = Float.parseFloat(input);
				if (f < 0) {
					displayText.append("CANNOT WITHDRAW A NEGATIVE VALUE.\n\n");
				} else if (f > account.getBalance()) {
					displayText.append("THERE IS NOT ENOUGH IN THIS ACCOUNT TO COMPLETE THAT WITHDRAWAL.\n\n");
				} else {
					account.withdraw(f);
					displayText.append("WITHDRAWAL OF " + input + " SUCCESSFUL.\n\n");
				}
			} catch (NumberFormatException nfe) {
				displayText.append("THE INPUT \"" + input + "\" IS NOT VALID.\n\n");
			}
			activity = LOGGED_MENU;
			break;
		}
		
		System.out.print("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
	}
	
	private void logout() {
		if (account != null) {
			dataManager.storeAccount(account);
		}
	}
	
	private final String baseMenu = 
			"1) Log In To Existing Account\n"
			+ "2) Create A New Account\n"
			+ "3) Exit\n";
	
	private final String loggedMenu = 
			"1) Make a Deposit\n"
			+ "2) Make a Withdrawal\n"
			+ "3) Logout\n";
	
}
