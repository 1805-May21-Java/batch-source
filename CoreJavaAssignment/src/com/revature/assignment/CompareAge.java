package com.revature.assignment;

import java.util.Comparator;

public class CompareAge implements Comparator<Q7> {

	@Override
	public int compare(Q7 e1, Q7 e2) {
		
		if (e1.getAge() == e2.getAge()) {
			return 0;
		} else {
			return (e1.getAge() - e2.getAge() > 0 ? 1 : -1);
		}
	}

}
