package core.revature.assignment;
//Q4. Write a program to compute N factorial.
import java.util.Scanner;
public class Q4 {
	public static void main(String[] args) {
	    Scanner sc = new Scanner(System.in);
		long n; //using long variables
		long fact = 1; //factorial variable
		System.out.println("Enter a number: ");
		/*
		 * Possibly due to overflow, but it doesn't look like I can get accurate factorial values with bigger numbers,
		 * either they show up as 0 or as a negative number. This starts around 20
		 */
		long number = sc.nextInt();
		for(n = 1; n <= number; n++) {
			fact = fact * n; //factorial algorithm
		}
		System.out.println(number + " factorial is: " + fact);
		sc.close();
	}
}
