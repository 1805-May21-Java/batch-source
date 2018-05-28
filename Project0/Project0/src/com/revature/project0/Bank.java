package com.revature.project0;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class Bank {
	private ArrayList<Account> accounts;

	public Bank() {
		super();
	}
	
	public Bank(ArrayList<Account> accounts) {
		super();
		this.accounts = accounts;
	}
	
	public void save(String content, boolean append) {
		String path = "src/com/revature/project0/Data.txt";
		BufferedWriter bw = null;
		File file = new File(path);
		FileWriter fw = null;
		try {
			if(!file.exists())
				file.createNewFile();
			
			if(append)
				fw = new FileWriter(file, true);
			else
				fw = new FileWriter(file);
			
			bw = new BufferedWriter(fw);
			bw.write(content);
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if(bw != null) {
				try {
					bw.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}
	
	public void edit(String username, String content) {
		BufferedReader br = null;
		String path = "src/com/revature/project0/Data.txt";
		StringBuilder input = new StringBuilder();
		try {
			br = new BufferedReader(new FileReader(path));
			String line = null;
			
			
			while((line = br.readLine()) != null) {
				String[] parts = line.split(",");
				if(parts[0].equals(username)) {
					input.append(content);
				} else {
					input.append(line + "\n");
				}
			}
			
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if(br != null) {
				try {
					br.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		String inputStr = input.toString();
		save(inputStr, false);
	}
	
	public boolean createAccount(Account newAccount) {
		for(Account account : accounts) {
			if(account.getUsername().equals(newAccount.getUsername())) { // duplicate account
				return false;
			}
		}
		
		accounts.add(newAccount);
		
		save(newAccount.getUsername() + "," + newAccount.getPassword() + "," + newAccount.getBalance() + "\n", true);
		
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
		edit(account.getUsername(), account.getUsername() + "," + account.getPassword() + "," + account.getBalance() + "\n");

		for(Account acc : accounts) {
			if(acc.getUsername().equals(account.getUsername())) {
				acc.setLoggedIn(false);
			}
		}
		return false;
	}
}
