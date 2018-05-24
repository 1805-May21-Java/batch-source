package core_java_assignment;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Arrays;

import org.junit.Test;

public class Question1Test {

	@Test
	public void test() {
		Question1 question1 = new Question1();
		ArrayList<Integer> list = new ArrayList(Arrays.asList(0,1,2,3,3,4,5,6,7,8,9));
		assertEquals(question1.bubbleSort(), list);
	}

}
