package com.revature.homework;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Q7{

	String name; // assign attributes
	String age;
	String department;

	public Q7(String name, String age, String department) { // constructor
		super();
		this.name = name;
		this.age = age;
		this.department = department;

	}
	
@Override
	public String toString() {
		return "Employee [name=" + name + ", age=" + age + ", department=" + department + "]";
	}

	// implementing comparator 
	static class CompareName implements Comparator<Q7> {

		@Override
		public int compare(Q7 o1, Q7 o2) {
			// TODO Auto-generated method stub
			return o1.name.compareTo(o2.name);
		}
	}

	public static class department implements Comparator<Q7> {

		@Override
		public int compare(Q7 o1, Q7 o2) {
			// TODO Auto-generated method stub
			return o1.department.compareTo(o2.department);
		}

	}

	public static class Compareage implements Comparator<Q7> {

		@Override
		public int compare(Q7 o1, Q7 o2) {
			// TODO Auto-generated method stub
			return o1.age.compareTo(o2.age);
		}
	}

	public static void main(String[] args) {
		ArrayList<Q7> em = new ArrayList<Q7>();
		em.add(new Q7("lilly","IT","26"));
		em.add(new Q7("lynda","Account","34"));
		//em.add(new Employee("john","HR","56"));
	Collections.sort(em, new Compareage());
	System.out.println("Sort by age: ");
	System.out.println(em.get(0));
	System.out.println(em.get(1));
	System.out.println();
	Collections.sort(em,  new department());
	System.out.println("Sort by department: ");
	System.out.println(em.get(0));
	System.out.println(em.get(1));
	System.out.println();
	Collections.sort(em, new CompareName());
	System.out.println("Sort by name");
	System.out.println(em.get(0));
	System.out.println(em.get(1));
	System.out.println();
	
	}

	

}
