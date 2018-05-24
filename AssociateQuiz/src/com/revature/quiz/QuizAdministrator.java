package com.revature.quiz;
import java.util.ArrayList;
import java.util.Random;

public class QuizAdministrator {

	ArrayList<String> associates;
	ArrayList<String> questions;
	
	public QuizAdministrator() {
		super();
		this.associates = new ArrayList<String>();
		this.questions = new ArrayList<String>();
	}

	public QuizAdministrator(ArrayList<String> associates, ArrayList<String> questions) {
		this.associates = associates;
		this.questions = questions;
	}
	
	public QuizAdministrator(String[] associates, String[] questions) {
		for(String s : associates)
			this.associates.add(s);
		for(String s : questions)
			this.questions.add(s);
	}
	
	public ArrayList<String> getAssociates() {
		return associates;
	}

	public void setAssociates(ArrayList<String> associates) {
		this.associates = associates;
	}

	public ArrayList<String> getQuestions() {
		return questions;
	}

	public void setQuestions(ArrayList<String> questions) {
		this.questions = questions;
	}

	public void addAssociate(String name) {
		this.associates.add(name);
	}
	
	public void addQuestion(String q) {
		this.questions.add(q);
	}
	
	public void randomQuestion(int i) {
		Random rand = new Random();
		System.out.println(this.associates.size() + " " + this.questions.size());
		int r1 = rand.nextInt(this.associates.size());
		int r2 = rand.nextInt(this.questions.size());
		System.out.println("Question " + i + ", for " + this.associates.get(r1) + ":");
		System.out.println(this.questions.get(r2));
	}
}
