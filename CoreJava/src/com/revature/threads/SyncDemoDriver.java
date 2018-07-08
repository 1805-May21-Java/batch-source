package com.revature.threads;

public class SyncDemoDriver {

	
	public static void main(String[] args) {
		
		Count c = new Count();
		Runnable job = new TestRunnable(c);
//		Thread t1 = new Thread(job);
//		Thread t2 = new Thread(job);
		
		StringBuilder sbuild = new StringBuilder();
		StringBuffer sbuffer = new StringBuffer();
		Runnable job2 = new TestRunnable(sbuild,sbuffer);
		Thread t1 = new Thread(job2);
		Thread t2 = new Thread(job2);
		
		
		t1.start();
		t2.start();
		
		try {
			t1.join();
			t2.join();			
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		
		//System.out.println("Count: "+c.count);
		System.out.println("StringBuilder result:");
		System.out.println(sbuild);
		System.out.println();
		System.out.println("StringBuffer result:");
		System.out.println(sbuffer);
		
	}
	
}
