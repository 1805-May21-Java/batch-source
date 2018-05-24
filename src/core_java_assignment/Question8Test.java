package core_java_assignment;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Arrays;

import org.junit.Test;

public class Question8Test {

	@Test
	public void test() {
		Question8 question8 = new Question8();
		System.out.println(question8.palindrome(new ArrayList<String>(Arrays.asList("karan", "madam", "tom", "civic", "radar", "jimmy", "kayak", "john", "refer", "billy", "did"))));
	}

}
