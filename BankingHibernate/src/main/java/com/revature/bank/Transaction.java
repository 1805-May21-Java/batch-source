package com.revature.bank;

import javax.persistence.*;

@Entity
@Table
public class Transaction {
	
	@Column
	private String acctName;
	
	@Column
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="transSequence")
	@SequenceGenerator(allocationSize=1,name="transSequence",sequenceName="SQ_Trans_PK")
	private int transactionID;
	
	@Column
	private String action;
	
	@Column(columnDefinition="number(10,2)")
	private float amount;
	
	@Column
	private String dateOccured;
	
	public Transaction() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Transaction(String acctName, int transactionID, String action, float amount, String date) {
		super();
		this.acctName = acctName;
		this.transactionID = transactionID;
		this.action = action;
		this.amount = amount;
		this.dateOccured = date;
	}
	@Override
	public String toString() {
		return "Name=" + acctName + "\ntransactionID=" + transactionID + "\naction: " + (action.equals("Deposit")?" Desposit":" Withdrawal")
				+ "\namount: $" + amount + "\nDate: " + dateOccured + "\n";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((acctName == null) ? 0 : acctName.hashCode());
		result = prime * result + ((action==null)?0 : action.hashCode());
		result = prime * result + Float.floatToIntBits(amount);
		result = prime * result + ((dateOccured == null) ? 0 : dateOccured.hashCode());
		result = prime * result + transactionID;
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
		if (acctName == null) {
			if (other.acctName != null)
				return false;
		} else if (!acctName.equals(other.acctName))
			return false;
		if (action != other.action)
			return false;
		if (Float.floatToIntBits(amount) != Float.floatToIntBits(other.amount))
			return false;
		if (dateOccured == null) {
			if (other.dateOccured != null)
				return false;
		} else if (!dateOccured.equals(other.dateOccured))
			return false;
		if (transactionID != other.transactionID)
			return false;
		return true;
	}
	public String getAcctName() {
		return acctName;
	}
	public void setAcctName(String acctName) {
		this.acctName = acctName;
	}
	public int getTransactionID() {
		return transactionID;
	}
	public void setTransactionID(int transactionID) {
		this.transactionID = transactionID;
	}
	public String getAction() {
		return action;
	}
	public void setAction(String action) {
		this.action = action;
	}
	public float getAmount() {
		return amount;
	}
	public void setAmount(float amount) {
		this.amount = amount;
	}
	public String getDate() {
		return dateOccured;
	}
	public void setDate(String date) {
		this.dateOccured = date;
	}
	
	

}
