package com.revature.background;

import java.util.Comparator;

import com.revature.assignment.QuestionSeven;

public class CompareDepartment implements Comparator<QuestionSeven>{

	//compares the department names of the employees
	@Override
	public int compare(QuestionSeven emp1, QuestionSeven emp2) {
		
		return emp1.getDepartment().compareTo(emp2.getDepartment());
	}
}
