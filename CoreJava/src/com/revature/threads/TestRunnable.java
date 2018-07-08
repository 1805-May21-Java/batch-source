package com.revature.threads;

public class TestRunnable implements Runnable {

	Count c;
	StringBuilder sbuild;
	StringBuffer sbuffer;
	
	public TestRunnable() {
		super();
	}

	public TestRunnable(Count c) {
		super();
		this.c = c;
	}

	public TestRunnable(StringBuilder sbuild, StringBuffer sbuffer) {
		super();
		this.sbuild = sbuild;
		this.sbuffer = sbuffer;
	}

	@Override
	public void run() {

//		for(int i = 0; i<5000; i++) {
//			c.increment();
//		}
		
		for(int i = 0; i<50; i++) {
			sbuild = sbuild.append("~");
			sbuffer = sbuffer.append("~");
		}
		
	}

}
