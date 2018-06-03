package com.revature.pojos;

import java.util.*;

public class Account {
	private long accountNumber;
	private double balance;
	private List<Integer> jointUsers;
	public Account() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Account(long accountNumber, double balance, List<Integer> jointUsers) {
		super();
		this.accountNumber = accountNumber;
		this.balance = balance;
		this.jointUsers = jointUsers;
	}
	public Account(long accountNumber, double balance) {
		super();
		this.accountNumber = accountNumber;
		this.balance = balance;
	}
	public Account(double balance) {
		super();
		this.balance = balance;
	}
	public long getAccountNumber() {
		return accountNumber;
	}
	public void setAccountNumber(long accountNumber) {
		this.accountNumber = accountNumber;
	}
	public double getBalance() {
		return balance;
	}
	public void setBalance(double balance) {
		this.balance = balance;
	}
	public List<Integer> getJointUsers() {
		return jointUsers;
	}
	public void setJointUsers(List<Integer> jointUsers) {
		this.jointUsers = jointUsers;
	}
	@Override
	public String toString() {
		return "Account [accountNumber=" + accountNumber + ", balance=" + balance + ", jointUsers=" + jointUsers + "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (accountNumber ^ (accountNumber >>> 32));
		long temp;
		temp = Double.doubleToLongBits(balance);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((jointUsers == null) ? 0 : jointUsers.hashCode());
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
		if (accountNumber != other.accountNumber)
			return false;
		if (Double.doubleToLongBits(balance) != Double.doubleToLongBits(other.balance))
			return false;
		if (jointUsers == null) {
			if (other.jointUsers != null)
				return false;
		} else if (!jointUsers.equals(other.jointUsers))
			return false;
		return true;
	}
	
}
