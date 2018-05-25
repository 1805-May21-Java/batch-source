package com.revature.lab2;

import java.util.Comparator;

public class Sortbyname implements Comparator<Associate>{

	public Sortbyname() {
		// TODO Auto-generated constructor stub
		super();
	}

	@Override
	public int compare(Associate arg0, Associate arg1) {
		// TODO Auto-generated method stub
        return arg0.getName().compareTo(arg1.getName());
	}

}
