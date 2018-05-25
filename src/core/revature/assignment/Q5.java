package core.revature.assignment;
//Q5. Write a substring method that accepts a string str and an integer idx
//and returns the substring contained between 0 and idx-1 inclusive.
//Do NOT use any of the existing substring methods in the String, StringBuilder, or StringBuffer APIs.
import java.util.Scanner;
public class Q5 {
	public static void main(String[] args) {
		String str = new String("This is a string"); //change this string to whatever
		int idx;
		System.out.println("Enter an index: ");
		Scanner sc = new Scanner(System.in);
		idx = sc.nextInt();
		while (idx > str.length()) { // check if index is larger than string length
			System.out.println("Index is longer than string length");
			idx = sc.nextInt();
		}
		char[] strArray = str.toCharArray(); //like Q3, I will convert the string to an array of characters for convenience 
		//System.out.println(str.length());
		for (int i = 0; i < idx; i++) // from 0 to idx, 1 inclusive
			System.out.print(strArray[i]); //use System.out.print for printing on one line, System.out.println for multiple lines
		sc.close();
	}
}
