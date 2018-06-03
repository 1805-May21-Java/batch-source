package com.revature.pojos;

import java.sql.Date;

public class Transaction {
	private int transactionId;
	private long accountNumber;
	private Date transactionDate;
	private String description;
	public Transaction() {
		super();
	}
	public Transaction(int transactionId, long accountNumber, Date transactionDate, String description) {
		super();
		this.transactionId = transactionId;
		this.accountNumber = accountNumber;
		this.transactionDate = transactionDate;
		this.description = description;
	}
	public Transaction(long accountNumber, Date transactionDate, String description) {
		super();
		this.accountNumber = accountNumber;
		this.transactionDate = transactionDate;
		this.description = description;
	}
	public Transaction(long accountNumber, String description) {
		super();
		this.accountNumber = accountNumber;
		this.description = description;
	}
	public int getTransactionId() {
		return transactionId;
	}
	public void setTransactionId(int transactionId) {
		this.transactionId = transactionId;
	}
	public long getAccountNumber() {
		return accountNumber;
	}
	public void setAccountNumber(long accountNumber) {
		this.accountNumber = accountNumber;
	}
	public Date gettransactionDate() {
		return transactionDate;
	}
	public void settransactionDate(Date transactionDate) {
		this.transactionDate = transactionDate;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	@Override
	public String toString() {
		return "Transaction [transactionId=" + transactionId + ", accountNumber=" + accountNumber + ", transactionDate="
				+ transactionDate + ", description=" + description + "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (accountNumber ^ (accountNumber >>> 32));
		result = prime * result + ((description == null) ? 0 : description.hashCode());
		result = prime * result + ((transactionDate == null) ? 0 : transactionDate.hashCode());
		result = prime * result + transactionId;
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
		Transaction other = (Transaction) obj;
		if (accountNumber != other.accountNumber)
			return false;
		if (description == null) {
			if (other.description != null)
				return false;
		} else if (!description.equals(other.description))
			return false;
		if (transactionDate == null) {
			if (other.transactionDate != null)
				return false;
		} else if (!transactionDate.equals(other.transactionDate))
			return false;
		if (transactionId != other.transactionId)
			return false;
		return true;
	}	
}
