package com.Revature.pojos;

import java.text.NumberFormat;

import javax.persistence.*;

@Entity
@Table
public class BankAccount {
	//Define members of a bank account
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "bankAccountSequence")
	@SequenceGenerator(allocationSize = 1, name = "bankAccountSequence", sequenceName = "SQ_BANK_ACCOUNT_PK")
	@Column(name="ACCOUNT_NUMBER")
	private int accountNumber;
	
	@Column
	private float balance;

	//POJO stuff
	
	public BankAccount() {
		super();
		// TODO Auto-generated constructor stub
	}

	public BankAccount(int accountNumber, float balance) {
		super();
		this.accountNumber = accountNumber;
		this.balance = balance;
	}

	public int getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(int accountNumber) {
		this.accountNumber = accountNumber;
	}

	public float getBalance() {
		return balance;
	}

	public void setBalance(float balance) {
		this.balance = balance;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + accountNumber;
		result = prime * result + Float.floatToIntBits(balance);
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
		if (accountNumber != other.accountNumber)
			return false;
		if (Float.floatToIntBits(balance) != Float.floatToIntBits(other.balance))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "BankAccount [accountNumber=" + accountNumber + ", balance=" + NumberFormat.getCurrencyInstance().format(balance) + "]";
	}

}
