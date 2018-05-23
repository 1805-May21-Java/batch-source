/**
 * 
 */
package com.revature.main;

/**
 * @author vannarahouth
 * We create Animal interface that allows Dog to take on many forms.
 * In this case Dog is-a Animal and Dog is-a Mammal
 * This process is called Polymorphism
 *
 *
 *With this same interface we can also accomplish Abstraction.
 *In this case we do not have to define the methods makeNoise(), speed(), animalName()
 *The class(es) which will implement this interface will define the detail or the functionality. 
 *This process is call Abstraction
 */
public interface Animal {
	
	void makeNoise();
	int speed();
	String animalName();

}


