package com.revature.game;

import java.util.*;
import java.io.*;

public class Driver {

	public static void main(String[] args) {
		ArrayList<Associate> associates = new ArrayList<Associate>();
		ArrayList<Question> questions = new ArrayList<Question>();
		
		BufferedReader associatesBR = null;
		String associatesPath = "src/com/revature/game/associates_file";
		BufferedReader questionsBR = null;
		String questionsPath = "src/com/revature/game/questions_file";
		
		try {
			associatesBR = new BufferedReader(new FileReader(associatesPath));
			questionsBR = new BufferedReader(new FileReader(questionsPath));
			
			//Populating ArrayLists
			String name = associatesBR.readLine();
			while(name != null && name != "") {
				associates.add(new Associate(name));
				name = associatesBR.readLine();
			}
			String query = questionsBR.readLine();
			while(query != null) {
				questions.add(new Question(query));
				query = questionsBR.readLine();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}

	
		
		
		Interviewer interviewer = new Interviewer(associates, questions);
		interviewer.start();
		
		System.out.println("Thank you for your time!");
	}
}
