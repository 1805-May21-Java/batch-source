package com.revature.question_game;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Game {
	public void play() {
		Scanner sc = new Scanner(System.in);
		boolean flag = true;
		ArrayList<String> questions = new ArrayList<>();
		ArrayList<String> players = new ArrayList<>();
		
		BufferedReader br = null;
		try {
			String path = "src/com/revature/question_game/questions.txt";
			br = new BufferedReader(new FileReader(path));
			String line = br.readLine();
			while(line != null) {
				questions.add(line);
				line = br.readLine();
			}
			
			path = "src/com/revature/question_game/players.txt";
			br = new BufferedReader(new FileReader(path));
			line = br.readLine();
			while(line != null) {
				players.add(line);
				line = br.readLine();
			}
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println("Welcome to the Question Game!");
		while(flag) {
			String player = selectRandom(players);
			String question = selectRandom(questions);
			System.out.println(player);
			System.out.println(question);
			System.out.println("Enter true to continue and false to quit.");
			flag = sc.nextBoolean();
		}
		System.out.println("Goodbye!");
	}
	
	private String selectRandom(ArrayList<String> arrList) {
		int size = arrList.size();
		Random r = new Random();
		int randomIndex = r.nextInt(size);
		return arrList.get(randomIndex);
	}
}
