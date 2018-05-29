package project0.data;

import java.io.Serializable;

public class User implements Serializable {
	
	private static final long serialVersionUID = 1;
	
	private String username;
	private long accountID;
	private String password;
	
	public User (String username, long accountID){
		this.username = username;
		this.accountID = accountID;
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
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
}
