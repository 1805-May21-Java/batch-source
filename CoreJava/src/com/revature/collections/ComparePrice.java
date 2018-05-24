package com.revature.collections;

import java.util.Comparator;

public class ComparePrice implements Comparator<ChineseFood> {

	@Override
	public int compare(ChineseFood cf1, ChineseFood cf2) {
		if (cf1.getPrice() == cf2.getPrice()) {
			return 0;
		} else {
			return (cf1.getPrice()-cf2.getPrice()>0)? 1 : -1;
		}
	}

}
