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
}

