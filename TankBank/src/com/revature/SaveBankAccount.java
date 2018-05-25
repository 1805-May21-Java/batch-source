package com.revature;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

//Saves a bank account object
public class SaveBankAccount {

	public static void save(BankAccount bankAccount) {
		String fileName = "src/com/revature/accounts/"+bankAccount.getUsername()+".txt";
		try(ObjectOutputStream oStream = new ObjectOutputStream(new FileOutputStream(fileName));){
			
			//writes object to file, overwriting old balance if there
			oStream.writeObject(bankAccount);
		
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
