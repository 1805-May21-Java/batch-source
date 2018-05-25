package com.revature.a2;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Q20FileRead {
	public void fileRead() {
		//set up path
		BufferedReader br = null;
		String path = "src/com/revature/a2/Data.txt";
		
		try {
			//read into the file
			br = new BufferedReader(new FileReader(path));
			int i;
			int count = 0;
			String s = br.readLine();
			while(s != null){
				//keep going until last line been read
				
				System.out.print("Name: ");
				for (i = 0; i < s.length(); i++) {
					//each line has the same amount of : that act as a separator, so using for loop
					//that will print out the character of each read line until it hits a :
					if(s.charAt(i) == ':') {
						if (count == 0) {
							System.out.print(" ");
							count++;
						} else if (count == 1) {
							System.out.println();
							System.out.print("Age is: ");
							count++;
						} else if (count == 2) {
							System.out.print(" years");
							count++;
							System.out.println();
							System.out.print("State: ");
						} 
					} else if (i == s.length()-1){
						//until the last char has been read, and print out
						System.out.print(s.charAt(i));
						System.out.print(" State");
						count = 0;
						System.out.println();
					} else {
						//keep printing the char until it hit a :
						System.out.print(s.charAt(i));
					}
					
				}
				s = br.readLine();
			}
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
