package com.revature.menus;

import java.util.ArrayList;
import java.util.Scanner;

import com.revature.dao.BankAccountDaoImpl;
import com.revature.dao.BankTransactionDaoImpl;
import com.revature.models.BankAccount;
import com.revature.models.BankTransaction;
import com.revature.models.BankUser;

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
	
	public void display(BankUser user) {
		Scanner sc = new Scanner(System.in);
		boolean flag = false;
		String operation = "";
		BankAccountDaoImpl adi = new BankAccountDaoImpl();
		BankTransactionDaoImpl tdi = new BankTransactionDaoImpl();
		BankAccount account = adi.getAccount(user.getUsername());
		while(flag != true) {
			System.out.println();
			System.out.println("Enter 1 to view balance. Enter 2 to deposit money. \nEnter 3 to withdraw money. Enter 4 to transfer funds to another account."
					+ "\nEnter 5 to view transaction history. Enter 6 to logout and exit.");
			
			operation = sc.nextLine();
			switch(operation) {
				case "1":
					double balance = account.getBalance();
					System.out.println("Your balance is " + String.format("%.2f", balance));
					break;
				case "2":
					System.out.println("How much money would you like to deposit?");
					try {
						Double amount = Double.parseDouble(sc.nextLine());
						if(validateInput(amount)) {
							account.setBalance(account.getBalance() + amount);
 							adi.updateBalance(account);
 							BankTransaction newTransction = new BankTransaction("deposit", amount, user);
 							tdi.createTransaction(newTransction);
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
						if(validateInput(amount) && amount <= account.getBalance()) {
							account.setBalance(account.getBalance() - amount);
 							adi.updateBalance(account);
 							BankTransaction newTransction = new BankTransaction("withdraw", amount, user);
 							tdi.createTransaction(newTransction);
							System.out.println("Successfully withdrew " + String.format("%.2f", amount) + " dollars.");	
						} else {
							System.out.println("Insufficient funds.");
						}
					} catch(NumberFormatException e) {
						System.out.println("Must enter a number.");
					}
					break;
				case "4":
					System.out.println("How much money would you like to transfer?");
					try {
						double amount = Double.parseDouble(sc.nextLine());
						if(validateInput(amount) && amount <= account.getBalance()) {
							System.out.println("Enter the username of the account to transfer the funds to.");
							String username = sc.nextLine();
							BankAccount otherAccount = adi.getAccount(username);
							account.setBalance(account.getBalance() - amount);
							otherAccount.setBalance(otherAccount.getBalance() + amount);
							adi.updateBalance(account);
							adi.updateBalance(otherAccount);
 							BankTransaction newTransction = new BankTransaction("transfer", amount, user);
 							tdi.createTransaction(newTransction);
 							newTransction = new BankTransaction("deposit", amount, otherAccount.getUser());
 							tdi.createTransaction(newTransction);
							System.out.println("Successfully transferred " + String.format("%.2f", amount) + " dollars to " + username);		
						} else {
							System.out.println("Insufficient funds.");
						}
					} catch(NumberFormatException e) {
						System.out.println("Must enter a number.");
					}
					break;
				case "5":
					ArrayList<BankTransaction> transactions = tdi.getTransactions(user.getUsername());
					System.out.println();
					for(BankTransaction t : transactions)
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
