import java.util.Scanner;

public class Digit {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        int temp = n;
        while (temp != 0) {
            System.out.println(temp % 10);
            temp /= 10;
        }
    }
}
