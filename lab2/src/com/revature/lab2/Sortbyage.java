package com.revature.lab2;

import java.util.Comparator;

public class Sortbyage implements Comparator<Associate> {

	public Sortbyage() {
		// TODO Auto-generated constructor stub
		super();
	}

	@Override
	public int compare(Associate o1, Associate o2) {
		// TODO Auto-generated method stub
		return o1.getAge()-o2.getAge();
	}

}
