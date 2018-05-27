package com.revature;

import java.io.Serializable;

public class BankAccount implements Serializable{

	private static final long serialVersionUID = 6137519972665705247L;
	private double balence;
	private String accountName;
	

	public BankAccount() {
		super();
	}

	public BankAccount(double balence, String accountName){
		super();
		this.balence = balence;
		this.accountName = accountName;
	}

	//withdraws amount entered to total amount
	public double withdraw(double amountToWithdraw) {
		if(this.balence - amountToWithdraw < 0) {
			System.out.println("You don't have that much money!");
			return balence;
		}else {
			this.balence -= amountToWithdraw;
			return balence;
		}
	}
	
	//adds amount entered to total amount
	public double deposit(double amountToDeposit) {
		balence += amountToDeposit;
		return balence;
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
