package com.revature.a2;

public class Q13TriangleDisplay {

	//loops isn't avaliable thus we use recursion
	public void triangleDisplay(int a) {
		printNum(a);
	}
	private int b = 0;
	
	//take in the height of the triangle it wants to create
	public void printNum(int a) {
		//starts with 0 and keeps building up until it reachs its height
		if(b % 2 == 0) {
			printNum0(b);
		} else {
			printNum1(b);
		}
		if(b < a) {
			System.out.println();
			b++;
			//keep going until it is up to height
			printNum(a);
		}
	}
	public void printNum0(int b) {
		System.out.print("0  ");
		if(b > 0) {
			//prints 0 then 1 then 0 again, use the 2 function to alternate until the line is done
			//using b-1 for every time a number prints out, set its max length to the start number
			printNum1(b-1);
		}
	}
	public void printNum1(int b) {
		System.out.print("1  ");
		if(b > 0) {
			printNum0(b-1);
		}
	}
	
}
