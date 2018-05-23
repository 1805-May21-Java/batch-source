package com.revature.exceptions;

/* This exception is thrown when an animal is assigned a negative number
 * of limbs, usually after the predatorAttack method is called.
 * (I know, I know, it's awful. It's what my sleep-deprived brain came up with)
 */

public class NegativeLegsException extends Exception {
	
	public NegativeLegsException() {
		super();
	}
	
	// pass along custom message
	public NegativeLegsException(String message) {
		super(message);
	}
}
