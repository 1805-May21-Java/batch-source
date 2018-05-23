package com.revature.expections;


/**
 * @author vannarahouth
 * We create a custom exception to throw a flag on Negative age for the animal. 
 * We inherited Exception class. 
 */
public class NegativeAgeException extends Exception {

	private static final long serialVersionUID = 1L;

	public NegativeAgeException(String message) {
        super(message);
    }

}
