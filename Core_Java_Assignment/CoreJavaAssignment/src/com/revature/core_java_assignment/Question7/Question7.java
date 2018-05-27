package com.revature.core_java_assignment.Question7;

import java.util.ArrayList;
import java.util.Collections;

class Employee {
	private String name;
	private String department;
	private int age;
	
	public Employee() {
		super();
	}
	
	public Employee(String name, String department, int age) {
		super();
		this.name = name;
		this.department = department;
		this.age = age;
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
	public String toString() {
		return "Employee [name=" + name + ", department=" + department + ", age=" + age + "]";
	}
}

public class Question7 { // implement the Comparator interface to specify sorting by name, age, or deparment
	public static void main(String[] args) {
		ArrayList<Employee> employees = new ArrayList<>();
		employees.add(new Employee("Bob", "Marketing", 30));
		employees.add(new Employee("Alex", "Sales", 22));
		employees.add(new Employee("Missy", "Developer", 32));
		employees.add(new Employee("Hans", "Marketing", 40));

		System.out.println("Sort by name.");
		Collections.sort(employees, new CompareEmployeeByName());
		for(Employee e : employees)
			System.out.println(e);
		
		System.out.println();
		System.out.println("Sort by department.");
		Collections.sort(employees, new CompareEmployeeByDepartment());
		for(Employee e : employees)
			System.out.println(e);
		
		System.out.println();
		System.out.println("Sort by age.");
		Collections.sort(employees, new CompareEmployeeByAge());
		for(Employee e : employees)
			System.out.println(e);

	}

}
