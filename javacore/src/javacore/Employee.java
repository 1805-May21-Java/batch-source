package javacore;

import java.util.Comparator;

public class Employee implements Comparator<Employee>{
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + age;
		result = prime * result + departmentID;
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
		Employee other = (Employee) obj;
		if (age != other.age)
			return false;
		if (departmentID != other.departmentID)
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
		return "Employee [name=" + name + ", departmentID=" + departmentID + ", age=" + age + "]";
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getDepartmentID() {
		return departmentID;
	}
	public void setDepartmentID(int departmentID) {
		this.departmentID = departmentID;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public Employee() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Employee(String name, int departmentID, int age) {
		super();
		this.name = name;
		this.departmentID = departmentID;
		this.age = age;
	}
	private String name;
	private int departmentID;
	private int age;
	@Override
	public int compare(Employee emp1, Employee emp2) {
		if (emp1.getDepartmentID() == emp2.getDepartmentID()) {
			return 0;
		} else {
			return(emp1.getDepartmentID()-emp2.getDepartmentID() > 0 ? 1 : -1);
		}
		
	}
	
}
