package com.revature.p0;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class MockBank {

	UserInput input;
	
	public MockBank() {
		input = new UserInput();
	}
	
	public void AccountHub() {
		System.out.println("Press 1 to make an account or 2 to log in.");
		
		int x = input.menu();
		
		if(x == 1) {
			//go to MakeAccount
			MakeAccount();
		}
		else if(x == 2) {
			//go to Login
			Login();
		}
		else {
			//print invalid num, try again
			System.out.println("Number Invalid! Please try again.");
			AccountHub();
		}
	}
	
	public void MakeAccount()
	{
		System.out.println("Please enter either an email"
			+ " or make an account name.");
		String name = input.names();
//		System.out.println(name+" was entered.");
//		System.out.println(input.names());
		BufferedWriter bw = null;
		String path = "src/com/revature/p0/"+name+"Data.txt";
		try {
			//specifies file to write to
			File file = new File(path);
			
			//check to see if file exists 1st; make one if there isn't one
			if(!file.exists()) {
				file.createNewFile();
			}
			//FileWriter has optional argument that specifies if it should append
			FileWriter fw = new FileWriter(file, true);
			bw = new BufferedWriter(fw);

			bw.write(name);
			bw.newLine();
			bw.write("0");
			bw.close();
			System.out.println("Account Created. Entering Main Hub...\n");
			MainHub(name);
		}catch(IOException e) {
			e.printStackTrace();
		}finally {
			if(bw!=null) {
				try {
					bw.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		//Check to see if account exists?
	}

	public void Login()
	{
		System.out.println("Please enter your account name.");
		String name = input.names();
		BufferedReader br = null;
		String path = "src/com/revature/p0/"+name+"Data.txt";
		try {
			br = new BufferedReader(new FileReader(path));
			String line = br.readLine();
			
			//read file until there's nothing left
			//Check to see if account exists?
			while(line != null)
			 {
				System.out.println(line);
			 		if(name.equals(line))
			 		{
						System.out.println("Access Granted! Moving to Main Hub...\n");
						br.close();
						MainHub(name);
			  		}
				line = br.readLine();
			 }
			System.out.println("Account not found. Please try again.");
			br.close();
			AccountHub();
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void MainHub(String Name) {
		System.out.println("Main Hub: \n"
				+ "Press 1 to make a deposit, \n"
				+ "Press 2 to make a Withdrawal, \n"
				+ "Press 3 to see your current balance, \n"
				+ "or press 4 to log out.");
		
		int x = input.menu();
		
		if(x == 1) {
			//go to Deposit
			Deposit(Name);
		}
		else if(x == 2) {
			//go to Withdrawal
			Withdraw(Name);
		}
		else if(x == 3) {
			//go to seeBalance
			seeBalance(Name);
		}
		else if(x == 4) {
			//go to AccountHub
			System.out.println("Thank you for using MyBank. Please come again!\n");
			AccountHub();
		}
		else {
			//print invalid num, try again
			System.out.println("Number Invalid! Please try again.\n");
			MainHub(Name);
		}
	}
	
	public void Deposit(String Name) {
		// user inputs $$$
		double total;
		System.out.println("How much would you like to add?");
		double x = input.money();
//		System.out.println(x);

		String path = "src/com/revature/p0/"+Name+"Data.txt";
		BufferedReader br = null;
		try {
			br = new BufferedReader(new FileReader(path));
			String line = br.readLine();
			System.out.println(line);
			while(line != null)
			 {
//				System.out.println(line);
			 		if(Name.equals(line))
			 		{
						line = br.readLine();
//						System.out.println(line);
			 			total = Double.parseDouble(line);
//						System.out.println(total);
						total += x;
						System.out.println("Your total is now " + total + ".\n");
						BufferedWriter bw = null;
						FileWriter fw = new FileWriter(path);
						bw = new BufferedWriter(fw);
						bw.write(String.valueOf(Name));
						bw.newLine();
						bw.write(String.valueOf(total));
//						System.out.println(total);
//						System.out.println(line);
						bw.close();
						MainHub(Name);
			  		}
				line = br.readLine();
			 }
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void Withdraw(String Name) {
		// user inputs $$$
		double total;
		System.out.println("How much would you like to remove?");
		double x = input.money();
//		System.out.println(x);

		String path = "src/com/revature/p0/"+Name+"Data.txt";
		BufferedReader br = null;
		try {
			br = new BufferedReader(new FileReader(path));
			String line = br.readLine();
			while(line != null)
			 {
//				System.out.println(line);
			 		if(Name.equals(line))
			 		{
						line = br.readLine();
//						System.out.println(line);
			 			total = Double.parseDouble(line);
//						System.out.println(total);
			 			total -= x;
						if(total < 0){
						System.out.println("Invalid! Don't take more money"
								+ " than what's in the account!\n");
						MainHub(Name);
						}
						System.out.println("Your total is now " + total + ".\n");
						BufferedWriter bw = null;
						FileWriter fw = new FileWriter(path);
						bw = new BufferedWriter(fw);
						bw.write(String.valueOf(Name));
						bw.newLine();
						bw.write(String.valueOf(total));
//						System.out.println(total);
//						System.out.println(line);
						bw.close();
						MainHub(Name);
			  		}
				line = br.readLine();
			 }
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void seeBalance (String Name) {
		// user sees $$$
		double total;
		String path = "src/com/revature/p0/"+Name+"Data.txt";
		BufferedReader br = null;
		try {
			br = new BufferedReader(new FileReader(path));
			String line = br.readLine();
			
			//read file until there's nothing left
			while(line != null)
			 {
				System.out.println(line);
			 		if(Name.equals(line))
			 		{
						line = br.readLine();
						System.out.println(line);
						total = Double.parseDouble(line);
						System.out.println("Your total is currently " + total + ".\n");
						br.close();
						MainHub(Name);
			  		}
				line = br.readLine();
			 }
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}