package com.revature.a2;

import java.util.Comparator;

public class Q7Employee implements Comparable<Q7Employee>{
	
	//basic info to compare with
	private String name;
	private String department;
	private int age;
	
	//super class constructors
	public Q7Employee() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	//field constructors
	public Q7Employee(String name, String department, int age) {
		super();
		this.name = name;
		this.department = department;
		this.age = age;
	}

	//getter and setter
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

	//hashcode and equals
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
		Q7Employee other = (Q7Employee) obj;
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

	//tostring
	@Override
	public String toString() {
		return "Q7Employee [name=" + name + ", department=" + department + ", age=" + age + "]";
	}

	@Override
	public int compareTo(Q7Employee e) {
		//compare them by name,department, then age
		if(this.getName() != e.getName()) {
			int a = this.getName().compareTo(e.getName());
			if(a < 0) {
				return -1;
			} else {
				return 1;
			}
			//if name are same, compare department
		} else if (this.getDepartment() != e.getDepartment()) {
			int b = this.getDepartment().compareTo(e.getDepartment());
			if(b < 0) {
				return -1;
			} else {
				return 1;
			}
			// if department and name are same, compare age
		} else if (this.getAge() != e.getAge()) {
			if (this.getAge() < e.getAge()) {
				return -1;
			} else {
				return 1;
			}
			//doen't matter the order when they have everything same
		} else {
			return 1;
		}
	}
}
