package com.revature.banking;

import java.io.*;
import java.util.*;

public class Driver 
{
	
	public static void main(String[] args) 
	{
		Scanner scanner = new Scanner(System.in);
		ArrayList<Account> accountList = new ArrayList<Account>();
		BufferedReader br = null;
		String path = "src/com/revature/banking/Data.txt";
		
		try
		{
			br = new BufferedReader(new FileReader(path));
			String line = null;
			
			while((line = br.readLine()) != null)
			{
				String[] strArr = line.split(",");
				Account account = new Account(strArr[0], strArr[1], Double.parseDouble(strArr[2]));
				accountList.add(account);
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
		
		Bank bank = new Bank(accountList);
		String input , username, password;
		Account account = null;
		boolean flag = false;
		
		while(flag != true)
		{
			System.out.println("Welcome to revature banking!");
			System.out.println("Press 1 if you would like to login to an existing account");
			System.out.println("Press 2 if you would like to create a new account.");
			input = scanner.nextLine();
			switch(input)
			{
			case "1":
				System.out.println("Enter your username.");
				username = scanner.nextLine();
				System.out.println("Enter your password.");
				password = scanner.nextLine();
				if(bank.login(username, password)) 
				{
					flag = true;
					for(Account acc : accountList)
					{
						if(acc.getUsername().equals(username)) 
						account = acc;
					}
					break;
				}
				else
				{
					System.out.println("No user matching those credentials exists!");
				}
			case "2":
				System.out.println("Enter your desired username.");
				username = scanner.nextLine();
				System.out.println("Enter your desired password");
				password = scanner.nextLine();
				account = new Account(username,password);
				if(bank.createNewAccount(account))
				{
					System.out.println("Account successfully created! Thanks for banking with Revature");
					flag = true;
				}
				break;
			default:
				System.out.println("Invalid Input! Please try again...");
				break;
			}
		}
		
		double amount;
		flag = false;
		
		if(account.isLoggedIn())
		{
			while(flag != true)
			{
				System.out.println();
				System.out.println("Press 1 if you would like to view your balance");
				System.out.println("Press 2 if you would like to make a deposit");
				System.out.println("Press 3 if you would like to make a withdrawal");
				System.out.println("Press 4 if you would like to logout of your account");
				input = scanner.nextLine();
				switch(input)
				{
				case "1":
					System.out.println("Your current balance is " + account.getBalance());
					break;
				case "2":
					System.out.println("Enter the amount you would like to deposit: ");
					amount = Double.parseDouble(scanner.nextLine());
					account.deposit(amount);
					System.out.println("You have successfully deposited " + amount + " dollars into your account!");
					break;
				case "3":
					System.out.println("Enter the amount you would like to withdraw: ");
					amount = Double.parseDouble(scanner.nextLine());
					
					if(amount > account.getBalance())
					{
						System.out.println("Error: Your desired withdrawal amount exceeds your current balance!");
						break;
					}
					else
					{
						account.withdraw(amount);
						System.out.println("You have successfully withdrawn " + amount + " dollars into your account!" );
						break;
					}
				case "4":
					bank.logout(account);
					flag = true;
					System.out.println("Thank you for banking with us here at Revature! Good Bye!");
					break;
				default:
					System.out.println("Invalid input! Please try again...");
					break;
				}
			}
		}
		
		scanner.close();
	}
}
