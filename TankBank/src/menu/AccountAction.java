package menu;

import com.revature.BankAccount;
import com.revature.Client;

public class AccountAction extends Menu{
	
	public static void accountAction(BankAccount bankAccount, Client client) {
		//menu to withdraw, deposit, or view balance
		System.out.println(bankAccount.getAccountName()+" $"+bankAccount.getBalence());
		System.out.print("Would you like to withdraw (1), deposit (2), view balance (3), "
				+ "select a differnt account(4), logout(5) or exit (6)? ");
		switch (scan.nextLine()) {
		case "1":
			System.out.println(lineBreak);
			System.out.print("How much would you like to withdraw? ");
			//gets double input
			double withdrawAmount = inputDouble();
			bankAccount.withdraw(withdrawAmount);
			
			//Saves changes
			WriteReadBankAccount.saveClient(client);
			System.out.println(lineBreak);
			break;
			
		case "2":
			System.out.println(lineBreak);
			System.out.print("How much would you like to deposit? ");
			//gets double input
			double depositAmount = inputDouble();
			bankAccount.deposit(depositAmount);
			
			//Saves changes
			WriteReadBankAccount.saveClient(client);
			System.out.println(lineBreak);
			break;
			
		case "3":
			System.out.println(lineBreak);
			//prints balance
			System.out.println(String.format("%s, you have $%.2f in the account %s", 
					client.getUsername(),bankAccount.getBalence(),bankAccount.getAccountName()));
			System.out.println(lineBreak);
			break;
		case "4":
			System.out.println(lineBreak);
			//Lets user go back to select account screen
			SelectAccount.selectAccount(client);
		case "5":
			System.out.println(lineBreak);
			//logs user out, then sends to login screen
			System.out.println("Logged out!");
			client = WriteReadBankAccount.getClient();
			SelectAccount.selectAccount(client);
		case "6":
			//closes resources then exits
			scan.close();
			System.out.println(lineBreak);
			exit();
		default:
			//prints message, then runs the mainMenu method again
			System.out.println("I'm sorry, that wasn't one of our options!");
			System.out.println(lineBreak);
			break;
		}
		accountAction(bankAccount, client);
		
	}
	
	//makes sure user enters a double
		private static double inputDouble() {
			while(scan.hasNext()) {
				try{
					double var = Double.valueOf(scan.nextLine());
					return var;
				}catch (NumberFormatException e) {
					System.out.println("Enter a valid number!");
				}
			}
			//should never get here
			return 0;
		}

}
