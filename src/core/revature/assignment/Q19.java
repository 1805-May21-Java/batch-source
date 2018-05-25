package core.revature.assignment;
//Q19. Create an ArrayList and insert integers 1 through 10.
//Display the ArrayList.
//Add all the even numbers up and display the result.
//Add all the odd numbers up and display the result.
//Remove the prime numbers from the ArrayList and print out the remaining ArrayList.
import java.util.ArrayList;
public class Q19 {
	public static void removePrimes(ArrayList<Integer> al) { // function to remove primes, needs the boolean function below
		boolean isPrime;
		int last = al.size() - 1; //check number starting from the back, helps with indexing
		for (int idx = last; idx >= 0; idx--) {
			isPrime = true; //default isPrime to true until it is proven to be composite
			if(al.get(idx) == 1) { //remove 1
				isPrime = false;
				break;
			}
			for(int num = 2; num < al.get(idx); num++) {
				if(al.get(idx) % num == 0) { //check for composite
					isPrime = false;
					break;
				}
			}
			if(isPrime) {
				al.remove(idx); // remove primes
			}
		}
	}
	public static void main(String[] args) {
		ArrayList<Integer> numArray = new ArrayList<Integer>(); //Create an ArrayList
		for (int x = 1; x <= 10; x++) { //insert integers 1 through 10
			numArray.add(x); // add each number to ArrayList
		}
		System.out.println("ArrayList (1-10)");
		System.out.println(numArray.toString()); //Display the ArrayList
		ArrayList<Integer> evenArray = new ArrayList<Integer>();
		for (int x : numArray) {
			if(x % 2 == 0) { //using modulus to get evens
				evenArray.add(x);
			}
		}
		//System.out.println(evenArray.toString()); //Display the even numbers;
		int sum = 0;
		for (int i : evenArray) { //for loop for even numbers
			sum += i; //add all the even numbers up
		}
		System.out.println("Sum of even numbers 2, 4, 6, 8, 10");
		System.out.println(sum); // displaying the result
		ArrayList<Integer> oddArray = new ArrayList<Integer>(); //repeating this for the odd numbers
		for (int x : numArray) {
			if(x % 2 == 1) { //using modulus to get odds
				oddArray.add(x);
			}
		}
		//System.out.println(oddArray.toString()); //Display the odd numbers;
		sum = 0;
		for (int i : oddArray) { //for loop for odd numbers
			sum += i; //add all the odd numbers up
		}
		System.out.println("Sum of odd numbers 1, 3, 5, 7, 9");
		System.out.println(sum); // displaying the result
		removePrimes(numArray); // finally let's call removePrimes
		System.out.println("ArrayList without prime numbers"); 
		System.out.println(numArray.toString()); // and finally display
	}
}
