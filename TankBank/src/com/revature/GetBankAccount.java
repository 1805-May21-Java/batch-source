package com.revature;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.Scanner;

//retrieves a bank account object
public class GetBankAccount {
	
	private static Scanner scanner = new Scanner(System.in);
	static String username;
	static String password;
	public static BankAccount getAccount() {
		do{
			//prompts the user for username and password
			System.out.println("Please enter your username:");
			username = scanner.nextLine();
			System.out.println("Please enter your password:");
			password = scanner.nextLine();
			
			//attempts to open using the username
			String fileName = "src/com/revature/accounts/"+username+".txt";
					try(ObjectInputStream oStream = new ObjectInputStream(new FileInputStream(fileName))){
						
						//Returns the object
						BankAccount account = (BankAccount) oStream.readObject();
						//checks to see if password is correct
						if(account.getPassword().equals(password)) {
							//if so, prints message and returns the account
							System.out.println("Login successful!  Welcome, "+account.getUsername());
							return account;
						}else {
							//if not, informs the user and prompts for username and password again
							System.out.println("Invalid password!");
						}
			
					} catch (FileNotFoundException e) {
						//no file with that username, prints message and prompts user to try again
						System.out.println(username+" does not have an account with Tank Bank");
					} catch (IOException e) {
						e.printStackTrace();
					} catch (ClassNotFoundException e) {
						e.printStackTrace();
					}
					
		}while(true);
	}

}
