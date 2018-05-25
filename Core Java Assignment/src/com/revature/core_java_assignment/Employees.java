package com.revature.core_java_assignment;

class Employees implements Comparable<Employees>
{
	//this is my employees class which I use to create the two employees to use in my driver
	String name;
	String department;
	Integer age;
	public Employees()
	{
		super();
	}
	
	public Employees(String name, String department, Integer age)
	{
		super();
		this.name = name;
		this.department = department;
		this.age = age;
	}
	
	public String getName()
	{
		return name;
	}
	public void setName(String name)
	{
		this.name = name;
	}
	public String getDepartment()
	{
		return department;
	}
	public void setDepartment(String department)
	{
		this.department = department;
	}
	public Integer getAge()
	{
		return age;
	}
	public void setAge(Integer age)
	{
		this.age = age;
	}

	@Override
	public String toString()
	{
		return "Employees [name=" + name + ", department=" + department + ", age=" + age + "]";
	}

	//this makes it so that they are sorted by age
	@Override
	public int compareTo(Employees e)
	{
		return this.getAge() - e.getAge();
	}
	
	
}