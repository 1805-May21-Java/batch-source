package com.revature.Q12;

import java.util.*;

public class Q7Driver {
	public static <employees> void main(String[] args) {
		LinkedList<Q7> employees = new LinkedList<Q7>();
		employees.add(new Q7("Oliver", 38, "Utilities"));
		employees.add(new Q7("James",24,"IT"));
		employees.add(new Q7("Celi", 26,"Accounting"));
		employees.add(new Q7("Kevin", 29,"HR"));
		Collections.sort(employees, new Q7CompareAge());
		for(Q7 i:employees) {
			System.out.println(i);
		}
		System.out.println();
		
		Comparator<Q7> compareName = (Q7 o1, Q7 o2)-> o1.getName().compareTo(o2.getName()); 
		Collections.sort(employees, compareName);
		for(Q7 i:employees) {
			System.out.println(i);
		}
		System.out.println();
		
		Comparator<Q7> compareDept = (Q7 o1,Q7 o2)->o1.getDepartment().compareTo(o2.getDepartment());
		Collections.sort(employees, compareDept);
		for(Q7 i:employees) {
			System.out.println(i);
		}
	}
}
