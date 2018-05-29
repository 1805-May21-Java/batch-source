package com.revature.banking;

import java.io.*;
import java.util.ArrayList;

public class Bank 
{

	private ArrayList<Account> accountList;

	public Bank() 
	{
		super();
	}
	public Bank(ArrayList<Account> accounts) 
	{
		super();
		this.accountList = accounts;
	}
	
	public void saveAccount(String str, boolean append)
	{
		String path = "src/com/revature/banking/Data.txt";
		BufferedWriter bw = null;
		File file = new File(path);
		FileWriter fw = null;
		
		try
		{
			if(!file.exists())
				file.createNewFile();
			
			if(append)
				fw = new FileWriter(file, true);
			else
				fw = new FileWriter(file);
			
			bw = new BufferedWriter(fw);
			bw.write(str);
			
		}
		catch(IOException e)
		{
			e.printStackTrace();
		}
		finally
		{
			try 
			{
				bw.close();
			} 
			catch (IOException e) 
			{
				e.printStackTrace();
			}
				
		}
		
		
	}
	
	public void editAccount(String username, String str)
	{
		BufferedReader br = null;
		String path = "src/com/revature/banking/Data.txt";
		StringBuilder sb = new StringBuilder();
		
		try
		{
			br = new BufferedReader(new FileReader(path));
			String line;
			
			while((line = br.readLine()) != null)
			{
				String[] strArr = line.split(",");
				if(strArr[0].equals(username))
					sb.append(str);
				else
					sb.append(line + "\n");
			}
		}
		catch(IOException e)
		{
			e.printStackTrace();
		}
		finally
		{
			try 
			{
				br.close();
			}
			catch (IOException e) 
			{
				e.printStackTrace();
			}
		}
		String input = sb.toString();
		saveAccount(input, false);
	}
	
	public boolean createNewAccount(Account account)
	{
		for(Account a : accountList)
		{
			//testing and preventing the creation of a duplicate account.
			if(a.getUsername().equalsIgnoreCase(account.getUsername()))
				return false;
		}
		
		accountList.add(account);
		
		saveAccount(account.getUsername() + "," + account.getPassword() + "," +  account.getBalance() + "\n", true);
		
		account.setLoggedIn(true);
		return true;
	}
	
	public boolean login(String username, String password)
	{
		for(Account a : accountList)
		{
			if(a.getUsername().equalsIgnoreCase(username))
			{
				if(!a.getPassword().equals(password))
				{
					System.out.println("Incorrect username and password combination!");
					return false;
				}
				else
				{
					System.out.println("Login Successful!");
					a.setLoggedIn(true);
					return true;
				}
			}
		}
		return false;
	}

	public boolean logout(Account account)
	{
		editAccount(account.getUsername(), account.getUsername() + "," + account.getPassword() + "," + account.getBalance() + "\n");
		
		for(Account a : accountList)
		{
			if(a.getUsername().equalsIgnoreCase(account.getUsername()))
				a.setLoggedIn(false);
		}
		return false;
	}
}
