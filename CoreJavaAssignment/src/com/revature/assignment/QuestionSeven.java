package com.revature.assignment;

import java.util.Collections;
import java.util.LinkedList;

import com.revature.background.CompareAge;
import com.revature.background.CompareDepartment;

public class QuestionSeven implements Comparable<QuestionSeven>{
	
	private String name;
	private String department;
	private int age;
	
	public QuestionSeven() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public QuestionSeven(String name, String department, int age) {
		super();
		this.name = name;
		this.department = department;
		this.age = age;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + age;
		result = prime * result + ((department == null) ? 0 : department.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		QuestionSeven other = (QuestionSeven) obj;
		if (age != other.age)
			return false;
		if (department == null) {
			if (other.department != null)
				return false;
		} else if (!department.equals(other.department))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "QuestionSeven [name=" + name + ", department=" + department + ", age=" + age + "]";
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
	public int compareTo(QuestionSeven o) {
		// TODO Auto-generated method stub
		return this.getName().compareTo(o.getName());
	}
	
	public static void main(String[] args) {
		
		//creates a list to be further manipulated
		LinkedList<QuestionSeven> emp = new LinkedList<QuestionSeven>();
		emp.add(new QuestionSeven("Jill", "Marketing", 42));
		emp.add(new QuestionSeven("Bill", "Sales", 35));
		emp.add(new QuestionSeven("Phil", "Operations", 24));

		//sorts by employee name by using the original sort funtion
		System.out.println("Employees sorted by name:");
		Collections.sort(emp);
		for(QuestionSeven e:emp) {
			System.out.println(e);
		}
		System.out.println();
		
		//sorts by department by looking to a CompareDepartment class in the background package
		System.out.println("Employees sorted by department:");
		Collections.sort(emp, new CompareDepartment());
		for(QuestionSeven e:emp) {
			System.out.println(e);
		}
		System.out.println();
		
		//sorts by department by looking to a CompareAge class in the background package
		System.out.println("Employees sorted by age:");
		Collections.sort(emp, new CompareAge());
		for(QuestionSeven e:emp) {
			System.out.println(e);
		}
	}
}
