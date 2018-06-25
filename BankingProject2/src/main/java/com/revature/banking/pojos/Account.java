package com.revature.banking.pojos;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.hibernate.annotations.Where;

import com.revature.banking.dao.AccountImpl;
import com.revature.banking.dao.BankAccountImpl;

@Entity
@Table
public class Account extends AccountImpl{
	
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="accountSequence")
	@SequenceGenerator(allocationSize=1, name="accountSequence", sequenceName="SQ_ACCOUNT_PK")
	@Column(name="USER_ID")
	private int user_id;
	
	@Column
	private String user_name;
	
	@Column
	private String pass;
	
	/**
	 * @ManyToOne
@JoinTable(name = "user_locations", joinColumns = @JoinColumn(name="user_id"), inverseJoinColumns = @JoinColumn(name = "location_id"))
public void setLocation(Location location) {
    this.location = location;
}
	 */
	
	@Transient
	@OneToMany(fetch = FetchType.EAGER)
	@JoinTable(
			name="ACCOUNT_BANK_ACCOUNTS",
			joinColumns = { @JoinColumn(name="USER_ID") },
			inverseJoinColumns = { @JoinColumn(name="USER_ID")} )
	private List<BankAccount> bankAccounts;
	
	public Account() {
		super();
	}

	public Account(int user_id, String user_name, String pass) {
		super();
		this.user_id = user_id;
		this.user_name = user_name;
		this.pass = pass;
		//this.bankAccounts=accessBankAccounts(user_id);
	}
	
	public Account(String user_name, String pass) {
		this.user_name=user_name;
		this.pass=pass;
	}
	
	public int getUser_id() {
		return user_id;
	}

	public String getUser_name() {
		return user_name;
	}

	public String getPass() {
		return pass;
	}

	public List<BankAccount> getBankAccounts() {
		return bankAccounts;
	}
	
	public void setBankAccounts(List<BankAccount> bankAccounts) {
		this.bankAccounts=bankAccounts;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((bankAccounts == null) ? 0 : bankAccounts.hashCode());
		result = prime * result + ((pass == null) ? 0 : pass.hashCode());
		result = prime * result + user_id;
		result = prime * result + ((user_name == null) ? 0 : user_name.hashCode());
		return result;
	}

	@Override
	public String toString() {
		return "AccountImpl [user_id=" + user_id + ", user_name=" + user_name + ", pass=" + pass + ", bankAccounts="
				+ bankAccounts + "]";
	}
	
	
}
