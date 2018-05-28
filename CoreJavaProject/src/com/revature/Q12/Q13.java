package com.revature.Q12;

//Question 13: Program that displays a half triangle as 0's and 1's
public class Q13 {
	public static void main(String[] args) {
		int num = 0;
		//First for loop defines the rows
		for(int i = 0; i< 4; i++) {
			//Second for loop makes sure only a certain amount of numbers are printed per row
			for(int j=0; j<=i;j++) {
				//If the number is 0 it gets printed and incremented
				if(num == 0) {
					System.out.print(num);
					num++;
				}
				//If the number is 1 it gets printed and decremented 
				else if(num == 1) {
					System.out.print(num);
					num--;
				}
			}
			System.out.println();
		}
	}

}
