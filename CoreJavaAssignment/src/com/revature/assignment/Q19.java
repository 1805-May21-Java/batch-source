package com.revature.assignment;

import java.util.ArrayList;

public class Q19 {

	/*Q19. Create an ArrayList and insert integers 1 through 10. 
	Display the ArrayList. Add all the even numbers up and display the result. 
	Add all the odd numbers up and display the result. 
	Remove the prime numbers from the ArrayList and print out the remaining ArrayList.*/
	
	//Manipulated numbers inside this method and printed results to console
	public void numManipulate() {
	
		ArrayList<Integer> arr = new ArrayList<Integer>();
			for (int i = 1; i <=10; i++ ) {
				arr.add(i);
			}
			System.out.println("ArrayList: " + arr.toString());
			
			int evenSum = 0;
			for (int i = 1; i <= 9; i += 2) {
				evenSum += arr.get(i);
			} System.out.println("Even sum: " + evenSum);
			
			int oddSum = 0;
			for (int i = 0; i <= 9; i += 2) {
				oddSum += arr.get(i);
			} System.out.println("Odd sum: " + oddSum);
			
			
			for(int i=0; i<arr.size(); i++){
		        for (int j=2; j<i; j++){
		            if(i%j != 0){
		                arr.remove(i);
		            }
		        }
			}
			System.out.println("Prime numbers: " +arr.toString());
			
	}
	
		/*Driver Code
		Q19 q = new Q19();
		q.numManipulate();*/
	
}
