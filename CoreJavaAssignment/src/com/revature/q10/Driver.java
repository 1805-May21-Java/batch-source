<<<<<<< HEAD
package com.revature.q10;

import java.util.Scanner;

public class Driver {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		System.out.println("Enter First Number:");
        int num1 = sc.nextInt();
        System.out.println("Enter Second Number:");
        int num2 = sc.nextInt();
        sc.close();
        
        int minimum = num1 < num2 ? num1 : num2;
        System.out.println("The minimum number is: " + minimum);
	}

}
=======
package com.revature.q10;

import java.util.Scanner;

public class Driver {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		System.out.println("Enter First Number:");
        int num1 = sc.nextInt();
        System.out.println("Enter Second Number:");
        int num2 = sc.nextInt();
        sc.close();
        
        int minimum = num1 < num2 ? num1 : num2;
        System.out.println("The minimum number is: " + minimum);
	}

}
>>>>>>> 70ec7955e736c9c2ea644fea4703f6f75b046dac
