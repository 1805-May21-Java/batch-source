package questions;

public class Q6NumberEven {
	public boolean isNumberEven(int number) {
		int divided = number / 2;
		if(number == (divided * 2)) {
			return true;
		}
		return false;
	}

}
