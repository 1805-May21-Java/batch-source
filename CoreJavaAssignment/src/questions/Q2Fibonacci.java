package questions;


//Program's fibonnaci method prints out
//first 25 numbers in the fibonacci sequences. beginning from
// Zero.
public class Q2Fibonacci {
	//Program uses private int variables to
	//keep track of the two previous fibonnaci numbers that
	//make up each current number in the sequence.
	private int fibPrev1;
	private int fibPrev2;
	public void fibonacci() {
		//fib1 and fib2 are initialized to 1 and 0 
		//fibPrev1 is a fibonnaci number at sequence -1
		//at start of program
		fibPrev1 = 1;
		fibPrev2 = 0;
		//fibTemp will store fibPrev1
		int fibTemp;
		//fibSum will be the sum of fibPrev1 and fibPrev2
		//This is what will give the program the
		//fibonacci number at each sequence
		int fibSum = 0;
		//count will be used to keep track of each sequence
		int count = 0;
		System.out.println("Fibonacci Sequence:");
		//this will ensure that program only prints out
		//the first 25 fibonnaci numbers.
		while(count < 25) {
			System.out.println("Fib " + count + ": " + fibSum);
			fibTemp = fibPrev1;
			fibSum = fibPrev1 + fibPrev2;
			//fibPrev1 stores fibPrev2 to refer to the next sequence
			fibPrev1 = fibPrev2;
			//fibPrev2 now has the next number in the in the
			//fibnocci sequence after fibPrev1's value
			fibPrev2 += fibTemp;
			count++;
		}
	}
}
