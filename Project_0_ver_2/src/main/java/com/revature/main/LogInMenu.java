package com.revature.main;
import java.io.IOException;
import java.sql.*;
import java.util.*;
import com.revature.pojos.*;
import com.revature.util.ConnectionUtil;
import com.revature.dao.*;

public class LogInMenu
{
	//The log in menu, takes a string in so that it knows what account it is working with
	public static void runLogIn(String userName)
	{
		//Creating variables and populating the hash maps
		Map<String,UserInfo> userInfoMap = new HashMap<String,UserInfo>();
		Map<Integer,Checking> checkingMap = new HashMap<Integer,Checking>();
		Map<Integer,Saving> savingMap = new HashMap<Integer,Saving>();
		UserInfoDaoImpl uidi = new UserInfoDaoImpl();
		SavingDaoImpl sdi = new SavingDaoImpl();
		CheckingDaoImpl cdi = new CheckingDaoImpl();

		Scanner sc = new Scanner(System.in);
		boolean loggedOn = true;
		String input;
		
		checkingMap = cdi.getChecking();
		savingMap = sdi.getSaving();
		userInfoMap = uidi.getUserInfo();
		
		//Creating a user info object to use and putting in the object located at that key
		//This ensures that we are working on the account that we want to
		UserInfo ui = new UserInfo();
		ui = userInfoMap.get(userName);
		
		while(loggedOn)
		{
			System.out.println("To create a checking account type 1, to create a savings account 2, to deposit 3, to withdraw 4, to check your balance 5, 6 to delete accounts, and 7 to exit.");
			input = sc.nextLine();
			
			switch(input)
			{
				//Creating checking account case
				case "1":
				{
					//I put in a trigger in my SQL file that auto generates the primary keys
					//Using the object ui here to provide the checking account with the user id from the account info
					//This ties the checking account to the user that is logged in
					Checking c = new Checking(0, ui.getId());
					cdi.createChecking(c);
					System.out.println("Checking account created.");
					break;
				}
				//Creating savings account case, same as above just with saving
				case "2":
				{
					Saving s = new Saving(0, ui.getId());
					sdi.createSaving(s);
					System.out.println("Savings account created.");
					break;
				}
				
				//The deposit case
				case "3":
				{
					//I create some objects to use within this case
					Checking c = new Checking();
					Saving s = new Saving();
					Integer i = ui.getId();
					
					//First ask the user what account they would like to deposit to
					System.out.println("Which account would you like to deposit to?");
					input = sc.nextLine();
					//This checks to make sure the input is correct and that the account has been created
					if(input.toLowerCase() == "savings" && savingMap.containsKey(i))
					{
						//Populating the saving object with the user's savings account
						s = savingMap.get(i);
						System.out.println("Enter the ammout you would like to deposit:");
						input = sc.nextLine();
						
						//Checking for a negative or zero deposit amount
						if(Integer.parseInt(input) <= 0)
						{
							System.out.println("Invalid amount, please enter a number greater than zero.");
							break;
						}
						else
						{
							//Here I call the procedure that I had made in SQL
							try
							{
								Connection con = ConnectionUtil.getConnection();
								CallableStatement cs = con.prepareCall("DEPOSIT_SAVING(?,?)");
								//I pass in the user id into my procedure and the input from the user using an Integer object
								//The user id is the foreign key of the saving table and the checking table
								//This is so that if we delete some rows and insert some rows that we will deposit to the correct account
								//This is because the user id is unique to each row in the account tables
								cs.setInt(ui.getId(), Integer.parseInt(input) );
								System.out.println(input+" deposited into your savings account.");
							}
							catch (IOException | SQLException e)
							{
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
							break;
						}
						
					}
					//If the account does not exist telling the user so
					else if (!savingMap.containsKey(i))
					{
						System.out.println("Your savings account does not exist, please create it.");
						break;
					}
					//If the input is incorrect telling the user so
					else if(input.toLowerCase() != "savings")
					{
						System.out.println("Invalid input please enter savings.");
						break;
					}
					
					//Same as the savings account, but with checking
					if(input.toLowerCase() == "checking" && checkingMap.containsKey(i))
					{
						c = checkingMap.get(i);
						System.out.println("Enter the ammout you would like to deposit:");
						input = sc.nextLine();
						
						if(Integer.parseInt(input) <= 0)
						{
							System.out.println("Invalid amount, please enter a number greater than zero.");
							break;
						}
						else
						{
							try
							{
								Connection con = ConnectionUtil.getConnection();
								CallableStatement cs = con.prepareCall("DEPOSIT_CHECKING(?,?)");
								cs.setInt(ui.getId(), Integer.parseInt(input) );
								System.out.println(input+" deposited into your checking account.");
							}
							catch (IOException | SQLException e)
							{
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
							break;
						}
					}
					else if (!checkingMap.containsKey(i))
					{
						System.out.println("Your checking account does not exist, please create it.");
						break;
					}
					else if (input.toLowerCase() != "checking")
					{
						System.out.println("Invalid input please enter checking.");
						break;
					}
				}
				//The withdraw case
				case "4":
				{	
					//Withdrawing case is very similar to the deposit case with a few differences
					Checking c = new Checking();
					Saving s = new Saving();
					Integer i = ui.getId();
					
					//Asking what account the user would like to withdraw from
					System.out.println("Which account would you like to withdraw from?");
					input = sc.nextLine();
					//If the input is correct and the account exists
					if(input.toLowerCase() == "savings" && savingMap.containsKey(i))
					{
						//Populating the saving object with the user's saving's account
						s = savingMap.get(i);
						System.out.println("Enter the ammout you would like to withdraw:");
						input = sc.nextLine();
						
						//Can't withdraw a non zero amount
						if(Integer.parseInt(input) <= 0)
						{
							System.out.println("Invalid amount, please enter a number greater than zero.");
							break;
						}
						else
						{
							//Over draft protection, makes sure you can't withdraw more money than what is within the savings account
							if(s.getBalance() - Integer.parseInt(input) < 0)
							{
								System.out.println("Not enough funds.");
								break;
							}
							else
							{
								//Using the saving object's getters and setters to do the calculation.
								s.setBalance(s.getBalance()- Integer.parseInt(input));
								System.out.println(input+" withdrawn from your savings account.");
								break;
							}
						}
						
					}
					//If the account doesn't exist telling the user so
					else if (!savingMap.containsKey(i))
					{
						System.out.println("Your savings account does not exist, please create it.");
						break;
					}
					//If the input is incorrect telling the user so
					else if(input.toLowerCase() != "savings")
					{
						System.out.println("Invalid input please enter savings.");
						break;
					}
					//Same as the savings account above just with checking
					if(input.toLowerCase() == "checking" && checkingMap.containsKey(i))
					{
						c = checkingMap.get(i);
						System.out.println("Enter the ammout you would like to withdraw:");
						input = sc.nextLine();
						
						if(Integer.parseInt(input) <= 0)
						{
							System.out.println("Invalid amount, please enter a number greater than zero.");
							break;
						}
						else
						{
							if(c.getBalance() - Integer.parseInt(input) < 0)
							{
								System.out.println("Not enough funds.");
								break;
							}
							else
							{
								c.setBalance(c.getBalance() - Integer.parseInt(input));
								System.out.println(input+ " withdrawn from your checking.");
								break;
							}
						}
					}
					else if (!checkingMap.containsKey(i))
					{
						System.out.println("Your checking account does not exist, please create it.");
						break;
					}
					else if (input.toLowerCase() != "checking")
					{
						System.out.println("Invalid input please enter checking.");
						break;
					}
				}
				//The check balance case
				case "5":
				{
					//Similar to deposit and withdraw in that we check to see if the account has been created
					//And that the user input is correct
					Checking c = new Checking();
					Saving s = new Saving();
					Integer i = ui.getId();
					
					System.out.println("Which account's balance would you like to check?");
					input = sc.nextLine();
					
					if(input.toLowerCase() == "savings" && savingMap.containsKey(i))
					{
						s = savingMap.get(i);
						//Displaying the balance
						System.out.println("Your savings account balance is:" + s.getBalance());
						break;
					}
					//If it doesn't exist tell the user to go make it
					else if(!savingMap.containsKey(i))
					{
						System.out.println("Your savings account does not exist, please create it.");
						break;
					}
					//If the input is incorrect telling the user that it is
					else if(input.toLowerCase() != "savings")
					{
						System.out.println("Invalid input please enter savings.");
						break;
					}
					
					//Same as saving above just with checking
					if(input.toLowerCase() == "checking" && checkingMap.containsKey(i))
					{
						c = checkingMap.get(i);
						System.out.println("Your checking account balance is:" + c.getBalance());
						break;
					}
					else if(!checkingMap.containsKey(i))
					{
						System.out.println("Your checking account does not exist, please create it.");
						break;
					}
					else if(input.toLowerCase() != "checking")
					{
						System.out.println("Invalid input please enter checking.");
						break;
					}
				}
				//The delete case
				case "6":
				{
					//Similar to all the other update cases 
					Checking c = new Checking();
					Saving s = new Saving();
					Integer i = ui.getId();
					
					//I provide an option to delete everything
					System.out.println("Which account would you like to delete? Type my account for user account");
					input = sc.nextLine();
					
					//Checks to see if user input is correct and the account exists
					if(input.toLowerCase() == "savings" && savingMap.containsKey(i) )
					{
						//Making sure the user really wants to delete it
						System.out.println("Are you sure?");
						//Deleting the account
						if(input.toLowerCase() == "yes")
						{
							s = savingMap.get(i);
							sdi.deleteSaving(s);
							System.out.println("Savings account deleted.");
							break;
						}
						else
						{
							System.out.println("Savings account not deleted.");
							break;
						}
					}
					//If the account does not exist telling the user so
					else if(!savingMap.containsKey(i)) 
					{
						System.out.println("Savings account doesn't exist.");
						break;
					}
					//If the input is incorrect telling the user so
					else if(input.toLowerCase() != "savings")
					{
						System.out.println("Invalid input, please enter savings");
						break;
					}
					
					//Same as saving above just with checking
					if(input.toLowerCase() == "checking" && checkingMap.containsKey(i) )
					{
						System.out.println("Are you sure?");
						if(input.toLowerCase() == "yes")
						{
							c = checkingMap.get(i);
							cdi.deleteChecking(c);
							System.out.println("Checking account deleted.");
							break;
						}
						else
						{
							System.out.println("Checkings account not deleted.");
							break;
						}
					}
					else if(!checkingMap.containsKey(i)) 
					{
						System.out.println("Checking account doesn't exist.");
						break;
					}
					else if(input.toLowerCase() != "checking")
					{
						System.out.println("Invalid input, please enter checking");
						break;
					}
					
					//The delete everything option
					if(input.toLowerCase() == "my account" && userInfoMap.containsKey(userName) )
					{
						//This one deletes everything, the user account, checking, and banking(if they exist)
						System.out.println("Are you sure? This will delete all of your banking accounts assocciated with this account.");
						if(input.toLowerCase() == "yes")
						{
							s = savingMap.get(i);
							if(savingMap.containsKey(i)) 
							{
								sdi.deleteSaving(s);
							}
							else
							{
								System.out.println("Savings account doesn't exist.");
							}
							
							c = checkingMap.get(i);
							if(checkingMap.containsKey(i))
							{
								cdi.deleteChecking(c);
							}
							else
							{
								System.out.println("Checking account doesn't exist.");
							}
							
							ui = userInfoMap.get(userName);
							uidi.deleteUser(ui);
							System.out.println("User account deleted.");
							break;
						}
						else
						{
							System.out.println("User account not deleted.");
							break;
						}
					}
					else if(!userInfoMap.containsKey(userName)) 
					{
						System.out.println("User account doesn't exist.");
						break;
					}
					else if(input.toLowerCase() != "my account")
					{
						System.out.println("Invalid input, please enter my account");
						break;
					}
					
				}
				//Exit case
				case "7":
				{
					loggedOn = false;
					break;
				}
			}
		}
	}
}
