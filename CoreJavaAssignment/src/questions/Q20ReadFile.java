package questions;

import java.io.*;

//Q20ReadFile reads file Data.txt and prints out information as specified
//in Q20.
public class Q20ReadFile {
	
	//Any Exception will throw an IOException
	public static void main(String[] args) throws IOException {
		//New File object created, using Data.txt
		//A BuffredReader reading from a FileInputStream of Data.txt is
		//created.
		File newFile = new File("src/questions/Data.txt");
		FileInputStream fis = new FileInputStream(newFile);
		BufferedReader br = new BufferedReader(new InputStreamReader(fis));
		
		//A while loop is used to check that each line != null
		String line;
		while((line = br.readLine()) != null){
			//Each line is split into a String[], using regex ":"
			//Each value in strArray is printed as requested in Q20
			String[] strArray = line.split(":");
			System.out.println("Name: " + strArray[0] + " " + strArray[1]);
			System.out.println("Age: " + strArray[2] + " years");
			System.out.println("State: " + strArray[3] + " State");
			System.out.println();
		}
		//At end of file BufferedReader br and FileInputStream fis are closed.
		br.close();
		fis.close();
	}

}
