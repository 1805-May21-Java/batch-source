package questions;

//Q13Triangle containst method printTriangle(int rows), which will
//print a string of 0's and 1's that form a triangle.
//The user can put in how many rows they would like their triangle to form.
public class Q13TriangleLoop {
	
	public void printTriangle(int rows) {
		//String line will be used to concatenate string
		//with 1's and 0's
		//StringBuilder triangle will concatenate line with a newline character
		//to form a triangle
		String line = "";
		StringBuilder triangle = new StringBuilder();
		for(int i = 0; i < rows; i++) {
			//if else checks if row is odd or even, which
			//will concatenate either a 0 or 1.
			if(i % 2 == 0) {
				line = "0" + line;
				triangle.append(line + "\n");
			}else {
				line = '1' + line;
				triangle.append(line + "\n");
			}
		}
		//One print statement is used to print the String triangle
		System.out.println(triangle.toString());
	}
}
