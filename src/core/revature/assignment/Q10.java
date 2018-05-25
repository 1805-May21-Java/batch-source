package core.revature.assignment;
//Q10. Find the minimum of two numbers using ternary operators.
import java.util.Scanner;
public class Q10 {
	public static void main(String[] args) {
		Scanner sc = new Scanner (System.in); // this will use a scanner to input the two numbers
		int a;
		int b;
		System.out.println("Enter the value for the first number: ");
		a = sc.nextInt();
		System.out.println("Enter the value for the second number: ");
		b = sc.nextInt();
		int minimum = (a <= b)?a:b; // ternary operator
		System.out.println("Minimum of two numbers: " + a + " and " + b + " is " + minimum);
		sc.close();
	}
}
