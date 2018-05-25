package core.revature.assignment;
/*
 * Q15. Write a program that defines an interface having the following methods:
 * addition, subtraction, multiplication, and division.
 * Create a class that implements this interface
 * and provides appropriate functionality to carry out the required operations.
 * Hard code two operands in a test class having a main method that calls the implementing class.
 */
public class Q15 implements Q15Interface { //implement interface
		@Override
		public int add(int x, int y) {
			return x + y;
		}

		@Override
		public int subtract(int x, int y) {
			return x - y;
		}

		@Override
		public int multiply(int x, int y) {
			return x * y;
		}

		@Override
		public int divide(int x, int y) {
			while (y == 0) { // no division by zero
				System.out.println("ERR: DIVIDE BY ZERO");
				return 0;
			}
			return x / y;
		}
	public static void main(String[] args) {
		try {
			Q15 calculation = new Q15(); //declare new calculation object, again I screw up the naming because I wanted to align each problem with the question number.
			System.out.println(calculation.add(15, 5)); //add
			System.out.println(calculation.subtract(15, 5)); //subtract
			System.out.println(calculation.multiply(15, 5)); //multiply
			System.out.println(calculation.divide(15, 5)); //divide
			} catch (ArithmeticException e) {
				e.printStackTrace();
			}	
	}
}
