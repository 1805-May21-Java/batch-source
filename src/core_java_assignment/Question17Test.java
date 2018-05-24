package core_java_assignment;

import java.util.Scanner;

import org.junit.Test;

public class Question17Test {

	@Test
	public void test() {
		Scanner scanner = new Scanner(System.in);
		Question17 question17 = new Question17();
		System.out.println(question17.simpleInterest(scanner));
		scanner.close();
	}

}
