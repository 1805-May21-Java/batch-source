package javacore;

public class Operations implements OperationsInterface {

	@Override
	public int add(int x, int y) {
		return x + y;
	}

	@Override
	public int subtract(int x, int y) {
		return x - y;
	}

	@Override
	public int divide(int x, int y) {
		if(y == 0) {
			throw new IllegalArgumentException("Can't divide by zero");
		}
		return x/y;
	}

	@Override
	public int multiply(int x, int y) {
		return x * y;
	}

	public static void main(String[] args) {
		Operations op = new Operations();
		
		System.out.println(op.add(3, 2));
		System.out.println(op.divide(50,5));
	}

}
