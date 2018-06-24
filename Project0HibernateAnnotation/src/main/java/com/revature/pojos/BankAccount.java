package com.revature.pojos;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.revature.dao.BankContract;

@Entity
@Table(name=BankContract.ANNOTATIONS_BANK_TABLE_NAME)
public class BankAccount implements Serializable{

	@Transient
	private static final long serialVersionUID = 6137519972665705247L;
	@Column
	private double balence;
	@Column
	private String accountName;
	@Column(name="ACCOUNT_ID")
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE,generator="accountSequence")
	@SequenceGenerator(allocationSize=1,name="accountSequence",sequenceName="SQ_ACCOUNT_PK")
	private int bankId;
	//multiple clients can own an account, but this refers to the account accessing at this time
	@Transient
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
