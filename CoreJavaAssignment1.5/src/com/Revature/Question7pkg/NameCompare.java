package com.Revature.Question7pkg;

import java.util.Comparator;

public class NameCompare implements Comparator<Employee>{
	//Compares employees alphabetically
	@Override
	public int compare(Employee e1 , Employee e2 ) {
		return e1.getName().compareTo(e2.getName());
	}
}
