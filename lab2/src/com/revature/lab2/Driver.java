package com.revature.lab2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.Random;
import java.util.Scanner;

public class Driver {

	public Driver() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		
		Scanner s = new Scanner(System.in);
        ArrayList<Associate> a = new ArrayList<Associate>();
		ArrayList<Question> q = new ArrayList<Question>();

		System.out.println("Enter -1 to exit");
		System.out.println("Enter your associate name (ex. John Doe): ");
		String str1 = s.nextLine();
		System.out.println("Enter your associate age (ex. 30): ");
		String str2 = s.nextLine();

		if(str1.equals("-1")||str2.equals("-1")) 
			System.exit(0);
		a.add(new Associate(str1,Integer.parseInt(str2)));

		while(!str1.equals("-1")&&!str2.equals("-1")) {
			System.out.println("Enter -1 to exit, -2 to enter Questions");
			System.out.println("Enter your associate name (ex. John Doe): ");
			str1 = s.nextLine();
			System.out.println("Enter your associate age (ex. 30): ");
			str2 = s.nextLine();
			if(str1.equals("-1")||str2.equals("-1")) 
				System.exit(0);
			if(str1.equals("-2"))
				break;
			a.add(new Associate(str1,Integer.parseInt(str2)));

		}


		System.out.println("Enter your question (ex. 1.  What the ...): ");
		System.out.println("Enter -1 to exit, -2 to continue program");
		str1 = s.nextLine();

		if(str1.equals("-1")) 
			System.exit(0);
		q.add(new Question(str1));

		while(!str1.equals("-1")) {
			System.out.println("Enter your question (ex. 1.  What the ...): ");
			System.out.println("Enter -1 to exit, -2 to run program");
			str1 = s.nextLine();
			if(str1.equals("-1")) 
				System.exit(0);
			if(str1.equals("-2")) 
				break;
			q.add(new Question(str1));
		}

		
//        q.add(new Question("1.  What's the JDK?"));
//        q.add(new Question("3.  What are the important interfaces in the Collection Framework?"));
//        q.add(new Question("2.  What is Reflection?"));
        
//        a.add(new Associate("Mary",50));
//        a.add(new Associate("Paul",20));
//        a.add(new Associate("Jenna",30));
        
        
        System.out.println("Unsorted");
        for (Associate as: a) {
            System.out.println(as.getName()+" " + as.getAge());  

        }
 
        Collections.sort(a, new Sortbyage());
 
        System.out.println("\nSorted by age");
        for (Associate as: a) {
      	  // use currInstance
            System.out.println(as.getName()+" " + as.getAge());  

      }
 
        Collections.sort(a, new Sortbyname());
        System.out.println("\nSorted by name");
        for (Associate as: a) {
      	  // use currInstance
            System.out.println(as.getName()+" " + as.getAge());  

      }
        
        System.out.println("\nUnsorted");
        for (Question qs: q) {
            System.out.println(qs.getQuestion());  

        }
        
        Collections.sort(q, new Sortbyquestionid());
        System.out.println("\nSorted by questionid");
        for (Question qs: q) {
        	System.out.println(qs.getQuestion());  

        } 
        
        Random rand = new Random();    	
        
		int n1, n2;
		boolean[] visited1 = new boolean[a.size()-1];
//		System.out.println("visited1 size:" + a.size());
		
		for (int i=0;i<visited1.length-1;i++) {
			visited1[i]=false;
//			System.out.println(visited1[i]);			
		}
	 
 		
		for(Associate as: a) {
	
			n1 = rand.nextInt(a.size()-1);
			
			while (visited1[n1]!=true) {
				if(visited1[n1]!=true) {
					visited1[n1]=true;
//					System.out.println("inside"+visited1[n2]);
					
				}
				n1 = rand.nextInt(a.size()-1);
				
			}
			System.out.println("a(name): " + as.getName() + " a(age): " + as.getAge() + " asks: " );
			System.out.println("q: " + q.get(n1).getQuestion());

 		}	

	        	
	}

}
