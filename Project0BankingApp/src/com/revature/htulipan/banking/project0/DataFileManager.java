package com.revature.htulipan.banking.project0;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

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
				if (entryParts[0].equals(name)) {
					return true;
				}
				line = fileReader.readLine();
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
				if (entryParts[0].equals(name) && entryParts[1].equals(password)) {
					account = new BankingAccount(entryParts[0], entryParts[1], Float.parseFloat(entryParts[2]));
					break;
				}
				line = fileReader.readLine();
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
		if (!usernameExists(account.getUsername())) {
			return;
		}
		
		try {
			Path path = FileSystems.getDefault().getPath(filepath);
			List<String> lines = Files.readAllLines(path, StandardCharsets.UTF_8);
			for (int i = 0; i < lines.size(); i++) {
				String[] lineParts = lines.get(i).split(" ");
				if (lineParts[0].equals(account.getUsername())) {
					lines.set(i, account.toString());
					break;
				}
			}
			Files.write(path, lines, StandardCharsets.UTF_8);
		} catch (IOException ioe) {
			ioe.printStackTrace();
		}
	}
	
	public void storeAccount(BankingAccount account) {
		if (usernameExists(account.getUsername())) {
			updateAccount(account);
		} else {
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
}
