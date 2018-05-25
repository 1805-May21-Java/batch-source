package com.revature.a2;

public class Q6OddOrEven {
	private int tempNum; //tempNum to do the subtraction
	public void oddOrEven(int num) {
		tempNum = num;
		while (tempNum > 0 && (tempNum != 1 || tempNum != 0)) {
			//keep subtracting until the number hits negative, if tempNum ever equals to 1 or 2, we can
			//tell if the number entered is odd or even
			if(tempNum == 1) {
				System.out.println("The number: " + num + " is Odd!");
			}
			else if (tempNum == 2) {
				System.out.println("The number: " + num + " is Even!");
			}
			tempNum -= 2;
		}
		System.out.println();
	}
}
