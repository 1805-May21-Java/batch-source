package com.revature.Bank;

import java.io.*;

public class BankAccounts implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String name;
	private int AccountNum;
	private double balance;
	private String UName;
	private String Passw;
	
	public BankAccounts(String name, int accountNum, double balance, String uName, String passw) {
		super();
		this.name = name;
		AccountNum = accountNum;
		this.balance = balance;
		UName = uName;
		Passw = passw;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAccountNum() {
		return AccountNum;
	}
	public void setAccountNum(int accountNum) {
		AccountNum = accountNum;
	}
	public double getBalance() {
		return balance;
	}
	public void setBalance(double balance) {
		this.balance = balance;
	}
	public String getUName() {
		return UName;
	}
	public void setUName(String uName) {
		UName = uName;
	}
	public String getPassw() {
		return Passw;
	}
	public void setPassw(String passw) {
		Passw = passw;
	}
	
	public int withdrawl(double amount) {
		if(amount < 0) {
			return -1;
		}
		else if(amount >balance) {
			return -2;
		}
		else {
			balance =- amount;
		}
		return 0;
	}
	
	public int deposit(double amount) {
		if(amount < 0) {
			return -1;
		}
		else {
			balance =+ amount;
		}
		return 0;
	}

	@Override
	public String toString() {
		return "Current Account: Name on Account:" + name + "\n"+ "AccountNum:" + AccountNum + "\n" +" balance:$" + balance;
		
	}
	
}
