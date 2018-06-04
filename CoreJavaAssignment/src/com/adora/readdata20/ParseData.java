package com.adora.readdata20;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class ParseData {

	public static void main (String[] args) {
		
		String path = "src/com/adora/readdata20/Data.txt";
		try(BufferedReader br = new BufferedReader(new FileReader(path))) {
			String line = br.readLine();
			
			while (line != null) {
				String[] data = line.split(":");
				System.out.println("Name: " + data[0] + " " + data[1]);
				System.out.println("Age: " + data[2] + " years" );
				System.out.println("Sate: " + data[3] + " State");
				System.out.println();
				
				line = br.readLine();
			}
			
		} catch(IOException e) {
			e.printStackTrace();
		}	
		
	}
	
	
}
