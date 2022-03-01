package week_4.serialization;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

public class Atm {
    public static void main(String[] args) throws IOException {
        ObjectInputStream in = null;
        FileInputStream fin = null;
        try {
            // Reading the object file
            fin = new FileInputStream("week_4/serialization/account.txt");
            // Creating stream to read the object
            in = new ObjectInputStream(fin);
            BankAccount acc = (BankAccount) in.readObject();
            // printing the data of the serialized object
            System.out.println(acc);
            System.out.println("Account Balance: " + acc.displayBalance(acc));
        } catch (Exception e) {
            System.out.println(e);
        } finally {
            // closing the stream
            in.close();
            // closing the file input stream
            fin.close();
        }
    }
}
