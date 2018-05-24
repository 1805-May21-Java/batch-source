package com.revature.questiongame;

public class Question {
 
	String question;

	public Question(String question) {
		super();
		this.question = question;
	}

	public Question() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return question;
	}

	public String getQuestion() {
		return question;
	}

	public void setQuestion(String question) {
		this.question = question;
	}
	
	
}
