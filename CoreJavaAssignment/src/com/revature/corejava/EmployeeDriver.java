package com.revature.corejava;

import java.util.ArrayList;
import java.util.Collections;

public class EmployeeDriver {
	public static void main(String[] args) {
		ArrayList<Employee> employees = new ArrayList<>();
		employees.add(new Employee(35, "John Doe", "Finance"));
		employees.add(new Employee(26, "Bob Smith", "Marketing"));
		
		System.out.println("Unsorted: ");
		for(Employee e : employees) {
			System.out.println(e);
		}
		Collections.sort(employees, new SortByAge());
		System.out.println("Sorted by Age: ");
		for(Employee e : employees) {
			System.out.println(e);
		}
		Collections.sort(employees, new SortByDept());
		System.out.println("Sorted by Department: ");
		for(Employee e : employees) {
			System.out.println(e);
		}
		Collections.sort(employees, new SortByName());
		System.out.println("Sorted by Name: ");
		for(Employee e : employees) {
			System.out.println(e);
		}
	}
}
