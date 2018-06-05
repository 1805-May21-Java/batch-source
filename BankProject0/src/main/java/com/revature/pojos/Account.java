package com.revature.pojos;

import java.io.Serializable;

public class Account implements Serializable{
	private static final long serialVersionUID = 617125119381151376L; // don't know what else to do here
	private String usr, username, pw; //user credentials
	private float balance; //for account balance
	private transient boolean isLoggedIn; //transient boolean variable to ensure user is logged in
	public Account() {
		super();
	}
	public Account(String usr, String username, String pw, float balance, boolean isLoggedIn) {
		super();
		this.usr = usr; //NOT the same as username though
		this.username = username; // because this is username
		this.pw = pw;
		this.balance = balance;
		this.isLoggedIn = isLoggedIn;
	}
	public String getPw() {
		return pw;
	}
	public void setPw(String pw) {
		this.pw = pw;
	}
	public String getUsr() {
		return usr;
	}
	public void setUsr(String usr) {
		this.usr = usr;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public float getBalance() {
		return balance;
	}
	public void setBalance(float balance) {
		this.balance = balance;
	}
	public boolean isLoggedIn() {
		return isLoggedIn;
	}
	public void setLoggedIn(boolean isLoggedIn) {
		this.isLoggedIn = isLoggedIn;
	}
	@Override
	public String toString() {
		return "Account [usr =" + usr + ", username =" + username + ", password =" + pw
				+ ", balance =" + balance + "]";
	}
	
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + Float.floatToIntBits(balance);
		result = prime * result + ((pw == null) ? 0 : pw.hashCode());
		result = prime * result + ((username == null) ? 0 : username.hashCode());
		result = prime * result + ((usr == null) ? 0 : usr.hashCode());
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
		if (Float.floatToIntBits(balance) != Float.floatToIntBits(other.balance))
			return false;
		if (pw == null) {
			if (other.pw != null)
				return false;
		} else if (!pw.equals(other.pw))
			return false;
		if (username == null) {
			if (other.username != null)
				return false;
		} else if (!username.equals(other.username))
			return false;
		if (usr == null) {
			if (other.usr != null)
				return false;
		} else if (!usr.equals(other.usr))
			return false;
		return true;
	}
	public int withdraw (float amount) { //withdraw money from account
		if(!isLoggedIn) {
			System.out.println("Please log in to withdraw money");
			return 0;
		}
		if(balance < amount) {
			return -1; // if the balance is smaller than the amount to withdraw
		}
		balance -= amount;
		System.out.printf("Current balance: $%.2f\n", balance);
		return 1;
	}
	
	public int deposit(float amount) { //deposit money into account
		System.out.println("You are depositing $" + amount + " into your account.");
		if(!isLoggedIn) {
			System.out.println("Please log in to deposit money");
			return 0;
		}
		if(amount <= 0) return -1; // can't deposit 0
		balance += amount;
		System.out.printf("Current Balance: $%.2f\n", balance);
		return 1;
	}
	
}