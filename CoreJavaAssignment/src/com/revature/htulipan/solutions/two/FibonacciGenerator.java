package com.revature.htulipan.solutions.two;

import java.util.ArrayList;

public class FibonacciGenerator {
	private ArrayList<Integer> fibList;
	
	public FibonacciGenerator(int n) {
		this.fibList = new ArrayList<>();
		for (int i = 0; i <= n; i++) {
			this.fibList.add(i, -1);
		}
		this.fibList.set(0, 0);
		this.fibList.set(1, 1);
	}
	
	public int getNth(int n) {
		if (n > this.fibList.size() + 1) {
			for (int i = this.fibList.size(); i <= n; i++) {
				this.fibList.add(i, -1);
			}
		}
		
		if (this.fibList.get(n) > -1) {
			return this.fibList.get(n);
		}
		
		int cur = 0;
		
		while (cur <= n) {
			if (this.fibList.get(cur) > -1) {
				cur++;
				continue;
			}
			this.fibList.set(n, this.fibList.get(n - 1) + this.fibList.get(n - 2));
			cur++;
		}
		
		return this.fibList.get(n);
	}
	
	
}
