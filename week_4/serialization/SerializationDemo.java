package week_4.serialization;

import java.io.*;

class StudentSeriliazation {
    public static void main(String... args) {
        try (FileOutputStream fout = new FileOutputStream("week_4/serialization/f.txt");
                ObjectOutputStream out = new ObjectOutputStream(fout);) {
            // Creating the object
            Studentss s1 = new Studentss(21, "Akash");
            // Write the object into the file
            out.writeObject(s1);
            // Flush the output stream pipe
            out.flush();
            System.out.println("success");
        } catch (Exception e) {
            System.out.println("failure");
            System.out.println(e);
        }
    }
}
// Intrensic lock - you are providing the recourse on which you want the
// lock(synchronized block)
// extrensic lock- in this it automatically assign the lock(synchronized method
// )

// Suppose super class of a new class implement Serializable interface, how can
// you avoid new class to being serialized?
// One of the tricky interview question in Serialization in Java. If Super Class
// of a Class already implements Serializable
// interface in Java then its already Serializable in Java, since you can not
// unimplemented an interface its not really possible
// to make it Non Serializable class but yes there is a way to avoid
// serialization of new class.

// To avoid Java serialization you need to implement writeObject() and
// readObject() method in your Class and need to throw
// NotSerializableException from those method