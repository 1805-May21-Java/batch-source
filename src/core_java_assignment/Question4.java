package core_java_assignment;

public class Question4 {
	public int factorial(int integer){
		int factorial = integer;
		for (int i = integer - 1; i > 0; i--){
			factorial *= i;
		}
		return factorial;
	}
}
