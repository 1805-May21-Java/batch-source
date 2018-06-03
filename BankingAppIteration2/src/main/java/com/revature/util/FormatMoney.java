package com.revature.util;

import java.text.DecimalFormat;

public class FormatMoney {
	static DecimalFormat numberFormat = new DecimalFormat("#.00");
	public static double format(double d) {
		String s = numberFormat.format(d);
		double newD = Double.parseDouble(s);
		return newD;
	}
	
	public static String print(double d) {
		return numberFormat.format(d);
	}
}
