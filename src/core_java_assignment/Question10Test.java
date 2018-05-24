package core_java_assignment;

import static org.junit.Assert.*;

import org.junit.Test;

public class Question10Test {

	@Test
	public void test() {
		Question10 question10 = new Question10();
		assertEquals(question10.minimum(10,11), 10);
	}

}
