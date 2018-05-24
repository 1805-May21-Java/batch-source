package com.revature.question;


public class PairProcess {
	//set up the strings for class pairProcess
	private String names;
	private String questions;
	
	public PairProcess() {
		super();
		// TODO Auto-generated constructor stub
	}

	//getter and setter
	public PairProcess(String names, String questions) {
		super();
		this.names = names;
		this.questions = questions;
	}

	public String getNames() {
		return names;
	}

	public void setNames(String names) {
		this.names = names;
	}

	public String getQuestions() {
		return questions;
	}

	public void setQuestions(String questions) {
		this.questions = questions;
	}

	//hashcode and .equals
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((names == null) ? 0 : names.hashCode());
		result = prime * result + ((questions == null) ? 0 : questions.hashCode());
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
		PairProcess other = (PairProcess) obj;
		if (names == null) {
			if (other.names != null)
				return false;
		} else if (!names.equals(other.names))
			return false;
		if (questions == null) {
			if (other.questions != null)
				return false;
		} else if (!questions.equals(other.questions))
			return false;
		return true;
	}

	//tostring
	@Override
	public String toString() {
		return "PairProcess [names=" + names + ", questions=" + questions + "]";
	}
	
	
}
