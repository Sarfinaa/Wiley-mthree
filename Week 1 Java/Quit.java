import java.util.Scanner;

public class Quit {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int count = 0;
        while (true) {
            if (s.next().equals("q"))
                break;
            count++;
        }
        System.out.println("Count:" + count);
    }
}
