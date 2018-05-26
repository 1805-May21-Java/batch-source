package com.revature.hw2;

import java.util.Comparator;

public class Q7e implements Comparable<Q7e>{
	private String name, department;
	private int age;
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
		Q7e other = (Q7e) obj;
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
		return "Q7e [name=" + name + ", department=" + department + ", age=" + age + "]";
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
	public Q7e(String name, String department, int age) {
		super();
		this.name = name;
		this.department = department;
		this.age = age;
	}
	public Q7e() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public int compareTo(Q7e o) {
		if(this.getName() == o.getName()) {
			if(this.getDepartment() == o.getDepartment()) {
				if(this.getAge() == o.getAge()) {
					return 0;
					}
				else {
					return (this.getAge() - o.getAge() > 0 ? 1 : -1);
					}
				}
			else {
				return (this.getDepartment().compareTo(o.getDepartment()));
				}
			}
		else {
			return (this.getName().compareTo(o.getName()));
			}
	}
}