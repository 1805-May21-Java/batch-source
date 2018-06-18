package com.revature.core_java_assignment;

import java.util.Scanner;

public class Q18Driver
{

	public static void main(String[] args)
	{
		Scanner sc = new Scanner(System.in);
		String str;
		Q18_SubClass sb = new Q18_SubClass();
		
		System.out.print("Enter a string to check for upper cases: ");
		str = sc.nextLine();
		System.out.println(sb.checkUpperCase(str));
		
		System.out.println("Enter a string to convert to upper case");
		str = sc.nextLine();
		System.out.println(sb.convertLowerToUpper(str));
		
		System.out.println("Enter an integer to add 10 to");
		str = sc.nextLine();
		System.out.println(sb.convertStringToIntPlusTen(str));
		
		

	}

}
