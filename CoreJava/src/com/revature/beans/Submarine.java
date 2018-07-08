package com.revature.beans;

public class Submarine extends Vehicle {
	
	private int depth;
	private boolean periscopeExtended;
	private int numTorpedos;
	private boolean redAlert;
	
	public Submarine() {
		super();
	}

	public Submarine(int depth, boolean periscopeExtended, int numTorpedos, boolean redAlert) {
		super();
		this.depth = depth;
		this.periscopeExtended = periscopeExtended;
		this.numTorpedos = numTorpedos;
		this.redAlert = redAlert;
	}

	public int getDepth() {
		return depth;
	}

	public void setDepth(int depth) {
		this.depth = depth;
	}

	public boolean isPeriscopeExtended() {
		return periscopeExtended;
	}

	public void setPeriscopeExtended(boolean periscopeExtended) {
		this.periscopeExtended = periscopeExtended;
	}

	public int getNumTorpedos() {
		return numTorpedos;
	}

	public void setNumTorpedos(int numTorpedos) {
		this.numTorpedos = numTorpedos;
	}

	public boolean isRedAlert() {
		return redAlert;
	}
	
	public void setRedAlert(Boolean redAlert) {
		this.redAlert = redAlert;
	}

	
}
