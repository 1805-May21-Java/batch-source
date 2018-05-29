package project0.data;

import java.io.Serializable;

public class Account implements Serializable{
	
	private double savings;
	private String username;
	private long accountID;
	
	private static final long serialVersionUID = 1;
	
	public Account (String username, long accountID) {
		this.username = username;
		this.accountID = accountID;
		savings = 0.;
	}
	
	public double getSavings() {
		return savings;
	}
	public void setSavings(double savings) {
		this.savings = savings;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public long getAccountID() {
		return accountID;
	}
	public void setAccountID(long accountID) {
		this.accountID = accountID;
	}
	
}
