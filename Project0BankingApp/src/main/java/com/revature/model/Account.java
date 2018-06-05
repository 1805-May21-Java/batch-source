package com.revature.model;

import java.util.Scanner;

import com.revature.dao.AccountDAOImpl;

public class Account {

	int accountid;
	String accounttype;
	double balance;
	int userid;
	
	Scanner sc = new Scanner(System.in);
	
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
	
	public void viewAccounts(UserAccount user) {
		AccountDAOImpl account = new AccountDAOImpl();
		account.getAccountsByUserId(user);
	}
	
	public void newAccount(UserAccount user) {
		
		String accounttype = null;
		while (accounttype == null) {
			System.out.println("What type of account would you like to set up?");
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
		}
		
		AccountDAOImpl account = new AccountDAOImpl();
		Account a = new Account(0, accounttype, 0.0, user.getAccountid());
		account.addAccount(a);
		System.out.println("Account created!");
	}
	
	public Account() {
		super();
	}
	
	public Account(int accountid, String accounttype, double balance, int userid) {
		super();
		this.accountid = accountid;
		this.accounttype = accounttype;
		this.balance = balance;
		this.userid = userid;
	}
	
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
	@Override
	public String toString() {
		return accounttype +" Account ID: " + accountid + "  Balance: $" + balance;
	}
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
