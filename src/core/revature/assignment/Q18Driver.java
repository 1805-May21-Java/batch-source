package core.revature.assignment;

public class Q18Driver {
	public static void main(String[] args) {
		Q18sub test = new Q18sub();
		String x = "This is a string"; //change this to whatever
		System.out.println("Testing out Q18sub extends Q18Superclass: String used = " + x);
		System.out.println(test.hasUpper(x)); // testing all three main methods
		System.out.println(test.makeUpper(x));
		System.out.println(test.convert_to_int(x));
		//note for convert_to_int method, it does not accept alphabetical characters
	}
}
