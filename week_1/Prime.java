package week_1;

import java.util.Scanner;

public class Prime {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        boolean prime = true;
        for (int i = 2; i * i <= n; i++) {
            if (n % i == 0)
                prime = false;
        }
        System.out.println(prime);
    }

}
