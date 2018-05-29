package com.revature.htulipan.banking.project0;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class DataFileManager {
	private String filepath = "src/com/revature/htulipan/banking/project0/Data.txt";
	
	public DataFileManager() {
		super();
	}

	public String getFilepath() {
		return filepath;
	}

	public void setFilepath(String filepath) {
		this.filepath = filepath;
	}
	
	public boolean usernameExists(String name) {
		BufferedReader fileReader = null;
		try {
			fileReader = new BufferedReader(new FileReader(filepath));
			String line = fileReader.readLine();
			while (line != null) {
				String[] entryParts = line.split(" ");
				if (entryParts[0] == name) {
					return true;
				}
			}
		} catch (IOException ioe) {
			ioe.printStackTrace();
		} finally {
			try {
				fileReader.close();
			} catch (IOException ioe) {
				ioe.printStackTrace();
			}
		}
		return false;
	}
	
	public BankingAccount getAccount (String name, String password) {
		BufferedReader fileReader = null;
		BankingAccount account = null;
		try {
			fileReader = new BufferedReader(new FileReader(filepath));
			String line = fileReader.readLine();
			while (line != null) {
				String[] entryParts = line.split(" ");
				if (entryParts[0] == name && entryParts[1] == password) {
					account = new BankingAccount(entryParts[0], entryParts[1], Float.parseFloat(entryParts[2]));
					break;
				}
			}
		} catch (IOException ioe) {
			ioe.printStackTrace();
		} finally {
			try {
				fileReader.close();
			} catch (IOException ioe) {
				ioe.printStackTrace();
			}
		}
		return account;
	}
	
	public void updateAccount(BankingAccount account) {
		
	}
	
	public void storeAccount(BankingAccount account) {
		BufferedWriter fileWriter = null;
		try {
			fileWriter = new BufferedWriter(new FileWriter(filepath, true));
			fileWriter.write(account.toString());
			fileWriter.newLine();
		} catch (IOException ioe) {
			ioe.printStackTrace();
		} finally {
			try {
				fileWriter.close();
			} catch (IOException ioe) {
				ioe.printStackTrace();
			}
		}
	}
}
