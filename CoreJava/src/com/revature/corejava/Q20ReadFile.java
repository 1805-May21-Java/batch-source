package com.revature.corejava;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Q20ReadFile {

	public static void main(String[] args) {
		String path = "src/Data.txt";
		BufferedReader br;
		try {
			br = new BufferedReader(new FileReader(path));
			String line = br.readLine();
			
			// read whole file
			while (line != null) {
				String[] arr = line.split(":"); // split line on colon
				// print information
				System.out.println("Name: " + arr[0] + " " + arr[1]);
				System.out.println("Age: " + arr[2] + " years");
				System.out.println("State: " + arr[3] + " State");
				System.out.println();
				line = br.readLine();
			}
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
		

	}

}
