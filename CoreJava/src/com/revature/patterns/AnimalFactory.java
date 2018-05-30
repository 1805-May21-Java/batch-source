package com.revature.patterns;

public class AnimalFactory {
	
	public Animal getAnimal(String a) {
		 a = a.toLowerCase();
		if(a.equals("cat")) {
			return new Cat();
		} else if (a.equals("hippo")) {
			return new Hippopotamus();
		} else if (a.equals("albatross")) {
			return new Albatross();
		} else {
			return null;
		}
	}

}
