package com.revature.menu;

import com.revature.pojos.*;

public class SelectAccount extends Menu{

	//Client can select an existing account or create a new one
		public static void selectAccount(Client client) {
			System.out.println("Select from existing accounts by typing the name of the account, "
					+ "or create a new one by typing 'new'");
			System.out.println("Type 'exit' at any time to exit");
			client.getAccounts().forEach(account -> System.out.println(
					account.getAccountName()+" $"+account.getBalence()));
			BankAccount account = inputAccount(client);
			System.out.println(lineBreak);
			AccountAction.accountAction(account,client);
		}
		
		//user entry for selecting an existing account or opening a new one
		private static BankAccount inputAccount(Client client) {
			while(scan.hasNext()) {
				String entry = scan.nextLine();
				//exits if the user entered 'exit'
				if(entry.equals("exit")) exit();
				if(entry.equals("new")) {
					String accountName;
					do{
						System.out.print("What is the name of your new account? ");
						accountName = scan.nextLine();
						
					}while(accountAlreadyExists(client, accountName));	
					//Capitalizes first letter, both for formality
					//If the user is a jerk and tries to call the account 'exit', it will change to 'Exit'
					accountName = accountName.substring(0, 1).toUpperCase() + accountName.substring(1);
					//adds the new account to the client's list of accounts
					BankAccount bankAccount = new BankAccount();
					bankAccount.setBalence(0);
					bankAccount.setAccountName(accountName);
					bankAccount.setClient(client);
					
					do{
						//asks user if it is a joint account or solo owner
						System.out.println("Is this a joint account?");
						System.out.print("(1) for sole owner, (2) for joint: ");
						switch (scan.nextLine()) {
						case "1":
							break;
						case "2":
							return jointAccount(client,bankAccount);
						default:
							System.out.println("Please enter 1 or 2!");
							//prevents loop from reaching the end and makes user enter information again
							continue;
						}
						//if it reaches the end, breaks the loop
					}while(false);
					
					//creates new account
					client.addNewAccount(bankAccount);
					dImpl.saveNewAccount(bankAccount,client);
					dImpl.saveAccountClientLink(bankAccount, client);
					return bankAccount;
					
				}else {
					//Matches user entry with existing accounts
					for(BankAccount account : client.getAccounts()) {
						if(entry.equals(account.getAccountName())) {
							return account;
						}
					}
				}
				System.out.println("Invalid account name!  "
						+ "Enter another name, or type 'new' for a new account");
			}
			//Should never reach here
			return null;
		}
		
		private static boolean accountAlreadyExists(Client client, String name) {
			//checks to make sure user doesn't already have an account of the same name
			for(BankAccount account : client.getAccounts() ) {
				if(account.getAccountName().equals(name)) {
					System.out.println("You already have an account with that name!");
					return true;
				}
			}
			return false;
		}
		
		private static BankAccount jointAccount(Client client,BankAccount bankAccount) {
			//creates a joint account with another user
			System.out.println("Credentials of the second account owner: ");
			dImpl.saveNewAccount(bankAccount,client);
			dImpl.saveAccountClientLink(bankAccount, client);
			Client client2 = GetClient.getClient();
			dImpl.saveAccountClientLink(bankAccount, client2);
			return bankAccount;
		}
}
