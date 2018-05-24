package com.revature.algorithms;

import java.util.Arrays;
import java.util.Collections;

import com.revature.other.Weird;
import java.util.ArrayList;

public class AlgorithmDriver {

	public static void main(String[] args) {
		
		// #1: BubbleSort
		int[] arr1 = {1,0,5,6,3,2,3,7,9,8,4};
		System.out.println("=== #1 BubbleSort");
		System.out.println("Unsorted array: " + Arrays.toString(arr1));
		BubbleSort.bubbleSort(arr1);
		System.out.println("Sorted array: " + Arrays.toString(arr1));
		System.out.println();
		
		// #2: First 25 Fibonacci Numbers
		System.out.println("=== #2 Fibonacci");
		Fibonacci.printFibonacci(25);
		System.out.println();
		
		// #3: String Reversal
		System.out.println("=== #3 String Reversal");
		String s1 = "PartyParrot";
		System.out.println("Initial String: " + s1);
		s1 = ReverseString.reverseString(s1);
		System.out.println("Reversed String: " + s1);
		System.out.println();
		
		// #4: N factorial
		System.out.println("=== #4 Factorial");
		int n1 = 9;
		System.out.println(n1 + "! = " + Factorial.nFactorial(n1));
		System.out.println();
		
		// #5: Substring
		System.out.println("=== #5 Substring");
		String s2 = "Don't you hate it when someone cuts you off mid sentence?";
		int idx1 = 51;
		System.out.println("Original String: " + s2);
		s2 = Substring.substring(s2, idx1);
		System.out.println("Substring from 0 to " + (idx1 - 1) + ": " + s2);
		System.out.println();
		
		// #6: Even Number Check
		System.out.println("=== #6 Even Number Check");
		EvenNumberCheck.checkIfEven(1);
		EvenNumberCheck.checkIfEven(0);
		EvenNumberCheck.checkIfEven(9999998);
		System.out.println();
		
		// #7: Employee Sort
		System.out.println("=== #7 Employee Sort");
		ArrayList<Employee> arr2 = new ArrayList<Employee>();
		arr2.add(new Employee("Fred", "Packaging", 2));
		arr2.add(new Employee("Bob", "HR", 1000));
		System.out.println("Unsorted Employees: " + arr2.toString());
		Collections.sort(arr2);
		System.out.println("Sorted Employees: " + arr2.toString());
		System.out.println();
		
		// #8: Palindrome Favoritism
		System.out.println("=== #8 Palindrome Favoritism");
		PalindromeStorage ps = new PalindromeStorage();
		String[] wordArr  = {"karan", "madam", "tom", "civic", "radar",
				"jimmy", "kayak", "john", "refer", "billy", "did"};
		for(int i = 0; i < wordArr.length; i++) {
			ps.insertString(wordArr[i]);
		}
		System.out.println("Normal array: " + ps.getArr().toString());
		System.out.println("Palindromes: " + ps.getPalindromes().toString());
		System.out.println();
		
		// #9: Prime Separation
		System.out.println("=== #9 Prime Separation");
		PrimeCheck pm = new PrimeCheck();
		pm.fillLists(100);
		System.out.println("Numbers from 1 to 100: " + pm.getNums().toString());
		System.out.println("Primes from 1 to 100: " + pm.getPrimes().toString());
		System.out.println();
		
		// #10: Ternary Minimum
		System.out.println("=== #10 Ternary Minimum");
		double num1 = 5.5555555;
		double num2 = Math.PI;
		Mins.ternaryMin(num1, num2);
		System.out.println();
		
		// #11: Accessing Private Floats
		System.out.println("=== #11 Accessing Private Floats");
		Weird w = new Weird(1.1f, 2.2f);
		System.out.println("Before: float1 = " + w.getVar1() + ", float2 = " + w.getVar2());
		Access.accessFloats(w, 3.0f, 5.8f);
		System.out.println("After: float1 = " + w.getVar1() + ", float2 = " + w.getVar2());
		System.out.println();
		
		// #12: Enhanced for-loop
		System.out.println("=== #12 Enchanced for-loop");
		Even e = new Even();
		e.fillArr(100);
		System.out.print("Evens from 1 to 100: ");
		e.printEvens();
		System.out.println();
		
		// #13: Binary Triangle
		System.out.println("=== #13 Binary Triangle");
		Triangle.printBinaryTriangle(4);
		System.out.println();
		
		// #14: Switch Showcase
		System.out.println("=== #14 Switch Showcase");
		Switch.executeOption(1);
		Switch.executeOption(2);
		Switch.executeOption(3);
		System.out.println();
		
		// #15: Arithmetic w/Interface
		System.out.println("=== #15 Arithmetic w/Interface");
		BasicMath bm = new BasicMath(5, 2.5);
		System.out.println("a = " + bm.getNum1() + ", b = " + bm.getNum2());
		System.out.println("a + b = " + bm.add());
		System.out.println("a - b = " + bm.sub());
		System.out.println("a * b = " + bm.mult());
		System.out.println("a / b = " + bm.div());
		System.out.println();
		
		// #16: String Length from Command Line
		if(args.length > 0) {
			System.out.println("=== #16 String Length from Command Line");
			System.out.println("String entered: " + args[0]);
			System.out.println("Length: " + CommandLineInput.arg0Length(args));
			System.out.println();
		}
		
		// #17: Simple Interest
		System.out.println("=== #17 Simple Interest");
		Financial f = new Financial();
		f.promptValues();
		System.out.println("\nThe simple interest rate is $" + f.calculateSimpleInterest());
		System.out.println();
		
		// #18: Abstract Methods
		System.out.println("=== #18 Abstract Methods");
		QuestionEighteen q18 = new QuestionEighteen();
		String niceStr = "hello world";
		String weirdStr = "heLLo WoOooOOOoOOOoOrld";
		String numberStr = "1234";
		
		System.out.println("True/False: " + niceStr + " has uppercase letters. " + q18.checkUppercase(niceStr));
		System.out.println("True/False: " + weirdStr + " has uppercase letters. " + q18.checkUppercase(weirdStr));
		System.out.println(niceStr + " to uppercase -> " + q18.lowerToUpper(niceStr));
		System.out.println(weirdStr + " to uppercase -> " + q18.lowerToUpper(weirdStr));
		System.out.println(numberStr + " + 10 = " + q18.addTen(numberStr));
		System.out.println();
		
		// #19: More ArrayLists
		System.out.println("=== #19 More ArrayLists");
		ArrayListActivity al = new ArrayListActivity();
		
		System.out.println("Original ArrayList: " + al.toString());
		System.out.println("Sum of evens: " + al.addEvens());
		System.out.println("Sum of odds: " + al.addOdds());
		al.removePrimes();
		System.out.println("New Prime-free ArrayList: " + al.toString());
		System.out.println();
		
		// #20: File IO
		System.out.println("=== #20 File IO");
		MyReader mr = new MyReader();
		mr.readRecords();
		mr.printRecords();
	}
}
