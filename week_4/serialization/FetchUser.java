package week_4.serialization;

import java.io.*;
import java.lang.reflect.*;

public class FetchUser {
    public static void main(String args[]) throws IOException {
        ObjectInputStream in = null;
        FileInputStream fin = null;
        // use try with recourses
        try {
            // Reading the object file
            fin = new FileInputStream("week_4/serialization/userdata.txt");
            // Creating stream to read the object
            in = new ObjectInputStream(fin);
            User user = (User) in.readObject();
            // printing the data of the serialized object
            System.out.println("user record retrieved");
            Class usercls = user.getClass();
            Field pass = usercls.getDeclaredField("password");
            pass.setAccessible(true);
            pass.set(user, "1234");
            System.out.println((String) pass.get(user));
            System.out.println(user);

        } catch (Exception e) {
            System.out.println("user record not retrieved");
            System.out.println(e);
        } finally {
            // closing the stream
            in.close();
            // closing the file input stream
            fin.close();
        }
    }
}
