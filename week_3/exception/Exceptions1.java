package week_3.exception;

import java.util.Scanner;

class MathUtils {
    // -------------------------------------------------------------
    // Returns the factorial of the argument given
    // -------------------------------------------------------------
    public static int factorial(int n) {
        int fac = 1;
        if (n < 0)
            throw new IllegalArgumentException("Enter the value greater than 0!!");
        if (n > 16) {
            throw new IllegalArgumentException("You cannot pass a value greater than 16 -> Arithmetic overflow");
        }

        for (int i = n; i > 0; i--)
            fac *= i;
        return fac;
    }
}

public class Exceptions1 {

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        try {
            System.out.println(MathUtils.factorial(n));
        } catch (IllegalArgumentException e) {
            System.out.println(e);

        }
    }
}
