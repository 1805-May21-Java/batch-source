package com.revature.question7;

import java.util.Comparator;

class Sortbydept implements Comparator<Employee> {

	public Sortbydept() {
		// TODO Auto-generated constructor stub
	}
	
    // Used for sorting in ascending order of
    // roll number
    public int compare(Employee e1, Employee e2)
    {
        return e1.department.compareTo(e2.department);
    }

}
