package core.revature.assignment;
//Q9. Create an ArrayList which stores numbers from 1 to 100 and prints out all the prime numbers to the console.
import java.util.ArrayList;
public class Q9 {
	public static void main(String[] args) {
		String prime = "";
		ArrayList<Integer> numArray = new ArrayList<Integer>();
		for (int x = 1; x <= 100; x++) {
			numArray.add(x); // add each number to ArrayList
			int count = 0; //temporary count variable
			for (int num = x; num >= 1; num--) { //lines 13-22 for the prime numbers
				if(x % num == 0) {
					count = count + 1;
				}
			}
			if (count == 2)
			{
				prime = prime + x + " "; // prime numbers listed accordingly delimited by space
			}
		}
		//next two lines are testing for accessing the 100 numbers
		//System.out.println("Stored numbers from 1 to 100:");
		//System.out.println(numArray.toString());
		System.out.println("Prime numbers from 1 to 100:"); //display
		System.out.println(prime);
	}
}
