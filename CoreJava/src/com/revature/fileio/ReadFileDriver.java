package com.revature.fileio;

import java.io.*;

public class ReadFileDriver {
	
	public static void main(String[] args) {
		
		BufferedReader br = null;
		String path = "src/com/revature/fileio/read_data";
		
		
		try {
			br = new BufferedReader(new FileReader(path));
			String line = br.readLine();
			
			// read the file until there are no more lines to read
			while(line != null) {
				System.out.println(line);
				line = br.readLine();
			}
		
		
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
