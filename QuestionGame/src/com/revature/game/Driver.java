package com.revature.game;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Random;
import java.util.Scanner;

public class Driver {

	public static void main(String[] args) {
		//One Map stores the Names, the other stores the Questions
		HashMap<Integer, String> names = new HashMap<>(), questions = new HashMap<>();
		BufferedReader bReader = null;
		boolean quit = false;
		String q="";
		
		
		Scanner scanner = new Scanner(System.in);

		String path = "src/com/revature/game/Associates.txt";
		try {
			bReader = new BufferedReader(new FileReader(path));
			String line = bReader.readLine();
			int i=0; //Number of Names
			while (line!=null) {
				names.put(i, line);
				i++;
				line = bReader.readLine();
			}
			System.out.println("");
			path = "src/com/revature/game/Questions.txt";
			int j=0;	//Number of Questions
			bReader = new BufferedReader(new FileReader(path));
			line = bReader.readLine();
			while (line!=null) {
				questions.put(j, line);
				j++;
				line = bReader.readLine();
			}
			int associateNum = 0, questionNum=0;
			while(!quit) {
				//These generate random numbers in order to get a random name and question
				associateNum = (int) (Math.random()*i);
				questionNum = (int) (Math.random()*j);
				System.out.println(names.get(associateNum));
				System.out.println(questions.get(questionNum));
				System.out.println("\nEnter 'q' to Quit, anything else to continue");
				q = scanner.nextLine();
				if(q.equals("q")) {
					quit = true;
				}
			}
			System.out.println("Thanks for playing!");
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
