package com.adora.employee7;

import java.util.LinkedList;

public class EmployeeCompareDriver {

	public static void main(String[] args) {
		LinkedList<Employee> eList = new LinkedList<Employee>();
		
		eList.add(new Employee("Jane", 34, "HR"));
		eList.add(new Employee("Karen", 27, "IT"));
		eList.add(new Employee("Steve", 28, "Marketing"));
		eList.add(new Employee("John", 45, "Executive"));
		
		System.out.println(eList.toString());	
		eList.sort(new EmployeeNameComparator());
		System.out.println(eList.toString());
		eList.sort(new EmployeeAgeComparator());
		System.out.println(eList.toString());
		eList.sort(new EmployeeDepartmentComparator());
		System.out.println(eList.toString());
	
	}

}
