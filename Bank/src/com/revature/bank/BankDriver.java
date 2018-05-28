package com.revature.bank;
import java.util.Scanner;
import java.io.*;

public class BankDriver {

	private static final File ACCOUNT_FILE = new File("./accountFile.ser");
	
	// reads the serialized bank account information from ACCOUNT_FILE into a BankInfo object
	// creates a new file for serialization if one does not already exist
	private static BankInfo readFromFile() {
		FileInputStream fis = null;
		ObjectInputStream ois = null;
		BankInfo b = null;
		
		try {
			if(!ACCOUNT_FILE.exists()) {
				ACCOUNT_FILE.createNewFile();
				writeToFile(new BankInfo());
			}
			fis = new FileInputStream(ACCOUNT_FILE);
			ois = new ObjectInputStream(fis);
			b = (BankInfo) ois.readObject();
		} catch (EOFException e) {
			writeToFile(new BankInfo());
			b = readFromFile();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		if(b == null)
			b = new BankInfo();
		return b;
	}
	
	// serializes back account information and writes it to the ACCOUNT_FILE
	static void writeToFile(BankInfo b) {
		FileOutputStream fos = null;
		ObjectOutputStream oos = null;
		
		try {
			fos = new FileOutputStream(ACCOUNT_FILE);
			oos = new ObjectOutputStream(fos);
			oos.writeObject(b);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		BankInfo bi = readFromFile();
		BankMenu bm = new BankMenu(bi);
		bm.printHome();
	}
}
