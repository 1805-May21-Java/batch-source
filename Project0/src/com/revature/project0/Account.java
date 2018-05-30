package com.revature.project0;

public class Account {

	private double balance;
	private int accountid;
	private String account;
	private String password;


	public Account() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Account(double b, String a, String p) {
		super();
		this.balance = b;
		this.account = a;
		this.password = p;
	}
	public String getAccount() {
		return account;
	}
	public void setAccount(String account) {
		this.account = account;
	}
	public int getAccountid() {
		return accountid;
	}
	public void setAccountid(int aId) {
		this.accountid = aId;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String pd) {
		this.password = pd;
	}
	public Account(double b, String pd) {
		super();
		this.balance = b;
		this.password = pd;
	}
	public double getBalance() {
		return balance;
	}
	public void setBalance(double b) {
		this.balance = b;
	}
	
	
}
