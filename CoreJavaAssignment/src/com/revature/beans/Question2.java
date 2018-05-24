package com.revature.beans;

public class Question2
{
	public static void main(String[] args)
	{
		final int howMany = 25;
		int twoAgo = 0;
		int oneAgo = 1;
		System.out.println("#1: 0 \n#2: 1");
		
		for(int i = 2; i < howMany; i++)
		{
			int temp = oneAgo + twoAgo;
			twoAgo = oneAgo;
			oneAgo = temp;
			System.out.println("#" + (i + 1) + ": " + temp);
		}
	}
}
