package week_4.serialization;

import java.io.*;

class Deserialization {
    public static void main(String args[]) throws IOException {
        try (FileInputStream fin = new FileInputStream("week_4/serialization/f.txt");
                ObjectInputStream in = new ObjectInputStream(fin);) {

            Studentss s = (Studentss) in.readObject();
            // printing the data of the serialized object
            System.out.println(s.rollNumber + " " + s.name);
        } catch (Exception e) {
            System.out.println(e);

        }
    }
}
