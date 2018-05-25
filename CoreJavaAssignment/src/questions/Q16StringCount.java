package questions;

import java.util.Scanner;

//Q16StringCount has a Scanner sc that takes user input. The method
//getStringCount() is used to print String count.
public class Q16StringCount {
	Scanner sc = new Scanner(System.in);
	
	
	public void getStringCount() {
		//User input a string and the string's length is then printed.
		System.out.println("Give me a string!");
		String input = sc.nextLine();
		System.out.println(input.length());
	}

}
