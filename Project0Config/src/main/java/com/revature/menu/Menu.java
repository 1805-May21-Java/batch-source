package com.revature.menu;

import java.util.Scanner;

import com.revature.dao.DaoInterfaceImpl;
import com.revature.pojos.*;

public class Menu {
	//Common methods and variables for all menu classes
	
	static Scanner scan = new Scanner(System.in);
	static DaoInterfaceImpl dImpl = new DaoInterfaceImpl();
	Client client;
	public static final String lineBreak = "~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~";
	public static final String loadingMessage = "Processing...";
	
	public Menu() {
		super();
		}
	
	public Menu(Client client) {
		super();
		this.client = client; 
	}
	
	//Exits program, static protected so other classes in the package can use it
	static protected void exit() {
		System.out.println("Have a good day!");
		System.exit(0);
	}
	
	
}