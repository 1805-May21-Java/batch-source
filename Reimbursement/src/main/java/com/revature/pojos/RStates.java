package com.revature.pojos;

public class RStates {
	private int stateNumber;
	private String stateName;
	
	public int getStateNumber() {
		return stateNumber;
	}
	public void setStateNumber(int stateNumber) {
		this.stateNumber = stateNumber;
	}
	public String getStateName() {
		return stateName;
	}
	public void setStateName(String stateName) {
		this.stateName = stateName;
	}
	
	public RStates() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public RStates(int stateNumber, String stateName) {
		super();
		this.stateNumber = stateNumber;
		this.stateName = stateName;
	}
	
	@Override
	public String toString() {
		return "RStates [stateNumber=" + stateNumber + ", stateName=" + stateName + "]";
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((stateName == null) ? 0 : stateName.hashCode());
		result = prime * result + stateNumber;
		return result;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		RStates other = (RStates) obj;
		if (stateName == null) {
			if (other.stateName != null)
				return false;
		} else if (!stateName.equals(other.stateName))
			return false;
		if (stateNumber != other.stateNumber)
			return false;
		return true;
	}
	
}
