package core.revature.assignment;
/*
 * Q14. Write a program that demonstrates the switch case.
 * Implement the following functionalities in the cases:java 
 * Case 1: Find the square root of a number using the Math class method.
 * Case 2: Display today’s date.
 * Case 3: Split the following string and store it in a string array. “I am learning Core Java”
 */
import java.util.Scanner;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.lang.Math;
public class Q14 {
	public static void main(String[] args) {
		DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		Date date = new Date();
		int choice;
		boolean exit = false;
		Scanner sc = new Scanner(System.in);

		do { // let's make a menu to further accommodate the switch case
			System.out.println("Enter your choice (1-4): ");
			System.out.println("1. Calculate square root");
			System.out.println("2. Print today's date");
			System.out.println("3. Split a string into a string array.");
			System.out.println("4. Exit");
			choice = sc.nextInt();
			switch(choice) {
			case 1: // square root
				double x;
				System.out.println("Enter a number to compute the square root: ");
				x = sc.nextInt();
				System.out.println("Square root: " + Math.sqrt(x));
				System.out.println();
				break;
			case 2:
				System.out.println(dateFormat.format(date)); // print today's date, also time
				System.out.println();
				break;
			case 3:
				String str = "I am learning Core Java"; // split the string into a string array
				String[] stringArray = str.split(" ");
				for(int i = 0; i < stringArray.length; i++) {
					System.out.println(stringArray[i]);
					System.out.println();
				}
				break;
			case 4:
				exit = true; //includes a boolean variable for exit condition
				break;
			default:
				System.out.println("Invalid input, rerun it again");
				System.out.println();
				break;
			}
		} while (exit == false);
		sc.close();
	}
}
