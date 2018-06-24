package com.revature.pojos;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.revature.dao.BankContract;

//This class creates Clients, who may have one or more bank accounts, stored in an ArrayList
@Entity
@Table(name=BankContract.ANNOTATIONS_CLIENT_TABLE_NAME)
public class Client implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 7164980474022034266L;
	//List of all accounts the user has

	@ManyToMany
	@JoinTable(
			name=BankContract.ANNOTATIONS_CLIENT_ACCOUNT_TABLE_NAME,
			joinColumns= {@JoinColumn(name=BankContract.ANNOTATIONS_CLIENT_EMAIL)}, 
			inverseJoinColumns={@JoinColumn(name=BankContract.ANNOTATIONS_BANK_ID)})
	private List<BankAccount> accounts = new ArrayList<>();
	
	@Column
	private String username;
	@Column
	private String password;
	@Column(name=BankContract.ANNOTATIONS_CLIENT_EMAIL)
	@Id
	private String email;

	public Client() {
		super();
		accounts = new ArrayList<>();
	}
	
	public Client(ArrayList<BankAccount> accounts, String username, String password, String email) {
		super();
		this.accounts = accounts;
		this.username = username;
		this.password = password;
		this.email = email;
	}

	

	public ArrayList<BankAccount> getAccounts() {
		return (ArrayList<BankAccount>) accounts;
	}


	public void addNewAccount(BankAccount account) {
		accounts.add(account);
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


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	@Override
	public String toString() {
		return "Client [accounts=" + accounts + ", username=" + username + ", password=" + password + ", email=" + email
				+ "]";
	}
	
	
	
	

}
