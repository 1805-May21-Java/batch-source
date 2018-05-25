package core.revature.assignment;
//Q6. Write a program to determine if an integer is even without using the modulus operator (%)
import java.util.Scanner;
public class Q6 {
	public static void main(String[] args) {
		/*
		 * A number of ways to do this
		 * This uses the bitwise method
		 */
		int num;
		Scanner sc = new Scanner(System.in); // again we need scanner
		System.out.println("Enter a number to determine if it is even");
		num = sc.nextInt();
		if((num & 1) == 0) { //bitwise AND
			System.out.println("Number is even");
		}
		else {
			System.out.println("Number is not even");
		}
		sc.close();
	}
}
