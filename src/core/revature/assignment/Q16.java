package core.revature.assignment;
//Q16. Write a program to display the number of characters for a string input.
//The string should be entered as a command line argument using (String [] args).
//for this example, the string is "There are five words here"
public class Q16 {
	public static void main(String[] args) { //this does not use Scanner, instead it uses the command line
		int count = 0; //count will count the characters
		for(String s: args) { //for loop to read it
			char[] ca = s.toCharArray(); //convert string to character array
			for(int i = 0; i < ca.length; i++ ) {
				//System.out.print(ca[i]);
				count++;
			}
		}
		//System.out.println();
		System.out.println(count);
	} //NOTE: I was able to get the spaces into this program
}     //      by including quotation marks in between the string
