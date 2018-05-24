package core_java_assignment;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Arrays;

import org.junit.Test;

public class Question2Test {

	@Test
	public void test() {
		Question2 question2 = new Question2();
		ArrayList<Integer> list = new ArrayList(Arrays.asList(0, 1, 1, 2, 3, 5, 8, 13, 21, 34, 55, 89, 144, 233, 377, 610, 987, 1597, 2584, 4181, 6765, 10946, 17711, 28657, 46368));
		assertEquals(question2.fibonacci(25), list);
	}

}
