package com.revature.bank;

import java.util.ArrayList;
import java.util.LinkedList;

import com.revature.bank.Transaction;

public class Account {
	private int id;
	private double balance;
	private String nickname;
	private ArrayList<String> users;
	private LinkedList<Transaction> transactions;
	
	public Account() {
		super();
		balance = 0;
		users = new ArrayList<String>();
		transactions = new LinkedList<Transaction>();
	}
	
	public Account(int id, double balance, String nickname) {
		super();
		this.id = id;
		this.balance = balance;
		this.nickname = nickname;
		users = new ArrayList<String>();
		transactions = new LinkedList<Transaction>();
	}
	
	public Account(int id, double balance, String nickname, ArrayList<String> users, LinkedList<Transaction> transactions) {
		super();
		this.id = id;
		this.balance = balance;
		this.nickname = nickname;
		this.users = users;
		this.transactions = transactions;
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public ArrayList<String> getUsers() {
		return users;
	}

	public void setUsers(ArrayList<String> users) {
		this.users = users;
	}

	public void setTransactions(LinkedList<Transaction> transactions) {
		this.transactions = transactions;
	}
	
	public LinkedList<Transaction> getTransactions(){
		return this.transactions;
	}

	public Transaction getTransaction(int i) {
		return this.transactions.get(i);
	}
	
	public void addTransaction(Transaction t) {
		transactions.addFirst(t);
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		long temp;
		temp = Double.doubleToLongBits(balance);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + id;
		result = prime * result + ((nickname == null) ? 0 : nickname.hashCode());
		result = prime * result + ((transactions == null) ? 0 : transactions.hashCode());
		result = prime * result + ((users == null) ? 0 : users.hashCode());
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
		Account other = (Account) obj;
		if (Double.doubleToLongBits(balance) != Double.doubleToLongBits(other.balance))
			return false;
		if (id != other.id)
			return false;
		if (nickname == null) {
			if (other.nickname != null)
				return false;
		} else if (!nickname.equals(other.nickname))
			return false;
		if (transactions == null) {
			if (other.transactions != null)
				return false;
		} else if (!transactions.equals(other.transactions))
			return false;
		if (users == null) {
			if (other.users != null)
				return false;
		} else if (!users.equals(other.users))
			return false;
		return true;
	}
}

