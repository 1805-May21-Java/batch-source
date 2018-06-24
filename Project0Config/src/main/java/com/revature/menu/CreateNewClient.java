package com.revature.menu;

import com.revature.pojos.*;

public class CreateNewClient extends Menu{
	
	public static void createClient() {
		//creates a new account, prompting the user for a username, password, and email address
		String username;
		Client client = new Client();
		do{
			System.out.println("Type 'exit' at any time to quit this process.");
			System.out.println(lineBreak);
			System.out.print("Please enter a username: ");
			//inputs and validates entered name
			username = inputUsernamePassword("username");
			client.setUsername(username);
		}while(userNameTaken(username));
		
		System.out.print("Great!  Now enter your password: ");
		//inputs and validates entered password
		client.setPassword(inputUsernamePassword("password"));

		System.out.print("Awesome.  Now enter your email address: ");
		client.setEmail(inputUsernamePassword("email"));
		System.out.println(lineBreak);
		System.out.println(loadingMessage);
	//	ReadWriteClient.saveAccount(client);
		dImpl.saveNewClient(client);
		System.out.println("You're all set up!");
		
		SelectAccount.selectAccount(client);
	}
	
	//validates username, email, and password
	//different validation methods based on which is being entered
	private static String inputUsernamePassword(String type) {
		while(scan.hasNext()) {
			String entry = scan.nextLine();
			//exits if user entered "exit"
			if(entry.equals("exit")) {
				//exits if user entered exit
				System.out.println(lineBreak);
				exit();
			}
			TYPE:
			switch (type) {
			case "email":
				//makes sure there's a '.' and an '@' in the email address
				if(!entry.contains(".") || !entry.contains("@")) {
					System.out.print("Please enter a valid email address! ");
					break TYPE;
				}
			case "password":
			case "username":
				//makes sure there are no spaces in any entry
				if(entry.contains(" ") ) {
					System.out.print("Please enter one word! ");
				}else if(entry.length()>59){
					System.out.print("Too long!  It must be less than 60 characters ");
				}
				else {
					//passed all validation tests
					return entry;
				}
				}
		}
		
		//should never get here
		return null;
	}
	
	//checks if that username is already taken
	private static boolean userNameTaken(String username) {
		
		if(dImpl.userNameExists(username)){
			//if taken, print message and return true so the loop continues
			System.out.println("Sorry, username has already been taken!");
			return true;
		}else{
			return false;
		}
	}
}
