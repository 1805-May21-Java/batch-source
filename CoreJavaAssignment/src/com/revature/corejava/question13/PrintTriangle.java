package com.revature.corejava.question13;

public class PrintTriangle {
	
	// Variable to store the number of rows that the user wishes to have printed out
	private int rows;

	// Constructor that calls the super class
	public PrintTriangle() {
		super();
	}
	
	// Constructor that calls the super class and initializes private variable rows to the local variable rows 
	public PrintTriangle(int rows) {
		super();
		this.rows=rows;
	}
	
	// Setter to set the value of private variable rows to the local variable rows
	public void setRows(int rows) {
		this.rows=rows;
	}
	
	// Getters to return the value of private variable rows
	public int getRows() {
		return rows;
	}
	
	/*
	 * Method to print a triangle of 1's and 0's
	 * 
	 * Initializes count variable to 0 and printer variable to ""
	 * 
	 * A while loop is created that will continue to loop until count equals rows
	 * 
	 * Ternary operator adds a 0 to the front of the printer variable if the count is divisible by 2 and 1 if not
	 * 
	 * The printer is then printed
	 * 
	 * Count is then iterated
	 * 
	 */
	public void printTriangle() {
		int count=0;
		String printer="";
		while(count<rows) {
			
			printer=(count%2==0)?"0"+printer:"1"+printer;
			
			System.out.println(printer);
			count++;
		}
	}

	
}
