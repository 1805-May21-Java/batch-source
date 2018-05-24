package com.revature.fileio;

import java.io.*;

public class DeserializationDriver {


	public static void main(String[] args) {

		Cereal c = null;
		
		try (FileInputStream fis = new FileInputStream("./Cereal.ser"); ObjectInputStream ois = new ObjectInputStream(fis)) {
//			FileInputStream fis = new FileInputStream("./Cereal.ser");
//			ObjectInputStream ois = new ObjectInputStream(fis);
			
			c = (Cereal) ois.readObject();
			System.out.println(c);
			
//			ois.close();
//			fis.close();
		
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
