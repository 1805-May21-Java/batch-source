package com.revature.q20;

import java.io.*;

public class FormatFileDriver {

	public static void main(String[] args) {
		//set up buffered reader
		BufferedReader br = null;
		//create path
		String path = "src/com/revature/q20/Data";
		
		try {
			//instantiate buffered reader with FileReader and the path
			br = new BufferedReader(new FileReader(path));
			
			//read a line from the fill
			String line = br.readLine();
			//if line isn't null format the text
			while (line != null || line == "") {
				//array now has four elements First : Last : Age : State
				//split the string by ":"
				String[] info = line.split(":");
				System.out.println("Name: " + info[0] + " " + info[1]);
				System.out.println("Age: " + info[2] + " years");
				System.out.println("State: " + info[3] + " State");
				System.out.println();
				
				//read next line
				line = br.readLine();
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
