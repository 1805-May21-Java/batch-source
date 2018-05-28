package com.revature.corejava.question7;

import java.util.Comparator;

public class CompareEmployeeDepartment implements Comparator<Employee>{

	
	/*
	 * Class to compare two Employee objects by their department variables
	 * Uses the String method compareTo to determine which should come first
	 * 
	 * If the number returned is negative, then it means that e1 comes first when ordered
	 * If the number returned is positive, then it means that e2 comes first when ordered
	 * If the number returned is 0, then their age is the same, and the one that was already first will remain first
	 * 
	 */
	@Override
	public int compare(Employee e1, Employee e2) {
		return e1.getDepartment().compareTo(e2.getDepartment());
	}

}
