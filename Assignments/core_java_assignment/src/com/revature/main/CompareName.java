package com.revature.main;

import java.util.Comparator;
/**
 * This is the compareName class where we implements compare() method to sort by Name
 * The compare() method takes two object inputs 
 *
 */

public class CompareName implements Comparator<Employee>
{



	@Override
	public int compare(Employee o1, Employee o2)
	{
		
		return (o1.getName().compareTo(o2.getName()));
	}

}
