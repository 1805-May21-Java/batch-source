package com.revature.OOps;

public class Dog extends Animal {

	public Dog() {
		super();
		
	}

	public Dog(String color, int age, String name, int noOfLegs) {
		super(color, age, name, noOfLegs);
		
	}
  public void sleep() {
System.out.println("my dog is sleep since this morning ......");


}
// polymorphism concept
@Override
public void move() {
	System.out.println("Dog is moving ");

}
// polymorphism concept
@Override
public void eat() {
	System.out.println("Dog is eating bones ");
	
}
}