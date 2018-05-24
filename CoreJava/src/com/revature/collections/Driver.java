package com.revature.collections;

import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.TreeSet;

public class Driver {

	public static void main(String[] args) {
		
		//LinkedHashSet has no duplicates and maintains order of insertion
		LinkedHashSet<Integer> hSet = new LinkedHashSet<Integer>();
		hSet.add(6);
		hSet.add(2);
		hSet.add(1);
		hSet.add(9);
		hSet.add(2);
//		System.out.println(hSet);
//		System.out.println();
		
		//TreeSet is naturally ordered, but will also contain no duplicates
		TreeSet<Integer> tSet = new TreeSet<Integer>();
		tSet.add(6);
		tSet.add(2);
		tSet.add(1);
		tSet.add(9);
		tSet.add(2);
//		System.out.println(tSet);
//		System.out.println();
		
		//TreeSet with data types which have a straightforward ordering
		//need not their ordering defined
		TreeSet<String> sSet = new TreeSet<String>();
		sSet.add("bravo");
		sSet.add("charlie");
		sSet.add("alpha");
//		System.out.println(sSet);
//		System.out.println();
		
		//create a collection with our chinese food in it
		//we've seen LinkedHashSet will be in order of insertion
		LinkedHashSet<ChineseFood> foodSet = new LinkedHashSet<ChineseFood>();
		foodSet.add(new ChineseFood(true,8000,4f,"Tso's Chicken"));
		foodSet.add(new ChineseFood(false,1000,1f,"Fortune Cookies"));
		foodSet.add(new ChineseFood(true,230,2f,"Egg Rolls"));
		foodSet.add(new ChineseFood(true,820,8f,"Fried Dumplings"));
		for(ChineseFood f : foodSet) {
//			System.out.println(f);
		}
		
		TreeSet<ChineseFood> foodTreeSet = new TreeSet<ChineseFood>();
		foodTreeSet.add(new ChineseFood(true,8000,4f,"Tso's Chicken"));
		foodTreeSet.add(new ChineseFood(false,1000,1f,"Fortune Cookies"));
		foodTreeSet.add(new ChineseFood(true,230,2f,"Egg Rolls"));
		foodTreeSet.add(new ChineseFood(true,820,8f,"Fried Dumplings"));
		for(ChineseFood f : foodTreeSet) {
//			System.out.println(f);
		}
		
		LinkedList<ChineseFood> foodList = new LinkedList<ChineseFood>();
		foodList.add(new ChineseFood(true,8000,4f,"Tso's Chicken"));
		foodList.add(new ChineseFood(false,1000,1f,"Fortune Cookies"));
		foodList.add(new ChineseFood(true,230,2f,"Egg Rolls"));
		foodList.add(new ChineseFood(true,820,8f,"Fried Dumplings"));
		System.out.println("Before using utility class's sort method:");
		for(ChineseFood f : foodList) {
			System.out.println(f);
		}
		System.out.println();
		
		System.out.println("After using utility class's sort method:");
		//before we print, we can use the Collections utility class's sort method to sort our food
		Collections.sort(foodList);
		for(ChineseFood f : foodList) {
			System.out.println(f);
		}
		System.out.println();
		
		System.out.println("After using utility class's sort method with ComparePrice:");
		Collections.sort(foodList, new ComparePrice());
		for(ChineseFood f : foodList) {
			System.out.println(f);
		}
		
	}

}
