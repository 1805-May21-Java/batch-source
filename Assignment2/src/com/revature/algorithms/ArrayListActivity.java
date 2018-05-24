package com.revature.algorithms;
import java.util.ArrayList;

public class ArrayListActivity {

	ArrayList<Integer> nums;
	
	public ArrayListActivity() {
		super();
		nums = new ArrayList<Integer>();
		for(int i = 0; i < 10; i++)
			nums.add(i + 1);
	}

	public ArrayList<Integer> getNums() {
		return nums;
	}

	public void setNums(ArrayList<Integer> nums) {
		this.nums = nums;
	}
	
	// iterates through nums and sums the even integers
	public int addEvens() {
		int sum = 0;
		for(int i = 0; i < nums.size(); i++) {
			if(nums.get(i) % 2 == 0)
				sum += nums.get(i);
		}
		return sum;
	}
	
	// iterates through nums and sums the odd integers
	public int addOdds() {
		int sum = 0;
		for(int i = 0; i < nums.size(); i++) {
			if(nums.get(i) % 2 == 1)
				sum += nums.get(i);
		}
		return sum;
	}
	
	// removes prime integers from nums
	public void removePrimes() {
		for(int i = 0; i < nums.size(); i++) {
			boolean prime = true;
			for(int j = 2; j <= Math.sqrt(nums.get(i)); j++) {
				if(nums.get(i) % j == 0)
					prime = false;
			}
			if(prime && nums.get(i) != 1)
				nums.remove(i--);
		}
	}
	
	// uses ArrayList.toString() for ease of implementation in main()
	public String toString() {
		return nums.toString();
	}
}