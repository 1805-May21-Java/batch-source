package core.revature.assignment;

public interface Q15Interface { //calculator operations
	int add(int a, int b);
	int subtract(int a, int b);
	int multiply(int a, int b);
	int divide(int a, int b);
	//all the stuff below didn't really fit into this particular class, I put them in the other one.
	/*class MOps { //math operators class
		public static Q15Interface ADD = new Q15Interface() {
			@Override
			public double operate(double a, double b) {
				return a + b;
			}
		};
		public static Q15Interface SUBTRACT = new Q15Interface() {
			@Override
			public double operate(double a, double b) {
				return a - b;
			}
		};
		public static Q15Interface MULTIPLY = new Q15Interface() {
			@Override
			public double operate(double a, double b) {
				return a * b;
			}
		};
		public static Q15Interface DIVIDE = new Q15Interface() {
			@Override
			public double operate(double a, double b) {
				while(b == 0) {
					System.out.println("ERR: DIVIDE BY ZERO");
				}
				return a / b;
			}
		};*/
}
