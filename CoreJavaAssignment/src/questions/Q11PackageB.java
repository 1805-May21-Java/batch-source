package questions;

import question11.Q11PackageA;

//Solution imports Q11PackageA and then creates and instance of it.
//The get methods in Q11PackageA are then used to retrieve the two
//float variables and are then printed.
public class Q11PackageB {
	
	public static void main(String[] args) {
		Q11PackageA q11A = new Q11PackageA(5f, 30f);
		System.out.println("Retrieved float values from another package");
		System.out.println(q11A.getF1());
		System.out.println(q11A.getF2());
	}
}
