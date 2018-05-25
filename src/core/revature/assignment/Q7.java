package core.revature.assignment;
//Q7. Sort two employees based on their name, department, and age using the Comparator interface.
import java.util.*;
public class Q7 { //because I named these wrong, pretend that Q7 is employee
	String name;
	String department;
	int age; // variables
	public Q7(String name, String department, int age) { //employee constructor
		this.name = name;
		this.department = department;
		this.age = age;
	}
	public String toString() { //toString function
		return this.name + " " + this.department + " " + this.age;
	}
}
/*
 * Three different classes now, all implement Comparator
 * Again, because I screwed up naming conventions
 * pretend that Q7 refers to Employee
 */
class SortByName implements Comparator<Q7> {
	//sort by name, ascending
	public int compare(Q7 a, Q7 b) {
		return a.name.compareTo(b.name);
	}
}
class SortByDepartment implements Comparator<Q7> {
	//sort by department, ascending
	public int compare(Q7 a, Q7 b) {
		return a.department.compareTo(b.department);
	}
}
class SortByAge implements Comparator<Q7> {
	//sort by age, ascending
	public int compare(Q7 a, Q7 b) {
		return a.age - b.age; //int variable is different than string here
	}
}
