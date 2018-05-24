package com.revature.question7;

import java.util.*;

public class EmployeeDriver
{
	public static void main(String[] args)
	{
		ArrayList<Employee> employees = new ArrayList<Employee>();
		employees.add(new Employee("Mary Jones", "Finance", 21));
		employees.add(new Employee("Adam Sandler", "Comedy", 51));
		
		System.out.println("Unsorted: " + employees);
		
		Collections.sort(employees, new Sortbydepartment());
		System.out.println("Sorted by department: " + employees);
		
		Collections.sort(employees, new Sortbyage());
		System.out.println("Sorted by age: " + employees);
		
		Collections.sort(employees, new Sortbyname());
		System.out.println("Sorted by name: " + employees);
	}

}
