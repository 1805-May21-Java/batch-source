package com.revature.core_java_assignment;
import java.util.ArrayList;

public class Q19
{
	public static void main(String[] args)
	{	
		//declaring ints to store the sums of the odds and evens
		//creating the array list
		int evens = 0;
		int odds = 0;
		ArrayList<Integer> arrList = new ArrayList<Integer>();
		
		System.out.print("The elements of the array list are: ");
		
		//this for loop populates the array as well as sums up the odds and evens
		for(int i = 1; i <= 10; i++)
		{
			//I started i at one so I could just add whatever i was into the array list so less code was required
			//therefore to get the correct index position of the number, I had to subtract 1 from i
			arrList.add(i);
			System.out.print(arrList.get(i-1)+ " ");
			if(i%2 == 0)
			{
				evens += arrList.get(i-1);
			}
			else
			{
				odds += arrList.get(i-1);
			}
		}
		//this for loop removes the primes and displays the remaining elements
		System.out.println();
		System.out.print("The remaining elements of the array list after the primes have been removed: ");

		/*1 is not a prime, so as a special case I am just going to print it out right away
		 *2 is however so I am removing it as a special case
		 *3 is a prime number and the method I am using has me dividing each number between 4 and 10 by each prime
		 *between 2 and the sqrt(10) to determine to determine which others are primes in the rest of the set
		 *starting with 4
		 */
		arrList.remove(1);
		arrList.remove(1);
		System.out.print(arrList.get(0) + " ");
		
		//for this loop starting it at 1 skips the special case of number 1 
		for(int i = 1; i < arrList.size(); i++)
		{
			if (arrList.get(i)%2 != 0)
			{	
				if(arrList.get(i)%3 != 0)
				{
					arrList.remove(i);
				}
			}
			System.out.print(arrList.get(i)+" ");
		}
		System.out.println();
		System.out.println("Even total: "+evens);
		System.out.println("Odd total: "+odds);	
	}

}
