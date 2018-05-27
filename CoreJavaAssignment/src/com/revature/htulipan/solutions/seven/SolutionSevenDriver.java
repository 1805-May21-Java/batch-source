package com.revature.htulipan.solutions.seven;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/*
 * Q7. Sort two employees based on their name, department, and age using the Comparator interface.
 */

public class SolutionSevenDriver {

	public static void main(String[] args) {
		Employee e1 = new Employee("Bob", "Quality Control", 33);
		Employee e2 = new Employee("Alice", "Sales", 29);
		
		ArrayList<Employee> employeeList = new ArrayList<>();
		employeeList.add(e1);
		employeeList.add(e2);
		
		Comparator<Employee> nameComparator = new Comparator<Employee>() {
			@Override
			public int compare(Employee e1, Employee e2) {
				return e1.getName().compareTo(e2.getName());
			}
		};
		
		Comparator<Employee> departmentComparator = new Comparator<Employee>() {
			@Override
			public int compare(Employee e1, Employee e2) {
				return e1.getDepartment().compareTo(e2.getDepartment());
			}
		};
		
		Comparator<Employee> ageComparator = new Comparator<Employee>() {
			@Override
			public int compare(Employee e1, Employee e2) {
				return Integer.compare(e1.getAge(), e2.getAge());
			}
		};
		
		System.out.println("Alice and Bob before sorting:");
		for (Employee e : employeeList) {
			System.out.println(e);
		}
		System.out.println();
		
		System.out.println("Alice and Bob after sort-by-name: ");
		Collections.sort(employeeList, nameComparator);
		for (Employee e : employeeList) {
			System.out.println(e);
		}
		System.out.println();
		
		System.out.println("Alice and Bob after sort-by-department: ");
		Collections.sort(employeeList,  departmentComparator);
		for (Employee e : employeeList) {
			System.out.println(e);
		}
		System.out.println();
		
		System.out.println("Alice and Bob after sort-by-age: ");
		Collections.sort(employeeList, ageComparator);
		for (Employee e : employeeList) {
			System.out.println(e);
		}
		System.out.println();
		
		
		
		
		
	}

}
