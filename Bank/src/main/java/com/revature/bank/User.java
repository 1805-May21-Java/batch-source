package com.revature.bank;

import java.util.ArrayList;

public class User {
	private String user;
	private String pass;
	private ArrayList<Integer> accounts;
	
	public User() {
		this.accounts = new ArrayList<Integer>();
	}
	
	public User(String user, String pass) {
		super();
		this.user = user;
		this.pass = pass;
		this.accounts = new ArrayList<Integer>();
	}
	
	public User(String user, String pass, ArrayList<Integer> accounts) {
		super();
		this.user = user;
		this.pass = pass;
		this.accounts = accounts;
	}

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public String getPass() {
		return pass;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}

	public ArrayList<Integer> getAccounts() {
		return accounts;
	}

	public void setAccounts(ArrayList<Integer> accounts) {
		this.accounts = accounts;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((pass == null) ? 0 : pass.hashCode());
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
		User other = (User) obj;
		if (pass == null) {
			if (other.pass != null)
				return false;
		} else if (!pass.equals(other.pass))
			return false;
		if (user == null) {
			if (other.user != null)
				return false;
		} else if (!user.equals(other.user))
			return false;
		return true;
	}
}

