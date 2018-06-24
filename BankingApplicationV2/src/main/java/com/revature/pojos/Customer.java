package com.revature.pojos;

import javax.persistence.*;

@Entity
@Table
public class Customer {
	
	@Id
	@Column(name="Username")
	private String username;
	
	@Column(name="Password")
	private String password;
	
	@Column(name="Balance")
	private int balance;
	
	
	public Customer() {
		super();
	}


	public Customer(String username, String password, int balance) {
		super();
		this.username = username;
		this.password = password;
		this.balance = balance;
	}


	@Override
	public String toString() {
		return "Customer [username=" + username + ", password=" + password + ", balance="
				+ balance + "]";
	}

	public String getUsername() {
		return username;
	}


	public void setUsername(String username) {
		this.username = username;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	public int getBalance() {
		return balance;
	}


	public void setBalance(int balance) {
		this.balance = balance;
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + balance;
		result = prime * result + ((password == null) ? 0 : password.hashCode());
		result = prime * result + ((username == null) ? 0 : username.hashCode());
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
		Customer other = (Customer) obj;
		if (balance != other.balance)
			return false;
		if (password == null) {
			if (other.password != null)
				return false;
		} else if (!password.equals(other.password))
			return false;
		if (username == null) {
			if (other.username != null)
				return false;
		} else if (!username.equals(other.username))
			return false;
		return true;
	}

}
