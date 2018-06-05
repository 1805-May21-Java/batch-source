package com.revature.main;
import java.util.*;
import com.revature.pojos.*;
import com.revature.dao.*;

public class MainMenu
{
	//The main menu
	public static void runProgram()
	{
		//Declaring variables and classes that I will need
		//I used a hash map so that I could check to make sure each account is unique
		Map<String,UserInfo> userInfoMap = new HashMap<String,UserInfo>();
		UserInfoDaoImpl uidi = new UserInfoDaoImpl();
		Scanner sc = new Scanner(System.in);
		boolean on = true;
		String input;
		String userName;
		String email;
		String password;
		
		//Populating the map I declared above
		userInfoMap = uidi.getUserInfo();
		
		while(on)
		{
			System.out.println("Welcome to Generic bank, type 1 to log on, 2 to create an account, or 3 to exit.");
			input = sc.nextLine();
			
			switch(input)
			{
				//Logging in
				case "1":
				{
					//I created a new UserInfo object here for use in this case
					UserInfo ui = new UserInfo();
					System.out.println("Please enter your username and password");
					System.out.println("Username: ");
					userName = sc.nextLine();
					
					//If the map has something mapped to the key provided it will return true
					//This is to check to see if the account has been created already or it was mistyped
					if(userInfoMap.containsKey(userName)) 
					{
						//Populating the UserInfo object with the object that maps to the key provided
						ui = userInfoMap.get(userName);
						System.out.println("Password: ");
						password = sc.nextLine();
						//This is to ensure that you have to type the correct password to login 
						if(ui.getPw().equals(password)) 
						{
							System.out.println("Welcome "+userName);
							//The login menu
							LogInMenu.runLogIn(userName);
							break;
							
						}
						else
						{
							System.out.println("Invalid password.");
							break;
						}
						
					}
					else
					{
						System.out.println("Invalid username.");
						break;
					}
					
				}
				//Create Account case
				case "2":
				{
					
					System.out.println("To create an account please enter your userName:");
					userName = sc.nextLine();
					//Checking the hash map to make sure the account is unique
					if(userInfoMap.containsKey(userName)) 
					{
						System.out.println("That acocunt has already been created.");
						break;
					}
					//Creating the account if it is unique
					else
					{
						System.out.println("Please enter your email:");
						email = sc.nextLine();
						
						System.out.println("Please enter a password:");
						password = sc.nextLine();
						
						UserInfo ui = new UserInfo(email, userName, password);
						uidi.createUser(ui);
						System.out.println("Account created.");	
						break;
					}
				}
				//Exit case
				case "3":
				{
					on = false;
					break;
				}
			}

		}
	}
}
