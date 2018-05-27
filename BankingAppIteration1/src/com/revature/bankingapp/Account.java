package com.revature.bankingapp;

import java.io.*;

/*
 * 
 * This is a Serializable POJO that acts as a container for an account's
 * username, password, and balance. Most methods are protected so that noone 
 * can change values or access info unless they extend this class.
 * 
 * Added functionality with addToBalance(float) and removeFromBalance(float)
 * 
 */
public class Account implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -2228988432616182385L;
	private String username;
	private String password;
	private float balance;
	protected Account() {
		super();
	}
	protected Account(String username, String password, float balance) {
		super();
		this.username = username;
		this.password = password;
		this.balance = balance;
	}
	
	// This adds to the balance without having to use getters and setters
	// validation must be handled before this is called
	protected void addToBalance(float amount) {
		this.balance += amount;
	}
	
	// This removes from the balance without having to use getters and setters
	// validation must be handled before this is called
	protected void removeFromBalance(float amount) {
		this.balance -= amount;
	}
	
	protected String getUsername() {
		return username;
	}
	protected void setUsername(String username) {
		this.username = username;
	}
	protected String getPassword() {
		return password;
	}
	protected void setPassword(String password) {
		this.password = password;
	}
	protected float getBalance() {
		return balance;
	}
	protected void setBalance(float balance) {
		this.balance = balance;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + Float.floatToIntBits(balance);
		result = prime * result + ((password == null) ? 0 : password.hashCode());
		result = prime * result + ((username == null) ? 0 : username.hashCode());
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
		if (password == null) {
			if (other.password != null)
				return false;
		} else if (!password.equals(other.password))
			return false;
		if (username == null) {
			if (other.username != null)
				return false;
		} else if (!username.equals(other.username))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Don't access account info like this.";
	}
}
