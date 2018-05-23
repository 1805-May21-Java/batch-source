package fileio;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

public class DeserializationDriver {
    public static void main(String args[]){
        Cereal c = null;
        try {
            FileInputStream s = new FileInputStream("./Cereal.ser");
            ObjectInputStream ois = new ObjectInputStream(s);

            c = (Cereal) ois.readObject();
            System.out.println(c.toString());

            ois.close();
            s.close();

        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
