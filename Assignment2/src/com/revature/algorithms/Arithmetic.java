package com.revature.algorithms;

// this interface assumes implementing classes have doubles a and b as parameters
public interface Arithmetic {
	
	// returns a + b
	double add();
	
	// returns a - b
	double sub();
	
	// returns a * b
	double mult();
	
	// returns a / b (b must be nonzero!)
	double div();
}
