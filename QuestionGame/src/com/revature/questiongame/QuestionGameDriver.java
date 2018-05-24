package com.revature.questiongame;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class QuestionGameDriver {

	public static void main(String[] args) {
		
		BufferedReader br = null;
		BufferedReader br2 = null;
		String path = "src/com/revature/questiongame/Associate.txt";
		String path2 = "src/com/revature/questiongame/Questions.txt";
		
		Scanner sc = new Scanner(System.in);
		String next;
		
			List<Associate> a = new LinkedList<Associate>();
			a.add(new Associate("Mary", 25));
			a.add(new Associate("Paul", 22));
			a.add(new Associate("Jenna", 30));
			
			Collections.shuffle(a);
			
			List<Question> q = new LinkedList<Question>();
			q.add(new Question("What is the JDK?"));
			q.add(new Question("What is reflection?"));
			q.add(new Question("What are the important interfaces in the Collections Framework?"));
			
			Collections.shuffle(q);
			
			Iterator<Associate> itr = a.iterator();
			Iterator<Question> itr2 = q.iterator();
			
//			try {
//				br = new BufferedReader(new FileReader(path));
//				br2 = new BufferedReader(new FileReader(path2));
//				
//				String line = br.readLine();
//				String line2 = br2.readLine();
//				//read file until there are no more lines to read
//				while(line != null) {
//					System.out.println(line);
//					System.out.println(line2);
//					line=br.readLine();
//					line2=br2.readLine();
//				}
//				
//			} catch (IOException e) {
//				e.printStackTrace();
//			}
			
			while (itr.hasNext()) {
				System.out.println();
				System.out.println("Hit enter see your question:");
				next = sc.nextLine();
				if (next != null) {
					System.out.println(itr.next());
					System.out.println(itr2.next());
				} 
			} 
			System.out.println();
			System.out.println("No more questions left!");
			
		}
	
	} 

