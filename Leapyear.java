import java.util.Scanner;

public class Leapyear {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int year = s.nextInt();
        if ((year % 4 == 0 && year % 100 != 0) || year % 400 == 0)
            System.out.println("Leap Year: " + year);
        else
            System.out.println("Not a Leap Year");
    }
}