<<<<<<< HEAD
package com.revature.q18;

import java.util.Scanner;

public class Driver {

	public static void main(String[] args) {
		
		String myString = "Hello there";
	
		
		MySubClass test = new MySubClass();
		boolean isUpper = test.caseCheck(myString);
		System.out.println(isUpper);
		
		String newUpper = test.makeUpper(myString);
		System.out.println(newUpper);
		
		int biggerNum = test.addTen("15");
		
		System.out.println(biggerNum);

	}

}
=======
package com.revature.q18;

import java.util.Scanner;

public class Driver {

	public static void main(String[] args) {
		
		String myString = "Hello there";
	
		
		MySubClass test = new MySubClass();
		boolean isUpper = test.caseCheck(myString);
		System.out.println(isUpper);
		
		String newUpper = test.makeUpper(myString);
		System.out.println(newUpper);
		
		int biggerNum = test.addTen("15");
		
		System.out.println(biggerNum);

	}

}
>>>>>>> 70ec7955e736c9c2ea644fea4703f6f75b046dac
