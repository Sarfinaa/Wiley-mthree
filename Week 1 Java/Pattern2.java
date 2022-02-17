import java.util.Scanner;

public class Pattern2 {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        int star = 1;
        int space = 2 * n - 3;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < star; j++)
                System.out.print("* ");
            for (int k = 0; k <= space; k++)
                System.out.print("  ");
            if (i == n)
                star--;
            for (int l = 0; l < star; l++)
                System.out.print("* ");
            star += 1;
            space -= 2;
            System.out.println();
        }
    }
}
