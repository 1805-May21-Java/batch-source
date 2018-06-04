package com.revature.bank;

import java.util.ArrayList;

public class User {
	private String user;
	private String pass;
	private ArrayList<Integer> accounts;
	
	public User() {
		this.accounts = new ArrayList<Integer>();
	}
	
	public User(String user, String pass) {
		super();
		this.user = user;
		this.pass = pass;
		this.accounts = new ArrayList<Integer>();
	}
	
	public User(String user, String pass, ArrayList<Integer> accounts) {
		super();
		this.user = user;
		this.pass = pass;
		this.accounts = accounts;
	}

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public String getPass() {
		return pass;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}

	public ArrayList<Integer> getAccounts() {
		return accounts;
	}

	public void setAccounts(ArrayList<Integer> accounts) {
		this.accounts = accounts;
	}
}

