import java.util.*;

public class Merge {
    public static int[] merge(int[] a1, int[] a2, int n1, int n2) {
        int res[] = new int[n1 + n2];
        int i = 0, j = 0, k = 0;
        while (i < n1 && j < n2) {
            if (a1[i] <= a2[j]) {
                res[k] = a1[i];
                i++;
            } else {
                res[k] = a2[j];
                j++;
            }
            k++;
        }
        while (i < n1) {
            res[k] = a1[i];
            i++;
            k++;
        }
        while (j < n2) {
            res[k] = a2[j];
            j++;
            k++;
        }
        return res;
    }

    public static void main(String[] args) {
        int[] a1 = { 1, 2, 4, 5, 6 };
        int[] a2 = { 3, 4, 5, 7, 8 };
        int a1len = a1.length;
        int a2len = a2.length;
        int[] res = merge(a1, a2, a1len, a2len);
        System.out.println("Resulted Array: " + Arrays.toString(res));

    }
}
