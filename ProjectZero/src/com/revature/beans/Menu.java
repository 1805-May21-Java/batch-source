package com.revature.beans;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Scanner;

import com.revature.accountGrouping.Account;
import com.revature.accountGrouping.AccountList;
import com.revature.errors.DuplicateUserNameException;

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
			int choice = getChoice();
			takeAction(choice);
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
		Scanner scan = new Scanner(System.in);
		Account pertinantAccount = new Account();
	
		System.out.print("Enter the username or email associated with the account: ");
		String userName = scan.nextLine();
		Account relevantAccount = accounts.retrieveAccount(userName);

		while(relevantAccount == null)
		{
			System.out.print("Invalid username.  Please reenter: ");
			userName = scan.nextLine();
			relevantAccount = accounts.retrieveAccount(userName);
		}
		
		System.out.print("Enter the password: ");
		String password = scan.nextLine();
		
		while(!relevantAccount.isPassword(password))
		{
			System.out.print("Incorrect password.  Please reenter: ");
			password = scan.nextLine();
		}
		
		loggedInAccount = relevantAccount;
	}

	private void createAccount()
	{
		Scanner sc = new Scanner(System.in);
		try
		{
			System.out.print("Enter a username or email: ");
			String uName = sc.nextLine();
//			uName = sc.nextLine();
			
			System.out.print("Enter your name: ");
			String name = sc.nextLine();
			
			System.out.print("Enter your password: ");
			String password = sc.nextLine();
			
			accounts.createAccount(uName, name, password);
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

			if(loggedInAccount == null)
			{
				if(choice > 2 && choice < 7) //All these actions require the user to be logged in
				{
					System.out.println("Please log in before doing that");
					return getChoice();
				}
			}

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
		File file = new File("./Bank.ser");
		try (FileInputStream fis = new FileInputStream(file); ObjectInputStream ois = new ObjectInputStream(fis)) 
		{	
			
			accounts = (AccountList) ois.readObject();
		} 
		catch (IOException e) 
		{
			accounts = new AccountList();
		}
//		catch (ClassNotFoundException e) 
//		{
//			e.printStackTrace();
//		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
}
