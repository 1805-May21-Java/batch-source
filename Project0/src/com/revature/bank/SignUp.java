package com.revature.bank;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import java.util.Vector;

public class SignUp extends SignIn
{
	private static Vector<String> users= new Vector<>();
	public SignUp()
	{
		
	}

	public static boolean isDuplicated(String user)
	{
		users = getUsers();
		String[] str;
		for(int i=0; i<users.size(); i++)
		{
			str = users.get(i).split(" ");
			if(str[0].equals(user))
				return true;
			
		}
		return false;

	}
	
	public static void writeFile(String user, String pwd)
	{
		BufferedWriter bw = null;
		String path = "src/com/revature/resource/users.txt";
		try
		{
			
			File file = new File(path);
			
			// checking first to see if the file exists, creating it if it doesn't
			if(!file.exists()) 
			{
				file.createNewFile();
			}
			
			// our FileWriter has an optional argument which specifies whether it will append 
			FileWriter fw = new FileWriter(file, true);
			bw = new BufferedWriter(fw);
			
			bw.write("\n"+user+" "+pwd+" 0");
			
		
		} catch (IOException e) {
			e.printStackTrace();
		} finally 
		{
			if(bw != null) 
			{
				try 
				{
					bw.close();
				} catch (IOException e) 
				{
					e.printStackTrace();
				}
			}
		}
	}
	
	public static void writeFile()
	{
		BufferedWriter bw = null;
		String path = "src/com/revature/resource/users.txt";
		try
		{
			
			File file = new File(path);
			
			// checking first to see if the file exists, creating it if it doesn't
			if(!file.exists()) 
			{
				file.createNewFile();
			}
			
			// our FileWriter has an optional argument which specifies whether it will append 
			FileWriter fw = new FileWriter(file);
			bw = new BufferedWriter(fw);
			for(int i=0; i<users.size();i++)
			{
				if(i<users.size()-1)
					
					bw.write(users.get(i)+"\n");
				else {
					bw.write(users.get(i));
				}
			}
			

		} catch (IOException e) {
			e.printStackTrace();
		} finally 
		{
			if(bw != null) 
			{
				try 
				{
					bw.close();
				} catch (IOException e) 
				{
					e.printStackTrace();
				}
			}
		}
	}

	
	public static void createUser() throws IOException
	{
		SignIn.getUsers().clear();
		SignUp.getUsers().clear();

		SignIn.readFile();
		users = getUsers();
		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);
		boolean flag = true;
		boolean flag2= true;
		// specifying the file we want to write to
		System.out.println("Enter Your Username or Email To Sign Up:");
		String user = sc.nextLine();
		while(isDuplicated(user))
		{
			System.out.println("That Username Is Taken, Try Another.");
			user = sc.nextLine();
			
		}
		
		String pwd, pwd2;
		do
		{
			if(flag)
			{
				if(!flag2) System.out.println("You Password Cannot Be Empty!");
				System.out.println("Please Enter Your New Password:");
				flag=false;
			}
			else
			{
				System.out.println("Try Again, Your Password Did Not Match\n Please Enter Your New Password:");
			}
			
			pwd = sc.nextLine();
			
			if(!pwd.equals("")) {
				System.out.println("Please verify your new password: ");
				pwd2= sc.nextLine();
			}
			else
			{
				flag=true;;
				flag2=false;
				pwd2="none";
			}
		}while(!pwd.equals(pwd2));
	
		writeFile(user, pwd);
	}
}
