package week_1;

import java.util.Scanner;

public class Armstrong {
    public static int cube(int a) {
        return a * a * a;
    }

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        System.out.print("Enter the number: ");
        int n = s.nextInt();
        int temp = n;
        int sum = 0;
        while (temp != 0) {
            int rem = temp % 10;
            sum += cube(rem);
            temp /= 10;
        }
        System.out.println(n == sum);
    }
}
