package com.revature.main;


import java.io.IOException;
import java.util.Scanner;


public class display {
	
	
	
	public static void welcome() throws IOException
	{
		String option;
		do
		{
			System.out.println("Welcome to Revature LLC (Formely eIntern)");
			System.out.println("Please choose an option from below");
			System.out.println("1.)Sign In");
			System.out.println("2.)Sign Up");
		
			@SuppressWarnings("resource")
			Scanner sc = new Scanner(System.in);
			option = sc.nextLine(); 
			if(option.equals("1"))
			{
				console.logIn();
			}
			else if(option.equals("2"))
			{
				console.signUp();
				welcome();
			} 
			else
			{
				System.out.println("Please Enter 1 or 2 ");
			}
		}while(!(option.equals("1") || option.equals("2")));
	}
	
	

}