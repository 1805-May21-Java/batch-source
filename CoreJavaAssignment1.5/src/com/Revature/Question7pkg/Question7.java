package com.Revature.Question7pkg;

import java.util.Collection;
import java.util.LinkedList;

public class Question7 {

	public static <T> void print(Collection<T> list) { //Generic print method
		for (T t : list) {
			System.out.println(t);
		}
		
		System.out.println();
	}

	public static void main(String args[]) {
		LinkedList<Employee> list = new LinkedList<Employee>();

		//Initialize list of employees
		list.add(new Employee("Thomas", "IT", 22));
		list.add(new Employee("Paul", "Cooking", 40));
		list.add(new Employee("Oliver", "Devops", 14));
		
		list.sort(new AgeCompare()); //Sort by age
		
		print(list);
		
		list.sort(new NameCompare()); //Sort by name
		
		print(list);
		
		list.sort(new DepartmentCompare()); //Sort by Department
		
		print(list);
	}
}
