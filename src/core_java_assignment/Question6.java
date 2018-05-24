package core_java_assignment;

public class Question6 {
	public boolean isEven(int number){
		boolean isEven;
		double half = (double)number / 2;
		
		if (half == number / 2){
			isEven = true;
		} else {
			isEven = false;
		}
		
		return isEven;
	}
}
