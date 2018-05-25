package questions;

import java.time.LocalDateTime;
import java.util.Arrays;



import java.util.Scanner;

//Q14Switch uses Scanner to give user option to carry out.
//Options are A) Squareroot a number, B) Display today's date,
//and C) Split String "I am learning Core Java.
public class Q14Switch {
	
	public static void main(String[] args) {
		
		//String action will be used in switch statement
		String action;
		//Scanner will allow user to input option.
		Scanner sc = new Scanner(System.in);
		//Options are displayed on the console
		System.out.println("What do you want to do?");
		System.out.println("Press A to get squareroot of a number");
		System.out.println("Press B to Display today's date");
		System.out.println("Press C to split 'I am learning Core Java'");
		//User Input is not case sensitive
		action = sc.nextLine().toUpperCase();
		
		//Beginning of switch statement
		switch(action) {
		case "A":
			//User is asked to give a number to squareroot
			//If user supplies anything other than a number
			//a NumberFormatException is caught in the try/catch statement below
			System.out.println("Give me a number to squareroot:");
			try {
				double number = sc.nextDouble();
				double numberSquared = Math.sqrt(number);
				System.out.println("Squareroot of " + number + " is:");
				System.out.println(numberSquared);
			}catch(NumberFormatException e) {
				e.printStackTrace();
			}
			break;
		case "B":
			//LocalDateTime date is used to get instance of the currentTime
			LocalDateTime date = LocalDateTime.now();
			//day, month and year is retrieved from date
			int day = date.getDayOfMonth();
			int month = date.getMonthValue();
			int year = date.getYear();
			//Date is printed in format of mm/dd/yyyy
			System.out.println("Date is: " + month + "/" + day + "/" + year);
			break;
		case "C":
			//String "I am learning Core Java" is split, using " " as the regex.
			//The resulting array is then printed
			System.out.println("I will split 'I am learning Core Java':");
			String[] arr = "I am learning Core Java".split(" ");
			System.out.println(Arrays.toString(arr));
			break;
		default:
			//Any other input will print this line below
			System.out.println("Invalid option");
		}
		//Scanner sc is then closed at end of program
		System.out.println("Exiting switch case");
		sc.close();
	}

}
