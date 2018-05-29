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
			System.out.println(users);

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


	public static boolean logIn()
	{
		readFile();
		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter your user name to sign in:");
		String user = sc.nextLine();
		System.out.println("~~~~~");
		System.out.println(SignUp.isDuplicated(user));
		if(SignUp.isDuplicated(user))
		{
			System.out.println("Enter your password:");
			String pwd = sc.nextLine();
			if(users.contains(user+" "+pwd))
				{
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
					// TODO Auto-generated catch block
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
