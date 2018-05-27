package com.revature.main;

import java.util.Comparator;

/**
 * This is the compareAge class where we implements compare() method to sort by age
 * The compare() method takes two object inputs 
 * we return 0 1, or -1. If the age of the object1 is greater than the age of the object 2, it will return 1, or -1
 * It will return 0 if the age of both objects have the same values.
 */
public class CompareAge implements Comparator<Employee>

{

	
	@Override
	public int compare(Employee o1, Employee o2)
	{
		if(o1.getAge()==o2.getAge())
		{
			return 0;
		}
		return (o1.getAge()-o2.getAge()>0)?1:-1;
	}

}
