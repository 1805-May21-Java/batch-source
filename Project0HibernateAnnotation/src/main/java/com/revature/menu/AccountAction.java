package com.revature.menu;

import java.util.ArrayList;
import java.util.List;

import com.revature.pojos.*;

public class AccountAction extends Menu{
	
	public static void accountAction(BankAccount bankAccount, Client client) {
		//menu to withdraw, deposit, or view balance
		System.out.println(bankAccount.getAccountName()+" $"+bankAccount.getBalence());
		System.out.print("Would you like to withdraw (1), deposit (2),"
				+ " Transfer money to another account (3),"
				+ " \nview balance (4), select a differnt account(5), "
				+ "view all transactions (6), logout(7) or exit (8)? ");
		switch (scan.nextLine()) {
		case "1":
			//gets double input
			double withdrawAmount = inputDouble(lineBreak+"\nHow much would you like to withdraw? ");
			bankAccount.withdraw(withdrawAmount);
			
			//Saves changes
			dImpl.saveOldAccount(bankAccount,client);
			System.out.println(lineBreak);
			break;
			
		case "2":
			//gets double input
			double depositAmount = inputDouble(lineBreak+"\nHow much would you like to deposit? ");
			bankAccount.deposit(depositAmount);
			
			//Saves changes
			dImpl.saveOldAccount(bankAccount,client);
			System.out.println(lineBreak);
			break;
		case "3":
			//Brings the user to the Transfer Account menu
			TransferFunds.transferFunds(client,bankAccount);
			break;
		case "4":
			System.out.println(lineBreak);
			//prints balance
			System.out.println(String.format("%s, you have $%.2f in the account %s", 
					client.getUsername(),bankAccount.getBalence(),bankAccount.getAccountName()));
			System.out.println(lineBreak);
			break;
		case "5":
			System.out.println(lineBreak);
			//Lets user go back to select account screen
			SelectAccount.selectAccount(client);
		case "6":
			System.out.println(lineBreak);
			//Prints out all transactions on that account
			List<Transaction> transactionList = dImpl.getTransactions(bankAccount);
			for(Transaction transaction : transactionList) {
				System.out.println(transaction.getDate()+" Transaction done by "+
			transaction.getClientUsername());
				System.out.println(transaction.getTransactionMessage());
			}
			System.out.println(lineBreak);
			break;
			
		case "7":
			System.out.println(lineBreak);
			//logs user out, then sends to login screen
			System.out.println("Logged out!");
			WelcomeMenu.Existing(new Client());
		case "8":
			//closes resources then exits
			scan.close();
			System.out.println(lineBreak);
			exit();
		default:
			//prints message, then runs the mainMenu method again
			System.out.println("I'm sorry, that wasn't one of our options!");
			System.out.println(lineBreak);
			break;
		}
		accountAction(bankAccount, client);
		
	}
	
	
	//makes sure user enters a double
		public static double inputDouble(String message) {
			while(true) {
				System.out.print(message);
				try{
					double var = Double.valueOf(scan.nextLine());
					//validates that user entered a positive number
					if(var < 0 ) {
						System.out.println("Negative money not allowed!");
					//validates for a fraction of a cent
					}else if(var > 60000000){
						System.out.println("That is more money than exists in the world.  Try again");
					}else if (var*100 != (long) (var*100)) {
						System.out.println("Cannot input fractions of a cent!");
					}else {
						return var;
					}
				}catch (NumberFormatException e) {
					System.out.println("Enter a valid number!");
				}
			}
		}
}
