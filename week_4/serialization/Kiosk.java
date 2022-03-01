package week_4.serialization;

import java.io.FileOutputStream;
import java.io.ObjectOutputStream;

public class Kiosk {
    public static void main(String[] args) {
        try (FileOutputStream fout = new FileOutputStream("week_4/serialization/account.txt");
                ObjectOutputStream out = new ObjectOutputStream(fout);) {
            // Creating the object
            BankAccount acc = new BankAccount(1002, "Karan Seth", 1000);
            // Write the object into the file
            out.writeObject(acc);
            // Flush the output stream pipe
            out.flush();
            System.out.println("success");
        } catch (Exception e) {
            System.out.println("failure");
            System.out.println(e);
        }
    }
}
