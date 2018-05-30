package com.revature.patterns;

public class Singleton {
	
	private int value;

	public static Singleton getMySingleton() {
		return mySingleton;
	}

	public static void setMySingleton(Singleton mySingleton) {
		Singleton.mySingleton = mySingleton;
	}

	private static Singleton mySingleton;

	private Singleton() {
		super();
	}
	
	public static Singleton getInstance() {
		
//		if(mySingleton == null) {
//			mySingleton = new Singleton();
//		}
//		return mySingleton;
		
		return (mySingleton == null)? mySingleton = new Singleton() : mySingleton;
		
		
	}
	
	

	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}
	
	@Override
	public Object clone() throws CloneNotSupportedException {
		throw new CloneNotSupportedException();
	}

}
