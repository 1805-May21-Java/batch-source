package com.revature.menu;

import com.revature.pojos.BankAccount;
import com.revature.pojos.Client;
import com.revature.pojos.Transaction;

public class TransferFunds extends Menu {
	
	public static void transferFunds(Client client,BankAccount firstAccount) {
		 BankAccount secondAccount= selectWhichAccount(client);
		 Double amount = AccountAction.inputDouble("How much would you like to transfer? ");
		 if(firstAccount.withdraw(amount)) {
			 secondAccount.deposit(amount);
			 dImpl.saveOldAccount(firstAccount, client);
			 dImpl.saveOldAccount(secondAccount, client);
			 return;
		 }else {
			 System.out.println("You don't have that much money!");
		 }
	}
	
	private static BankAccount selectWhichAccount(Client client) {
		System.out.println("Which account would you like to select? Type 'exit' to quit at any point. ");
		client.getAccounts().forEach(account -> System.out.println(
				account.getAccountName()+" $"+account.getBalence()));
		String entry = scan.nextLine();	
		if(entry.equals("exit")) exit();
		for(BankAccount account : client.getAccounts()) {
			if(entry.equals(account.getAccountName())) {
				return account;
			}
		}
		System.out.println("That wasn't one of the accounts!");
		selectWhichAccount(client);
		return null;
	}
	
}
