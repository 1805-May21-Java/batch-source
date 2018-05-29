package com.revature.banking;

import java.io.Serializable;
import java.util.ArrayList;

public class Account implements Serializable{

	// Variables to hold the users information
	public String userEmail;
	private String password;
	private double balance=0;
	
	// Constructor to create a new by calling to the super class and setting the userEmail and password vairables
	//
	// Did not think that I needed to have a class that calls to the super class only, since an Account should never be created without
	// a user name and a password
	public Account(String userEmail, String password) {
		super();
		this.userEmail = userEmail;
		this.password=password;
	}
	
	// Method to check whether the given String email is the same as the userEmail String
	// Used for validation
	public boolean compareEmail(String email) {
		return (userEmail.equals(email))?true:false;
	}
	
	// Method to check whether the give String password is the same as the private String password
	// Used for validation
	public boolean comparePassword(String password) {
		return (this.password.equals(password))?true:false;
	}
	
	// Method to make a withdraw from users bank account
	//
	// Checks that the balance is large enough first, if it is it subtracts the withdraw amount from the balance 
	// and returns true, else false
	public boolean makeWithdraw(double amount) {
		if(balance>=amount) {
			balance-=amount;
			return true;
		}
		else
			return false;
	}
	
	// Method to make a deposit into the users bank account by adding amount to the balance variable
	public void makeDeposit(double amount) {
		balance+=amount;
	}
	
	// Method to return the value of the balance variable
	public double getBalance() {
		return balance;
	}

}
