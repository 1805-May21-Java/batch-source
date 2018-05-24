import java.sql.Time;
import java.time.LocalDate;
import java.util.Arrays;

public class Q14 {

	public static void main(String[] args) {
		//this is the number that determines which case is met
		int num = 3;
		int squareRootMe = 10000;
		String str = "I am learning Core Java";
		
		switch (num) {
		case 1:
			Math.sqrt(squareRootMe);
			break;
		case 2:
			System.out.println(LocalDate.now());
			break;
		case 3:
			//splits the string by spaces to create an array with each word being an element
			String[] stringArray = str.split(" ");
			break;
		}
	}

}
