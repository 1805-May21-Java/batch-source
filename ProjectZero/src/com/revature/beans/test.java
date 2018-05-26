package com.revature.beans;

import java.io.*;

public class test
{
	public void deserialize()
	{
		try (FileInputStream fis = new FileInputStream("./Bank.ser"); ObjectInputStream ois = new ObjectInputStream(fis)) {
//			FileInputStream fis = new FileInputStream("./Cereal.ser");
//			ObjectInputStream ois = new ObjectInputStream(fis);
			
			System.out.println(ois.readObject());
//			System.out.println(c);
			
//			ois.close();
//			fis.close();
		
		} 
		catch (IOException e) 
		{
			System.out.println("File io exception");
		} 
		catch (ClassNotFoundException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
