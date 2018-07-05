package com.revature.exceptions;

public class StoreOutOfStockException extends Exception{
	
	String message = "Out of stock";
	
	public StoreOutOfStockException() {
		super();
	}

	public StoreOutOfStockException(String message) {
		super(message);
	}
	
	

}
