package com.revature.beans;

import java.io.*;
import java.util.*;

import com.revature.accountGrouping.*;
import com.revature.errors.DuplicateUserNameException;
import com.revature.errors.NoSuchUserException;

public class Menu
{
	Scanner sc = new Scanner(System.in);
	
	private AccountList accounts = null;
	private Account loggedInAccount = null;
	private String[] menuOptions = {"Create an account", "Log in", "Log off", "Make a deposit", "Make a withdrawl", "View Balance", "Exit"};
	private boolean isRunning = true;
	
	public Menu()
	{
		super();
	}
	
	public void runMenu()
	{
		deserializeData(); //Retrieve data from the file
		while(isRunning)
		{
			printMenu();
			takeAction(getChoice());
		}
	}

	public void takeAction(int choice)
	{
		switch(choice)
		{
			case 1:
				createAccount();
				break;
			case 2:
				logIn();
				break;
			case 3:
				loggedInAccount = null;
				break;
			case 4:
				deposit();
				break;
			case 5:
				withdraw();
				break;
			case 6:
				System.out.println(loggedInAccount.getBalance());
				break;
			case 7:
				isRunning = false;
				break;
		}
		serializeData();
	}
	
	private void withdraw()
	{
		System.out.print("Enter an amount to withdraw: ");
		try
		{
			double withdrawl = sc.nextDouble();
			loggedInAccount.withdraw(withdrawl);
		}
		catch(NumberFormatException e)
		{
			System.out.println("Invalid number.");
			withdraw();
		}
		catch(NullPointerException e)
		{
			System.out.println("You are not logged into an account.  Please log in before making a withdrawl");
		}
	}

	private void deposit()
	{
		System.out.print("Enter an ammount to deposit: ");
		try
		{
			double depositValue = sc.nextDouble();
			loggedInAccount.deposit(depositValue);
		}
		catch(NumberFormatException e)
		{
			System.out.println("Invalid entry.");
			deposit();
		}
		catch(NullPointerException e)
		{
			System.out.println("You are not logged into an account.  Please log in before making a deposit");
		}
	}

	private void logIn()
	{
		boolean isValidLogin = false;
		System.out.print("Enter the username or email associated with the account: ");
		String userName = sc.nextLine();
		try
		{
			loggedInAccount = accounts.logOn(userName);
		}
		catch (NoSuchUserException e)
		{
			e.printStackTrace();
			logIn();
		}
	}

	private void createAccount()
	{
		System.out.print("Enter a username or email: ");
		try
		{
			accounts.createAccount(sc.nextLine());
		}
		catch (DuplicateUserNameException e)
		{
			e.printStackTrace();
			createAccount();
		}
	}

	public void printMenu()
	{
		for(int i = 0; i < menuOptions.length; i++)
		{
			System.out.println((i + 1) + ". " + menuOptions[i]);
		}
	}
	
	public int getChoice()
	{
		int choice;
		System.out.print("Enter the number associated with your choice: ");
		try
		{
			choice = sc.nextInt();
			if((choice > menuOptions.length) || (choice <= 0))
			{
				throw new NumberFormatException();
			}
			return choice;
		}
		catch(NumberFormatException e)
		{
			System.out.println("Invalid choice.  Please enter an integer between 1 and " + menuOptions.length);
			return getChoice();
		}
	}
	
	public void serializeData()
	{
		try {
			FileOutputStream fos = new FileOutputStream("./Bank.ser");
			ObjectOutputStream oos = new ObjectOutputStream(fos);
			oos.writeObject(accounts);
			oos.close();
			fos.close();			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void deserializeData()
	{
		try (FileInputStream fis = new FileInputStream("./Bank.ser"); ObjectInputStream ois = new ObjectInputStream(fis)) 
		{	
			accounts = (AccountList) ois.readObject();
			if(accounts == null)
			{
				accounts = new AccountList();
			}
		} 
		catch (IOException e) 
		{
			e.printStackTrace();
			accounts = new AccountList();
		}
		catch (ClassNotFoundException e) 
		{
			e.printStackTrace();
		}
	}
}
