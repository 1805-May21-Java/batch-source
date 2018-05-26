package com.revature.hw2;

import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;

import com.revature.hw2.Q7e;

public class Q7 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LinkedList<Q7e> employee = new LinkedList<Q7e>();
		employee.add(new Q7e("Dell","Engineering",40));
		employee.add(new Q7e("Jane","Management",35));
		
		Collections.sort(employee);
		for(Q7e x : employee) {
			System.out.println(x);
		}
	}
}