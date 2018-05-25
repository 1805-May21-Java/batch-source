package com.revature.question;
import java.io.*;
import java.util.*;
public class QuizDriver {
	public static void main(String[] args) {
		ArrayList<Associates> assoc = new ArrayList<Associates>();
		ArrayList<Questions> quest = new ArrayList<Questions>();
		
		BufferedReader associatesReader = null;
		String associatesPath = "src/com/revature/question/Associates";
		BufferedReader questionsReader = null;
		String questionsPath = "src/com/revature/question/Questions";
		
		try {
			associatesReader = new BufferedReader(new FileReader(associatesPath));
			questionsReader = new BufferedReader(new FileReader(questionsPath));
			
			//Populating ArrayLists
			String name = associatesReader.readLine();
			while(name != null && name != "") {
				assoc.add(new Associates(name));
				name = associatesReader.readLine();
			}
			String que = questionsReader.readLine();
			while(que != null) {
				quest.add(new Questions(que));
				que = questionsReader.readLine();
			}
		} catch (IOException e) { //need to catch IOException if possible
			e.printStackTrace();
		}

	
		
		
		Quizzer interviewer = new Quizzer(assoc, quest);
		interviewer.start();
		
		System.out.println("Thank you for your time!");
	}
}

