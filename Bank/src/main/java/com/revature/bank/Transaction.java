package com.revature.bank;

import java.text.DecimalFormat;
import java.sql.Date;

public class Transaction {	
	private static final DecimalFormat df = new DecimalFormat("#0.00");
	
	private String type;
	private String user;
	private double amount;
	private double balance;
	private Date date;
	private int otherAccount;
	
	public Transaction() {
		super();
	}
	
	public Transaction(String type, String user,  double amount,
			double balance, Date date, int otherAccount) {
		super();
		this.type = type;
		this.user = user;
		this.amount = amount;
		this.balance = balance;
		this.date = date;
		this.otherAccount = otherAccount;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public int getOtherAccount() {
		return otherAccount;
	}

	public void setOtherAccount(int otherAccount) {
		this.otherAccount = otherAccount;
	}

	// most importantly in this class is this toString() method
	// returns a String message depending on the type of transaction
	// represented by the Transaction object
	public String toString() {
		String s = date.toString() + "\n\t";
		if(this.type.equals("Withdrawal")) {
			s += (this.user + " withdrew $" + df.format(this.amount));
			s += ("\n\n\t-$" + df.format(this.amount));
			s += ("\n\tBalance: $" + df.format(this.balance));
		}
		else if(this.type.equals("Deposit")) {
			s += (this.user + " deposited $" + df.format(this.amount));
			s += ("\n\n\t+$" + df.format(this.amount));
			s += ("\n\tBalance: $" + df.format(this.balance));
		}
		else if(this.type.equals("TransferTo")) {
			s += (this.user + " transferred $" + df.format(this.amount) +
					" to account #" + this.otherAccount);
			s += ("\n\n\t-$" + df.format(this.amount));
			s += ("\n\tBalance: $" + df.format(this.balance));
		}
		else if(this.type.equals("TransferFrom")) {
			s += ("Received transfer of $" + df.format(this.amount) +
					" from account #" + this.otherAccount + " by " + this.user);
			s += ("\n\n\t+$" + df.format(this.amount));
			s += ("\n\tBalance: $" + df.format(this.balance));
		}
		else if(this.type.equals("Add")) {
			s += (this.user + " added to the account");
		}
		else if(this.type.equals("Remove")) {
			s += (this.user + " removed from the account");
		}
		else if(this.type.equals("Open")) {
			s += ("Account opened by " + this.user);
		}
		
		return s;
	}
}

