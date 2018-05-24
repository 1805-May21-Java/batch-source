import java.util.Scanner;

public class Q17 {

	static Scanner scanner = new Scanner(System.in);
	public static void main(String[] args) {
		double principle;
		double interest;
		int numYears;
		//asks user for the inputs
		System.out.println("What's the principle?");
		principle = returnDouble();
		System.out.println("What's the interest?");
		interest = returnDouble();
		System.out.println("For how many years are you investing?");
		numYears = returnInt();
		//calculates the money, round to 2 decimals by multiplying by 100,
		//rounding to a whole number, then dividing
		System.out.println(String.format("Your intrest will be %.2f dollars in %d years!", 
				principle*interest*numYears,numYears));
		
		
	}
	//checks to make sure input is a double
	static double returnDouble() {
		while(! scanner.hasNextDouble()) {
			System.out.println("Please input a number!");
			scanner.nextLine();
		}
		return scanner.nextDouble();
	}

	//checks to make sure input is an int
	static int returnInt() {
		while(! scanner.hasNextInt()) {
			System.out.println("Please input an integer!");
			scanner.nextLine();
			
		}
		return scanner.nextInt();
	}

}
