package com.revature.question7;

import java.util.Comparator;

class Sortbyage implements Comparator<Employee> {

	public Sortbyage() {
		// TODO Auto-generated constructor stub
		super();
	}
	
    // Used for sorting in ascending order of
    // roll number
    public int compare(Employee e1, Employee e2)
    {
    	return e1.age - e2.age;    
    }

}
