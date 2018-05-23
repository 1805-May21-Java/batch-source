package fileio;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class WriteFileDriver {
    public static void main(String args[]){
        BufferedWriter bw = null;
        String path = "src/com/revature/fileio/data.txt";

        String content = "Launch Torpedoes";
        File file = new File(path);

        if(!file.exists()){
            try {
                file.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }else{System.out.println("File exists, not creating a new one.");
        }
        FileWriter fw = null;
        try {
            fw = new FileWriter(file);
        } catch (IOException e) {
            e.printStackTrace();
        }
        bw = new BufferedWriter(fw);
        try {
            bw.write(String.valueOf(content));
        } catch (IOException e) {
            e.printStackTrace();
        }

        if(bw!=null){
            try {
                bw.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
