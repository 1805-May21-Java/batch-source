package core.revature.assignment;
/*
 * Q13. Display the triangle on the console as follows using any type of loop. 
 * Do NOT use a simple group of print statements to accomplish this.
    0
    1 0
    0 1 0
    1 0 1 0
 */
public class Q13 {
	public static void main(String[] args) {
//this is best done with two for loops
		for (int i = 0; i <= 4; i++) {
			for (int j = 0; j < i; j++) {
				System.out.print((i+j) % 2 == 0?"1 ":"0 "); //ternary operator, remember to use print instead of println
			} //Reversing the true/false part of this gives me a different result
			System.out.println();
		}
	}
}
