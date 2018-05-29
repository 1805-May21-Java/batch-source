package com.revature.htulipan.banking.project0;

import com.sun.xml.internal.ws.util.StringUtils;

public class BankingSession {
	private final int BASE_MENU = 0;
	private final int CREATE_USERNAME = 1;
	private final int CREATE_PASSWORD = 2;
	private final int LOGIN_USERNAME = 3;
	private final int LOGIN_PASSWORD = 4;
	private final int LOGOUT = 5;
	
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
		
		}
		
		System.out.print("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
	}
	
	private void logout() {
		if (account != null) {
			dataManager.storeAccount(account);
		}
		exitStatus = false;
	}
	
	private final String baseMenu = 
			"1) Log In To Existing Account\n"
			+ "2) Create A New Account\n"
			+ "3) Exit\n";
	
	
	
}
