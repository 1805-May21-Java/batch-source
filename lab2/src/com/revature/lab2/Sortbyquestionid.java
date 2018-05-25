package com.revature.lab2;

import java.util.Comparator;

public class Sortbyquestionid implements Comparator<Question> {

	public Sortbyquestionid() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public int compare(Question o1, Question o2) {
		// TODO Auto-generated method stub
		return o1.getQID()-o2.getQID();
	
	}

}
