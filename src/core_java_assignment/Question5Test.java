package core_java_assignment;

import static org.junit.Assert.*;

import org.junit.Test;

public class Question5Test {

	@Test
	public void test() {
		Question5 question5 = new Question5();
		assertEquals(question5.subString("bloop", 4), "bloo");
	}

}
