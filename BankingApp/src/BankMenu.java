import java.util.Scanner;

public class BankMenu {
	

	public static void main(String[] args) {
		
		System.out.println("Welcome to Bank of Adora");
		mainMenu();
		

	}
	
	private static void mainMenu() {
		
		Scanner sc = new Scanner(System.in);
		int option = 0;
		int tries = 0;
		boolean choice = false;
		
		
		
		
		
		while (true) {
			try {	
				System.out.println("Please choose one of the following menu options:");
				System.out.println();
				System.out.println("1: Login with existing account");
				System.out.println("2: Create a new account");
				System.out.println("3: Close app");
				
				option = Integer.parseInt(sc.nextLine());
				
				switch(option) {
				case 1: 
					tries = 0;
					loginMenu();
					break;
				case 2:
					tries = 0;
					createAccountMenu();
					break;
				case 3: 
					System.out.println("Thank you for using Bank of Adora. Goodbye.");
					return;
				default:
					System.out.println(option + " is not a valid menu option.");
				}
				
			} catch (NumberFormatException e) {
	
				System.out.println("Please enter one of the menu options.");
				
			} finally {
				tries++;
				if(tries >= 3) {
					return;
				} 
			}	
		}	
	}

	
	private static void loginMenu() {

		BankAccount account = null;
		int tries = 0;
		
		Scanner sc = new Scanner(System.in);
		String user, pass;
		System.out.println();
		System.out.println("Login Menu");
		
		
		while(account == null) {
			
			System.out.println();
			System.out.print("Username: ");
			user = sc.nextLine();
			System.out.print("Password: ");
			pass = sc.nextLine();
			
			account = validateCredentials(user, pass); 
			
			if(account != null) {
				accountMenu(account);
			} else {
				tries++;
				if(tries >= 3) {
					System.out.println("Invalid username/password. Too many attempts. Try again later.");
					return;
				}
				System.out.println("The username and/or password provided was invalid. Try again.");
			}	
		}
	}
	
	
	
	private static BankAccount validateCredentials (String user, String pass) {	
		return AccountRetriever.retrieve(user, pass);
	}
	
	private static void accountMenu(BankAccount account) {
		Scanner sc = new Scanner(System.in);
		int option;
		boolean loggedIn = true;
		
		System.out.println();
		System.out.println("Account Menu");
		System.out.println("Please choose one of the following options");
		
		while (loggedIn) {
		System.out.println("1: View balance");
		System.out.println("2: Deposit money");
		System.out.println("3: Withdraw money");
		System.out.println("4: Logout");
		
			try {
				option = Integer.parseInt(sc.nextLine());
				
				switch(option) {
					case 1: 
						account.viewBalance();
						break;
					case 2:
						account.depositMoney();
						break;
					case 3: 
						account.withdrawMoney();
						break;
					case 4:
						AccountRetriever.update(account);
						loggedIn = false;
						break;
					default: 
						System.out.println("That is not a valid menu option.");
				}
				
				
			} catch (NumberFormatException e) {
				System.out.println("Please enter one of the menu options");
			} 
		}
	}

	private static void createAccountMenu() {
		
		Scanner sc = new Scanner(System.in);
		System.out.println();
		System.out.println("Create a new account");
		
		System.out.println();
		System.out.println("Username must be more than 5 characters long and have no spaces");
		System.out.println("Password must be at least 8 characters long and have no spaces");
		System.out.print("Please enter a username: ");
		
		String user = sc.nextLine();
		
		boolean valid = false;
		while(!valid) {
			//check more than 5 characters
			if(user.length() > 5) {
				if(user.compareTo(user.trim()) == 0) {
					if(AccountRetriever.userNameInUse(user) == false) {
					     valid = true;
					     continue;
					} else { System.out.println("That username is already taken."); }
				} else { System.out.println("Username cannot have white spaces."); }
			} else { System.out.println("Username must be more than 5 characters long.");}
			
			System.out.print("Enter a user name: ");
			user = sc.nextLine();
		
		}
		
		boolean match  = false;
		String pass = "", confirmPass = "";
		
		while(!match ) {
			System.out.print("\nPlease enter a new password: ");
			pass = sc.nextLine();
			
			while(pass.length() < 8 || pass.compareTo(pass.trim()) != 0) {
				System.out.println("Inavlid password");
				System.out.print("Please enter a password: ");
				pass = sc.nextLine();
			}
			
			System.out.print("Please confirm password: ");
			confirmPass = sc.nextLine();
			if(pass.compareTo(confirmPass) != 0 ) {
				System.out.println("Passwords  did not match. Please start again.");
			} else { match = true; }
		}
		
		BankAccount account = new BankAccount(user, pass);
		AccountRetriever.save(account);
		
		System.out.println("\nNew account successfully created! Returning to main menu. \n\n");
		
		
		
		
	}
}
