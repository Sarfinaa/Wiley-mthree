package week_3.file_handling;

import java.io.File;
import java.io.IOException;
import java.io.FileWriter;
import java.util.Scanner;

public class FileCopy {
    public static void main(String[] args) throws IOException {
        File f = new File("text1.txt");
        if (f.createNewFile()) {
            System.out.println("File Created");
        } else
            System.out.println("File not created!!!");
        FileWriter fw = new FileWriter("text1.txt");
        fw.write("hello ");
        fw.write("world");
        fw.close();
        Scanner s = new Scanner(f);
        File f2 = new File("text2.txt");
        f2.createNewFile();
        FileWriter fw2 = new FileWriter("text2.txt");
        while (s.hasNextLine()) {
            fw2.write(s.nextLine());

        }
        fw2.close();
    }
}
