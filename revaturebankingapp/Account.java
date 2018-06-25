package com.revature.revaturebankingapp;

import java.util.ArrayList;
import java.util.Scanner;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name="RBA_ACCOUNT")
public class Account {

	//Variables
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="accountSequence")
	@SequenceGenerator(allocationSize=46, name="accountSequence", sequenceName="SQ_ACCOUNT_PK")
	@Column(name="ACCOUNTID")
	int accountid;
	
	@Column(name="ACCOUNTTYPE", length=10)
	String accounttype;
	
	@Column(name="balance")
	double balance;
	
	@Column(name="USERID")
	int userid;
	
//	@ManyToOne
//	@JoinColumn(name="USERID")
//	User user;
	
	@Transient
	Scanner sc = new Scanner(System.in);
	
	//Method to deposit funds into user specified account, calls balanceInquiry and updateBalance methods from AccountDAOImpl class
	public void deposit() {
		AccountDAOImpl account = new AccountDAOImpl();
		System.out.println("^^^Please select an Account ID to deposit your funds^^^");
		int aid = Integer.parseInt(sc.nextLine());
		System.out.println("And how much would you like to deposit:");
		try {double d = Double.parseDouble(sc.nextLine());
		if (d < 0) {
			System.out.println("Please enter a positive integer");
			System.out.println();
			return;
		}
		double balance1 = account.balanceInquiry(aid);
		balance1 += d;
		
		
		account.updateBalance(aid, balance1);
		System.out.println("Your new account balance is $" + balance1);
		} catch (NumberFormatException e) {
			System.out.println("Please enter a positive integer");
			return;
		}
	
		
		System.out.println();
		return;
	}
	//Method to withdraw funds from user specified accounts, calls balanceInquiry and updateBalance methods from AccountDAOImpl class
	public void withdraw() {
		AccountDAOImpl account = new AccountDAOImpl();
		System.out.println("^^^Please select an Account ID to withdraw your funds^^^");
		int aid = Integer.parseInt(sc.nextLine());
		System.out.println("And how much would you like to withdraw:");
		try {double d = Double.parseDouble(sc.nextLine());
		if (d < 0) {
			System.out.println("Please enter a positive integer");
			System.out.println();
			return;
		}
		double balance1 = account.balanceInquiry(aid);
		balance1 -= d;
		
		if (balance1 < 0) {
			balance1 += d;
			System.out.println("Account overdrawn! Account balance remains at $" + balance1);
			return;
		}
		
		account.updateBalance(aid, balance1);
		System.out.println("Your new account balance is $" + balance1);
		} catch (NumberFormatException e) {
			System.out.println("Please enter a positive integer");
			return;
		}
		return;
	}
	
	//Method to view all accounts associated with a user. Calls getAccountsByUserId from AccountDAOImpl class
	public void viewAccounts(int id) {
		AccountDAOImpl account = new AccountDAOImpl();
		ArrayList<Account> accounts = account.getAccountsByUserId(id);
		for(Account a : accounts) {
			System.out.println(a);
		}
	}
	
	//Method creates new account to be associated with inputted User, calls addAccount from AccountDAOImpl class
	public void newAccount(User user) {
		
		String accounttype = null;
		while (accounttype == null) {
			
			try {System.out.println("What type of account would you like to set up?");
			System.out.println("Press 1 for a CHECKING account");
			System.out.println("Press 2 for a SAVINGS account");
			int check = Integer.parseInt(sc.nextLine());
		if (check == 1) {
			accounttype = "CHECKING";
		} else if (check == 2) {
			accounttype = "SAVINGS";
		} else {System.out.println("Invalid input. Please enter valid choice");
		System.out.println();
		}
		} catch (NumberFormatException e) {
			System.out.println("Please enter a valid integer to select your account type.");
			break;
		}
		
		AccountDAOImpl account = new AccountDAOImpl();
		Account a = new Account(0, accounttype, 0.0, user.getAccountid());
		account.addAccount(a);
		System.out.println("Account created!");
	}
	}
	//No args constructor
	public Account() {
		super();
	}
	//Constructor with fields
	public Account(int accountid, String accounttype, double balance, int userid) {
		super();
		this.accountid = accountid;
		this.accounttype = accounttype;
		this.balance = balance;
		this.userid = userid;
	}
	
	public Account(String accounttype, double balance, int userid) {
		super();
		this.accounttype = accounttype;
		this.balance = balance;
		this.userid = userid;
	}
	
	//Getters and setters
	public int getAccountid() {
		return accountid;
	}
	public void setAccountid(int accountid) {
		this.accountid = accountid;
	}
	public String getAccounttype() {
		return accounttype;
	}
	public void setAccounttype(String accounttype) {
		this.accounttype = accounttype;
	}
	public double getBalance() {
		return balance;
	}
	public void setBalance(double balance) {
		this.balance = balance;
	}
	public int getUserid() {
		return userid;
	}
	public void setUserid(int userid) {
		this.userid = userid;
	}
	//Overriden toString() method
	@Override
	public String toString() {
		return accounttype +" Account ID: " + accountid + "  Balance: $" + balance;
	}
	//overridden hashCode() method
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + accountid;
		result = prime * result + ((accounttype == null) ? 0 : accounttype.hashCode());
		long temp;
		temp = Double.doubleToLongBits(balance);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + userid;
		return result;
	}
	//Overriden equals() method
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Account other = (Account) obj;
		if (accountid != other.accountid)
			return false;
		if (accounttype == null) {
			if (other.accounttype != null)
				return false;
		} else if (!accounttype.equals(other.accounttype))
			return false;
		if (Double.doubleToLongBits(balance) != Double.doubleToLongBits(other.balance))
			return false;
		if (userid != other.userid)
			return false;
		return true;
	}
	
	
}
