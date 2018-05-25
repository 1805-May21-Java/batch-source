package com.revature.core_java_assignment;

import java.util.Scanner;

public class Q5
{

	public static void main(String[] args)
	{
		//added a scanner for a little interactivity
		String str;
		int idx;
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Please enter a phrase:");
		//getting our string to substring
		str = sc.nextLine();
		System.out.println("Please enter the index and which you want to start the substring:");
		//getting our starting index(inclusive)
		idx = Integer.parseInt(sc.nextLine());
		//displaying the resulting substring
		System.out.println("Here is your substring:");
		System.out.println(str.substring(idx));
	}

}
