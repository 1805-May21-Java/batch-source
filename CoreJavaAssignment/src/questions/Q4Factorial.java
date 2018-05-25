package questions;

//Program has method factorial(double n) which will return the
//result of n factorial.
public class Q4Factorial {
	
	//method has been done recursively.
	public double factorial(double n) {
		//base case which will return n.
		if(n <= 1) {
			return n;
		}else {
			//method continues calling itself until reaching base case.
			return factorial(n - 1) * n;
		}
		
	}

}
