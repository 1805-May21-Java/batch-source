package com.revature.practice;

import java.io.*;

public class FileIO {
	public static void main(String[] args) throws IOException{
		FileReader in = null;
	    FileWriter out = null;

	      try {
	         in = new FileReader("input.txt");
	         out = new FileWriter("output.txt");
	         
	         int c;
	         while ((c = in.read()) != -1) {
	            out.write(c);
	         }
	      }catch(FileNotFoundException e) {
	    	  e.printStackTrace();
	      }
	      finally {
	         if (in != null) {
	            in.close();
	         }
	         if (out != null) {
	            out.close();
	         }
	      }
	}

}
