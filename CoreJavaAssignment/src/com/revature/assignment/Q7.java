package com.revature.assignment;

import java.util.Collections;
import java.util.LinkedList;

public class Q7 implements Comparable<Q7> {

	//Q7. Sort two employees based on their name, department, and age using the Comparator interface.
	
	
	//Made three Compare classes implementing Comparator (CompareAge, CompareDepartment, CompareName
	//I then call the Collections.sort method with those comparator classes and an enhanced for loop to run through the Collection to sort the employees
	//Driver code at bottom
	String name;
	String department;
	int age;
	
	@Override
	public String toString() {
		return name + ": Department = " + department + ", Age = " + age;
	}
	public Q7(String name, String department, int age) {
		super();
		this.name = name;
		this.department = department;
		this.age = age;
	}
	public Q7() {
		super();
		// TODO Auto-generated constructor stub
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDepartment() {
		return department;
	}
	public void setDepartment(String department) {
		this.department = department;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	@Override
	public int compareTo(Q7 o) {
		return this.getAge()-o.getAge();
	}
	
	/*Driver Code
			LinkedList<Q7> employees = new LinkedList<Q7>();
			employees.add(new Q7("Jack", "Sales", 29));
			employees.add(new Q7("Jill", "HR", 28));
			
			//Using CompareAge class with Comparator interface to sort by Age
			System.out.println("Using CompareAge class with Comparator interface to sort by Age:");
			Collections.sort(employees, new CompareAge());
			for(Q7 e : employees) {
			System.out.println(e);
			}
			System.out.println();
			
			//Using CompareDepartment with Comparator interface to sort by Age
			System.out.println("Using CompareDepartment with Comparator interface to sort by Department:");
			Collections.sort(employees, new CompareDepartment());
			for(Q7 e : employees) {
				System.out.println(e);
			}
			System.out.println();
			//Using CompareName with Comparator interface to sort by Age
			System.out.println("Using CompareName with Comparator interface to sort by Name:");
			Collections.sort(employees, new CompareName());
			for(Q7 e : employees) {
				System.out.println(e);
			}*/
	
}
