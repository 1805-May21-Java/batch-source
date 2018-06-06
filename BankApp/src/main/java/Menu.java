import java.util.Scanner;
import java.util.*;

public class Menu {
	Scanner sc = new Scanner(System.in);
	Bank bank = new Bank();
	boolean exit;
	
	public void startMenu() {
		printHeader();
		
		while(!exit) {
			showMenu();
			int option = getInput();
			performAction(option);
		}
	}
	
	private void printHeader() {
		// TODO Auto-generated method stub
		System.out.println("**************************");
		System.out.println("        Greetings         ");
		System.out.println("    Welcome to Tron Bank  ");
		System.out.println("**************************"); 
		
	}

	private void showMenu() {
		
		// TODO Auto-generated method stub
		System.out.println("Select option:");
		System.out.println();
		System.out.println("1.) Create new account");
		System.out.println("2.) Make a deposit");
		System.out.println("3.) Withdraw funds");
		System.out.println("4.) View account balance");
		System.out.println("0.) Exit");
		
		
	}

	private int getInput() {
		int option = -1;
		do {
			try {
			option = Integer.parseInt(sc.nextLine());
			
			} catch (NumberFormatException e) {
				// TODO: handle exception
				System.out.println("Invalid entry. Enter a number.");
			}
			
			if(option < 0 || option > 4) {
				System.out.println("Please select option within 0-4.");
			}
			
		} while(option < 0 || option > 4);
		
		return option;
		
	}

	private void performAction(int option) {
		// TODO Auto-generated method stub
		switch (option) {
		case 0:
			System.out.println("Thanks for using Tron Bank!");
			System.exit(0);
			break;
		case 1:
			createAccount();
			break;
		case 2:
			deposit();
			break;
		case 3: 
			withdraw(1);
			break;
		case 4:
			showBalance();
			break;
	

		default:
			System.out.println("Unrecognizable error");
			break;
		}
//		
	}

	private void showBalance() {
		// TODO Auto-generated method stub
		
	}

	private void withdraw(int i) {
		// TODO Auto-generated method stub
		
	}

	private void deposit() {
		// TODO Auto-generated method stub
		
	}

	private void createAccount() {
		// TODO Auto-generated method stub
		String firstName, lastName, ssn, acctType;
		double firstDeposit;
		boolean valid = false;
		
		while(!valid) {
			System.out.println("Enter below account type[Checking or Savings]: ");
			acctType = sc.nextLine();
			if(acctType.equalsIgnoreCase("checking") || acctType.equalsIgnoreCase("savings")) {
				valid = true;
			} else {
				System.out.println("Invalid entry. Enter checking or savings.");
			}
		}
		System.out.print("Enter your first name: ");
		firstName = sc.nextLine();
		System.out.println("Enter your last name: ");
		lastName = sc.nextLine();
		System.out.println("Enter your social security number");
		ssn = sc.nextLine();
		valid = false;
		while(!valid) {
			System.out.println("");
		}
	}

	public static void main(String[] args) {
		Menu menu = new Menu();
		menu.startMenu();
	}

	
}
