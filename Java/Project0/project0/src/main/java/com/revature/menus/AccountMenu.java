package com.revature.menus;

import java.util.ArrayList;
import java.util.Scanner;
import com.revature.dao.AccountDaoImpl;
import com.revature.dao.TransactionDaoImpl;
import com.revature.pojos.Account;
import com.revature.pojos.Bank;
import com.revature.pojos.Transaction;
import com.revature.pojos.User;

public class AccountMenu {
	public boolean validateInput(Double input) {
		if(input < 0) {
			System.out.println("You must enter a positive number.");
			return false;
		}
		
		if(input <= 0.009) {
			System.out.println("The number you entered is too small.");
			return false;
		}
		
		String[] splitter = null; 
		if(input.toString().indexOf('.') != -1 && input.toString().indexOf('E') == -1) {
			splitter = input.toString().split("\\.");
			if (splitter[1].length() > 2) {
				System.out.println("You cannot enter more than 2 decimal places.");
				return false;
			}
		}
		
		return true;
	}
	
	public void display(User user) {
		Scanner sc = new Scanner(System.in);
		boolean flag = false;
		String operation = "";
		AccountDaoImpl adi = new AccountDaoImpl();
		TransactionDaoImpl tdi = new TransactionDaoImpl();
		Account account = adi.getAccount(user.getUsername());
		
		while(flag != true) {
			System.out.println();
			System.out.println("Enter 1 to view balance. Enter 2 to deposit money. \nEnter 3 to withdraw money. Enter 4 to transfer funds to another account."
					+ "\nEnter 5 to view transaction history. Enter 6 to logout and exit.");
			
			operation = sc.nextLine();
			switch(operation) {
				case "1":
					double balance = adi.getBalance(account.getAccountId());
					System.out.println("Your balance is " + String.format("%.2f", balance));
					break;
				case "2":
					System.out.println("How much money would you like to deposit?");
					try {
						Double amount = Double.parseDouble(sc.nextLine());
						if(validateInput(amount)) {
 							if(account.deposit(account.getAccountId(), amount, user.getUsername()))
								System.out.println("Successfully deposited " + String.format("%.2f", amount) + " dollars.");	
						}
					} catch(NumberFormatException e) {
						System.out.println("Must enter a number.");
					}
					break;
				case "3":
					System.out.println("How much money would you like to withdraw?");
					try {
						double amount = Double.parseDouble(sc.nextLine());
						if(validateInput(amount)) {
							if(account.withdraw(account.getAccountId(), amount, user.getUsername())) {
								System.out.println("Successfully withdrew " + String.format("%.2f", amount) + " dollars.");
							}		
						}
					} catch(NumberFormatException e) {
						System.out.println("Must enter a number.");
					}
					break;
				case "4":
					System.out.println("How much money would you like to transfer?");
					try {
						double amount = Double.parseDouble(sc.nextLine());
						if(validateInput(amount)) {
							System.out.println("Enter the username of the account to transfer the funds to.");
							String username = sc.nextLine();
							if(Bank.transfer(account.getAccountId(), amount, username, account.getUsername() )) {
								System.out.println("Successfully transferred " + String.format("%.2f", amount) + " dollars to " + username);
							} 				
						}
					} catch(NumberFormatException e) {
						System.out.println("Must enter a number.");
					}
					break;
				case "5":
					ArrayList<Transaction> transactions = tdi.getTransactions(user.getUsername());
					System.out.println();
					for(Transaction t : transactions)
						System.out.println(t);
					break;
				case "6":
					flag = true;
					System.out.println("Good bye!");
					break;
				default:
					System.out.println("Invalid operation");
					break;
			}
		}
		sc.close();
	}
}
