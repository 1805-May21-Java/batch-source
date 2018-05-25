package com.revature.q20;

import java.io.*;

public class FormatFileDriver {

	public static void main(String[] args) {
		BufferedReader br = null;
		String path = "src/com/revature/q20/Data";
		
		try {
			br = new BufferedReader(new FileReader(path));
			
			String line = br.readLine();
			while (line != null || line == "") {
				String[] info = line.split(":");
				System.out.println("Name: " + info[0] + " " + info[1]);
				System.out.println("Age: " + info[2] + " years");
				System.out.println("State: " + info[3] + " State");
				System.out.println();
				
				line = br.readLine();
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
