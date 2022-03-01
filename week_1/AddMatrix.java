package week_1;

import java.util.*;

public class AddMatrix {
    public static void main(String[] args) {
        int[][] mat1 = { { 1, 2 }, { 3, 4 } };
        int[][] mat2 = { { 1, 2 }, { 3, 4 } };
        int n = mat1.length;
        int m = mat1[0].length;
        int[][] result = new int[n][m];
        for (int i = 0; i < mat1.length; i++) {
            for (int j = 0; j < mat1[0].length; j++) {
                result[i][j] = mat1[i][j] + mat2[i][j];
            }
        }
        for (int[] el : result)
            System.out.println(Arrays.toString(el));

    }
}
