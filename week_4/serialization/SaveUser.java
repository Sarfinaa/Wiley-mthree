package week_4.serialization;

import java.io.*;

public class SaveUser {
    public static void main(String... args) {
        try (FileOutputStream fout = new FileOutputStream("week_4/userdata.txt");
                ObjectOutputStream out = new ObjectOutputStream(fout);) {
            // Creating the object
            User user = new User("karan seth", "karanseth@gmail.com", "1234");
            // Write the object into the file
            out.writeObject(user);
            // Flush the output stream pipe
            out.flush();
            System.out.println("user record saved");
        } catch (Exception e) {
            System.out.println("user record not saved!!!");
            System.out.println(e);
        }
    }
}
