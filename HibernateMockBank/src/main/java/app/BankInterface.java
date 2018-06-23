package app;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

import dao.BankInfoDaoImpl;

import pojos.OBankInfo;

public class BankInterface extends SpecificCommand implements Command {
	//extends the specific command and implements command so we can save space
	
	//necessary variables
	BankInfoDaoImpl bidi = new BankInfoDaoImpl();
	private String comm1, comm2, comm3, comm4;
	private Scanner scan = new Scanner(System.in);
	private OBankInfo obi = new OBankInfo();
	private LinkedList<OBankInfo> tempInfo = new LinkedList<OBankInfo>();
	BufferedReader br = null;
	BufferedWriter bw = null;
	String path = "C:\\Users\\julia\\Documents\\workspaceSTS\\MockBank2\\src\\main\\java\\com\\revature\\MockBank2\\";
	
	public void bankInterface() {
		// start the bank interface for customer, who choose one of the 3 options
		System.out.println("Hello, customer, welcome to the Mock Bank");
		System.out.println("Please choose your options: 1 for signup, 2 for login or 0 for exit");
		comm1 = scan.nextLine();
		//based on the number entered, go to the specific actions
		switch(comm1) {
			case "1":
				signup();
				break;
			case "2":
				login();
				break;
			case "0":
				//close the connection before exiting program
				//bidi.closeConnection();
				System.exit(0);
				break;
			default:
				//making sure customer enters the right process
				System.out.println("Error, please choose avaliable options, or exit to exit");
				bankInterface();
				break;
		}
	}

	public void bankInterface2(OBankInfo obi) {
		String yorn;
		System.out.println("Hello, customer: " + obi.getUsername());
		System.out.println("What would you like to do? Our options are 1 for checking, 2 for saving, 3 for logout, 4 for deleteaccount");
		comm2 = scan.nextLine();
		switch(comm2) {
		//based on the number entered, go to the account, can also delete the user from the bank records if wanted
		case "1":
			bankInterfaceC(obi);
			break;
		case "2":
			bankInterfaceS(obi);
			break;
		case "3":
			logout();
			break;
		case "4":
			System.out.println("Would you like to delete your account: ");
			//check if the user didn't press this by accident
			yorn = scan.nextLine().toLowerCase();
			while(!yorn.equals("y") && !yorn.equals("n")){
				System.out.println("Invalid Command, please re-enter your command");
				System.out.println("Enter y for yes, and n for no: ");
				yorn = scan.nextLine().toLowerCase();
			}
			if(yorn.equals("y")) {
				bidi.deleteBankAccount(obi.getUserId());
			} else if (yorn.equals("n")) {
				bankInterface2(obi);
			}
			break;
		default:
			System.out.println("Error, please choose avaliable options, or 3 to exit");
			bankInterface2(obi);
			break;
		}
		//after each user command, ask if they still want to continue
		System.out.println("Would you like to continue: ");
		//check if the user has anything more to do here, or log him out
		yorn = scan.nextLine().toLowerCase();
		while(!yorn.equals("y") && !yorn.equals("n")){
			System.out.println("Invalid Command, please re-enter your command");
			System.out.println("Enter y for yes, and n for no: ");
			yorn = scan.nextLine().toLowerCase();
		}
		if(yorn.equals("y")) {
			bankInterface2(obi);
		} else if (yorn.equals("n")) {
			bankInterface();
		}
	}
	
	public void bankInterfaceC(OBankInfo obi) {
		//interface for checking account
		double amount;
		String yorn;
		System.out.println("Hello, customer: " + obi.getUsername());
		System.out.println("What would you like to do? Our options are 1 for deposit, 2 for withdraw, 3 for bankbalance, 4 for exit, 5 for transfer,  6 for view transfer history");
		comm3 = scan.nextLine();
		switch(comm3) {
		case "1":
			amount = deposit();
			bidi.increaseChecking(obi.getUserId(), amount);
			//after deposit/changing the amount in database, make sure to set it up correctly for the arraylist in java as well
			obi.setCheckingAmount(obi.getCheckingAmount()+amount);
			writeData(obi.getCheckingAmount()+":"+amount+":"+obi.getSavingAmount()+":0");
			System.out.println("Deposit finished, your current Checkings Account have: " + obi.getCheckingAmount() + " Dollars!");
			break;
		case "2":
			amount = withdraw();
			//similar for withdraw, but make sure you are able to withdraw, or it will return to the previous interface
			if(amount <= obi.getCheckingAmount()) {
				bidi.decreaseChecking(obi.getUserId(), amount);
				obi.setCheckingAmount(obi.getCheckingAmount()-amount);
				writeData(obi.getCheckingAmount()+":-"+amount+":"+obi.getSavingAmount()+":0");
				System.out.println("Withdraw finished, your current Checkings Account have: " + obi.getCheckingAmount() + " Dollars!");
			}
			else {
				System.out.println("Error, not enough money in the account!");
				bankInterfaceC(obi);
			}
			break;
		case "3":
			//check the current bank balance
			System.out.println("Your Current Checkings Balance is: " + obi.getCheckingAmount() + "Dollars!");
			break;
		case "4":
			bankInterface2(obi);
			break;
		case "5":
			//transfer between the 2 accounts
			//also make sure the money are enough to transfer
			amount = transfer();
			if(amount <= obi.getCheckingAmount()) {
				bidi.increaseSaving(obi.getUserId(), amount);
				bidi.decreaseChecking(obi.getUserId(), amount);
				obi.setCheckingAmount(obi.getCheckingAmount()-amount);
				obi.setSavingAmount(obi.getSavingAmount()+amount);
				writeData(obi.getCheckingAmount()+":-"+amount+":"+obi.getSavingAmount()+":"+amount);
				System.out.println("Amount transfered is " + amount + " from Checking to Savings");
			}
			else {
				System.out.println("Error, not enough money in the account!");
				bankInterfaceC(obi);
			}
			break;
		case "6":
			readData();
			break;
		default:
			System.out.println("Error, please choose avaliable options, or 4 to exit");
			bankInterfaceC(obi);
			break;
		}
		System.out.println("Would you like to continue: ");
		//check if the user has anything more to do here, or go to the previous interface
		yorn = scan.nextLine().toLowerCase();
		while(!yorn.equals("y") && !yorn.equals("n")){
			System.out.println("Invalid Command, please re-enter your command");
			System.out.println("Enter y for yes, and n for no: ");
			yorn = scan.nextLine().toLowerCase();
		}
		if(yorn.equals("y")) {
			bankInterfaceC(obi);
		} else if (yorn.equals("n")) {
			bankInterface2(obi);
		}
	};
	
	public void bankInterfaceS(OBankInfo obi) {
		//basically the same set up as the checkings interface, except this is for savings
		double amount;
		String yorn;
		System.out.println("Hello, customer: " + obi.getUsername());
		System.out.println("What would you like to do? Our options are 1 for deposit, 2 for withdraw, 3 for bankbalance, 4 for exit, 5 for transfer, 6 for view transfer history");
		comm4 = scan.nextLine();
		switch(comm4) {
		case "1":
			amount = deposit();
			bidi.increaseSaving(obi.getUserId(), amount);
			obi.setSavingAmount(obi.getSavingAmount()+amount);
			writeData(obi.getCheckingAmount()+":0:"+obi.getSavingAmount()+":"+amount);
			System.out.println("Deposit finished, your current Savings Account have: " + obi.getSavingAmount() + " Dollars!");
			break;
		case "2":
			amount = withdraw();
			if(amount <= obi.getSavingAmount()) {
				bidi.decreaseSaving(obi.getUserId(), amount);
				obi.setSavingAmount(obi.getSavingAmount()-amount);
				writeData(obi.getCheckingAmount()+":0:"+obi.getSavingAmount()+":-"+amount);
				System.out.println("Withdraw finished, your current Savings Account have: " + obi.getSavingAmount() + " Dollars!");
			}
			else {
				System.out.println("Error, not enough money in the account!");
				bankInterfaceS(obi);
			}
			break;
		case "3":
			System.out.println("Your Current Savings Balance is: " + obi.getSavingAmount() + "Dollars!");
			break;
		case "4":
			bankInterface2(obi);
			break;
		case "5":
			amount = transfer();
			if(amount <= obi.getSavingAmount()) {
				bidi.increaseChecking(obi.getUserId(), transfer());
				bidi.decreaseSaving(obi.getUserId(), transfer());
				obi.setCheckingAmount(obi.getCheckingAmount()+amount);
				obi.setSavingAmount(obi.getSavingAmount()-amount);
				writeData(obi.getCheckingAmount()+":"+amount+":"+obi.getSavingAmount()+":"+amount);
				System.out.println("Amount transfered is " + amount + " from Checking to Savings");
			}
			else {
				System.out.println("Error, not enough money in the account!");
				bankInterfaceC(obi);
			}
			break;
		case "6":
			readData();
			break;
		default:
			System.out.println("Error, please choose avaliable options, or 4 to exit");
			bankInterfaceC(obi);
			break;
		}
		System.out.println("Would you like to continue: ");
		//check if the user has anything more to do here, or log him out
		yorn = scan.nextLine().toLowerCase();
		while(!yorn.equals("y") && !yorn.equals("n")){
			System.out.println("Invalid Command, please re-enter your command");
			System.out.println("Enter y for yes, and n for no: ");
			yorn = scan.nextLine().toLowerCase();
		}
		if(yorn.equals("y")) {
			bankInterfaceS(obi);
		} else if (yorn.equals("n")) {
			bankInterface2(obi);
		}
	};
	
	@Override
	public void signup() {
		String username, email, password;
		String yorn;
		
		//username, email and password equals to the 3 function extended from specific command
		username = username();
		email = email();
		password = password();
		//add the bankinfo into the linkedlist
		tempInfo.add(new OBankInfo(username, password, email, 0, 0));
		//add it to the database
		bidi.createBankAccount(new OBankInfo(username, password, email, 0, 0));
		path = "C:\\Users\\julia\\Documents\\workspaceSTS\\MockBank2\\src\\main\\java\\com\\revature\\MockBank2\\"+username+"History";
		writeData("0:0:0:0");
		//remove the info from linked list so it doesn't stay on the program
		tempInfo.removeFirst();
		System.out.println("Would you like to automatically go to login: ");
		yorn = scan.nextLine().toLowerCase();
		while(!yorn.equals("y") && !yorn.equals("n")){
			System.out.println("Invalid Command, please re-enter your command");
			System.out.println("Enter y for yes, and n for no: ");
			yorn = scan.nextLine().toLowerCase();
		}
		if(yorn.equals("y")) {
			//time saving feature?
			login();
		} else if (yorn.equals("n")) {
			bankInterface();
		}	
	}

	@Override
	public void login() {
		String username, password;
		username = logUserOrEmail();
		password = logPassword();
		int obiid = 0;
		//get the user info by the username and passowrd
		List<OBankInfo> obilist = bidi.bankInfo();
		for(OBankInfo obis : obilist) {
			if(obis.getUsername().equals(username) && obis.getPassword().equals(password)) {
				obiid = obis.getUserId();
			}
		}
		obi = bidi.getOBankInfoByUserPass(obiid);
		path = "C:\\Users\\julia\\Documents\\workspaceSTS\\MockBank2\\src\\main\\java\\com\\revature\\MockBank2\\"+username+"History";
		
		
		//if nothing is found
		if(obi == null) {
			System.out.println("We are sorry, but the username and password you provided doesn't match,");
			System.out.println("Please re-enter your information");
			login();
		}
		else {
			bankInterface2(obi);
		}
	}

	@Override
	public double deposit() {
		String yorn;
		double amount = 0;
		System.out.println("Hello, customer, how much would you like to deposit: ");
		try {
			// ask for the amount a person wants to enter when deposit
			amount = Double.parseDouble(scan.nextLine());
			System.out.println("This " + amount + " is how much you want to deposit, right?");
			System.out.println("Please enter y or n to confirm");
			yorn = scan.nextLine().toLowerCase();
			//making sure its the right amount
			while(!yorn.equals("y") && !yorn.equals("n")){
				System.out.println("Invalid Command, please re-enter your command");
				System.out.println("Enter y for yes, and n for no: ");
				yorn = scan.nextLine().toLowerCase();
			}
			if(yorn.equals("y")) {
				return amount;
			} else if (yorn.equals("n")) {
				return deposit();
			}
			//making sure its a number being entered
		} catch (NumberFormatException e) {
			System.out.println("This is not a number, please re-enter: ");
			return deposit();
		}
		return amount;
	}

	@Override
	public double withdraw() {
		String yorn;
		double amount = 0;
		System.out.println("Hello, customer, how much would you like to withdraw: ");
		try {
			//similar to deposit, making sure the amount withdraw are correct, or redo the function
			amount = Double.parseDouble(scan.nextLine());
			System.out.println("This " + amount + " is how much you want to withdraw, right?");
			System.out.println("Please enter y or n to confirm");
			yorn = scan.nextLine().toLowerCase();
			while(!yorn.equals("y") && !yorn.equals("n")){
				System.out.println("Invalid Command, please re-enter your command");
				System.out.println("Enter y for yes, and n for no: ");
				yorn = scan.nextLine().toLowerCase();
			}
			if(yorn.equals("y")) {
				return amount;
			} else if (yorn.equals("n")) {
				return withdraw();
			}
		} catch (NumberFormatException e) {
			System.out.println("This is not a number, please re-enter: ");
			return withdraw();
		}
		return amount;
	}

	public double transfer() {
		String yorn;
		double amount = 0;
		System.out.println("Hello, customer, how much would you like to transfer: ");
		try {
			//similar to deposit, making sure the amount withdraw are correct, or redo the function
			amount = Double.parseDouble(scan.nextLine());
			System.out.println("This " + amount + " is how much you want to transfer, right?");
			System.out.println("Please enter y or n to confirm");
			yorn = scan.nextLine().toLowerCase();
			while(!yorn.equals("y") && !yorn.equals("n")){
				System.out.println("Invalid Command, please re-enter your command");
				System.out.println("Enter y for yes, and n for no: ");
				yorn = scan.nextLine().toLowerCase();
			}
			if(yorn.equals("y")) {
				return amount;
			} else if (yorn.equals("n")) {
				return withdraw();
			}
		} catch (NumberFormatException e) {
			System.out.println("This is not a number, please re-enter: ");
			return withdraw();
		}
		return amount;
	}
	
	public void readData() {		
		try {
			br = new BufferedReader(new FileReader(path));
			String line = br.readLine();
			String[] datalist;
			//check if this line is null
			while(line != null) {
				//split the function into 4 parts based on the tostring i changed in bankinfo class
				datalist = line.split(":", 4);
				System.out.println("Checking Amount: "+datalist[0]+"   Checking Difference: "+datalist[1]+
						"   Saving Amount: "+datalist[2]+"   Saving Difference: "+datalist[3]);
				//keep reading from the file until its done
				line = br.readLine();
			}
			//close it
			br.close();
		} catch(IOException e) {
			e.printStackTrace();
		}
	}
	
	public void writeData(String s) {
		try {
			//create a new file if it doesn't exist
			File file = new File(path);
			if(!file.exists()) {
				file.createNewFile();
			}
			
			FileWriter fw = new FileWriter(file, true);
			bw = new BufferedWriter(fw);
			//write the file in the form i decided 
			bw.write(s);
			bw.newLine();
			
		}catch(IOException e) {
			e.printStackTrace();
		}finally {
			if(bw != null) {
				try {
					bw.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}
	
	@Override
	public void logout() {
		//go back the previous interface
		bankInterface();
		
	}
}
