package core.revature.assignment;
//Q2. Write a program to display the first 25 Fibonacci numbers beginning at 0.
public class Q2 {
	public static void main(String[] args) {
		int a = 0; // 3 int variables to use
		int b = 0;
		int c = 1;
		System.out.println("First 25 numbers of Fibonacci:");
		for(int i = 0; i <= 24; i++) // i = 0; i <= 24 means that it will count the first twenty-five Fibonacci numbers
		{							 // equivalent to i = 1; i <= 25
			a = b;
			b = c;
			c = a+b; //fibonacci algorithm
			System.out.print(a+" ");
		}
	}
}
