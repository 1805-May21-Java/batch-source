package core_java_assignment;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.Scanner;

public class Question14 {
	Scanner scanner = new Scanner(System.in);

	public void switchCase() {
		int bloop = 0;
		boolean validInput = false;
		while (!validInput) {
			System.out.println("Enter a number between 1 and 3: ");
			if (scanner.hasNextInt()) {
				bloop = scanner.nextInt();
				if (bloop > 0 && bloop < 4) {
					validInput = true;
				} else {
					System.out.println("Integer is not within range.");
				}
			} else {
				System.out.println("Not an Integer.");
				scanner.next();
			}
		}
		if (validInput) {
			switch (bloop) {
			case 1:
				validInput = false;
				double root = 0;
				while (!validInput) {
					System.out.println("Enter a number to find the square root.");
					if (scanner.hasNextInt()) {
						root = scanner.nextInt();
						validInput = true;
					} else {
						System.out.println("Not an Integer.");
						scanner.next();
					}
				}
				System.out.println(Math.sqrt(root));
				break;
			case 2:
				System.out.println(new Date().toString());
				break;
			case 3:
				String string = "I am learning Core Java.";
				String[] splitString = string.split(" ");
				ArrayList<String> list = new ArrayList(Arrays.asList(splitString));
				System.out.println(list);
				break;
			}
		}
		scanner.close();

	}
}
