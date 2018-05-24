package core_java_assignment;

import static org.junit.Assert.*;

import org.junit.Test;

public class Question4Test {

	@Test
	public void test() {
		Question4 question4 = new Question4();
		assertEquals(question4.factorial(5), 120);
	}

}
