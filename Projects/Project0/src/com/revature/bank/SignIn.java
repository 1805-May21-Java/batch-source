package com.revature.bank;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;
import java.util.Vector;

public class SignIn
{

	private static Vector<String> users = new Vector<>();
	public SignIn()
	{
		
	}	
	public static void readFile()	
	{
		BufferedReader br = null;
		String path = "src/com/revature/resource/users.txt";
		try {
			br = new BufferedReader(new FileReader(path));
			String line = br.readLine();
			
			// read the file until there are no more lines to read
			while(line != null) {
				//System.out.println(line);
				users.add(line);
				line = br.readLine();
			}
			//System.out.println(users);

		} catch (IOException e) {

			e.printStackTrace();
		}
		finally 
		{
			if(br != null) 
			{
				try 
				{
					br.close();
				} catch (IOException e) 
				{
					e.printStackTrace();
				}
			}
		}
	}
	
	public static Vector<String> getUsers()
	{
		return users;
	}

	public static void setUsers(Vector<String> users)
	{
		SignIn.users = users;
	}

	public static int findIndexOfMatchName(String str)
	{
		for(int i=0; i<users.size(); i++)
		{
			if(users.get(i).substring(0, str.length()).equals(str))
			{
				return i;
			}
		}
		return -1;
		
	}
	public static boolean logIn()
	{
		SignIn.getUsers().clear();
		SignUp.getUsers().clear();
		readFile();
		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter your user name to sign in:");
		String user = sc.nextLine();

		if(SignUp.isDuplicated(user))
		{
			
			System.out.println("Enter your password:");
			String pwd = sc.nextLine();
			String line = users.get(findIndexOfMatchName(user));
			String[] lineArray = line.split(" ");
			Account.setBalance(Double.parseDouble(lineArray[2]));
			if(users.contains(user+" "+pwd+" "+lineArray[2]))
				{
					Account.setUser(user);
					Account.setPassword(pwd);
					return true;
				}
			else {
				System.out.println("*******************************");
				System.out.println("Your Password Is Not Valid!");
				System.out.println("*******************************\n");
				try
				{
					Display.welcome();
				} catch (IOException e)
				{
					e.printStackTrace();
				}
				
			}
		}else
		{
			System.out.println("*******************************");
			System.out.println("Your User Name Does Not Exist!");
			System.out.println("*******************************\n");
			try
			{
				Display.welcome();
			} catch (IOException e)
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return false;
	}


}
