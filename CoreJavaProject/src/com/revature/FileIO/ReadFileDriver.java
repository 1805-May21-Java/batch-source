package com.revature.FileIO;
import java.io.*;
public class ReadFileDriver {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BufferedReader br = null;
		String path = "src/com/revature/FileIO/read_data.txt";
		
		try
		{
			br = new BufferedReader(new FileReader(path));
			String line = br.readLine();
			
			while(line != null) {
				System.out.println(line);
				line = br.readLine();
			}
		}catch (IOException e)
		{
			e.printStackTrace();
		}
		

	}

}
