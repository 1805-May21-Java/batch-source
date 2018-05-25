import java.util.Scanner;

public class ComputeFactorial {
	
	public static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		
		System.out.println("Choose value to compute factorial for: ");
		int val = sc.nextInt();

		System.out.println(factorial(val));
	}
	
	public static int factorial(int n) {
		// base case; final value multiplied is 1
		if (n == 1) {
			return 1;
		}
		
		return n * factorial(n-1); // recursive call
	}

}
