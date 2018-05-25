package core.revature.assignment;
//Q18 Write a program having a concrete subclass that inherits three abstract methods from a superclass.
//Provide the following three implementations in the  subclass corresponding to the abstract methods in the superclass:
//1. Check for uppercase characters in a string, and return ‘true’ or ‘false’ depending if any are found.
//2. Convert all of the lower case characters to uppercase in the input string, and return the result.
//3. Convert the input string to integer and add 10, output the result to the console.
//Create an appropriate class having a main method to test the above setup.
//this will use a separate main driver class
public class Q18sub extends Q18Superclass{ //this is the implementation class
//auto-generated override methods
	@Override
	public boolean hasUpper(String str) {
		boolean uppercase = false;
		for (int i = 0; i < str.length(); i++) {
			if(Character.isUpperCase(str.charAt(i))) { //using isUpperCase and charAt methods for getting the uppercase.
				uppercase = true; // the loop will check
			}
		}
		return uppercase;
	}

	@Override
	public String makeUpper(String str) { //method to make all lower case to upper case
		String caps = ""; //empty string here
		for (int i = 0; i < str.length(); i++) {
			caps += Character.toUpperCase(str.charAt(i)); //using toUpperCase method
		}
		return caps;
	}

	@Override
	public int convert_to_int(String str) {
		int x;
		try {
			x = Integer.parseInt(str); //parseInt method used for converting String to int.
		} catch (NumberFormatException e) {
			System.out.println("ERR: CANNOT CONVERT STRING TO INTEGER");
			return 0; 
		}
		return x + 10; //finally to add 10 to the converted string
	}

}
