package week_1;

import java.util.*;

public class Array {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int[] bestScore = new int[10];
        for (int i = 0; i < 10; i++)
            bestScore[i] = 0;
        for (int i = 0; i < 10; i++)
            bestScore[i] = s.nextInt();
        for (int i = 0; i < 10; i++)
            bestScore[i]++;
        Arrays.sort(bestScore);
        System.out.println("     !!! Top Five Scores !!!");
        for (int i = 9; i > 5; i--)
            System.out.println(bestScore[i]);

    }
}
