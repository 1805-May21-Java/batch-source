package com.revature.a2;

import java.util.ArrayList;

public class Q19ArrayList {

	ArrayList<Integer> arraylist = new ArrayList<Integer>();
	
	public void arrayList() {
		for (int i = 1; i < 11; i++) {
			//add 1 to 10 into the array list
			arraylist.add(i);
		}
		int evensum = 0, oddsum = 0;
		for (int i : arraylist) {
			//for every number in the arraylist, add them to odd/even sum based on whether thay can divided by 2
			if(i % 2 == 0) {
				evensum += i;
			}else {
				oddsum += i;
			}
		}
		System.out.println("The Evensum of this ArrayList is: " + evensum);
		System.out.println("The Oddsum of this ArrayList is: " + oddsum);
		
		int count;
		
		for(int i = 2; i < arraylist.size(); i++) {
			count = 0;
			//find prime by testing if the value form the arraylist divided by number less than him will 
			//get no reminders, if not, remove it.
			if(arraylist.get(i) > 2) {
				for(int j = 2; j < i; j++) {
					if(arraylist.get(i) % j == 0) {
						count++;
					}
					
				}
				if(count == 0) {
					arraylist.remove(i);
				}
			}
		}
		//remove 2 because it is special
		arraylist.remove(1);
		System.out.println(arraylist);
	}
	
}
