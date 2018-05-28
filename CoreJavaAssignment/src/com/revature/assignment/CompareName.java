package com.revature.assignment;

import java.util.Comparator;

public class CompareName implements Comparator<Q7> {

	@Override
	public int compare(Q7 e1, Q7 e2) {
		return e1.getName().compareTo(e2.getName());
	}

}
