package com.revature.question7;

// Java program to demonstrate working of Comparator
// interface
import java.util.*;
import java.lang.*;
import java.io.*;

public class Question7Driver {

	public Question7Driver() {
		// TODO Auto-generated constructor stub
		super();
	}


	

	    public static void main (String[] args)
	    {
	        ArrayList<Employee> e = new ArrayList<Employee>();
	        e.add(new Employee(20, "Matt Kassel", "development"));
	        e.add(new Employee(60, "Jane Doe", "marketing"));
	        e.add(new Employee(30, "John Doe", "sales"));
	        e.add(new Employee(35, "Doe","engineer"));
	        
	        System.out.println("Unsorted");
	        for (int i=0; i<e.size(); i++)
	            System.out.println(e.get(i));
	 
	        Collections.sort(e, new Sortbydept());
	 
	        System.out.println("\nSorted by dept");
	        for (int i=0; i<e.size(); i++)
	            System.out.println(e.get(i));
	 
	        Collections.sort(e, new Sortbyname());
	 
	        System.out.println("\nSorted by name");
	        for (int i=0; i<e.size(); i++)
	            System.out.println(e.get(i));
	        
	        Collections.sort(e, new Sortbyage());
	        
	        System.out.println("\nSorted by age");
	        for (int i=0; i<e.size(); i++)
	            System.out.println(e.get(i));
	    
	    }
	}
	

