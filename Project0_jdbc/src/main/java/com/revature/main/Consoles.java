package com.revature.main;

import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

import com.revature.dao.UserDaoImpl;
import com.revature.pojos.User;


public class Consoles {
	
	private static User user ;
	private static UserDaoImpl dao = new UserDaoImpl();; 
	
	public static boolean logIn() throws IOException
	{
	
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter your username to sign in:");
		String loginUser = sc.nextLine();
		
		if(dao.isUserNameExist(loginUser))
		{
			System.out.println("Enter your password:");
			String loginPassword = sc.nextLine();
			if(dao.isAuthenticated(loginUser, loginPassword))
			{
				user = dao.getUserByName(loginUser);
				Consoles.transaction();
			}else{
				System.out.println("*******************************");
				System.out.println("Your Password Is Not Valid!");
				System.out.println("*******************************\n");
				try
				{
					user=null;
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
				user = null;
				Display.welcome();
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
				throw new IllegalArgumentException("*!!!! Your Withdraw Amount Cannot Be Processed !!!!");

			}
			else if(value>=0)
			{
				balance-=value;
				System.out.println("**************************************");
				System.out.println("You Have Withdrawed $"+value+" Successfully!");
				System.out.println("You Current Balance is "+balance);
				System.out.println("**************************************\n");
				dao.updateUser(new User(user.getUserId(), user.getUserName(), user.getPassword(), balance));
				
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
	public static void deposit(Double value)  
	{
		
		double balance = dao.getUserById(user.getUserId()).getBalance();
		try
		{
			if(value<0) 
			{
				throw new IllegalArgumentException("************************************************\n ! Your Deposit Amount Can Only Be Positive ! \n************************************************\n\"");

			}
			else if(value>=0.01)
			{
				balance+=value;
				System.out.println("**************************************");
				System.out.println("You Have Deposited $"+value+" Successfully!");
				System.out.println("You Current Balance is "+balance);
				System.out.println("**************************************\n");
				User myUser = new User(user.getUserId(), user.getUserName(), user.getPassword(), balance);
				dao.updateUser(myUser);
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
	
	
	public static void transaction() throws IOException
	{
		String option;
		Double value;
		try
		{
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
					Display.welcome();
				}
				else
				{
					System.out.println("!!!*** Please Enter \"1\" , \"2\" , \"3\", or \"4\" ***!!!");
				}
				
			}while(true);
			
		
		}
		catch (InputMismatchException e) 
		{
            System.out.println("!!!*** Oops!! Please Enter Only Decimal Numbers ***!!!");
            transaction();
		}

	}

	public static void signUp() {
		
		Scanner sc = new Scanner(System.in);
		boolean flag = true;
		boolean flag2= true;
		// specifying the file we want to write to
		System.out.println("Enter Your Username or Email To Sign Up:");
		String userName = sc.nextLine();
		while(dao.isUserNameExist(userName))
		{
			System.out.println("That Username Is Taken, Try Another.");
			userName = sc.nextLine();
			
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
	
		Integer rowSize = dao.rowSize();
		rowSize++;
		User myUser = new User(rowSize.toString(), userName, pwd, 0.0);
		dao.createUser(myUser);
		
	}

}
