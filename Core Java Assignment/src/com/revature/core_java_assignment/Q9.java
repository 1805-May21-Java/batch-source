package com.revature.core_java_assignment;

public class Q9
{

	public static void main(String[] args)
	{
		for(int i = 2; i <= 100; i++)
		{
			int num = i;
			
			if(i == 2 || i == 3 || i == 5 || i ==7)
			{
				System.out.println(i + "is a prime number");
			}
			else
			{
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
