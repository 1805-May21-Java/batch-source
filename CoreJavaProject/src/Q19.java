import java.util.ArrayList;

public class Q19 {
	//creates initial list
	static ArrayList<Integer> arrayList = new ArrayList<>();

	public static void main(String[] args) {

		//initializes array 1-10
		for(int i=1;i<=10;i++) {
			arrayList.add(i);
		}
		//Displays original list
		System.out.println("Original List: "+arrayList);
		System.out.println("Evens: "+addEven(arrayList));
		System.out.println("Odds: "+addOdd(arrayList));
		System.out.println("Primes: "+addPrimes(arrayList));
	}
	
	//checks if a number is even
	static private boolean isEven(int num) {
		return (num%2==0);
	}
	
	//returns true if the number is prime, if it makes it to the end of the loop and hasn't been divisible
	static private boolean isPrime(int num) {
		//1 is not prime but would fail the test
		if(num == 1 ) {
			return false;
		}
		for(int i = 2;i<=Math.sqrt((double)num);i++){
			if(num % i == 0 ) {
				return false;
			}
		}
		return true;
	}
	
	//Adds even numbers by checking for even, then adding the rests
	static private int addEven(ArrayList<Integer> arr) {
		int total = 0;
		for(int i : arr) {
			if (isEven(i)) {
				total += i;
			}
		}
		return total;
	}
	
	//Exact same as before except only adds if isEven returns false
	static private int addOdd(ArrayList<Integer> arr) {
		int total = 0;
		for(int i : arr) {
			if (!isEven(i)) {
				total += i;
			}
		}
		return total;
	}

	//adds all the prime numbers
	static private int addPrimes(ArrayList<Integer> arr) {
		int total = 0;
		for(int i : arr) {
			if(isPrime(i)) {
				total += i;
			}
		}
		return total;
	}
}
