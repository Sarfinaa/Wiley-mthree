package week_2;

import java.util.Scanner;

public class HappyNumber {
    public static int digitSquareSum(int n) {
        int ans = 0;
        while (n > 0) {
            int r = n % 10;
            ans += (r * r);
            n /= 10;
        }
        return ans;
    }

    public static boolean isHappyNumber(int n) {

        int orgiginalN = n;
        while (true) {
            if (n == 1)
                return true;
            n = digitSquareSum(n);
            if (n == 4 || n == orgiginalN)
                return false;

        }
    }

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        System.out.print("Enter the value of number:");
        int n = s.nextInt();
        if (isHappyNumber(n)) {
            System.out.println(n + " is a Happy Number");
            System.out.print("Enter the value of K:");
            int k = s.nextInt();
            System.out.print(k + " Happy Number from " + n + " are:");
            int t = n + 1;
            for (int i = 1; i <= k;) {
                if (isHappyNumber(t)) {
                    System.out.print(t + " ");
                    t++;
                    i++;
                } else
                    t++;
            }
        } else {
            System.out.println(n + " is not a Happy Number");
        }
    }
}