package menu;

import com.revature.BankAccount;
import com.revature.Client;

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
					//creates new account
					
					System.out.print("What is the name of your new account? ");
					String accountName = scan.nextLine();
					//Capitalizes first letter, both for formality
					//If the user is a jerk and tries to call the account 'exit', it will change to 'Exit'
					accountName = accountName.substring(0, 1).toUpperCase() + accountName.substring(1);
					//adds the new account to the client's list of accounts
					BankAccount bankAccount = new BankAccount(0,accountName);
					client.addNewAccount(bankAccount);
					return bankAccount;
				}else {
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
}
