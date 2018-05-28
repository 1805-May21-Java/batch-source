package com.revature.Q12;
import java.io.*;
public class Q20 {

	public static void main(String[] args) throws IOException {
		//Reader to bring in the data from the files
		BufferedReader br = new BufferedReader(new FileReader("src/com/revature/Q12/Data.txt"));
		//String the file would be read into
		String line;
		//while loop that would send the reader into the file to collect the data
		while((line = br.readLine())!= null) {
			//Made string array taht skipped the : and took in all other information
			String sign[] = line.split(":");
			//Printed all other information
			System.out.println("Name: "+sign[0]+ " "+ sign[1]);
			System.out.println("Age: "+sign[2]+ " years");
			System.out.println("State: " + sign[3]+ " State\n");
		}
	}

}
