package questions;

import java.util.Scanner;

public class Q16StringCount {
	Scanner sc = new Scanner(System.in);
	
	public void getStringCount() {
		System.out.println("Give me a string!");
		String input = sc.nextLine();
		System.out.println(input.length());
	}

}
