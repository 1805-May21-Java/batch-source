package com.revature.hw2;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class q20 {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		BufferedReader br = null;
		String path = "src/com/revature/hw2/Data.txt";
		
		try {
			br = new BufferedReader(new FileReader(path));
			String line = br.readLine();
			
//			"Name: Mickey Mouse\r\n" + 
//					"Age: 35 years\r\n" + 
//					"State: Arizona State\r\n";
//			line.split(arg0)
			//read file until there's nothing left
			while(line != null) {
			String[] str = line.split(":");
				int x = 0;
				System.out.print("Name: " + str[x] + " ");
				x++;
				System.out.println(str[x]);
				x++;
				System.out.println("Age: " + str[x] + " year");
				x++;
				System.out.println("State: " +str[x] + " state");
				x++;
				System.out.println();
				line = br.readLine();
			}
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}