package com.revature.bank;

import java.util.InputMismatchException;
import java.util.Vector;

public class Account
{
	private static double balance;
	private static String user;
	private static String password;
	
	
	public static String getUser()
	{
		return user;
	}

	public static void setUser(String user)
	{
		Account.user = user;
	}

	public static String getPassword()
	{
		return password;
	}

	public static void setPassword(String password)
	{
		Account.password = password;
	}

	public static double getBalance()
	{
		System.out.println("**************************************");
		System.out.println("You Current Balance is "+ balance);
		System.out.println("**************************************\n");
		return balance;
	}

	public static void setBalance(double balance)
	{
		Account.balance = balance;
	}
	
	public static void updateBalance(String str)
	{
		Vector<String> users = SignIn.getUsers();
		int index = SignIn.findIndexOfMatchName(str);
		String line = users.get(index);
		String[] lineArray = line.split(" ");
		users.set(index, lineArray[0]+" "+lineArray[1]+" "+Account.balance);
		SignIn.setUsers(users);
	}

	public void deposit(Double value)  
	{
		try
		{
			if(value<0) 
			{
				throw new IllegalArgumentException("************************************************\n ! Your Deposit Amount Can Only Be Positive ! \n************************************************\n\"");

			}
			else if(value>=0)
			{
				balance+=value;
				System.out.println("**************************************");
				System.out.println("You Have Deposited $"+value+" Successfully!");
				System.out.println("You Current Balance is "+balance);
				System.out.println("**************************************\n");
				updateBalance(user);
			}
			else
			{
				throw new InputMismatchException("Your Deposit Amount Has To Be Number");
			}
		}
		catch(IllegalArgumentException e)
		{
			System.out.println(e.getMessage());
		}
		catch(InputMismatchException e)
		{
			System.out.println(e.getMessage());
		}

	}
	
	public void withdraw(Double value)
	{
		
		try
		{
			if(balance<value || value<0)
			{
				throw new IllegalArgumentException("*!!!! Your Withdraw Amount Cannot Be Processed !!!!");

			}
			else if(value>=0)
			{
				balance-=value;
				System.out.println("**************************************");
				System.out.println("You Have Withdrawed $"+value+" Successfully!");
				System.out.println("You Current Balance is "+balance);
				System.out.println("**************************************\n");
				updateBalance(user);
				
			}
			else
			{
				throw new InputMismatchException("Your Withdraw Amount Has To Be Number");

			}
		}
		catch(IllegalArgumentException e)
		{
			System.out.println(e.getMessage());
		}

	}

	public Account()
	{
		
		

	}

}
