package com.revature.assigncorej;

import java.io.*;

public class Question20 {
    public static void main(String args[]){
        String s = "./src/com/revature/assigncorej/data.txt";
        File f = new File(s);
        try {
            FileReader fr = new FileReader(f);
            BufferedReader br = new BufferedReader(fr);

            String li;

            int i=1;

            while ((li = br.readLine()) != null){
                String arr[] = li.split(":");
                for (String x:arr) {
                    switch(i){
                        case 1: System.out.print("Name: "+x);
                            break;
                        case 2:
                            System.out.print(" "+x);
                            break;
                        case 3:
                            System.out.println("\nAge: "+x);
                            break;
                        case 4:
                            System.out.println("State: "+x+" State");
                            i=0;
                            break;
                        default:
                            break;
                    }
                    i++;
                }
                System.out.println();
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
