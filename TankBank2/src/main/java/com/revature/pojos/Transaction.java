package com.revature.pojos;

import java.sql.Date;

//Stores a single transaction
public class Transaction {
	
	private BankAccount bankAccount;
	private String transactionMessage;
	private Date date;
	private String clientUsername;
	public Transaction() {
		super();
	}
	
	public Transaction(BankAccount bankAccount, String transactionMessage, Date date, String clientUsername) {
		super();
		this.bankAccount = bankAccount;
		this.transactionMessage = transactionMessage;
		this.date = date;
		this.clientUsername = clientUsername;
	}
	
	public String getClientUsername() {
		return clientUsername;
	}
	public void setClientUsername(String clientUsername) {
		this.clientUsername = clientUsername;
	}
	public BankAccount getBankAccount() {
		return bankAccount;
	}
	public void setBankAccount(BankAccount bankAccount) {
		this.bankAccount = bankAccount;
	}
	public String getTransactionMessage() {
		return transactionMessage;
	}
	public void setTransactionMessage(String transactionMessage) {
		this.transactionMessage = transactionMessage;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((bankAccount == null) ? 0 : bankAccount.hashCode());
		result = prime * result + ((clientUsername == null) ? 0 : clientUsername.hashCode());
		result = prime * result + ((date == null) ? 0 : date.hashCode());
		result = prime * result + ((transactionMessage == null) ? 0 : transactionMessage.hashCode());
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
		if (bankAccount == null) {
			if (other.bankAccount != null)
				return false;
		} else if (!bankAccount.equals(other.bankAccount))
			return false;
		if (clientUsername == null) {
			if (other.clientUsername != null)
				return false;
		} else if (!clientUsername.equals(other.clientUsername))
			return false;
		if (date == null) {
			if (other.date != null)
				return false;
		} else if (!date.equals(other.date))
			return false;
		if (transactionMessage == null) {
			if (other.transactionMessage != null)
				return false;
		} else if (!transactionMessage.equals(other.transactionMessage))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Transaction [bankAccount=" + bankAccount + ", transactionMessage=" + transactionMessage + ", date="
				+ date + ", clientUsername=" + clientUsername + "]";
	}
	
	
}
