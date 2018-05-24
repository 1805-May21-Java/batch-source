
public class Q4 {

	//this will store the final answer
	static int answer = 1;
	public static void main(String[] args) {
		//number that I'm taking the factorial of
		int num = 10;
		for(int i=1;i<=num;i++) {
			answer *= i;
		}
		
		System.out.println(answer);
	}

}
