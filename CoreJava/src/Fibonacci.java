
public class Fibonacci {

	public static void main(String[] args) {
		
		int num1 = 0;
		int num2 = 1;
		int count = 3; // num1 and num2 are count's 1 and 2
		
		System.out.println("The first 25 fibonacci numbers: ");
		System.out.print(num1 + " " + num2 + " ");
		
		while (count <= 25) {
			int newNum = num1 + num2; // the next fibonacci number
			System.out.print(newNum + " ");
			num1 = num2; // set num2 and newNum as the new num1 and num2, respectively
			num2 = newNum;
			count++;
		}

	}

}
