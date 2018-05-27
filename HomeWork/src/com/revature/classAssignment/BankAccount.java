package com.revature.classAssignment;

public class BankAccount {
	 private String username;
	 private String email;
	 private double balance;// assigned balance 
	 
	public BankAccount(String username, String email, double balance) {
		super();
		this.username = username;
		this.email = email;
		this.balance = balance;
	}

	public  void depositBalance(double amount) {
		balance = balance + amount;
		//System.out.println("available balance is  $  " + balance );
		 
	}
	public  void withdrawBalance(double amount) {
		balance = balance - amount;
		//System.out.println("available balance after withdrawal is $   " + balance );
	}
	public void viewBalance(double afterWithdraw) { // passing object as a parameter
		System.out.println("available balance is $ " + afterWithdraw);// shows the available balance
	}
	
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

	@Override
	public String toString() {
		return "BankAccount [username=" + username + ", email=" + email + ", balance=" + balance + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		long temp;
		temp = Double.doubleToLongBits(balance);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((email == null) ? 0 : email.hashCode());
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
		if (Double.doubleToLongBits(balance) != Double.doubleToLongBits(other.balance))
			return false;
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
			return false;
		if (username == null) {
			if (other.username != null)
				return false;
		} else if (!username.equals(other.username))
			return false;
		return true;
	}
		


}