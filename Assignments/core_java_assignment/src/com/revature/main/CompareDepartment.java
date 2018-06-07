package com.revature.main;

import java.util.Comparator;
/**
 * This is the compareDepartment class where we implements compare() method to sort by Department
 * The compare() method takes two object inputs 
 *
 */
public class CompareDepartment implements Comparator<Employee>
{

	@Override
	public int compare(Employee o1, Employee o2)
	{
		return o1.getDepartment().compareTo(o2.getDepartment());
	}



}
