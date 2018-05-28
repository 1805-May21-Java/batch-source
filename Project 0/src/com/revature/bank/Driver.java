package com.revature.bank;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Scanner;

public class Driver
{

	public static void main(String[] args) throws IOException
	{
		//delaring variables and setting up the path and hashmap
		Scanner sc = new Scanner(System.in);
		String input;
		int amount;
		String email;
		String path = "src/com/revature/bank/User_Data";
		BufferedReader br = null;
		HashMap<String, Account> accountInfo = new HashMap<>();
	
		//reading in the file so that that I can change the info
		br = new BufferedReader(new FileReader(path));
		String line = br.readLine();
		
		//this loop populates the hashmap to use in main, since every time the program stops you lose your hashmap
		while(line != null)
		{
			String[] userInfo = line.split(":");
			int balance = Integer.parseInt(userInfo[1]);
			Account acc = new Account(userInfo[0], balance);
			accountInfo.put(userInfo[0], acc);
			line = br.readLine();
		}
		br.close();
		
		//start of the main loop or 'main menu'
		while(true)
		{
			System.out.println("Welcome to Generic Bank, type 1 to log in, 2 to register an account, or exit to exit");
			input = sc.nextLine();
			
			//this exits the loop and stops the program
			//I couldn't use a case statement for this because the break would have only worked on switch case block
			//and not the while loop
			//updates our file as well
			if(input.equals("exit"))
			{
				Account.updateData(accountInfo);
				break;
			}
				
			switch (input)
			{
			//log in case
			case "1":
			{
				System.out.println("To log in please type in your email");
				input = sc.nextLine();
				email = input;
				
				//this checks to make sure the account has actually been created
				if(accountInfo.containsKey(input))
				{
					
					//this is the second loop or 'sub menu' that deals with the depositing and withdrawing
					//as well as balance checking
					Account user = accountInfo.get(input);
					while (true)
					{
						System.out.println("Welcome " + email);
						System.out.println("To deposit type 1, to withdraw type 2, to check balance type 3, or exit to return.");
						input = sc.nextLine();
							
						//same as previous exit if
						if(input.equals("exit"))
						{
							Account.updateData(accountInfo);
							break;
						}
							
						switch(input)
						{
						//deposit case
						//I use the getters and setters of my Account class here to do the arithmetic
						//getBalance returns an int I can add the user inputed amount too
						//and then setBalance sets that new amount
						case "1":
						{
							System.out.println("Please enter the amount to deposit");
							amount = Integer.parseInt(sc.nextLine());
							user.setBalance(user.getBalance()+amount);
							break;
						}
						//withdraw case
						//same as deposit just minus instead of plus
						case "2":
						{
							System.out.println("Please enter the amount to withdraw");
							amount = Integer.parseInt(sc.nextLine());
							//over draft protection
							if(user.getBalance() - amount > 0)
							{
								user.setBalance(user.getBalance()-amount);
							}
							else
							{
								System.out.println("You do not have enough funds.");
							}
							break;

						}
						//checking balance case
						case "3":
						{
							System.out.println("Your balance is "+ user.getBalance());
							break;
						}
						}
					}

				}
				//the else statement to the if that checked to see if the account had been created
				else
				{
					System.out.println("That is not a valid account.");
				}
				break;
			}
			
			//account creation
			case "2":
			{
				System.out.println("Please enter your email:");
				input = sc.nextLine();
				//this checks to see if the account has been created already or not
				if(accountInfo.containsKey(input))
				{
					System.out.println("That accound has already been created.");
				}
				//creating a new account by putting it into the hashmap(in case we want to continue)
				else
				{
					Account newAccount = new Account(input, 0);
					accountInfo.put(input, newAccount);
					System.out.println("Account has been created.");
				}
				break;
			}
			}
		}
	}
}





