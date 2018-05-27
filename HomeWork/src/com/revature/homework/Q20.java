package com.revature.homework;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Q20 {

	public static void main(String[] args) {
		BufferedReader bReader = null;
			String path = "src/com/revature/homework/Data.txt";
			//String[] lines = {"","","",""};
				try {
					bReader = new BufferedReader(new FileReader(path)); // using buffered reader
					String line = bReader.readLine();
		             while (line!=null) {
					String[]	lines = line.split(":"); // using split method
						System.out.println("Name: "+lines[0]+ " "+lines[1]);
						System.out.println("Age: "+lines[2]);
						System.out.println("State: "+lines[3]);
						line = bReader.readLine();
						System.out.println();
					}
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
	 
		
		
	
}
}
