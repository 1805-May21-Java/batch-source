package com.revature.q07;

import java.util.Arrays;

public class EmployeeDriver {
	public static void main(String[] args) {
		Employee[] employees = {
				new Employee("Shawn", "HR", 30),
				new Employee("Angela", "Marketing", 40)
		};
		
		
		
		System.out.println("Sorted by name:");
		/*
		 * The sort method is only available for use because I implemented Comparator into a couple
		 * of comparison classes
		 */
		Arrays.sort(employees, new CompareEmployeeName());
		for(Employee e: employees) {
			System.out.println(e.toString());
		}
		System.out.println();
		
		System.out.println("Sorted by department:");
		Arrays.sort(employees, new CompareEmployeeDepartment());
		for(Employee e: employees) {
			System.out.println(e.toString());
		}
		System.out.println();
		
		System.out.println("Sorted by age:");
		Arrays.sort(employees, new CompareEmployeeAge());
		for(Employee e: employees) {
			System.out.println(e.toString());
		}
		System.out.println();
	}
	
	
}
