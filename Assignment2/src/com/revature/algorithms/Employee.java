package com.revature.algorithms;

public class Employee implements Comparable {

	private String name;
	private String department;
	private int age;
	
	public Employee() {
		super();
	}

	public Employee(String name, String department, int age) {
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
	
	// overriding compareTo to allow Collections.sort() to automatically sort using this
	public int compareTo(Object obj) {
		if(obj == null)
			return 1;
		Employee e = (Employee) obj;
		int retVal = this.name.compareTo(e.getName());
		if(retVal != 0)
			return retVal;
		retVal = this.department.compareTo(e.getDepartment());
		if(retVal != 0)
			return retVal;
		if(this.age == e.getAge())
			retVal = 0;
		else
			retVal = (this.age < e.getAge()) ? -1 : 1;
		return retVal;
	}

	// prints a short message about the Employee
	@Override
	public String toString() {
		return (name + " is " + age + " years old and works in " + department);
	}
	
	
}
