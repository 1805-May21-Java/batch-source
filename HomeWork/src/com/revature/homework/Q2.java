package com.revature.homework;

public class Q2 {
	// using recursion
	 static int  a =0;
	 static int  b=1;
	 static int c;
	 public void printFib(int i) {
		 if(i>=1) {
			 c = a+b;
			 System.out.print(" " + c);
			 a=b;
			 b=c;
			 printFib(i-1); // recursive call 
			 
	 }
	 }
	public static void main(String[] args) {
		// without using recursion
////		int a = 0, b = 1;// assigning two first numbers in series
//	
//		//System.out.print("printing fibonacci numbers from 0 to 25: ");
//		System.out.println(a + "" + b);
//		int c;
//		for (int i = 1; i <= 25; i++) // looping from 1 to 25
//		{
//
//			c = a + b;
//			System.out.println(" " + c);
//			a = b; // storing value of b in a (swapping)
//			b = c;// swapping
//
//		}
//		//System.out.println();
//		
//		//using recursion(  methods repeats by own)
		System.out.println(a + " " +b); // printing static variables 
		Q2 fib = new Q2();
		//System.out.print(a + " " +b);
		fib.printFib(25);
	}
}