package one;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Driver {

	public static void main(String[] args) {
		// asks for 1 to create new account, 2 to login to existing account
		System.out.println("Welcome! To register a new account, enter 1. To login, enter 2:");
		Scanner sc = new Scanner(System.in);
		String input1 = sc.nextLine();
		
		switch (input1) {
		case "1":
			// asks console for new email
			System.out.println("Please enter new user email:");
			String newEmail = sc.nextLine();
			// asks console for new password
			System.out.println("Please enter desired password:");
			String newPassword = sc.nextLine();
			// saves email and password as a single new string, delimited by :
			String newCredentials = newEmail + ":" + newPassword;
			
			// creates a Buffered Writer object to write the new credentials in the file
			BufferedWriter bw = null;
			String path = "src/one/Credentials.txt";
			File file = new File(path);
			
			try {
				// writes newCredentials to the file with bw object
				FileWriter fw = new FileWriter(file, true);
				bw = new BufferedWriter(fw);
				bw.write(newCredentials);
				
				System.out.println("New account created");
				
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} finally {
				try {
					bw.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			// creates UserAccount object to manipulate below
			double newBalance = 0;
			UserAccount ua = new UserAccount(newEmail, newPassword, newBalance);
			System.out.println("What would you like to do?");
			System.out.println("1. Get balance");
			System.out.println("2. Deposit cash");
			System.out.println("3. Withdraw cash");
			int choice = sc.nextInt();
			
			switch (choice) {
			
			case 1: 
				// gets balance with Email
				System.out.println("Your account balance is:");
				System.out.println(ua.myBalance(newEmail));
				
				break;
				
			case 2:
				// asks for deposit amount
				System.out.println("Enter the amount you would like to deposit (double):");
				// computes newBalance and prints the value
				double depositAmount = sc.nextDouble();
				System.out.println(ua.deposit(newBalance, depositAmount));
				
				break;
				
			case 3: 
				// asks for withdraw amount
				System.out.println("How much would you like to withdraw? (double)");
				double withdrawAmount = sc.nextDouble();
				// computes newBalance and prints the value
				System.out.println(ua.deposit(newBalance, withdrawAmount));
				
				break;
				
			}
			
			
			break;
			
		case "2":

			System.out.println("Please enter your email:");
			String checkEmail = sc.nextLine();
			System.out.println("Please enter password for the above account:");
			String checkPassword = sc.nextLine();
			String checkCredentials = checkEmail + ":" + checkPassword;
			
			BufferedReader br = null;
			String rPath = "src/one/Credentials.txt";
			
			try {
				br = new BufferedReader(new FileReader(rPath));
				String line = br.readLine();
				if (line == checkCredentials) {
					System.out.println("Login successful! Enter 1 to check balance, 2 to deposit cash, 3 to withdraw cash:");
					
				} 
				
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
			break;
			
		default:
				System.out.println("Please enter a valid command");
				break;
				
		}
		sc.close();
		System.out.println();
		
		
	}
}
