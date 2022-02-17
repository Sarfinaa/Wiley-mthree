import java.util.*;

public class MultiplyMatrix {
    public static void main(String[] args) {
        int[][] mat1 = { { 1, 2 }, { 3, 4 } };
        int[][] mat2 = { { 1, 2 }, { 3, 4 } };
        int r1 = mat1.length;
        int c1 = mat1[0].length;
        int r2 = mat2.length;
        int c2 = mat2[0].length;
        if (c1 != r2) {
            System.out.println("Matrix can't be multiplied as c1!=r2 !!!!");
            return;
        }
        int[][] result = new int[r1][c2];
        for (int i = 0; i < r1; i++) {
            for (int j = 0; j < c2; j++) {
                for (int k = 0; k < c2; k++) {
                    result[i][j] += mat1[i][k] * mat2[k][j];
                }

            }
        }
        for (int[] el : result)
            System.out.println(Arrays.toString(el));

    }
}
