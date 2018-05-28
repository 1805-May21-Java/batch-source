package com.revature.corejava.question1;

public class BubbleSort {
	
	//Variable to hold the array of numbers
	private int[] numbers;
	
	//Constructor to instantiate a BubbleSort Object
	public BubbleSort() {
		super();
	}
	
	//Runs the private BubbleSort method sort to sort the numbers
	public BubbleSort(int[] numbers) {
		super();
		this.numbers=sort(numbers);
	}
	
	//Getter to return the sorted numbers to the user
	public int[] getNumbers() {
		return numbers;
	}
	
	//Setter to set new new numbers which are then sorted
	public void setNumbers(int[] numbers) {
		this.numbers=sort(numbers);
	}
	
	//private method to sort the numbers using Bubble Sort
	private int[] sort(int[] numbers) {
		//Variables to be used
		//hold too act as a temporary variable to hold a number that needs to be switched
		//allGood assumes that the array is sorted, to tell the method that it can stop
		int hold;
		boolean allGood=true;
		
		
		/*Loop to go through each number in the array and check it with the next number in the array.
		 * 
		 * If the current number needs to be switched, the array value at the current index is 
		 * placed into the hold variable, and then the current index value is set to
		 * the next index value, and the next index value is set to the value in hold.
		 * 
		 * The allGood variable is set to false.
		 */
		int count=0;
		while(count<numbers.length-1) {
			if(numbers[count]>numbers[count+1]) {
				
				allGood=false;
				hold=numbers[count];
				numbers[count]=numbers[count+1];
				numbers[count+1]=hold;
			}
			count++;
		}
		
		/* If the allGood variable is false, the method recursively runs again until it is true.
		 * Once true, the method returns the array. 
		 */
		if(allGood==false)
			sort(numbers);
		return numbers;
	}
}
