package com.revature.algorithms;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;

public class MyReader {
	
	// nested class for storing all 4 data values in a single object
	private class Record {
		String first;
		String last;
		int age;
		String state;
		
		public Record() {
			super();
		}
		
		public Record(String first, String last, int age, String state) {
			super();
			this.first = first;
			this.last = last;
			this.age = age;
			this.state = state;
		}
		
		// prints record in the desired format
		public void printRecord() {
			System.out.println("Name: " + this.first + " " + this.last);
			System.out.println("Age: " + this.age + " years");
			System.out.println("State: " + this.state + " State");
		}
	}
	
	private Scanner input;
	ArrayList<Record> records;
	
	public MyReader() {
		super();
		File f = new File("./data.txt");
		try {
			input = new Scanner(f);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		records = new ArrayList<Record>();
	}

	// reads all records from the file as Record objects and adds them to records ArrayList
	public void readRecords() {
		while(input.hasNextLine()) {
			String line = input.nextLine();
			String[] split = line.split(":");
			if(split.length == 4) {
				records.add(new Record(split[0], split[1], Integer.parseInt(split[2]), split[3]));
			}
		}
	}
	
	// calls printRecord() on all Records in ArrayList records
	public void printRecords() {
		for(int i = 0; i < records.size(); i++) {
			if (i != 0)
				System.out.println();
			records.get(i).printRecord();
		}
	}
}
