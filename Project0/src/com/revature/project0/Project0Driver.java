package com.revature.project0;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Iterator;
import java.util.Scanner;
import java.util.regex.Pattern;

public class Project0Driver {

	
	private static BankSystem bs =new BankSystem(); 
	static Scanner scanner = new Scanner(System.in);

	private static String acct;
	
	public static void main(String[] args) {

		
		System.out.println("Welcome to your Banking Application: ");
		System.out.println("Enter 1 to use bank system file data test input: ");
		System.out.println("Enter 2 to enter user, account (bank system) info from Console: ");
		System.out.println("Enter 0 to exit program: ");
		String stri = scanner.nextLine();
		
        switch (Integer.parseInt(stri)) {
	        case 0:
				System.out.println("Entered 0");
				System.exit(0);
	            break;
	        case 1:
				System.out.println("Entered 1");
				Project0Driver.fileInput();
	            break;
	        case 2:
				System.out.println("Entered 2");
	            Project0Driver.fromConsole();
				break;
	        default: 
				System.out.println("unreachable");
	            break;
        }
        
		while(!(Integer.parseInt(stri)==0)&&!(Integer.parseInt(stri)==1)&&!(Integer.parseInt(stri)==2)) {
			System.out.println("Enter 0, 1, or 2");
			System.out.println("Enter 1 to use bank system file data test input: ");
			System.out.println("Enter 2 to enter user, account (bank system) info from Console: ");
			System.out.println("Enter 0 to exit program: ");
			stri = scanner.nextLine();
//			System.out.println("str: " + str);
	        switch (Integer.parseInt(stri)) {
		        case 0:
					System.out.println("Entered 0");
					System.exit(0);
		            break;
		        case 1:
					System.out.println("Entered 1");
					Project0Driver.fileInput();
		            break;
		        case 2:
					System.out.println("Entered 2");
		            Project0Driver.fromConsole();
		            break;
		        default: 
					System.out.println("never entered");
		            break;
		            
	        }
		}
        System.out.println("Finished enterring test bank system data");


		System.out.println("Enter 1 to login into bank system");
		System.out.println("Enter 0 to exit program: ");
		stri = scanner.nextLine();
		
        switch (Integer.parseInt(stri)) {
	        case 0:
				System.out.println("Entered 0");
				System.exit(0);
	            break;
	        case 1:
				System.out.println("Entered 1");
				acct = Project0Driver.logIn();
				boolean askTransaction = Project0Driver.secondMenu();
				while(!askTransaction) {
					askTransaction = Project0Driver.secondMenu();
				}				
	            break;
	        default: 
				System.out.println("unreachable");
	            break;
        }        
        
        
        scanner.close();
        

	}		
		
		        
			







	private static boolean secondMenu() {
		
		//String stri = null;
		int i = -20;
		System.out.println("1.  Log out:");
		System.out.println("2.  Withdraw");
		System.out.println("3.  Deposit");
		System.out.println("4.  View balance");
		System.out.println("0.  Log out:");
		
		i = scanner.nextInt();

		
//		
//        try {
//            // intentional error
//            i = Integer.parseInt(stri);
//
//            // this line of code will never be reached
//            System.out.println("int value = " + i);
//        }
//        catch (NumberFormatException nfe) {
//            nfe.printStackTrace();
//        }
//		
		
		
		while(!(i==1)&&!(i==2)&&!(i==3)&&!(i==4)&&!(i==0)) {

			
			i = scanner.nextInt();
			

			switch (i) {
		        case 0:
					System.out.println("Entered 0");
					System.exit(0);
		            break;
		        case 1:
					System.out.println("Entered 1");
					return true;
		        case 2:
					System.out.println("Entered 2");
					Project0Driver.withDrawMoney(acct);
		            break;
		        case 3:
					System.out.println("Entered 3");
					Project0Driver.depositMoney(acct);
		            break;
		        case 4:
					System.out.println("Entered 4");
					Project0Driver.viewBalance(acct);
		            break;
		        default: 
					System.out.println("never entered");
		            break;
	            
	        }
			
			
			System.out.println("1.  Log out:");
			System.out.println("2.  Withdraw");
			System.out.println("3.  Deposit");
			System.out.println("4.  View balance");
			System.out.println("0.  Log out:");

			
	        
		}
		return false;
	}










	private static void withDrawMoney(String acct) {
		int m;
		Account a = bs.findAcct(acct);
		
		
		System.out.println("Enter amount to withdraw: ");
		m = scanner.nextInt();


        
        System.out.println("Finished withdrawal");
		
		bs.withDrawMoney(a,m);
		Project0Driver.updateAcctInfoFile();

	}





	private static void depositMoney(String acct) {
		int m;
		Account a = bs.findAcct(acct);
		
		
		System.out.println("Enter amount to deposit: ");
		m = scanner.nextInt();


        
        System.out.println("Finished deposit");

		
		bs.depositMoney(a,m);
		Project0Driver.updateAcctInfoFile();
		
	}





	private static void updateAcctInfoFile() {

		File file1 = new File("resources/inputAccounts");
	    File file2 = new File("resources/inputUsers");

	    BufferedWriter writer = null;
		try {
			writer = new BufferedWriter(new FileWriter(file1));
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	        
        Iterator i = bs.users.iterator();
        String[] arrOfStr;
		while (i.hasNext()) {
            String input = (((Account) i.next()).getAccount())+','+(((Account) i.next()).getPassword()+','+(((Account) i.next()).getBalance()));
    	    try {
				writer.write(input);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
            
            
        }
		
	     
		try {
			writer = new BufferedWriter(new FileWriter(file2));
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
			
			

        Iterator j = bs.accounts.iterator();
		
		while (j.hasNext()) {
            String input = (((User) j.next()).getEmail())+','+(((User) j.next()).getPassword());
    	    try {
				writer.write(input);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
            
        }	        
	        
	    try {
			writer.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
		
		
	}










	private static void viewBalance(String acct) {
		Account a = bs.findAcct(acct);
		bs.checkBalance(a);
	}





	private static void fromConsole() {
		System.out.println("Add bank system data");
		System.out.println("1.  Create account: ");
		System.out.println("2.  Create user: ");
		System.out.println("3.  Finished adding account, user info");
		System.out.println("0.  Exit");
		String str = scanner.nextLine();
		
        switch (Integer.parseInt(str)) {
	        case 0:
				System.out.println("Entered 0");
				System.exit(0);
	            break;
	        case 1:
				System.out.println("Entered 1");
				bs.addAccount();
				break;
	        case 2:
				System.out.println("Entered 2");
				bs.addUser();
				break;
	        case 3:
				System.out.println("Entered 3");
				System.out.println("Bank System created, no data used");
				break;
			default:
				System.out.println("unreachable");
	            break;
	
        }		
		
		while(!(Integer.parseInt(str)==3)||bs.accountSize()==0||bs.userSize()==0) {
			System.out.println("Enter option 0 or 1 or 2 or 3: ");
			System.out.println("Must have users>=1 && accounts>=1");
			System.out.println("1.  Create account: ");
			System.out.println("2.  Create user: ");
			System.out.println("3.  Finished adding account, user info");
			System.out.println("0.  Exit");
			str = scanner.nextLine();
//			System.out.println("str: " + str);
	        switch (Integer.parseInt(str)) {
		        case 0:
					System.out.println("Entered 0");
					System.exit(0);
		            break;
		        case 1:
					System.out.println("Entered 1");
					bs.addAccount();
		            break;
		        case 2:
					System.out.println("Entered 2");
					bs.addUser();
					break;
		        case 3:
					System.out.println("Entered 3");
					System.out.println("Bank System created");
					break;
				default: 
					System.out.println("never entered");
		            break;
		            
	        }
		}

        System.out.println("finished adding user, account info from console");
	}




	private static void fileInput() {

	    File file1 = new File("resources/inputUsers");
		File file2 = new File("resources/inputAccounts");
	    String[] arrOfStr;
	    String[] arrOfStr2;
	    bs = new BankSystem();
	    try {

	        Scanner sc1 = new Scanner(file1);
	        Scanner sc2 = new Scanner(file2);

	        while (sc1.hasNextLine()) {
	            String input = sc1.nextLine();
	            arrOfStr = input.split(",");
	            System.out.println("arr[0]:"+arrOfStr[0]+" arr[1]: "+arrOfStr[1]);
	            User u =new User(arrOfStr[0],arrOfStr[1]);
	            bs.addUser(u);
//	            System.out.println("1");

	            
	        }
	        sc1.close();

	        while (sc2.hasNextLine()) {
	            String input = sc2.nextLine();
	            arrOfStr2 = input.split(",");
	            System.out.println("arr[0]: "+arrOfStr2[0]+" arr[1]: "+arrOfStr2[1]+" arr[2]: "+arrOfStr2[2]);
	            bs.addAccount(new Account(Double.parseDouble(arrOfStr2[2]),arrOfStr2[0],arrOfStr2[1]));
	            
	            
	        }	        
	        
	        sc2.close();
	    } 
	    catch (FileNotFoundException e) {
	        e.printStackTrace();
	    }
	
}

	public static String logIn() {
		Scanner scanner = new Scanner(System.in);
		User u1 = new User();
		String userPassword;
		String userName;
		final String strToMatch = ".*@*(.com|.edu)";
		System.out.println("Id/Email: ");
		String str = scanner.nextLine();
		System.out.println("You just entered: " + str);
		
		// Create a pattern to be searched
        Pattern pattern = Pattern.compile(strToMatch);
 
        // Print starting and ending indexes of the pattern
        // in text
        while (!Pattern.matches(strToMatch,str)) {
        	System.out.println("Enter a valid id containing .*@*(.com|.edu)" + str);
    		str = scanner.nextLine();
        	System.out.println("You just entered: " + str);
        }
        userName = str;
        System.out.println("finished gathering email id login");
    	System.out.println("Enter a password: " + str);

		str = scanner.nextLine();        
        while (!bs.verifyPassword(userName,str)) {
        	System.out.println("Another login attempt: " + userName);
    		str = scanner.nextLine();
        	System.out.println("You just entered: " + str);
        }
        
        
//            System.out.println("Pattern found from " + m.start() + " to " + (m.end()-1));
        scanner.close();
        return userName;
	
	}		


}		

		
		
		


