package com.revature.a2;

import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

public class Q7SortEmployee {
	//comparing the 2 employee class
	public void sortEmployee() {
		
		//add the info into the linked list
		LinkedList<Q7Employee> employee = new LinkedList<Q7Employee> ();
		employee.add(new Q7Employee("John Doe", "19555 Olde Civerton Cr, Room 301", 23));
		employee.add(new Q7Employee("Bob Ross", "19543 Olde Civerton Cr, Room 101", 26));
		employee.add(new Q7Employee("Lisa Simpson", "19547 Olde Civerton Cr, Room 301", 26));
		employee.add(new Q7Employee("Bob Ross", "19543 Olde Civerton Cr, Room 201", 15));
		
		//sort them
		Collections.sort(employee);
		//print them
		for(Q7Employee q : employee) {
			System.out.println(q);
		}
		
	}

}
