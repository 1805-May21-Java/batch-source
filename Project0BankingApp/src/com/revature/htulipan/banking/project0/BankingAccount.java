package com.revature.htulipan.banking.project0;

public class BankingAccount {
	private String username = "";
	private String password;
	private float balance;
	
	public BankingAccount() {
		super();
	}

	public BankingAccount(String username, String password, float balance) {
		super();
		this.username = username;
		this.password = password;
		this.balance = balance;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		if (this.username.equals("")) {
			this.username = username;
		}
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public float getBalance() {
		return balance;
	}

	public void setBalance(float balance) {
		this.balance = balance;
	}
	
	public void deposit(float amount) {
		this.balance += amount;
	}
	
	public boolean withdraw(float amount) {
		if (amount <= balance) {
			balance -= amount;
			return true;
		} else {
			return false;
		}
	}
}
