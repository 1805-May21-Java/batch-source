package questions;

/**
 * 
 * @author rod_elmariachi
 *Complete, just need to add comments
 */
public class Q4Factorial {
	private int result = 0;
	public int factorial(int n) {
		if(n <= 1) {
			return n;
		}else {
			return factorial(n - 1) * n;
		}
		
	}

}
