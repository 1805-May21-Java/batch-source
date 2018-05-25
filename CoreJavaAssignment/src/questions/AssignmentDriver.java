package questions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

//Assignment Driver serves as a test class for all classes

public class AssignmentDriver {
	public static void main(String[] args) {
		//Q1
		//Q1BubbleSort object created to test in the driver.
		System.out.println("Q1");
		Q1BubbleSort q1 = new Q1BubbleSort();
		//Array to be used in Q1, as requesting in Q1.
		int[] array1 = {1,0,5,6,3,2,3,7,9,8,4};
		q1.bubbleSort(array1);
		System.out.println("Array from Q1 after using BubbleSort:");
		System.out.println(Arrays.toString(array1));
		//Another example
		System.out.println("Second array after using BubbleSort");
		int[] array2 = {58,35,75,22,24,-24,434,-1};
		q1.bubbleSort(array2);
		System.out.println(Arrays.toString(array2));
		System.out.println();
		
		//Q2
		//Q2Fibonnaci object created to test in the driver
		//running q2.fibonnaci will print the first 25 numbers
		//in the fibonnaci sequence.
		System.out.println("Q2");
		Q2Fibonacci q2 = new Q2Fibonacci();
		q2.fibonacci();
		System.out.println();
		
		//Q3
		//Prints the String testQ3 and String revTestQ3,
		//the latter which is the reverse of testQ3
		System.out.println("Q3");
		Q3ReverseString q3 = new Q3ReverseString();
		String testQ3 = "abcdefg!";
		System.out.println("Testing Q3:");
		System.out.println(testQ3);
		String revTestQ3 = q3.reverseString(testQ3);
		System.out.println(revTestQ3);
		System.out.println();
		
		//Q4
		//The three print statements below
		//prints the result of each call to Q4Factorial.factorial(double n)
		System.out.println("Q4");
		Q4Factorial q4 = new Q4Factorial();
		System.out.println("Factorial of 5 is: " + q4.factorial(5));
		System.out.println("Factorial of 7 is: " + q4.factorial(7));
		System.out.println("Factorial of 9 is: " + q4.factorial(9));
		System.out.println();
		
		//Q5
		System.out.println("Q5");
		Q5Substring q5 = new Q5Substring();
		System.out.println(q5.getSubstring("Slice of pizza", 5));
		System.out.println(q5.getSubstring("PRINT ONLY the first two words", 10));
		System.out.println();
		
		//Q6
		System.out.println("Q6");
		Q6NumberEven q6 = new Q6NumberEven();
		System.out.println("Is 10 even?");
		System.out.println(q6.isNumberEven(10));
		System.out.println("Is 9 even?");
		System.out.println(q6.isNumberEven(9));
		System.out.println();
		
		//Q7
		//Four Q7Employee Objects
		System.out.println("Q7");
		Q7Employee q71 = new Q7Employee("Wade Wilson", "X-Force", 31);
		Q7Employee q72 = new Q7Employee("Nathan Summers", "Future", 48);
		Q7Employee q73 = new Q7Employee("Wade Wilson", "X-Men", 31);
		Q7Employee q74 = new Q7Employee("Dominoe", "X-Force", 28);
		//ArrayList q7List created and adds the Q7Employee objects
		ArrayList<Q7Employee> q7List = new ArrayList<Q7Employee>();
		q7List.add(q71);
		q7List.add(q72);
		q7List.add(q73);
		q7List.add(q74);
		//q7List is first printed out unsorted
		System.out.println("q7List unsorted:");
		for(Q7Employee q7elem : q7List) {
			System.out.println(q7elem);
		}
		System.out.println();
		//List is sorted by the compare(e1, e2) method in Q7Employee
		//q7List is then printed
		System.out.println("Sorting q7List by name, department, and age:");
		Collections.sort(q7List, new Q7Employee());
		for(Q7Employee q7elem : q7List) {
			System.out.println(q7elem);
		}
		System.out.println();
		
		//Q8
		System.out.println("Q8");
		//ArrayList from the question 8
		ArrayList<String> stringList = new ArrayList<String>(Arrays.asList("karan", "madam",
				"tom", "civic", "radar", "jimmy", "kayak", "john", "refer", "billy", "did"));
		//q8 is used to give value to ArrayList<String> palindromed
		Q8PalindromeArray q8 = new Q8PalindromeArray();
		ArrayList<String> palindromed = q8.getPalindrome(stringList);
		System.out.println("List with non-palindromes:");
		System.out.println(stringList);
		System.out.println("List with only palindromes: ");
		System.out.println(palindromed);
		System.out.println();
		
		//Q9
		System.out.println("Q9");
		//array from the question 9
		int[] arr = new int[100];
		for(int i = 0; i < arr.length; i++) {
			arr[i] = i+1;
		}
		//Prints all primes between 1 to 100.
		Q9ArrayPrimes q9 = new Q9ArrayPrimes();
		q9.printPrimes(arr);
		System.out.println();
		
		//Q10
		System.out.println("Q10");
		//Two print statements are provided to show q10 solution
		Q10TernaryOp q10 = new Q10TernaryOp();
		System.out.println("Min of 5 and 3 is: " + q10.findMin(5, 3));
		System.out.println("Min of 7 and 1 is: " + q10.findMin(7, 1));
		System.out.println();
		
		//Q11
		//Solution is in Q11PackageB
		
		//Q12
		System.out.println("Q12");
		Q12ArrayLoop q12 = new Q12ArrayLoop();
		q12.loopEvens();
		System.out.println();
		
		//Q13
		System.out.println("Q13");
		Q13TriangleLoop q13 = new Q13TriangleLoop();
		q13.printTriangle(8);
		System.out.println();
		q13.printTriangle(4);
		System.out.println();
		
		//Q14
		//Solution found in file Q14Switch.java
		
		//Q15
		System.out.println("Q15");
		//AssignmentDriver serves as test class for Q15MyClass
		//int variables are used to check each method in Q15MyClass at least twice.
		int a1 = 5;
		int b1 = 3;
		int a2 = 29;
		int b2 = 1;
		//Instance of Q15MyClass created
		Q15MyClass q15 = new Q15MyClass();
		System.out.println(a1 + " plus " + b1 + " is: " + q15.addition(a1, b1));
		System.out.println(a2 + " plus " + b2 + " is: " + q15.addition(a2, b2));
		System.out.println(a1 + " minus " + b1 + " is: " + q15.subtraction(a1, b1));
		System.out.println(a2 + " minus " + b2 + " is: " + q15.subtraction(a2, b2));
		System.out.println(a1 + " multiplied by " + b1 + " is: " + q15.multiplication(a1, b1));
		System.out.println(a2 + " multiplied by " + b2 + " is: " + q15.multiplication(a2, b2));
		System.out.println(a1 + " divided by " + b1 + " is: " + q15.division(a1, b1));
		System.out.println(a2 + " divided by " + b2 + " is: " + q15.division(a2, b2));
		System.out.println();
		//Exception for divide by 0 handled, as tested in the comment below
		//int fail = q15.division(4, 0);
		
		//Q16
		System.out.println("Q16");
		Q16StringCount q16 = new Q16StringCount();
		q16.getStringCount();
		System.out.println();
		
		//Q17 Solution is in Q17SimpletInterest.java
		
		//Q18
		System.out.println("Q18");
		//AssigmentDriver serves as test class for Q1.
		Q18MyClass q18 = new Q18MyClass();
		System.out.println("Testing hasUpperCase():");
		System.out.println(q18.hasUpperCase("all lowercased so false"));
		System.out.println(q18.hasUpperCase("this Should be true"));
		System.out.println("Testing lowerToUpper():");
		System.out.println(q18.lowerToUpper("Now i will Finally be UPPER!"));
		System.out.println("Testing stringToInt():");
		System.out.println(q18.stringToInt("59"));
		System.out.println();
		//Exception handled, as tested in the comment below
		//System.out.println(q18.stringToInt("NumberFormatException"));
		
		//Q19
		//Solution demonstrated in Q19ArrayList.java
		
		//Q20
		//Solution demonstrated in Q20ReadFile.java
		
		
	}
}
