import java.util.*;

public class LowerTriangle {
    public static void main(String[] args) {
        int[][] mat = { { 1, 2, 4 }, { 3, 4, 5 }, { 3, 6, 8 } };
        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[0].length; j++) {
                if (i > j) {
                    System.out.print(mat[i][j] + " ");
                } else
                    System.out.print("* ");
            }
            System.out.println();
        }
    }

}
