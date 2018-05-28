package com.revature.corejava;

public class PyramidPrint 
{

	public static void main(String[] args) 
	{
	int num = 0;	
	boolean zero = true;
		for (int i = 0; i < 4; i++)
		{
			for (int j = 0; j < 4; j++)
			{
				if(i >= j)
				{
				System.out.print(num + " ");
				zero = !zero;
				num = (num == 0) ?  1 : 0;
				}
				else
				{
					zero = !zero;
					num = (num == 0) ?  1 : 0;
				}
			}
			num = (num == 0) ?  1 : 0;
			System.out.println();
		}
	}

}
