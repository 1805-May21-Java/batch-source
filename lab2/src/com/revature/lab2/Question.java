package com.revature.lab2;

public class Question {

	private String question;
	private char qid;
	
	public Question() {
		// TODO Auto-generated constructor stub
		super();
	}
	public Question(String qt) {
		super();
		this.question = qt;
		this.qid=qt.charAt(0);
	}
	public String getQuestion() {
		return question;
	}
	public void setQuestion(String question) {
		this.question = question;
	}
	public int getQID() {
		return question.charAt(0);
	}
	public void setQID(char qid) {
		this.qid = qid;
	}

}
