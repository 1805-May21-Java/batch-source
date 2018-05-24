package questions;

//Completed
import question11.Q11PackageA;

public class Q11PackageB {
	
	public static void main(String[] args) {
		Q11PackageA q11A = new Q11PackageA(5f, 30f);
		System.out.println("Retrieved float values from another package");
		System.out.println(q11A.getF1());
		System.out.println(q11A.getF2());
	}
}
