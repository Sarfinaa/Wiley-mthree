package week_1;

import java.util.Scanner;

public class Prime1toN {
    public static int cube(int a) {
        return a * a * a;
    }

    public static boolean armstrong(int n) {
        int temp = n;
        int sum = 0;
        while (temp != 0) {
            int rem = temp % 10;
            sum += cube(rem);
            temp /= 10;
        }
        return n == sum;
    }

    public static boolean isPrime(int n) {
        boolean prime = true;
        for (int i = 2; i * i <= n; i++) {
            if (n % i == 0)
                prime = false;
        }
        return prime;
    }

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        for (int i = 1; i <= n; i++) {
            if (isPrime(i)) {
                System.out.println(i + " is a Prime no.");
            } else if (armstrong(i)) {
                System.out.println(i + " is a Armstrong no.");
            } else
                System.out.println(i + " is not Prime and Armstrong no");
        }
    }
}
