package com.revature.bank;

import java.util.*;
import java.io.*;

/*
 * Bank information class for account information storage
 * 
 * BankDriver serializes the Account information into a file and reads them
 * as a BankInfo object when starting the application
 * 
 * While running the program, all interaction with Account information occurs
 * within the program from the BankMenu class
 */

public class BankInfo implements Serializable {

	private static final long serialVersionUID = 7104008807727037474L;
	
	private transient int accountNumber;
	private ArrayList<Account> accounts;

	// nested class to specifically encapsulate account information
	public class Account implements Serializable {
		private static final long serialVersionUID = -2172682221453629514L;
		
		private String user;
		private String pass;
		private double balance;
		
		@SuppressWarnings("unused")
		public Account() {
			super();
			balance = 0;
		}
		
		@SuppressWarnings("unused")
		public Account(String user, String pass) {
			super();
			this.user = user;
			this.pass = pass;
			this.balance = 0;
		}
		
		@SuppressWarnings("unused")
		public String getUser() {
			return user;
		}

		@SuppressWarnings("unused")
		public void setUser(String user) {
			this.user = user;
		}

		@SuppressWarnings("unused")
		public String getPass() {
			return pass;
		}

		@SuppressWarnings("unused")
		public void setPass(String pass) {
			this.pass = pass;
		}

		@SuppressWarnings("unused")
		public double getBalance() {
			return balance;
		}

		@SuppressWarnings("unused")
		public void setBalance(double balance) {
			this.balance = balance;
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
