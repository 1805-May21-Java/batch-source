package javacore;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class File {
	public static void parse(String s) {
		String[] fileI = s.split(":");
		System.out.println("Name: " + fileI[0] + "," + fileI[1]);
		System.out.println("Age: " + fileI[2] + " years");
		System.out.println("State: " + fileI[3] + " State");
	}
	
	public static void main(String[] args) {
		
		BufferedReader br = null;
		String path = "/apps/javacore/src/javacore/Data.txt";
		
		try {
			br = new BufferedReader(new FileReader(path));
			String line = br.readLine();
			while (line != null) {
				parse(line);
				line = br.readLine();
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				br.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
}
