
public class Q15 implements Q15Interface{

	public static void main(String[] args) {
		//Need to create a main object to run non-static methods.  
		//Methods cannot be static because they are inherited from an interface,
		//which cannot define static abstract methods
		Q15 calculator = new Q15();
		System.out.println(calculator.addition(5.6, 7));
		System.out.println(calculator.division(9, 6));
		
	}

	@Override
	public double addition(double a, double b) {
		return a+b;
	}

	@Override
	public double subtraction(double a, double b) {
		return a-b;
	}

	@Override
	public double multiplication(double a, double b) {
		return a*b;
	}

	@Override
	public double division(double a, double b) {
		if(b != 0) {
			return a/b;
		}else {
			//Instead of diving by 0, just return 0 which cannot be achieved for any values of a and b
			//therefore the method that calls this can check for this return
			return 0;
		}
	}

}
