package com.revature.main;


import java.io.IOException;
import java.util.Scanner;


public class Display {
	
	
	
	public void welcome() throws IOException
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
				Consoles.logIn();
			}
			else if(option.equals("2"))
			{
				Consoles.signUp();
				welcome();
			} 
			else
			{
				System.out.println("Please Enter \"1\" or \"2\" ");
			}
		}while(!(option.equals("1") || option.equals("2")));
	}
	
	

}
