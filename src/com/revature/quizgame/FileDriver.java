package com.revature.quizgame;

import java.io.*;

public class FileDriver {
    private String path;
    private String fname;
    private int lc;

    public FileDriver(){
        super();
    }
    void quizCreate(String s, String n, int c){
        s = this.path;
        n = this.fname;
        c = this.lc;
        
        File f = new File(s+"/"+n);

        try {
            if(!f.exists()) f.createNewFile();

            FileWriter fw = new FileWriter(f);
            BufferedWriter bw = new BufferedWriter(fw);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
