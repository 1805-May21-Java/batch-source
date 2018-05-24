package core_java_assignment;

import java.util.Scanner;

public class Question16 {
	Scanner scanner = new Scanner(System.in);
	public int stringLength() {
		String string = "";
		System.out.println("Type something.");
		if(scanner.hasNextLine()) {
			string = scanner.nextLine();
		}
		return string.length();
	}
}
