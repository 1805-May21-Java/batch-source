package menu;

import java.io.File;

import com.revature.Client;

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
		}while(usernameFree(username));
		
		System.out.print("Great!  Now enter your password: ");
		//inputs and validates entered password
		client.setPassword(inputUsernamePassword("password"));

		System.out.print("Awesome.  Now enter your email address: ");
		client.setEmail(inputUsernamePassword("email"));
		
		System.out.println("You're all set up!");
		System.out.println(lineBreak);
		WriteReadBankAccount.saveClient(client);
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
			switch (type) {
			case "password":
			case "username":
				//Username and password have same validation factors, could enter separate validation for 
				//password above if necessary
				//makes sure there are no spaces
				if(!entry.contains(" ")) {
					return entry;
				}else {
					System.out.print("Please enter one word! ");
				}
				break;
			case "email":
				//makes sure there are no spaces, there is an '@', and there is a '.'
				if( (!entry.contains(" ")) && entry.contains(".") && entry.contains("@")) {
					return entry;
				}else {
					System.out.print("Please enter a valid email address! ");
				}
			default:
				break;
			}
			
		}
		//should never get here
		return null;
	}
	
	//checks if that username is already taken
	private static boolean usernameFree(String username) {
		String path = "src/com/revature/accounts/"+username+".txt";
		//returns true if file exist (meaning the username has been taken), true otherwise
		if(new File(path).exists())
		{
			//if taken, print message and return true so the loop continues
			System.out.println("Sorry, username has already been taken!");
			return true;
		}else {
			return false;
		}
	}
}
