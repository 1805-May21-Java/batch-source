package com.revature.menu;

import com.revature.pojos.*;

public class WelcomeMenu extends Menu{

	//Welcome menu that lets the user select accounts, create accounts, or fire the cannons
	public static void Existing(Client client) {
		System.out.println("Welcome to Tank Bank, where we keep your money safe!");
		System.out.println(tank);
		System.out.println("Do you already have an account with us, or would you like to make a new one?");
		System.out.print("Type (1) for existing account, (2) to create a new one, "
				+ "(3) to exit, or (4) to fire the cannons: ");
		switch (scan.nextLine()) {
		case "1":
			//reads an existing client
			client = GetClient.getClient();
			SelectAccount.selectAccount(client);
			break;
		case "2":
			//creates a new account, prompting user for information
			CreateNewClient.createClient();
		case "3":
			System.out.println(lineBreak);
			exit();
		case "4":
			//This option fires the cannons
			FireTheCannons.fire();
		default:
			System.out.println("Please enter 1 or 2!");
			Existing(client);
			}
	}
	
	//tank ASCII to print on welcome screen
	public static String tank = 
			"  $         			    \n"+ 
			" $$$     					\n"+ 
			"$	   .--._____,		\n"+
			" $$$    .-='=='==-,		\n"+
			"    $	(O_o_o_o_o_O)		\n"+
			" $$$						\n"+
			"  $";
	
}
