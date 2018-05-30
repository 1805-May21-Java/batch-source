package com.revature;

import static org.junit.Assert.*;

import org.junit.Test;

import com.revature.calc.Calculator;
/*
 * 
 * We have a selection of different assert methods, which allow us 
 * to compare our test values to our expected values
 * 
 */
public class CalculatorTest {

	@Test
	public void twoNumbersReturnSum() {
		int sum = Calculator.add("23,79");
		assertEquals(102, sum);
	}
	
	@Test
	public void emptyStringReturnsZero() {
		int sum = Calculator.add("");
		assertEquals(0,sum);
	}
	
	@Test(expected=RuntimeException.class)
	public void moreThanTwoNumbers() {
		Calculator.add("1,2,3");
	}

}
