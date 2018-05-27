package com.adora.testinterface15;



import static org.junit.Assert.assertEquals;

import org.junit.*;


public class ArithemeticTest {

	static Arithemetic machine;
	
	
	@BeforeClass
	public static void createClass() {
		machine = new Arithemetic();
		
	}
	
	@Test
	public void testAdd() {
		int sum = machine.addition(1,2);
		assertEquals(3, sum);
	}

	@Test
	public void testSubstract() {
		int difference = machine.subtraction(9, 5);
		assertEquals(4, difference);
	}
	
	@Test 
	public void testMultiplication() {
		int result = machine.multiplication(4, 5);
		assertEquals(20, result);
	}
	
	@Test
	public void testDivision() {
		float result = machine.division(10, 3);
		assert((float) 10/3 ==  result);
	}
}
