package com.revature.beans;

public class Question13
{

	public static void main(String[] args)
	{
		for(int i = 0; i < 4; i++)
		{
			for(int j = i; j >= 0; j--)
			{
				System.out.print((j % 2) + " ");
			}
			System.out.println();
		}
	}

}
