package com.revature.bank;

import java.util.LinkedList;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.*;
import java.util.Scanner;

public class BankInterface extends SpecificCommand implements Command {
	//extends the specific command and implements command so we can save space
	
	//necessary variables
	private String comm1, comm2;
	private Scanner scan = new Scanner(System.in);
	private LinkedList<BankInfo> bankInfo = new LinkedList<BankInfo>();
	private LinkedList<BankInfo> tempInfo = new LinkedList<BankInfo>();
	private BufferedReader br = null;
	private BufferedWriter bw = null;
	private String path = "src/com/revature/bank/bankinfo";
	
	public void bankInterface() {
		// start the bank interface for customer, who choose one of the 3 options
		System.out.println("Hello, customer, welcome to the Mock Bank");
		System.out.println("Please choose your options: signup, login or exit");
		comm1 = scan.nextLine();
		switch(comm1) {
			case "signup":
				signup();
				break;
			case "login":
				login();
				break;
			case "exit":
				//exit the whole program, but before then, clean up the templinkedlist
				while(!bankInfo.isEmpty()) {
					bankInfo.removeFirst();
				}
				System.exit(0);
				break;
			default:
				//making sure customer enters the right process
				System.out.println("Error, please choose avaliable options, or exit to exit");
				bankInterface();
				break;
		}
	}

	public void bankInterface2(BankInfo bi) {
		String yorn;
		System.out.println("Hello, customer: " + bi.getUsername());
		System.out.println("What would you like to do? Our options are deposit, withdraw, bankbalance, logout");
		comm2 = scan.nextLine();
		switch(comm2) {
		case "deposit":
			// add the money by setting the money amount
			bi.setMoney(bi.getMoney() + deposit());
			//write the new info in there into a new line, because when searching from the linkedlist that
			//read from the file Data, it will read from latest entry first, meaning before previous entries
			//gets put in, the latest entry will already fit the rrequirement and ended the search
			writeData(bi.toString());
			System.out.println("Deposit successful");
			break;
		case "withdraw":
			int a = withdraw();
			if(a > bi.getMoney()) {
				//similarly to deposit, except withdraw has a system that prevents withdraw more than what you have
				System.out.println("Sorry, you don't have enough money to withdraw that amount");
				System.out.println("Please try again");
				withdraw();
			} else {
				bi.setMoney(bi.getMoney() - a);
				System.out.println("Withdraw successful");
			}
			break;
		case "logout":
			logout();
			break;
		case "bankbalance":
			//take a look at how much user still has
			System.out.println("Your current amount are: " + bi.getMoney());
			break;
		default:
			System.out.println("Error, please choose avaliable options, or exit to exit");
			bankInterface2(bi);
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
			bankInterface2(bi);
		} else if (yorn.equals("n")) {
			bankInterface();
		}
	}
	
	@Override
	public void signup() {
		String username, email, password;
		String yorn;
		
		//username, email and password equals to the 3 function extended from specific command
		username = username();
		email = email();
		password = password();
		//add the bankinfo into the linkedlist
		tempInfo.add(new BankInfo(username, password, email, 0));
		//write the data into the file prepared
		writeData(tempInfo.getFirst().toString());
		//remove the info from linked list so it doesn't stay on the program
		tempInfo.removeFirst();
		System.out.println("Would you like to automatically go to login: ");
		yorn = scan.nextLine().toLowerCase();
		if(yorn.equals("y")) {
			//time saving feature?
			login();
		} else if (yorn.equals("n")) {
			bankInterface();
		}
		while(!yorn.equals("y") && !yorn.equals("n")){
			System.out.println("Invalid Command, please re-enter your command");
			System.out.println("Enter y for yes, and n for no: ");
			yorn = scan.nextLine().toLowerCase();
		}
	}

	@Override
	public void login() {
		String username, password;
		int count = 0;
		username = logUserOrEmail();
		password = logPassword();
		//read every line of the data stored, and put them into a linkedlist for temp use
		readData();
		BankInfo bi = new BankInfo();
		//compare entered information with all the available choices in the linkedlist
		for (int i = bankInfo.size()-1; i >= 0; i--) {
			bi = bankInfo.get(i);
			if ((username.equals(bi.getUsername()) || username.equals(bi.getEmail())) && password.equals(bi.getPassword())) {
				count++;
				bankInterface2(bi);
			}
		}
		//if nothing is found
		if(count == 0) {
			System.out.println("We are sorry, but the username and password you provided doesn't match,");
			System.out.println("Please re-enter your information");
			login();
		}	
	}

	@Override
	public int deposit() {
		String yorn;
		int amount = 0;
		System.out.println("Hello, customer, how much would you like to deposit: ");
		try {
			// ask for the amount a person wants to enter when deposit
			amount = Integer.parseInt(scan.nextLine());
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
	public int withdraw() {
		String yorn;
		int amount = 0;
		System.out.println("Hello, customer, how much would you like to withdraw: ");
		try {
			//similar to deposit, making sure the amount withdraw are correct, or redo the function
			amount = Integer.parseInt(scan.nextLine());
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


	@Override
	public void logout() {
		//go back the previous interface
		bankInterface();
		
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
				bankInfo.add(new BankInfo(datalist[0], datalist[1], datalist[2], Integer.parseInt(datalist[3])));
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
}
