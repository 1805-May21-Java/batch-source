package com.revature.core_java_assignment;

public class Q9
{

	public static void main(String[] args)
	{
		//1 is not considered a prime so I started the loop at 2
		//to find the primes between 1 and 100 I took the primes between 1 and sqrt(100), which are 2 ,3 ,5 7
		//if a number returned a non 0 number when divided by these primes then it too is prime
		//note that this method is not practical when the numbers get big
		for(int i = 2; i <= 100; i++)
		{
			int num = i;
			
			//handling my special cases since every to check if a number is prime it needs to be divided by each of those
			//4 numbers. besides the fact I know they are prime
			if(i == 2 || i == 3 || i == 5 || i ==7)
			{
				System.out.println(i + "is a prime number");
			}
			else
			{
				//nested if statements makes sure the number in question returns non 0 values for all 4 primes
				if(num%2 != 0)
				{
					if(num%3 != 0)
					{
						if(num%5 != 0)
						{
							if(num%7 != 0)
							{
								System.out.println(i + " is a prime number");
							}
						}
					}
				}
			}
			
		}
	}

}
