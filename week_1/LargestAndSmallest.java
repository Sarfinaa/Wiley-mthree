package week_1;

import java.util.Scanner;

public class LargestAndSmallest {
    public static int max(int n1, int n2, int n3) {
        int max = n1;
        if (max < n2) {
            if (n2 > n3)
                max = n2;
            else
                max = n3;
        } else if (max < n3) {
            max = n3;
        }
        return max;
    }

    public static int min(int n1, int n2, int n3) {
        int min = n1;
        if (n2 < min) {
            if (n2 < n3)
                min = n2;
            else
                min = n3;
        } else if (n3 < min) {
            min = n3;
        }
        return min;
    }

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        System.out.print("Enter the 3 no's: ");
        int n1 = s.nextInt();
        int n2 = s.nextInt();
        int n3 = s.nextInt();
        System.out.println("Max Value:" + max(n1, n2, n3));
        System.out.println("Min Value:" + min(n1, n2, n3));

    }
}
