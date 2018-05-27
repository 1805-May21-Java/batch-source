import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Q20 {

	public static void main(String[] args) {

		//reads in the file
		try(BufferedReader bufferedReader = new BufferedReader(new FileReader("src/Q20Text.txt"));) {
			
			//loops through the lines
			for(String line = bufferedReader.readLine();line != null; line = bufferedReader.readLine()) {
				
				//splits string by colons
				String[] splitLine = splitByColons(line);
				
				//prints out the formatted statement, index 0 is first name, 1 is last name,
				//2 is age, 3 is state
				System.out.println(String.format(
						"Name: %s %s\nAge: %s\nState: %s State", 
						splitLine[0],splitLine[1],splitLine[2],splitLine[3]));	
			}
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	//returns a string array, split by colons
	static private String[] splitByColons(String line) {
		return line.split(":");
	}
}
