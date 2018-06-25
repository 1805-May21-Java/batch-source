package com.Revature.pojos;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

@Entity
@Table
public class UserProfile {
	// Define username and password for user progile
	@Id
	@Column(name = "USERNAME")
	private String username;

	@Column(name="PWD")
	private String password;

	@ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinTable(name = "USER_PROFILE_BANK_ACCOUNT", joinColumns = {
			@JoinColumn(name = "USERNAME") }, inverseJoinColumns = { @JoinColumn(name = "ACCOUNT_NUMBER") })
	private List<BankAccount> accounts;

	public UserProfile() {
		super();
		// TODO Auto-generated constructor stub
	}

	public UserProfile(String username, String password) {
		this.username = username;
		this.password = password;
		this.accounts = new ArrayList<BankAccount>();
	}

	public UserProfile(String username, String password, List<BankAccount> accounts) {
		super();
		this.username = username;
		this.password = password;
		this.accounts = accounts;
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

	public List<BankAccount> getAccounts() {
		return accounts;
	}

	public void setAccounts(List<BankAccount> accounts) {
		this.accounts = accounts;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((accounts == null) ? 0 : accounts.hashCode());
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
		UserProfile other = (UserProfile) obj;
		if (accounts == null) {
			if (other.accounts != null)
				return false;
		} else if (!accounts.equals(other.accounts))
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

	@Override
	public String toString() {
		return "UserProfile [username=" + username + ", password=" + password + ", accounts=" + accounts + "]";
	}

}
