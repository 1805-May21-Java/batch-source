package com.revature.banking.pojos;

import com.revature.banking.dao.BankAccountImpl;

public class BankAccount extends BankAccountImpl{
	
	public BankAccount() {
		super();
	}

	public BankAccount(int user_id, int acc_num, String acc_type, double balance) {
		super();
		this.user_id = user_id;
		this.acc_num = acc_num;
		this.acc_type = acc_type;
		this.balance = balance;
	}

	public int getAcc_num() {
		return acc_num;
	}

	public String getAcc_type() {
		return acc_type;
	}

	public double getBalance() {
		return balance;
	}

	public int getUser_id() {
		return user_id;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + acc_num;
		result = prime * result + ((acc_type == null) ? 0 : acc_type.hashCode());
		long temp;
		temp = Double.doubleToLongBits(balance);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + user_id;
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
		if (acc_num != other.acc_num)
			return false;
		if (acc_type == null) {
			if (other.acc_type != null)
				return false;
		} else if (!acc_type.equals(other.acc_type))
			return false;
		if (Double.doubleToLongBits(balance) != Double.doubleToLongBits(other.balance))
			return false;
		if (user_id != other.user_id)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "BankAccount [user_id=" + user_id + ", acc_num=" + acc_num + ", acc_type="
				+ acc_type + ", balance=" + balance + "]";
	}
	
	
	
	
}
