package bank.app;

import java.io.*;
import java.util.HashMap;

import bank.users.Account;

//This class reads from text file bankData.txt to populate LinkedList<Account> bankAccounts
//with instances of Account objects using the information in each line of the text file
public class BankAccounts{
	
	//All instances of BankAccounts will share the same HashMap
	//the class will always refer to bankData.txt to populate it.
	private static HashMap<String, Account> bankAccounts = new HashMap<String, Account>();
	//The constructor populates the HashMap bankAccounts with data
	//read from bankData.txt
	public BankAccounts() throws IOException{
		//A File object referencing bankData.txt was created
		//pullInfo and getInfo reads the information from the text file
		File bankingInformation = new File("src/bank/app/bankData.txt");
		FileInputStream pullInfo = new FileInputStream(bankingInformation);
		BufferedReader getInfo = new BufferedReader(new InputStreamReader(pullInfo));
		
		//lineInfo will be used with the while loop to ensure
		//that the text file has been read in its entirety
		String lineInfo;
		while((lineInfo = getInfo.readLine()) != null) {
			//At each line, a String array is created using the String.split method,
			//with ":" as the regex.
			//if(lineInfo)
			String[] userInfo = lineInfo.split(":");
			//The double primitive variables are created to store the 
			//parsed Double versions of the strings representing Doubles.
			if(userInfo.length == 4) {
			double checking = Double.parseDouble(userInfo[2]);
			double savings = Double.parseDouble(userInfo[3]);
			//An Account object is created with the newly read data
			//and stored in the HashMap, using username as the key.
			Account currentUser = new Account(userInfo[0], userInfo[1],
					checking, savings);
			bankAccounts.put(userInfo[0], currentUser);
			}
		}
		//FileInputStream and BufferedReader are closed to prevent
		//resource leaks
		getInfo.close();
		pullInfo.close();
	}
	
	//This method returns the newly populated HashMap with Account objects
	public HashMap<String, Account> getBankAccounts() throws IOException{
		return bankAccounts;
		
	}

}
