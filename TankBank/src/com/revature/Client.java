package com.revature;

import java.io.Serializable;
import java.util.ArrayList;

//This class creates Clients, who may have one or more bank accounts, stored in an ArrayList
public class Client implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 7164980474022034266L;
	//List of all accounts the user has
	ArrayList<BankAccount> accounts;
	String username;
	String password;
	String email;
	
	
	public Client() {
		super();
		accounts = new ArrayList<>();
	}


	public Client(ArrayList<BankAccount> accounts, String username, String password, String email) {
		super();
		this.accounts = accounts;
		this.username = username;
		this.password = password;
		this.email = email;
	}

	

	public ArrayList<BankAccount> getAccounts() {
		return accounts;
	}


	public void addNewAccount(BankAccount account) {
		accounts.add(account);
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


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	@Override
	public String toString() {
		return "Client [accounts=" + accounts + ", username=" + username + ", password=" + password + ", email=" + email
				+ "]";
	}
	
	
	
	

}
