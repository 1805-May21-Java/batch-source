package com.revature.corejava;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

//Q20
public class StringSplit {

	public static void main(String[] args) {
		BufferedReader bReader = null;
		String path = "src/com/revature/corejava/data.txt";
		String[] lines = {"","","",""};
		try {
			bReader = new BufferedReader(new FileReader(path));
			String line = bReader.readLine();
			while (line!=null) {
				lines = line.split(":");
				System.out.println("Name: "+lines[0]+ " "+lines[1]);
				System.out.println("Age: "+lines[2]);
				System.out.println("State: "+lines[3]);
				line = bReader.readLine();
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	

}
