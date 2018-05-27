package com.revature.question7;

import java.util.Comparator;

class Sortbyname implements Comparator<Employee> {

	public Sortbyname() {
		// TODO Auto-generated constructor stub
	}

    // Used for sorting in ascending order of
    // roll name
    public int compare(Employee e1, Employee e2)
    {
        return e1.name.compareTo(e2.name);
    }


}
