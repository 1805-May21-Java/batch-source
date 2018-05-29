package com.revature.banking;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class SerializeData {

	// String to hold the path to the desired file
	private String path;

	// Constructor with call to the super class
	public SerializeData() {
		super();
	}

	// Constructor with call to the super class that also sets the path variable
	public SerializeData(String path) {
		super();
		this.path = path;
	}

	// Getter to return the path variable
	public String getPath() {
		return path;
	}

	// Setter to set the path variable
	public void setPath(String path) {
		this.path = path;
	}
	
	// Method that saves the data of an ArrayList with Account objects into the file specified by path variable
	public void serialize(ArrayList<Account> accounts) {
		FileOutputStream fileStream;
		ObjectOutputStream objectStream;
		try {
			fileStream=new FileOutputStream(new File(path));
			objectStream=new ObjectOutputStream(fileStream);
			
			objectStream.writeObject(accounts);
			
			fileStream.close();
			objectStream.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	// Method to retrieve the contents of the file specified in the path variable
	public ArrayList<Account> deserialize() {
		FileInputStream fileStream;
		ObjectInputStream objectStream;
		ArrayList<Account> accounts = null;
		try {
			
			fileStream=new FileInputStream(new File(path));
			objectStream=new ObjectInputStream(fileStream);
			
			accounts=(ArrayList<Account>) objectStream.readObject();
			
			fileStream.close();
			objectStream.close();
			
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			//e.printStackTrace();
			return null;
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		return accounts;
		
	}
}
