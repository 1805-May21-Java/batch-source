package com.revature.corejava.question7;

import java.util.ArrayList;
import java.util.Collections;

public class EmployeeDriver {

	public static void main(String[] args) {
		
		// Initializes a new ArrayList of Employee objects 
		ArrayList<Employee> employees=new ArrayList<Employee>();
		
		// Adds Employee objects to the array employees
		employees.add(new Employee("Dave", "Development", 27));
		employees.add(new Employee("Bob", "HR", 32));
		employees.add(new Employee("Sarah", "Cleaning", 22));
		
		// Sorts the employees ArrayList by using their name variables
		// Should be in the order Bob, Dave, Sarah
		System.out.println("Compare by Names");
		Collections.sort(employees, new CompareEmployeeName());
		System.out.println(employees);
		System.out.println();
		
		// Sorts the employees ArrayList by using their department variables
		// Should be in the order Sarah, Dave, Bob
		System.out.println("Compare by Department");
		Collections.sort(employees, new CompareEmployeeDepartment());
		System.out.println(employees);
		System.out.println();
		
		// Sorts the employees ArrayList by using their age variables
		// Should be in the order Bob, Dave, Sarah
		System.out.println("Compare by Age");
		Collections.sort(employees, new CompareEmployeeAge());
		System.out.println(employees);
		System.out.println();
		

	}

}
