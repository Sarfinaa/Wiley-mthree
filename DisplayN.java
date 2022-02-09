import java.util.Scanner;

public class DisplayN {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        System.out.print("Enter value of n: ");
        int m = s.nextInt();
        int n;
        if (m > 0)
            n = 1;
        else if (m == 0)
            n = 0;
        else
            n = -1;
        System.out.println("Value of n: " + n);
    }

}
