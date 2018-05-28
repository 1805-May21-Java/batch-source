package com.revature.q20;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Driver {

	public static void main(String[] args) {
		
		BufferedReader br = null;
		String path = "src/com/revature/q20/Data.txt";
		
		try {
			br = new BufferedReader(new FileReader(path));
			String line = br.readLine();
			
			String[] linesToPrint = line.split(":");
			
			for (String printLine : linesToPrint) {
				System.out.println(printLine);
			}
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	
}
