package com.revature.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table
public class BankUser {
	@Id
	@Column(name="BANK_USERNAME", columnDefinition="VARCHAR2(25)")
	String username;
	
	@Column(name="USER_PASSWORD ", columnDefinition="VARCHAR2(25)" )
	String password;
	
	public BankUser() {
		super();
	}
	
	public BankUser(String username, String password) {
		super();
		this.username = username;
		this.password = password;
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
}
