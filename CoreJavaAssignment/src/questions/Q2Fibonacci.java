package questions;


//Completed, now write comments
public class Q2Fibonacci {
	private int fib1;
	private int fib2;
	public int fibonacci() {
		fib1 = 1;
		fib2 = 0;
		int fibTemp;
		int fibSum = 0;
		int count = 0;
		System.out.println("Q2: Fibonacci Sequence");
		while(count < 25) {
			fibTemp = fib1;
			System.out.println("Fib " + count + ": " + fibSum);
			fibSum = fib1 + fib2;
			fib1 = fib2;
			fib2 += fibTemp;
			count++;
		}
		return 0;
	}
}
