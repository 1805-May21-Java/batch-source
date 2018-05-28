package com.revature.corejava;

import java.util.*;

public class EmployeeDriver
{

	public static void main(String[] args) 
	{
		//A list of employees is created
		ArrayList<Employee> employees = new ArrayList<Employee>();
		//I add 2 employees Joshua and John
		employees.add(new Employee("Joshua", "Home Improvement", 25));
		employees.add(new Employee("John", "Appliances", 19));
		//I sort the employees using my comparator
		EmployeeComparator comparator = new EmployeeComparator();
		Collections.sort(employees, comparator);
		//Then I print the sorted employees
		for(Employee e : employees)
		{
			System.out.println(e);
		}
		System.out.println();
	}

}
