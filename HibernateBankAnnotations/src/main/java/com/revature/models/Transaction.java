package com.revature.models;

import java.sql.Date;

import javax.persistence.*;

@Entity
@Table(name="JPA_TRANSACTION")
public class Transaction {
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="transactionSequence")
	@SequenceGenerator(allocationSize=1, name="transactionSequence", sequenceName="HSQ_TRANSACTION_PK")
	@Column(name="TRANSACTION_ID")
	private int transactionId;
	
	@ManyToOne
	@JoinColumn(name="ACCOUNT_NUMBER")
	private Account associatedAccount;
	
	@Column(name="TANSACTION_DATE", columnDefinition="DATE")
	private Date transactionDate;
	
	@Column
	private String description;
	
	public Transaction() {
		super();
		// TODO Auto-generated constructor stub
	}
	public int getTransactionId() {
		return transactionId;
	}
	public void setTransactionId(int transactionId) {
		this.transactionId = transactionId;
	}
	public Date getTransactionDate() {
		return transactionDate;
	}
	public void setTransactionDate(Date transactionDate) {
		this.transactionDate = transactionDate;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Account getAssociatedAccount() {
		return associatedAccount;
	}
	public void setAssociatedAccount(Account associatedAccount) {
		this.associatedAccount = associatedAccount;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((associatedAccount == null) ? 0 : associatedAccount.hashCode());
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
		if (associatedAccount == null) {
			if (other.associatedAccount != null)
				return false;
		} else if (!associatedAccount.equals(other.associatedAccount))
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
	@Override
	public String toString() {
		return "Transaction [associatedAccount=" + associatedAccount + ", transactionId=" + transactionId
				+ ", transactionDate=" + transactionDate + ", description=" + description + "]";
	}
}
