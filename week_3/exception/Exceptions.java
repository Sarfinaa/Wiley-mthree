package week_3.exception;

import java.util.Scanner;
import java.util.Arrays;

public class Exceptions {
    public static int divide(int a, int b, int c) {
        int res = 0;
        try {
            int d = a / b;
            try {
                res = d / c;
            } catch (Exception e) {
                System.out.println("Can't divide " + d + " by 0");

            }

        } catch (ArithmeticException e) {
            System.out.println("Division is 0 can't do the operation!!!");

        }
        return res;
    }

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int arrSize = 0;
        try {
            arrSize = divide(s.nextInt(), s.nextInt(), s.nextInt());
        } catch (Exception e) {
            System.out.println("Didn't get the size of array because of some exception in divide method!!!");
        }
        int[] ar = new int[arrSize];
        System.out.println(Arrays.toString(ar));

    }

}
