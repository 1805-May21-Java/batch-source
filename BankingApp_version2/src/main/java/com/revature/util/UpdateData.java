package com.revature.util;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;

import com.revature.pojos.Account;

//UpdateData is called in the App class when users are done using their accounts
//and have logged out. The updated HashMap from App is used in UpdateData to
//bankData.txt, it overwrites any existing text and populates it with
//information from the HashMap used in updateBankAccounts(HashMap clientList).
public class UpdateData {
	
	//method is static because no instance of the class is needed to use it
		//updateBankAccounts writes to bankData.txt
		public static void updateBankAccounts(HashMap<String, Account> clientList) throws IOException {
			//File object referencing bankData.txt is created, along with
			//a FileWriter and BufferedWriter, to write to the file
			File bankFile = new File("bankData.txt");
			FileWriter updatedInfo = new FileWriter(bankFile);
			BufferedWriter putInfo = new BufferedWriter(updatedInfo);
			
			//An enhanced for loop ensures iteration through the entire HashMap
			for(Account user: clientList.values()) {
				//Data is retrieved using the Account get methods
				String username = user.getUsername();
				String password = user.getPassword();
				double checking = user.getChecking();
				double savings = user.getSavings();
				//Data is then written on a single string, along with a newline character,
				//to prepare other incoming data.
				String line = username + ":" + password + ":" + checking + ":" + savings;
				putInfo.write(line + "\n");
			}
			//with bankData.txt now updated, resources are closed.
			putInfo.close();
			updatedInfo.close();
		}

}
