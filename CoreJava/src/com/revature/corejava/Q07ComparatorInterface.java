package com.revature.corejava;

import java.util.ArrayList;
import java.util.Collections;

public class Q07ComparatorInterface {

	public static void main(String[] args) {
		
		// create 2 new employees to compare
		ArrayList<Employee> employees = new ArrayList<Employee>();
		Employee mw = new Employee("Mary Watson", "Finance", 35);
		Employee js = new Employee("John Smith", "Human Resources", 29);
		employees.add(mw);
		employees.add(js);
		
		System.out.println("Sorted by name:");
		Collections.sort(employees, new CompareName()); // sort by name
		System.out.println(employees);
		
		System.out.println("Sorted by department:");
		Collections.sort(employees, new CompareDepartment());
		System.out.println(employees);
		
		System.out.println("Sorted by age:");
		Collections.sort(employees, new CompareAge());
		System.out.println(employees);
	}

}
