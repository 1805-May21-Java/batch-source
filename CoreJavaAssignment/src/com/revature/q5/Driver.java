<<<<<<< HEAD
package com.revature.q5;

import java.util.Scanner;

public class Driver {

	public static void main(String[] args) {

		System.out.println("Enter String:");
		Scanner sc = new Scanner(System.in);
		String myString = sc.nextLine();
		
		MyStringClass stro = new MyStringClass(myString);
		
		System.out.println("Enter idx:");
		int idx = sc.nextInt();
		System.out.println(MyStringClass.mySubstringMethod(myString, idx));
		
		

	}

}
=======
package com.revature.q5;

import java.util.Scanner;

public class Driver {

	public static void main(String[] args) {

		System.out.println("Enter String:");
		Scanner sc = new Scanner(System.in);
		String myString = sc.nextLine();
		
		MyStringClass stro = new MyStringClass(myString);
		
		System.out.println("Enter idx:");
		int idx = sc.nextInt();
		System.out.println(MyStringClass.mySubstringMethod(myString, idx));
		
		

	}

}
>>>>>>> 70ec7955e736c9c2ea644fea4703f6f75b046dac
