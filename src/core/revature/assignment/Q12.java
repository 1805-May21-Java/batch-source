package core.revature.assignment;
//Q12. Write a program to store numbers from 1 to 100 in an array.
//Print out all the even numbers from the array.
//Use the enhanced FOR loop for printing out the numbers.
import java.util.ArrayList;
public class Q12 {
	public static void main(String[] args) { //ArrayList similar to Q9
		ArrayList<Integer> numArray = new ArrayList<Integer>();
		for (int x = 1; x <= 100; x++) {
			numArray.add(x); // add each number to ArrayList
		}
		//same test lines as before
		//System.out.println("Stored numbers from 1 to 100:");
		//System.out.println(numArray.toString());
		System.out.println("Even numbers from 1 to 100:");
		for(int x : numArray) { //enhanced FOR loop
			if(x % 2 == 0) { //using modulus to get evens
				System.out.print(x + " ");
			}
		}
	}
}
