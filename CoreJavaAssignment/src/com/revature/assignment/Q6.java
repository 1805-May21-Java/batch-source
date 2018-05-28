package com.revature.assignment;

public class Q6 {

	//Q6. Write a program to determine if an integer is even without using the modulus operator (%)
	
	//If int input is odd then the data type will change when divided by two and will not much the original input when multiplied by 2
	public void evenCheck(int a) {
		if ((a/2) * 2 == a) {
			System.out.println("This number is even");
		} else {System.out.println(a);
			System.out.println("This number is odd");
	}
}
		// Driver code
		// Q6 q = new Q6();
		//q.evenCheck(10);
}