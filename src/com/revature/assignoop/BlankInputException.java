package com.revature.assignoop;

//Defines custom exception.
public class BlankInputException extends Exception {

    //Default constructor.
    public BlankInputException(){
        super();
    }

    //Params constructor.
    public BlankInputException(String message) {
        super(message);
    }
}
