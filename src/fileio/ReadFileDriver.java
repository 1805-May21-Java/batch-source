package fileio;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class ReadFileDriver {
    public static void main(String args[]){
        BufferedReader br = null;
        String path = "src/com/revature/fileio/read_data";

        try {
            br = new BufferedReader(new FileReader(path));
            String line = br.readLine();
            //Reads lines while there are no more lines to read.
            while(line != null){
                System.out.println(line);
                line=br.readLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
