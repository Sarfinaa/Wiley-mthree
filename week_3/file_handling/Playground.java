package week_3.file_handling;

import java.util.Scanner;
import java.io.FileWriter;
import java.io.IOException;
import java.io.File;
import java.io.FileNotFoundException;

public class Playground {
    public static String getData() throws FileNotFoundException {
        String input = "";
        try (Scanner s = new Scanner(new File("week_3/file_handling/playground.txt"))) {
            while (s.hasNextLine()) {
                input = s.nextLine();
            }
        }
        return input;
    }

    public static void main(String[] args) throws IOException {
        String input = getData();
        try (FileWriter fw = new FileWriter("week_3/file_handling/playground.txt");) {
            String output = input.substring(0, 5) + '@' + input.substring(5);
            int spaceidx = output.indexOf(' ', output.indexOf(' ') + 1);
            output = output.substring(0, spaceidx) + "123" + output.substring(spaceidx);
            fw.write(output);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
