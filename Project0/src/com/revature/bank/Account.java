package com.revature.bank;

public class Account
{
	private double balance=0;
	
	
	public double getBalance()
	{
		System.out.println("**************************************");
		System.out.println("You Current Balance is "+ balance);
		System.out.println("**************************************\n");
		return balance;
	}

	public void setBalance(double balance)
	{
		this.balance = balance;
	}

	public void deposit(Double value)  
	{
		try
		{
			if(value<0) 
			{
				throw new IllegalArgumentException("Your Deposit Amount Can Only Be Positive");

			}
			else
			{
				balance+=value;
				System.out.println("**************************************");
				System.out.println("You Have Deposited $"+value+" Successfully!");
				System.out.println("You Current Balance is "+balance);
				System.out.println("**************************************\n");
			}
		}
		catch(IllegalArgumentException e)
		{
			System.out.println(e.getMessage());
		}
	}
	
	public void withdraw(Double value)
	{
		
		try
		{
			if(balance<value)
			{
				throw new IllegalArgumentException("Your Withdraw Amount Cannot Be More Than Your Balance");

			}
			else
			{
				
				balance-=value;
				System.out.println("**************************************");
				System.out.println("You Have Withdraw $"+value+" Successfully!");
				System.out.println("You Current Balance is "+balance);
				System.out.println("**************************************\n");
				
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
