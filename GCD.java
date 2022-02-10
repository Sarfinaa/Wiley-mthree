import java.util.Scanner;

public class GCD {
    public static int findGCD(int a, int b) {
        while (a % b != 0) {
            int rem = a % b;
            a = b;
            b = rem;
        }
        return b;
    }

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        System.out.print("Enter value a and b:");
        int a = s.nextInt();
        int b = s.nextInt();
        System.out.println(findGCD(a, b));
    }
}
