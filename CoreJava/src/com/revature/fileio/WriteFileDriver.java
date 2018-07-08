package com.revature.fileio;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class WriteFileDriver {

	public static void main(String[] args) {
		
		BufferedWriter bw = null;
		String path = "src/com/revature/fileio/data";
		
		String content = "\nWe still have 4 ships to go";
		
		try {
		
			// specifying the file we want to write to
			File file = new File(path);
			
			// checking first to see if the file exists, creating it if it doesn't
			if(!file.exists()) {
				file.createNewFile();
			}
			
			// our FileWriter has an optional argument which specifies whether it will append 
			FileWriter fw = new FileWriter(file, true);
			bw = new BufferedWriter(fw);
			
			bw.write(content);
			System.out.println("Our file has been written");
		
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if(bw != null) {
				try {
					bw.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		

	}

}
