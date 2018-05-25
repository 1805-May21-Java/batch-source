package core.revature.assignment;
//Q20. Create a notepad file called Data.txt and enter the following:
//Mickey:Mouse:35:Arizona
//Hulk:Hogan:50:Virginia
//Roger:Rabbit:22:California
//Wonder:Woman:18:Montana 
//Write a program that would read from the file and print it out to the screen in the following format: 
//Name: Mickey Mouse
//Age: 35 years
//State: Arizona State
import java.io.*;
public class Q20 {
	public static void main(String[] args) {
		BufferedReader bf = null; //using BufferedReader for this one
		String path = "src/core/revature/assignment/data"; //change path if necessary
		try {
			bf = new BufferedReader(new FileReader(path)); // read data file
			String str = bf.readLine();
			while (str != null || str == "") {
				String[] data = str.split(":"); //colon delimited file
				System.out.println("Name: " + data[0] + " " + data[1]); //data[0] is equivalent to firstName, data[1] is equivalent to lastName
				System.out.println("Age: " + data[2] + " years"); //data[2] is equivalent to age
				System.out.println("State: " + data[3] + " State"); //data[3] is equivalent to state
				System.out.println();
				str = bf.readLine();
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace(); //catch FNF exceptions and IO exceptions
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
