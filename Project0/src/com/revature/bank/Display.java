package com.revature.bank;

import java.io.IOException;
import java.util.Scanner;

public class Display
{

	public Display()
	{
	
	}
	
	public static void welcome() throws IOException
	{
		String option;

		do
		{
			System.out.println("Welcome to Bank of Vannara");
			System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~");
			System.out.println("[1] Press 1 to Sign In");
			System.out.println("[2] Press 2 to Sign Up");
			

			@SuppressWarnings("resource")
			Scanner sc = new Scanner(System.in);
			option = sc.nextLine(); 
			if(option.equals("1"))
			{
				SignIn.logIn();
			}
			else if(option.equals("2"))
			{
				SignUp.createUser();
			} 
		}while(!(option.equals("1") || option.equals("2")));
	}
	
	public static void transaction() throws IOException
	{
		String option;
		Double value;
		Account account = new Account();

		do
		{
			System.out.println("----BANK OF VANNARA-------");
			System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~");
			System.out.println("[1] Press 1 to Withdraw");
			System.out.println("[2] Press 2 to Deposit");
			System.out.println("[3] Press 3 to Check Balance");
			System.out.println("[4] Press 4 to Log out");
			System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~");

			@SuppressWarnings("resource")
			Scanner sc = new Scanner(System.in);
			option = sc.nextLine(); 
			
			if(option.equals("1"))
			{
				System.out.println("Enter The Amount You Want to Withdraw:");
				value = sc.nextDouble();
				account.withdraw(value);
			}
			else if(option.equals("2"))
			{
				System.out.println("Enter The Amount You Want to Deposit:");
				value = sc.nextDouble();
				account.deposit(value);
			} 
			else if(option.equals("3"))
			{
				System.out.println("Your Account Balance is:");
				account.getBalance();
			}
			else if(option.equals("4"))
			{
				account = new Account();
				Display.welcome();
			}
			
		}while(true);
		
	}
	

}
