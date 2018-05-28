package com.revature.project0;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class Bank {
	private ArrayList<Account> accounts;

	public Bank() {
		super();
		this.accounts = new ArrayList<Account>();
	}
	
	public Bank(ArrayList<Account> accounts) {
		super();
		this.accounts = accounts;
	}
	
	public void save() {
		String path = "src/com/revature/project0/Data.ser";
		try (FileOutputStream fos = new FileOutputStream(path); ObjectOutputStream oos = new ObjectOutputStream(fos)) {
			oos.writeObject(accounts);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void read() {
		String path = "src/com/revature/project0/Data.ser";

		try (FileInputStream fis = new FileInputStream(path); ObjectInputStream ois = new ObjectInputStream(fis)) {
			accounts = (ArrayList<Account>) ois.readObject();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	public boolean createAccount(Account newAccount) {
		for(Account account : accounts) {
			if(account.getUsername().equals(newAccount.getUsername())) { // duplicate account
				return false;
			}
		}
		
		accounts.add(newAccount);
		System.out.println(accounts);
		save();
		
		newAccount.setLoggedIn(true);
		
		return true;
	}
	
	public boolean login(String username, String password) {
		for(Account account : accounts) {
			if(account.getUsername().equals(username)) {
				if(!account.getPassword().equals(password)) {
					System.out.println("Incorrect username/password combination");
					return false;
				} else {
					System.out.println("Successfully logged in.");
					account.setLoggedIn(true);
					return true;
				}
			}
		}
		return false;
	}
	
	public boolean logout(Account account) {
		save();

		for(Account acc : accounts) {
			if(acc.getUsername().equals(account.getUsername())) {
				acc.setLoggedIn(false);
			}
		}
		return false;
	}
	
	public boolean transfer(String username, double amount) {
		for(Account account : accounts) {
			if(account.getUsername().equals(username)) {
				account.deposit(amount);
				return true;
			}
		}
		return false; // account does not exist
	}

	public ArrayList<Account> getAccounts() {
		return accounts;
	}

	public void setAccounts(ArrayList<Account> accounts) {
		this.accounts = accounts;
	}
}
