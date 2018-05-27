public class Q16 {

	public static void main(String[] args) {
		//turns the string into an array of chars and prints the length of that array, 
		//which is the number of chars in the string
		if(args.length>0) {
			//checks to make sure there is an input
			
			System.out.println(args[0].toCharArray().length);
			
		}else {
			System.out.println("No input given!");
		}
	}
}
