import org.omg.CORBA.PRIVATE_MEMBER;

public class Q2 {

	public static void main(String[] args) {
		int a = 0;
		int b = 1;
		int tempA;
		//I want to turn B to A, then make the new B the old A plus B.  For those to happen, I need to create a 
		//temporary A to store B, then change B to be B+A
		for(int n=0;n<25;n++) {
			System.out.println(a);
			tempA = b;
			b = a+b;
			a = tempA;
		}
	}
	
}
