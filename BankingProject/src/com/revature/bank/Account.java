package com.revature.bank;

import java.io.Serializable;

public class Account implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 617125119381151376L;
	private String owner, username, password;
	private float balance;
	private transient boolean isLoggedIn;
	public Account() {
		super();
	}
	public Account(String owner, String username,String password, float balance, boolean isLoggedIn) {
		super();
		this.owner = owner;
		this.username = username;
		this.password = password;
		this.balance = balance;
		this.isLoggedIn = isLoggedIn;
	}
	@Override
	public String toString() {
		return "Account [owner=" + owner + ", username=" + username + ", password=" + password
				+ ", balance=" + balance + "]";
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getOwner() {
		return owner;
	}
	public void setOwner(String owner) {
		this.owner = owner;
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
	
	public int withdraw(float amount) {
		if(!isLoggedIn) {
			System.out.println("You must be logged in to do this.");
			return 0;
		}
		if(balance<amount) {
			return -1;
		}
		balance-=amount;
		System.out.println("You have $"+balance+" remaining.");
		return 1;
	}
	
	public int deposit(float amount) {
		System.out.println(amount+" depositing this much.");
		if(!isLoggedIn) {
			System.out.println("You must be logged in to do this.");
			return 0;
		}
		if(amount<=0) return -1;
		balance+=amount;
		System.out.println("Your balance is now: $"+balance);
		return 1;
	}
	
}
