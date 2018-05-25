package com.revature;

import java.io.Serializable;

public class BankAccount implements Serializable{

	private static final long serialVersionUID = 6137519972665705247L;
	private double balence;
	private String email;
	private String username;
	private String password;
	transient private boolean isLoggedIn = false;
	
	public BankAccount() {
		super();
	}

	public BankAccount(double balence, String email, String username, String password){
		super();
		this.balence = balence;
		this.email = email;
		this.username = username;
		this.password = password;
	}

	public double withdraw(double amountToWithdraw) {
		if(this.balence - amountToWithdraw < 0) {
			System.out.println("You don't have that much money!");
			return balence;
		}else {
			this.balence -= amountToWithdraw;
			return balence;
		}
	}
	
	public double deposit(double amountToDeposit) {
		balence += amountToDeposit;
		return balence;
	}

	public double getBalence() {
		return balence;
	}

	public void setBalence(double balence) {
		this.balence = balence;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
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

	public boolean isLoggedIn() {
		return isLoggedIn;
	}

	public void setLoggedIn(boolean isLoggedIn) {
		this.isLoggedIn = isLoggedIn;
	}

	@Override
	public String toString() {
		return String.format("Username: %s, Balance: $%.2f", this.username,this.balence);
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		long temp;
		temp = Double.doubleToLongBits(balence);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((email == null) ? 0 : email.hashCode());
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
		BankAccount other = (BankAccount) obj;
		if (Double.doubleToLongBits(balence) != Double.doubleToLongBits(other.balence))
			return false;
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
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
