package core.revature.assignment;
//Q17. Write a program that calculates the simple interest
//on the principal, rate of interest and number of years provided by the user.
//Enter principal, rate and time through the console using the Scanner class.
//Interest = Principal* Rate* Time
import java.util.Scanner;
public class Q17 {
	public static void main(String[] args) {
		double interest; // I = PRT
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the principal amount: ");
		double principal = sc.nextDouble(); // P must be double
		System.out.println("Enter the rate (decimal): ");
		double rate = sc.nextDouble(); // R must be double
		System.out.println("Enter the time (in years): ");
		int time = sc.nextInt(); // T must be int
		interest = principal * rate * time; // I = PRT
		System.out.println("Interest: " + interest);
		sc.close();
	}
}
