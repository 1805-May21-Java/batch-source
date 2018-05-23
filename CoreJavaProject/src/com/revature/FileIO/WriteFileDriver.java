package com.revature.FileIO;
import java.io.*;

public class WriteFileDriver {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		BufferedWriter bw = null;
		String path = "src/com/revature/fileIO/data.txt";
		
		String content = "Launch Torpedos! New Words";
		try 
		{
			
		File file = new File(path);
		if(!file.exists()) {
			 {
				file.createNewFile();
			} 
		
			 FileWriter fw = new FileWriter(file);
			bw = new BufferedWriter(fw);
		
			bw.write(content);
			System.out.println("Our file there");
			}
		}catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if(bw != null) {
				try {
					bw.close();
				}
				catch(IOException e) {
					e.printStackTrace();
				}
			}
		}
	}

}
