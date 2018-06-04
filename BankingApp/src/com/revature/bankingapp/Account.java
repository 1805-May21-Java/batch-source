package com.revature.bankingapp;

public class Account {
	
	private int id;
	private String username;
	private String password;
	private double balance = 0.00; // new account balance always starts at zero

	public Account(int id, String username, String password, double balance) {
		super();
		this.id = id;
		this.username = username;
		this.password = password;
		this.balance = balance;
	}
	
	public Account(String username, String password) {
		super();
		this.username = username;
		this.password = password;
	}
	
	public int getId() {
		return id;
	}
	
	public void setId (int id) {
		this.id = id;
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

	@Override
	public String toString() {
		return "Account [id=" + id + ", username=" + username + ", password=" + password + ", balance=" + balance + "]";
	}
	
	
}
