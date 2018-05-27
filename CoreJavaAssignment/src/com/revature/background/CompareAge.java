package com.revature.background;

import java.util.Comparator;

import com.revature.assignment.QuestionSeven;

public class CompareAge implements Comparator<QuestionSeven>{

	//compares the two ages
	@Override
	public int compare(QuestionSeven emp1, QuestionSeven emp2) {
		
		return emp1.getAge()-(emp2.getAge());
	}
	
}
