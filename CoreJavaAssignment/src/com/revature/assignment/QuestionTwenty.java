package com.revature.assignment;

import java.io.*;

public class QuestionTwenty {

	public static void main(String[] args) {
		
		//sets path and creates buffered reader
		BufferedReader br = null;
		String path = "src/com/revature/assignment/data.txt";
		
		try {
			//trys to read first line
			br = new BufferedReader(new FileReader(path));
			String line = br.readLine();
			
			//read the file until there are no more lines to read
			while(line != null) {
				//creates array split at the colons and prints based on position
				String[] parts = line.split(":");
				for(int i=0; i<parts.length; i++) {
					if(i==0) {
						System.out.print("Name: "+parts[i]);
					}else if(i==1) {
						System.out.println(" "+parts[i]);
					}else if(i==2) {
						System.out.println("Age: "+parts[i]+" years");
					}else {
						System.out.println("State "+parts[i]+" state");
					}
				}
				System.out.println();
				line = br.readLine();
			}
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
