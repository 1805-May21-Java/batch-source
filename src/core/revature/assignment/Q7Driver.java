package core.revature.assignment;

import java.util.ArrayList;
import java.util.Collections;

public class Q7Driver {
	public static void main(String[] args) {
		ArrayList<Q7> ar = new ArrayList<Q7>(); //ArrayList of employees
		ar.add(new Q7("David", "Logistics", 38)); // change both of these employees
		ar.add(new Q7("Joseph", "Housekeeping", 28)); // to anything you want
		System.out.println("Unsorted employees:"); 
		for (int i = 0; i < ar.size(); i++)
			System.out.println(ar.get(i)); // no sort
		Collections.sort(ar, new SortByName());
		System.out.println("\nSorted employees by name (ascending):");
		for (int i = 0; i < ar.size(); i++)
			System.out.println(ar.get(i)); //sort by name
		Collections.sort(ar, new SortByDepartment());
		System.out.println("\nSorted employees by department (ascending):");
		for (int i = 0; i < ar.size(); i++)
			System.out.println(ar.get(i)); // sort by department
		Collections.sort(ar, new SortByAge());
		System.out.println("\nSorted employees by age (ascending):");
		for (int i = 0; i < ar.size(); i++)
			System.out.println(ar.get(i)); // sort by age
	}
}
