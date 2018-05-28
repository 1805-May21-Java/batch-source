package com.revature.project0;

import java.io.Serializable;

public class Account implements Serializable {
	private static final long serialVersionUID = -6260234582326963129L;
	private String username;
	private String password;
	private double balance;
	private boolean isLoggedIn;
	
	public Account() {
		super();
	}
	
	public Account(String username, String password) {
		super();
		this.username = username;
		this.password = password;
	}
	
	public Account(String username, String password, double balance) {
		super();
		this.username = username;
		this.password = password;
		this.balance = balance;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
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
		return "Account [username=" + username + ", password=" + password + ", balance=" + balance + ", isLoggedIn="
				+ isLoggedIn + "]";
	}
	
	public double deposit(double amount) {
		this.balance += amount;
		return this.balance;
	}
	
	public double withdraw(double amount) {
		this.balance -= amount;
		return this.balance;
	}
}
