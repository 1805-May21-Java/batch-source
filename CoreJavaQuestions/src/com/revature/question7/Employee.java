package com.revature.question7;

public class Employee {

	public Employee() {
		// TODO Auto-generated constructor stub
	}
	

	    int age;
	    String name, department;
	 
	    // Constructor
	    public Employee(int age, String name,
	                               String department)
	    {
	        this.age = age;
	        this.name = name;
	        this.department = department;
	    }
	 
	    // Used to print student details in main()
	    public String toString()
	    {
	        return this.name + " " + this.age +
	                           " " + this.department;
	    }
	

}
