package com.revature.a2;

public class Q0Driver {
	public static void main (String[] args) {
		
		Q1BubbleSort bubbleSort = new Q1BubbleSort();
		bubbleSort.bubbleSort();
	
		Q2Fibonacci fibonacci = new Q2Fibonacci();
		fibonacci.fibonacci();
		
		Q3ReverseString reverseString = new Q3ReverseString();
		reverseString.reverseString();
		
		Q4NFactorial nFactorial = new Q4NFactorial();
		nFactorial.nFactorial();
		
		Q5Substring substring = new Q5Substring();
		substring.substring("Hello World!", 8);
		
		Q6OddOrEven oddOrEven = new Q6OddOrEven();
		oddOrEven.oddOrEven(14);
		
		Q7SortEmployee sortEmployee = new Q7SortEmployee();		
		sortEmployee.sortEmployee();
		
		Q8Palindromes palindrome = new Q8Palindromes();
		palindrome.palindromes();
		
		Q9PrimeNumber primeNumber = new Q9PrimeNumber();
		primeNumber.primeNumber();
		
		Q10TernaryMin ternaryMin = new Q10TernaryMin();
		ternaryMin.ternaryMin(9, 12);
		
		Q11FloatAccess floatAccess = new Q11FloatAccess();
		System.out.println(floatAccess.getA3());
		
		Q12EvenArray evenArray = new Q12EvenArray();
		evenArray.evenArray();
		
		Q13TriangleDisplay triangleDisplay = new Q13TriangleDisplay();
		triangleDisplay.triangleDisplay(5);
		
		Q14SwitchCase switchCase = new Q14SwitchCase();
		switchCase.switchCase("date");
		
		Q15BasicMath basicMath = new Q15BasicMath();
		basicMath.calculation(12, 6);
		
		Q16StringLength stringLength = new Q16StringLength();
		stringLength.stringLength();
		
		Q17SimpleInterest simpleInterest = new Q17SimpleInterest();
		simpleInterest.simpleInterest();
	
		Q18InheritClass inheritClass= new Q18InheritClass();
		inheritClass.inheritClass("15");
		
		Q19ArrayList arrayList = new Q19ArrayList();
		arrayList.arrayList();
		
		Q20FileRead fileRead = new Q20FileRead();
		fileRead.fileRead();
	}
}
