package com.revature.pojos;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

@Entity
@Table(name="JPA_ACCOUNT")
public class Account {
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="accountSequence")
	@SequenceGenerator(allocationSize=1, name="accountSequence", sequenceName="HSQ_ACCTOUNT_SQ")
	@Column(name="ACCOUNT_NUMBER")
	private long accountNumber;
	
	@Column
	private double balance;
	
	@ManyToMany(fetch=FetchType.EAGER)
	@JoinTable(
			name="JPA_USER_ACCOUNT",
			joinColumns={@JoinColumn(name="ACCOUNT_NUMBER")},
			inverseJoinColumns={@JoinColumn(name="USER_ID")})
	private List<User> users = new ArrayList<User>();
	
	public Account() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Account(long accountNumber, double balance, List<User> jointUsers) {
		super();
		this.accountNumber = accountNumber;
		this.balance = balance;
		this.users = jointUsers;
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
	public List<User> getUsers() {
		return users;
	}
	public void setUsers(List<User> users) {
		this.users = users;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (accountNumber ^ (accountNumber >>> 32));
		long temp;
		temp = Double.doubleToLongBits(balance);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((users == null) ? 0 : users.hashCode());
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
		if (users == null) {
			if (other.users != null)
				return false;
		} else if (!users.equals(other.users))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Account [accountNumber=" + accountNumber + ", balance=" + balance + ", users=" + users + "]";
	}
}
