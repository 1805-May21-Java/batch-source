package com.revature.pojos;

import java.io.Serializable;
import java.util.ArrayList;

public class BankAccount implements Serializable{

	private static final long serialVersionUID = 6137519972665705247L;
	private double balence;
	private String accountName;
	private int bankId;
	//multiple clients can own an account, but this refers to the account accessing at this time
	private Client client;

	public BankAccount() {
		super();
	}
	public BankAccount(double balence, String accountName, int bankId, Client client){
		super();
		this.balence = balence;
		this.accountName = accountName;
		this.bankId = bankId;
		this.client = client;
	}

	//withdraws amount entered to total amount
	public boolean withdraw(double amountToWithdraw) {
		if(this.balence - amountToWithdraw < 0) {
			System.out.println("You don't have that much money!");
			return false;
		}else {
			balence -= amountToWithdraw;
			return true;
		}
	}
	
	//adds amount entered to total amount
	public void deposit(double amountToDeposit) {
		balence += amountToDeposit;
	}
	
	public int getBankId() {
		return bankId;
	}

	public void setBankId(int bankId) {
		this.bankId = bankId;
	}

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}
	
	public String getAccountName() {
		return accountName;
	}

	public void setAccountName(String accountName) {
		this.accountName = accountName;
	}

	public double getBalence() {
		return balence;
	}

	public void setBalence(double balence) {
		this.balence = balence;
	}
	

	@Override
	public String toString() {
		return String.format("Balance: $%.2f", this.balence);
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		long temp;
		temp = Double.doubleToLongBits(balence);
		result = prime * result + (int) (temp ^ (temp >>> 32));
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
		BankAccount other = (BankAccount) obj;
		if (Double.doubleToLongBits(balence) != Double.doubleToLongBits(other.balence))
			return false;
		return true;
	}

	

}
