import java.util.Scanner;

public class Task1 {
    public static int fifthEl(Integer[] a) {
        return a[4];
    }

    public static double divide(int a, int b) {
        // if (b == 0) {
        // System.out.println("Can't divide by 0");
        // return 0;
        // }
        return (a / b);
    }

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        Integer[] ar = new Integer[n];
        for (int i = 0; i < ar.length; i++)
            ar[i] = 0;
        System.out.println(fifthEl(ar));
        int a = s.nextInt();
        int b = s.nextInt();
        System.out.println(divide(a, b));

    }
}