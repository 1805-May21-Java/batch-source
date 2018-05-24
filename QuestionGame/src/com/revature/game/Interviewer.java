package com.revature.game;

import java.util.*;

public class Interviewer {
	private static Scanner sc= new Scanner(System.in);
	
	private ArrayList<Associate> associates;
	private ArrayList<Question> questions;
	public Interviewer(ArrayList<Associate> associates2, ArrayList<Question> questions2) {
		super();
		this.associates = associates2;
		this.questions = questions2;
	}
	public Interviewer() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public void start() {
		
		int smaller = (this.associates.size() < this.questions.size()) ? this.associates.size() : this.questions.size();
		for (int i = 0; i < smaller; i++) {
			System.out.println(getRandom(associates).toString());
			System.out.println(getRandom(questions).toString());
			String answer = sc.nextLine();
		}
	}
	
	static <T> T getRandom (ArrayList<T> arr) {
		Random rand = new Random();
		
		T chosen = null;
		if(arr.size() > 0) {
			int index = rand.nextInt(arr.size());
			chosen = arr.get(index);
		 	arr.remove(index);
		}
		return chosen;
	}
	
	public ArrayList<Associate> getAssociates() {
		return associates;
	}
	public void setAssociates(ArrayList<Associate> associates) {
		this.associates = associates;
	}
	public ArrayList<Question> getQuestions() {
		return questions;
	}
	public void setQuestions(ArrayList<Question> questions) {
		this.questions = questions;
	}
	@Override
	public String toString() {
		return "Interviewer [associates=" + associates + ", questions=" + questions + "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((associates == null) ? 0 : associates.hashCode());
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
		Interviewer other = (Interviewer) obj;
		if (associates == null) {
			if (other.associates != null)
				return false;
		} else if (!associates.equals(other.associates))
			return false;
		if (questions == null) {
			if (other.questions != null)
				return false;
		} else if (!questions.equals(other.questions))
			return false;
		return true;
	}
	
	
}
