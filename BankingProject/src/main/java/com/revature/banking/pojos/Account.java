package com.revature.banking.pojos;

import java.util.ArrayList;

import com.revature.banking.dao.AccountImpl;
import com.revature.banking.dao.BankAccountImpl;

public class Account extends AccountImpl{
	
	public Account() {
		super();
	}

	public Account(int user_id, String user_name, String pass) {
		super();
		this.user_id = user_id;
		this.user_name = user_name;
		this.pass = pass;
		this.bankAccounts=accessBankAccounts(user_id);
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

	public ArrayList<BankAccount> getBankAccounts() {
		return bankAccounts;
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
