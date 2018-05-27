package com.revature.core_java_assignment.Question20;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Driver {

	public static void main(String[] args) {
		BufferedReader br = null;
		
		try {
			String path = "src/com/revature/core_java_assignment/Question20/Data.txt";
			br = new BufferedReader(new FileReader(path));
			String line = null;
			while((line = br.readLine()) != null) {
				String[] words = line.split(":");
				System.out.println("Name: " + words[0] + " " + words[1]);
				System.out.println("Age: " +  words[2] + " years");
				System.out.println("State: " +  words[3] + " State");
				System.out.println();
			}
		} catch (IOException  e) {
			e.printStackTrace();
		}
	}

}
