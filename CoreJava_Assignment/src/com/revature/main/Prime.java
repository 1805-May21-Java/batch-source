package com.revature.main;
 
/**
 *This class is created regarding Question to check prime number
 *In isTrue() method we determine that prime number cannot be 0 or 1.
 *Prime number can only divided by 1 and itself.
 *We go through from i=2 to the number/2 and check if the number has no reminder (mean divisible by i) 
 *
 */
public class Prime
{

	public Prime()
	{
		super();
	}
	
	public static boolean isTrue(int number)
	{
		if(number==0 || number==1)
			return false;
		for(int i=2; i<=number/2; i++)
		{
			if(number%i==0)
			{
				return false;
			}
		}
		return true;
	}

}
