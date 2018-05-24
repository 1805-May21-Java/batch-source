
public class Q15 implements Q15Interface{

	public static void main(String[] args) {

		
	}

	@Override
	public int addition(int a, int b) {
		return a+b;
	}

	@Override
	public int subtraction(int a, int b) {
		return a-b;
	}

	@Override
	public int multiplication(int a, int b) {
		return a*b;
	}

	@Override
	public int division(int a, int b) {
		if(b != 0) {
			return a/b;
		}else {
			//Instead of diving by 0, just return 0 which cannot be achieved for any values of a and b
			//therefore the method that calls this can check for this return
			return 0;
		}
	}

}
