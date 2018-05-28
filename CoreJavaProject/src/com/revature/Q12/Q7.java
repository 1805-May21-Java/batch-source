package com.revature.Q12;


public class Q7 implements Comparable<Q7>{
	String Name;
	int Age;
	String Department;
	public Q7() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Q7(String name, int age, String department) {
		super();
		Name = name;
		Age = age;
		Department = department;
	}
	public String getName() {
		return Name;
	}
	public void setName(String name) {
		Name = name;
	}
	public int getAge() {
		return Age;
	}
	public void setAge(int age) {
		Age = age;
	}
	public String getDepartment() {
		return Department;
	}
	public void setDepartment(String department) {
		Department = department;
	}
	@Override
	public String toString() {
		return "Q7 [Name=" + Name + ", Age=" + Age + ", Department=" + Department + "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + Age;
		result = prime * result + ((Department == null) ? 0 : Department.hashCode());
		result = prime * result + ((Name == null) ? 0 : Name.hashCode());
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
		Q7 other = (Q7) obj;
		if (Age != other.Age)
			return false;
		if (Department == null) {
			if (other.Department != null)
				return false;
		} else if (!Department.equals(other.Department))
			return false;
		if (Name == null) {
			if (other.Name != null)
				return false;
		} else if (!Name.equals(other.Name))
			return false;
		return true;
	}
	@Override
	public int compareTo(Q7 o) {
		// TODO Auto-generated method stub
		return this.getAge()-o.getAge();
	}
	
}
