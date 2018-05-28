package com.revature.Q12;

import java.util.Comparator;

public class Q7CompareAge implements Comparator<Q7> {

	@Override
	public int compare(Q7 o1, Q7 o2) {
		if(o1.getAge() == o2.getAge()) {
			return 0;
		}
		else {
			return (o1.getAge()-o2.getAge()>0)? 1:-1;
		}
	}

}
