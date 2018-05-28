package com.revature.bank;

import java.util.*;
import java.io.*;
import java.text.DecimalFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/*
 * Bank information class for account information storage
 * 
 * BankDriver serializes the Account information into a file and reads it
 * as a BankInfo object when starting the application
 * 
 * While running the program, all interaction with Account information occurs
 * within the program from the BankMenu class
 */

public class BankInfo implements Serializable {

	private static final long serialVersionUID = 7104008807727037474L;
	private static final DecimalFormat df = new DecimalFormat("#0.00");
	
	private transient int accountNumber;
	private ArrayList<Account> accounts;

	// nested class to specifically encapsulate account information
	public class Account implements Serializable {
		private static final long serialVersionUID = -2172682221453629514L;
		
		private String user;
		private String pass;
		private double balance;
		private LinkedList<Transaction> transactions;
		
		public Account() {
			super();
			balance = 0;
			transactions = new LinkedList<Transaction>();
		}
		
		public Account(String user, String pass) {
			super();
			this.user = user;
			this.pass = pass;
			this.balance = 0;
			transactions = new LinkedList<Transaction>();
		}
		
		public String getUser() {
			return user;
		}

		public void setUser(String user) {
			this.user = user;
		}

		public String getPass() {
			return pass;
		}

		public void setPass(String pass) {
			this.pass = pass;
		}

		public double getBalance() {
			return balance;
		}

		public void setBalance(double balance) {
			this.balance = balance;
		}
		
		public Transaction getTransaction(int i) {
			return this.transactions.get(i);
		}
		
		public LinkedList<Transaction> getTransactions(){
			return this.transactions;
		}
		
		public void addTransaction(Transaction t) {
			transactions.addFirst(t);
		}
	}
	
	// Nested class for handling Transaction related features
	public class Transaction implements Serializable {
		private static final long serialVersionUID = 3401336348247420513L;
		
		String type;
		String user;
		double amount;
		double balance;
		LocalDateTime date;
		
		public Transaction() {
			super();
			date = LocalDateTime.now();
		}
		
		public Transaction(String type, String user,  double amount, double balance, LocalDateTime date) {
			super();
			this.type = type;
			this.user = user;
			this.amount = amount;
			this.balance = balance;
			this.date = date;
		}

		public String getType() {
			return type;
		}

		public void setType(String type) {
			this.type = type;
		}

		public double getAmount() {
			return amount;
		}

		public void setAmount(double amount) {
			this.amount = amount;
		}

		public String getUser() {
			return user;
		}

		public void setUser(String user) {
			this.user = user;
		}
		
		public double getBalance() {
			return balance;
		}

		public void setBalance(double balance) {
			this.balance = balance;
		}

		public LocalDateTime getDate() {
			return date;
		}

		public void setDate(LocalDateTime date) {
			this.date = date;
		}
		
		// most importantly in this class is this toString() method
		// returns a String message depending on the type of transaction
		// represented by the Transaction object
		public String toString() {
			String s = date.format(DateTimeFormatter.ofPattern("MM-dd-yyyy HH:mm")) + "\n\t";
			switch(this.type) {
			case "Withdrawal":
				s += ("Withdrew $" + df.format(this.amount));
				s += ("\n\n\t-$" + df.format(this.amount));
				s += ("\n\tBalance: $" + df.format(this.balance));
				break;
			case "Deposit":
				s += ("Deposited $" + df.format(this.amount));
				s += ("\n\n\t+$" + df.format(this.amount));
				s += ("\n\tBalance: $" + df.format(this.balance));
				break;
			case "TransferTo":
				s += ("Transferred $" + df.format(this.amount) + " to " + this.user);
				s += ("\n\n\t-$" + df.format(this.amount));
				s += ("\n\tBalance: $" + df.format(this.balance));
				break;
			case "TransferFrom":
				s += ("Received transfer of $" + df.format(this.amount) + " from " + this.user);
				s += ("\n\n\t+$" + df.format(this.amount));
				s += ("\n\tBalance: $" + df.format(this.balance));
				break;
			case "Open":
				s += ("Opened account under username " + this.user);
			}
			
			return s;
		}
	}
	
	public BankInfo() {
		super();
		this.accountNumber = -1;
		this.accounts = new ArrayList<Account>();
	}

	public BankInfo(ArrayList<Account> accounts) {
		super();
		this.accountNumber = -1;
		this.accounts = accounts;
	}
	
	public int getAccountNumber() {
		return this.accountNumber;
	}

	public void setAccountNumber(int accountNumber) {
		this.accountNumber = accountNumber;
	}
	
	public ArrayList<Account> getAccounts() {
		return this.accounts;
	}
	
	public Account getAccount(int index) {
		return this.accounts.get(index);
	}
	
	public void addAccount(Account account) {
		this.accounts.add(account);
	}
}
