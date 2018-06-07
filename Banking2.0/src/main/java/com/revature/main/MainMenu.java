package com.revature.main;

import java.text.DecimalFormat;
import java.util.*;
import com.revature.dao.BankDaoImpl;
import com.revature.pojos.*;

public class MainMenu 
{

	private static final Scanner scanner = new Scanner(System.in);
	private static final DecimalFormat format = new DecimalFormat("#0.00");
	
	private CurrentUserInfo info;
	private BankDaoImpl impl;
	
	public MainMenu()
	{
		super();
		impl = new BankDaoImpl();
		info = new CurrentUserInfo();
	}
	
	public MainMenu(CurrentUserInfo info)
	{
		super();
		impl = new BankDaoImpl();
		this.info = info;
	}
	
	private boolean isAvailable(String user)
	{
		if(impl.getUserByName(user) == null)
			return true;
		else
			return false;
	}
	
	public void createUser()
	{
		System.out.println("\nWelcome to Revature Banking");
		System.out.println("Please enter your desired username or email: ");
		String username = scanner.nextLine();
		
		while(!isAvailable(username))
		{
			System.out.println("The desired username is already in use...");
			System.out.println("Please try again");
			System.out.println("Please enter your desired username or email: ");
			username = scanner.nextLine();
		}
		
		System.out.println("Please enter your desired password: ");
		String password = scanner.nextLine();
		System.out.println("Please reenter your desired password for validation purposes.");
		String validate = scanner.nextLine();
		
		while(!password.equals(validate))
		{
			System.out.println("We're Sorry, but your passwords do not match.");
			
			System.out.println("Please enter your desired password: ");
			 password = scanner.nextLine();
			System.out.println("Please reenter your desired password for validation purposes.");
			validate = scanner.nextLine();
		}
		
		//Testing to make sure values are not left blank
		if(!(username.equals("") || password.equals("") || validate.equals("")))
		{
			User user = new User(username,password);
			impl.createUser(user);
			System.out.println("Account successfully created! Thank you for banking with Revature.");
		}
		else
			System.out.println("No data entered! Returning to menu");
		
		printMainMenu();
	}
	
	public void loginUser()
	{
		do
		{
			System.out.println("Enter your username or email: ");
			String username = scanner.nextLine();
			System.out.println("Enter your password: ");
			String password = scanner.nextLine();
			
			User user = impl.getUserByName(username);
			
			if(username.equals("") || password.equals(""))
			{
				System.out.println("No data entered! Returning to menu");
				printMainMenu();
				break;
			}
			else if(user == null)
				System.out.println("The username/email provided does not match any records. Please try again!");
			else if(!user.getPassword().equals(password))
				System.out.println("Incorect password!");
			else
			{
				info.setUser(user);
				printUserMenu(user);
				break;
			}
			
		}while(true);
	}
	
	public void printMainMenu()
	{
		System.out.println("Hello! Welcome to Revature Banking");
		System.out.println("Press 1 if you would like to Log In");
		System.out.println("Press 2 if you would like to create a new account");
		System.out.println("Press 3 if you would like to exit.");
		String input = scanner.nextLine();
		boolean flag = false;
		
		while(!flag)
		{
			if(input.length() != 1)
			{
				System.out.println("Invalid Operation... Please try again!");
				
				System.out.println("Hello! Welcome to Revature Banking");
				System.out.println("Press 1 if you would like to Log In");
				System.out.println("Press 2 if you would like to create a new account");
				System.out.println("Press 3 if you would like to exit.");
				input = scanner.nextLine();
			}
			else
			{
				flag = true;
				switch(Integer.parseInt(input))
				{
				case 1:
					loginUser();
					break;
				case 2:
					createUser();
					break;
				case 3:
					System.out.println("Thank you for banking with Revature!");
					System.exit(0);
					break;
				default:
					flag = false;
					System.out.println("Invalid Operation... Please try again!");
					System.out.println("Hello! Welcome to Revature Banking");
					System.out.println("Press 1 if you would like to Log In");
					System.out.println("Press 2 if you would like to create a new account");
					System.out.println("Press 3 if you would like to exit.");
					input = scanner.nextLine();
				}
			}
		}
		
	}
	
	public void changePassword()
	{
		System.out.println("Please enter your desired password: ");
		String password = scanner.nextLine();
		System.out.println("Please reenter your desired password for validation purposes.");
		String validate = scanner.nextLine();
		
		if(!password.equals("") && !validate.equals(""))
		{
			while(!password.equals(validate))
			{
				System.out.println("We are sorry, but your password does not match");
				
				System.out.println("Please enter your desired password: ");
				password = scanner.nextLine();
				System.out.println("Please reenter your desired password for validation purposes.");
				validate = scanner.nextLine();
			}
			
			User user = info.getUser();
			user.setPassword(password);
			impl.updateUser(user);
			
			System.out.println("Password successfully changed!");
			loginUser();
		}
		else
		{
			System.out.println("No data entered! Returning to menu");
			printUserMenu(impl.getUserByName(info.getUser().getUsername()));
		}
	}
	
	public void printUserMenu(User user)
	{
		System.out.println("Hello " + user.getUsername() + "!");
		boolean flag = false;
		
		while(!flag)
		{
			System.out.println();
			
			for(int i = 0; i < user.getAccounts().size(); i++) 
			{
				Account account = impl.getAccountByID(user.getAccounts().get(i));
				System.out.println("account" + i);
			}
		
			System.out.println("Enter 1 if you would like to change your password: ");
			System.out.println("Enter 2 if you would like to proceed to the account menu: ");
			System.out.println("Enter 3 if you would like to log out: ");
			String input = scanner.nextLine();
			
			if(input.length() != 1)
			{
				System.out.println("Invalid Operation... Please try again!");

				System.out.println("Enter 1 if you would like to change your password: ");
				System.out.println("Enter 2 if you would like to proceed to the account menu: ");
				System.out.println("Enter 3 if you would like to log out: ");
				input = scanner.nextLine();
			}
			else
			{
				flag = true;
				switch(Integer.parseInt(input))
				{
				case 1:
					changePassword();
					break;
				case 2:
					printAccountMenu(impl.getAccountByID(user.getAccounts().get(0)));
					break;
				case 3:
					info.setUser(null);
					printMainMenu();
					break;
				default:
					flag = false;
					System.out.println("Invalid Operation... Please try again!");
					System.out.println("Enter 1 if you would like to change your password: ");
					System.out.println("Enter 2 if you would like to log out: ");
					input = scanner.nextLine();
				}
			}
			
		}
	}
	
	public void printAccountMenu(Account account)
	{
		System.out.println("Press 1 if you would like to make a withdrawal");
		System.out.println("Press 2 if you would like to make a deposit");
		String input = scanner.nextLine();
		boolean flag = false;
		
		while(!flag)
		{
			if(input.length() != 1)
			{
				System.out.println("Invalid Operation... Please try again!");
			
			System.out.println("Press 1 if you would like to make a withdrawal");
			System.out.println("Press 2 if you would like to make a deposit");
			input = scanner.nextLine();
			}
			else
			{
				flag = true;
				switch(Integer.parseInt(input))
				{
				case 1:
					withdraw(impl.getAccountByID(account.getId()));
					break;
				case 2:
					deposit(impl.getAccountByID(account.getId()));
					break;
				default:
					flag = false;
					System.out.println("Press 1 if you would like to make a withdrawal");
					System.out.println("Press 2 if you would like to make a deposit");
					input = scanner.nextLine();
				}
			}
		}
	}
	
	public void withdraw(Account account)
	{
		System.out.println("Your current balance is: $" + format.format(account.getBalance()));
		System.out.println("How much would you like to withdraw?");
		String input = scanner.nextLine();
		
		try 
		{
			double withdraw = Double.parseDouble(input);
			
			if(withdraw > account.getBalance() || withdraw < 0.01)
			{
				System.out.println("Insufficient funds for a withdrawal");
			}
			else
			{
				account = impl.getAccountByID(account.getId());
				account.setBalance(account.getBalance() - withdraw);
				impl.updateAccount(account);
				System.out.println("Successfully withdrew $" + format.format(withdraw));
				System.out.println("You're remaining balance is $" + format.format(account.getBalance()));
			} 
		}
		catch(NumberFormatException ex)
		{
			System.out.println("Invalid Operation... returning to menu ");
		}
		finally
		{
			printAccountMenu(impl.getAccountByID(account.getId()));
		}
	}
	
	public void deposit(Account account)
	{
		System.out.println("Your current balance is: $" + format.format(account.getBalance()));
		System.out.println("How much would you like to deposit?");
		String input = scanner.nextLine();
		
		try
		{
			double deposit = Double.parseDouble(input);
			
			if(deposit < 0.01)
				System.out.println("Invalid deposit amount.");
			else
			{
				account = impl.getAccountByID(account.getId());
				account.setBalance(account.getBalance() + deposit);
				impl.updateAccount(account);
				System.out.println("Successfully deposited $" + format.format(deposit));
				System.out.println("Your new balance is $" + format.format(account.getBalance()));
			}
		}
		catch(NumberFormatException ex)
		{
			System.out.println("Invalid Operation... returning to menu");
		}
		finally
		{
			printAccountMenu(impl.getAccountByID(account.getId()));
		}
	}
	
	
	
}
