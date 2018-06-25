package com.revature.bank;

import java.text.DecimalFormat;

import javax.persistence.*;

import java.sql.Date;

@Entity
@Table
public class Transaction {	
	private static final DecimalFormat df = new DecimalFormat("#0.00");
	
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="transactionSequence")
	@SequenceGenerator(allocationSize=1, name="transactionSequence", sequenceName="SQ_TRANSACTION_PK")
	@Column(name="TRANSACTION_ID")
	private int Id;
	
	@Column(name="TRANSACTION_TYPE")
	private String type;
	
	@Column(name="TRANSACTION_USER")
	private String user;
	
	@Column(name="TRANSACTION_AMOUNT")
	private double amount;
	
	@Column(name="TRANSACTION_BALANCE")
	private double balance;
	
	@Column(name="TRANSACTION_DATE")
	private Date date;
	
	@Column(name="TRANSACTION_OTHER")
	private int otherAccount;
	
	public Transaction() {
		super();
	}
	
	public Transaction(String type, String user,  double amount,
			double balance, Date date, int otherAccount) {
		super();
		this.type = type;
		this.user = user;
		this.amount = amount;
		this.balance = balance;
		this.date = date;
		this.otherAccount = otherAccount;
	}
	
	public int getId() {
		return Id;
	}

	public void setId(int id) {
		Id = id;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public int getOtherAccount() {
		return otherAccount;
	}

	public void setOtherAccount(int otherAccount) {
		this.otherAccount = otherAccount;
	}

	// most importantly in this class is this toString() method
	// returns a String message depending on the type of transaction
	// represented by the Transaction object
	public String toString() {
		String s = date.toString() + "\n\t";
		if(this.type.equals("Withdrawal")) {
			s += (this.user + " withdrew $" + df.format(this.amount));
			s += ("\n\n\t-$" + df.format(this.amount));
			s += ("\n\tBalance: $" + df.format(this.balance));
		}
		else if(this.type.equals("Deposit")) {
			s += (this.user + " deposited $" + df.format(this.amount));
			s += ("\n\n\t+$" + df.format(this.amount));
			s += ("\n\tBalance: $" + df.format(this.balance));
		}
		else if(this.type.equals("TransferTo")) {
			s += (this.user + " transferred $" + df.format(this.amount) +
					" to account #" + this.otherAccount);
			s += ("\n\n\t-$" + df.format(this.amount));
			s += ("\n\tBalance: $" + df.format(this.balance));
		}
		else if(this.type.equals("TransferFrom")) {
			s += ("Received transfer of $" + df.format(this.amount) +
					" from account #" + this.otherAccount + " by " + this.user);
			s += ("\n\n\t+$" + df.format(this.amount));
			s += ("\n\tBalance: $" + df.format(this.balance));
		}
		else if(this.type.equals("Add")) {
			s += (this.user + " added to the account");
		}
		else if(this.type.equals("Remove")) {
			s += (this.user + " removed from the account");
		}
		else if(this.type.equals("Open")) {
			s += ("Account opened by " + this.user);
		}
		
		return s;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		long temp;
		temp = Double.doubleToLongBits(amount);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(balance);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((date == null) ? 0 : date.hashCode());
		result = prime * result + otherAccount;
		result = prime * result + ((type == null) ? 0 : type.hashCode());
		result = prime * result + ((user == null) ? 0 : user.hashCode());
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
		if (Double.doubleToLongBits(amount) != Double.doubleToLongBits(other.amount))
			return false;
		if (Double.doubleToLongBits(balance) != Double.doubleToLongBits(other.balance))
			return false;
		if (date == null) {
			if (other.date != null)
				return false;
		} else if (!date.equals(other.date))
			return false;
		if (otherAccount != other.otherAccount)
			return false;
		if (type == null) {
			if (other.type != null)
				return false;
		} else if (!type.equals(other.type))
			return false;
		if (user == null) {
			if (other.user != null)
				return false;
		} else if (!user.equals(other.user))
			return false;
		return true;
	}
	
}

