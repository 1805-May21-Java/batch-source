package com.revature.beans;

import com.revature.abstraction.Animal;

public class Driver {

	public static void main(String[] args) {
		Animal[] animals = {new Dog(), new Cat(), new Crow(true), new Chicken(true)}; // covariant types is an example of polymorphism
		
		for(Animal animal : animals) {
			animal.speak();
		}
				
		System.out.println();
	
		for(Animal animal : animals) {
			animal.feedYoung();
		}
	}
}
