package fileio;

import java.io.*;

public class SerializationDriver {
    public static void main(String args[]){
        Cereal c = new Cereal(true, 130, false, "Cinnamon Toast Crunch");

        try {
            FileOutputStream fos = new FileOutputStream("./Cereal.ser");
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(c);
            oos.close();
            fos.close();
            System.out.println("We're done serializing the crunch.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
