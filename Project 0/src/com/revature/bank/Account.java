package com.revature.bank;
import java.util.*;
import java.io.*;

public class Account
{
	//declaring variables and setting up the has map
	int balance;
	String email;
	
	HashMap<String, Account> accountID = new HashMap<>();
	
	//auto generated constructors
	public Account()
	{
		super();
	}
	public Account(String email, int balance)
	{
		super();
		this.balance = balance;
		this.email = email;
	}
	
	//the update method that writes our changes to the file when called
	//it updates the data by calling getEmail and getBalance on each of the Account objects
	//it then puts them together with my deliniator of choice the ':'
	//after that it writes that string to the file with a new line return on the end for the next line of data to be written
	//I made it static so I could call it anywhere in my driver
	public static void updateData(HashMap<String, Account> clientInfo) throws IOException
	{
		String path = "src/com/revature/bank/User_Data";
		BufferedWriter bw = null;
		File file = new File(path);
		FileWriter fw = new FileWriter(file, false);
		bw = new BufferedWriter(fw);
		
		for(Account client : clientInfo.values())
		{
			String email = client.getEmail();
			int balance = client.getBalance();
			
			String line = email+":"+balance;
			bw.write(line+"\n");
		}
		//closing the bufferedwritter and fiewritter to stop resource leaks
		bw.close();
		fw.close();

	}
	
	//auto generated getters and setters
	public int getBalance()
	{
		return balance;
	}
	
	public void setBalance(int balance)
	{
		this.balance = balance;
	}
	
	public void setEmail(String email)
	{
		this.email = email;
	}
	
	public String getEmail()
	{
		return email;
	}
	
}
