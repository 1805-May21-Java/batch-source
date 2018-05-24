package com.revature.animalkingdom;

public class AnimalDriver 
{

	public static void main(String[] args) 
	{
		//The movement types that were used in this assignment were walk, swim, and fly
		Fish fish = new Fish("blue");
		System.out.println("The color of the fish is " + fish.getColor());

		
		Dog dog = new Dog("brown", "walk", 4);
		System.out.println(dog.getNumOfLegs());

		Bird bird = new Bird("white","fly", 12);
		
		//I demonstrate polymorphism by hacing multiple constructors with different signatures.
		Bird bird2 = new Bird("Black");
		
		Cat cat = new Cat("calico");
		
		//I demonstrate Polymorphism using covarient types
		Animal animal = new Dog();
		
	}

}
