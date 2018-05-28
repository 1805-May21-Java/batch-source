package com.revature.q7;

import java.util.ArrayList;
import java.util.Collections;

public class Driver {

	public static void main(String[] args) {

		ArrayList<Employee> employees = new ArrayList<Employee>();
		employees.add(new Employee("Steve", "IT", 34));
		employees.add(new Employee("Amy", "Marketing", 44));
		
		System.out.println("Employee List (no order):");
		
		for(int i = 0; i < employees.size(); i++) {
			System.out.println(employees.get(i));
		}
		
		Collections.sort(employees, new CompareAge());
		System.out.println("\nSorted by ascending Age:");
		for(int i = 0; i < employees.size(); i++) {
			System.out.println(employees.get(i));
		}
		
		Collections.sort(employees, new CompareName());
		System.out.println("\nSorted by Name:");
		for(int i = 0; i < employees.size(); i++) {
			System.out.println(employees.get(i));
		}
		
		Collections.sort(employees, new CompareDepartment());
		System.out.println("\nSorted by Department:");
		for(int i = 0; i < employees.size(); i++) {
			System.out.println(employees.get(i));
		}
	}


}
