package com.revature;

import static org.junit.Assert.*;

import org.junit.Test;

import com.revature.util.FormatMoney;

public class FormatMoneyTest {

	@Test
	public void printRoundsUp() {
		String money = FormatMoney.print(999.98999999);
		assertEquals(money, "999.99");
	}
	
	@Test
	public void printRoundsDown() {
		String money = FormatMoney.print(999.9819999);
		assertEquals(money, "999.98");
	}
	
	@Test
	public void printAddsCents() {
		String money = FormatMoney.print(1000);
		assertEquals(money, "1000.00");
	}
	
	@Test
	public void cutOffRoundUp() {
		double money = FormatMoney.format(123.595);
		assert(money == 123.59);
	}
	
	@Test
	public void cutOffRoundDown() {
		double money = FormatMoney.format(100.321);
		assert(money == 100.32);
	}

}
