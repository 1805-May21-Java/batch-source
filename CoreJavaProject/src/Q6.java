
public class Q6 {

	public static void main(String[] args) {
		int num = 1781;
		//Checks if doing the division by 2 as a float is the same as if it's truncated as an int. For even they'll both
		//be the same, for odd the float division will have a trailing 0.5 that will make it not equal
		 System.out.println(num/2. == num/2 ? "Even" : "Odd");
	}

}
