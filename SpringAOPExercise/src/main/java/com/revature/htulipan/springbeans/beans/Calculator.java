package com.revature.htulipan.springbeans.beans;

import org.springframework.stereotype.Component;

@Component
public class Calculator {
	private int ans = 0;
	
	public int add(int o1, int o2) {
		ans = o1 + o2;
		return ans;
	}
	
	public int sub(int o1, int o2) {
		ans = o1 - o2;
		return ans;
	}
	
	public int mul(int o1, int o2) {
		ans = o1 * o2;
		return ans;
	}
	
	public int div(int o1, int o2) {
		ans = o1 / o2;
		return ans;
	}

	public int getAns() {
		return ans;
	}

	public void setAns(int ans) {
		this.ans = ans;
	}

	@Override
	public String toString() {
		return "Calculator [ans=" + ans + "]";
	}
	
}
