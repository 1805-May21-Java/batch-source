package com.revature.banking.menus;

import java.util.ArrayList;

public class SignUp extends Menu{
	
	private static SignUp signUp=null;

	SignUp() {
		message="Sign Up";
		
		options=new ArrayList<String>();
		options.add("Username/Email:");
		options.add("Password:");
	}
	
	public static SignUp getInstance() {
		if(signUp==null)
			signUp=new SignUp();
		return signUp;
	}

	@Override
	public void switcher() {
		clear();
		String user = "";
		String user2 = "";
		String pass = "";
		String pass2 = "";
		String theSwitch="user";
		boolean skip=false;
		
		System.out.println(message);
		
		while(theSwitch.equals("validated")==false) {
			switch(theSwitch) {
			case "user":
				while(user.equals("") || user.trim().equals("")) {
					System.out.print("Enter Username/Email:");
					user=scanner.nextLine();
					
					if(user.equals("") || user.trim().equals("")) {
						clear();
						System.out.println("Username/Email Required");
						System.out.println();
						System.out.println(message);
						System.out.println();
						theSwitch="user";
					}
					else
						theSwitch="user2";
				}
				break;
				
			case "user2":
				
				System.out.print("Re-Enter Username/Email:");
				user2=scanner.nextLine();
				
				if(user.equals(user2)==false) {
					clear();
					System.out.println("Usernames/Emails did not match");
					System.out.println();
					System.out.println(message);
					System.out.println();
					String choice=exitOut("Main Menu");
					
					if(choice.equals("1")) {
						theSwitch="validated";
						new MainMenu().getInstance().switcher();
						break;
					}
					
					user="";
					user2="";
					theSwitch="user";
				}
				else {
					theSwitch="pass";
				}
				break;
				
			case "pass":
				while(pass.equals("") || pass.trim().equals("")) {
					System.out.print("Enter Password:");
					pass=scanner.nextLine();
					
					System.out.println();
					if(pass.equals("") || pass.trim().equals("")) {
						clear();
						System.out.println("Password Required");
						System.out.println();
					}
				}
				theSwitch="pass2";
				break;
				
			case "pass2":
				System.out.print("Re-Enter Password:");
				pass2=scanner.nextLine();
				
				if(pass.equals(pass2)==false) {
					clear();
					System.out.println("Passwords did not match");
					System.out.println();
					pass="";
					pass2="";
					theSwitch="pass";
				}
				else {
					account=access.signUp(user, pass);
					if(account==null) {
						clear();
						System.out.println("Username/Email already in use");
						String choice=exitOut("Main Menu");
						
						if(choice.equals("1")) {
							theSwitch="validated";
							skip=true;
							new MainMenu().getInstance().switcher();
						}
						else {
							clear();
							System.out.println(message);
							user="";
							user2="";
							pass="";
							pass2="";
							theSwitch="user";
						}
					}
					else
						theSwitch="validated";
				}
				break;
			}
		}
		if(skip==false) {
			clear();
			System.out.println("Success! Welcome to Java Banking Application 2.0");
			System.out.println();
			new AccountMenu().getInstance().switcher();
		}
	}
}
