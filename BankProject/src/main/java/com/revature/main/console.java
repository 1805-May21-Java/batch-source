package com.revature.main;

import java.io.Console;
import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

import com.revature.dao.bankInfoDaoImpl;
import com.revature.bankpojos.User;


public class console {
	
	private static User user ;
	private static bankInfoDaoImpl dao = new bankInfoDaoImpl();; 
	
	public static boolean logIn() throws IOException
	{
	
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter your username to sign in:");
		String loginUser = sc.nextLine();
		
		if(dao.doesExist(loginUser))
		{
			System.out.println("Enter your password:");
			String loginPassword = sc.nextLine();
			if(dao.doAuthenticate(loginUser, loginPassword))
			{
				user = dao.getUserByName(loginUser);
				console.choice();
			}else{
				System.out.println("We're sorry that password is not valid");
				try
				{
					user=null;
					display.welcome();
				} catch (IOException e)
				{
					e.printStackTrace();
				}
				
			}
		}else
		{
			System.out.println("That Username is not registered to an account with us");
			try
			{
				user = null;
				display.welcome();
			} catch (IOException e)
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return false;
	}
	
	public static void withdraw(Double value)
	{
		double balance =  dao.getUserById(user.getUserId()).getBalance();
		try
		{
			if(balance<value || value<0)
			{
				System.out.println("The amount you entered is not avaliable for withdrawl");
			}
			else if(value > 0)
			{
				balance-=value;
				System.out.println("$"+value+" Has been withdrawn from account");
				System.out.println("Remaining Balance is $"+balance);
				dao.updateUser(new User(user.getUserId(), user.getUserName(), user.getPassword(), balance));
			}
		}
		catch(IllegalArgumentException e)
		{
			System.out.println(e.getMessage());
		}

	}
	public static void deposit(Double value)  
	{
		
		double balance = dao.getUserById(user.getUserId()).getBalance();
		try
		{
			if(value<0) 
			{
				System.out.println("You cannot deposit negative sums of money...We're sorry");
				value = 0.00;
				deposit(value);
			}
			else if(value>=0.01)
			{
				balance+=value;
				System.out.println("You Have Deposited $"+value+" Successfully!");
				System.out.println("You Current Balance is "+balance);
				User myUser = new User(user.getUserId(), user.getUserName(), user.getPassword(), balance);
				dao.updateUser(myUser);
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
	
	
	public static void choice() throws IOException
	{
		String option;
		Double value;
		try
		{
			do
			{
				System.out.println("Revature LLC (formely eIntern)");
				System.out.println("Please Select an option below: ");
				System.out.println("1.) Withdraw");
				System.out.println("2.) Deposit");
				System.out.println("3.) View Avaliable Funds");
				System.out.println("4.) Log out");

				@SuppressWarnings("resource")
				Scanner sc = new Scanner(System.in);
				option = sc.nextLine(); 
				
				if(option.equals("1"))
				{
					System.out.println("Enter The Amount You Want to Withdraw:");
					value = sc.nextDouble();
					withdraw(value);
					
				}
				else if(option.equals("2"))
				{
					System.out.println("Enter The Amount You Want to Deposit:");
					value = sc.nextDouble();
					deposit(value);
				
					
				} 
				else if(option.equals("3"))
				{
					System.out.println("Your balance is "+dao.getUserById(user.getUserId()).getBalance());;
				}
				else if(option.equals("4"))
				{
					user= null;
					display.welcome();
				}
				else
				{
					System.out.println("We're sorry that is not one of our listed selections please choose one of the numerical options on screen");
					choice();
				}
				
			}while(true);
			
		
		}
		catch (InputMismatchException e) 
		{
            choice();
		}

	}

	public static void signUp() {
		
		Scanner sc = new Scanner(System.in);
		boolean flag = true;
		boolean flag2= true;
		// specifying the file we want to write to
		System.out.println("Enter Your Username or Email To Sign Up:");
		String userName = sc.nextLine();
		while(dao.doesExist(userName))
		{
			System.out.println("That Username Is Taken, Try Another.");
			userName = sc.nextLine();
			
		}
		
		String pwd, pwdC;
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
				pwdC= sc.nextLine();
			}
			else
			{
				flag=true;;
				flag2=false;
				pwdC="none";
			}
		}while(!pwd.equals(pwdC));
	
		Integer rowSize = dao.size();
		rowSize++;
		User myUser = new User(rowSize.toString(), userName, pwd, 0.0);
		dao.createUser(myUser);
		
	}

}