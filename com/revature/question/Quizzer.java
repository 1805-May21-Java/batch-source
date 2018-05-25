package com.revature.question;
import java.util.*;
public class Quizzer {
private static Scanner sc= new Scanner(System.in);
	
	private ArrayList<Associates> assoc;
	private ArrayList<Questions> quest;
	public Quizzer(ArrayList<Associates> assoc2, ArrayList<Questions> quest2) {
		super();
		this.assoc = assoc2;
		this.quest = quest2;
	}
	public Quizzer() {
		super();
	}
	
	public void start() {
		
		int smaller = (this.assoc.size() < this.quest.size()) ? this.assoc.size() : this.quest.size();
		for (int i = 0; i < smaller; i++) {
			System.out.println(getRandomQuestions(assoc).toString());
			System.out.println(getRandomQuestions(quest).toString());
			String answer = sc.nextLine();
		}
	}
	
	static <T> T getRandomQuestions (ArrayList<T> arr) {
		Random rand = new Random();
		
		T chosen = null;
		if(arr.size() > 0) {
			int index = rand.nextInt(arr.size());
			chosen = arr.get(index);
		 	arr.remove(index);
		}
		return chosen;
	}
	
	public ArrayList<Associates> getAssociates() {
		return assoc;
	}
	public void setAssociates(ArrayList<Associates> associates) {
		this.assoc = assoc;
	}
	public ArrayList<Questions> getQuestions() {
		return quest;
	}
	public void setQuestions(ArrayList<Questions> questions) {
		this.quest = quest;
	}
	@Override
	public String toString() {
		return "Quizzer [associates=" + assoc + ", questions=" + quest + "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((assoc == null) ? 0 : assoc.hashCode());
		result = prime * result + ((quest == null) ? 0 : quest.hashCode());
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
		Quizzer newInter = (Quizzer) obj;
		if (assoc == null) {
			if (newInter.assoc != null)
				return false;
		} else if (!assoc.equals(newInter.assoc))
			return false;
		if (quest == null) {
			if (newInter.quest != null)
				return false;
		} else if (!quest.equals(newInter.quest))
			return false;
		return true;
	}
}
