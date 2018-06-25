package com.revature.banking.menus;

import java.util.ArrayList;

public class SignIn extends Menu{

private static SignIn signIn=null;
	
	SignIn() {
		message="Sign In";
		
		options=new ArrayList<String>();
		options.add("Username/Email:");
		options.add("Password:");
	}
	
	public static SignIn getInstance() {
		if(signIn==null)
			signIn=new SignIn();
		return signIn;
	}

	@Override
	public void switcher() {
		String user = "";
		String pass = "";
		String theSwitch="user";
		boolean skip=false;
		
		System.out.println(message);
		while(theSwitch.equals("validated")==false) {
			System.out.println();
			
			switch(theSwitch) {
			case "user":
				while(user.equals("") || user.trim().equals("")) {
					System.out.print("Username/Email:");
					user=scanner.nextLine();
					
					if(user.equals("") || user.trim().equals("")) {
						clear();
						System.out.println("Username/Email Required");
						System.out.println();
						System.out.println(message);
						System.out.println();
					}
				}
				theSwitch="pass";
				break;
			case "pass":
				while(pass.equals("") || pass.trim().equals("")) {
					System.out.print("Password:");
					pass=scanner.nextLine();
					
					System.out.println();
					if(pass.equals("") || pass.trim().equals("")) {
						clear();
						System.out.println("Password Required");
						System.out.println();
					}
				}
				theSwitch="validate";
				break;
			
			case "validate":
				account=access.logIn(user, pass);
				
				if(account==null) {
					clear();
					System.out.println("Username/Email or Password was incorrect");
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
						pass="";
						theSwitch="user";
					}
				}
				else {
					theSwitch="validated";
				}
				break;
			}
		}
		
		if(skip==false)
			clear();
			new AccountMenu().getInstance().switcher();
		
		
	}
	
	
}
