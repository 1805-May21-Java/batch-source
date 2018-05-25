package com.revature.qNineteen;

import java.util.ArrayList;

public class NineteenDriver
{
	public static void main(String[] args)
	{
		QuestionNineteen qn = new QuestionNineteen();
		ArrayList<Integer> values = new ArrayList<Integer>();
		for(int i = 1; i <= 10; i++)
		{
			values.add(i);
		}
				
		qn.printTotals(values);
		qn.removePrimes(values);
	}
}
