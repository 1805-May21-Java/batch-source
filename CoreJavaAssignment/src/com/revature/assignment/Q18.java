package com.revature.assignment;

public class Q18 extends Q18SuperClass {
	
	/*Q18. Write a program having a concrete subclass that inherits three abstract methods from a superclass.  Provide the following three implementations in the  subclass corresponding to the abstract methods in the superclass:
	 
	1. Check for uppercase characters in a string, and return ‘true’ or ‘false’ depending if any are found.
	2. Convert all of the lower case characters to uppercase in the input string, and return the result.
	3. Convert the input string to integer and add 10, output the result to the console.

	Create an appropriate class having a main method to test the above setup.*/

	//Q18SuperClass is the superclass with three abstract methods that are implemented below
	@Override
	public boolean upperChecker(String string) {
		for (int i = 0; i < string.length(); i++){
		    char c = string.charAt(i);        
		    if (Character.isUpperCase(c)) {
		    	System.out.println("Yes, there are uppercase letters!");
		    	return true;
		    } else {System.out.println("No uppercase letters!"); 
		    return false; 
		    }
		}
		return true;
	}

	@Override
	public void changeToUpper(String string) {
		System.out.println(string.toUpperCase());	
	}

	@Override
	public void convertToInt(String string) {
		try {int num = Integer.parseInt(string);
			int newNum = num +10;
			System.out.println("Plus ten? That's " + newNum);}
			catch (NumberFormatException e) {
				System.out.println("You need to pass a number as your string");
			}
		
	}

	/*Driver Code
	Q18 q = new Q18();
	q.changeToUpper("RevaTUre");
	q.convertToInt("11");
	q.upperChecker("question");*/
	
	
	

}
