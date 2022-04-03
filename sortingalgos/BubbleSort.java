package sortingalgos;

// bubble sort me agar 5 element hai to 4 iteration hogi or har iteration me largest element end me aajega 
// best time -> O(n)
// worst time -> O(n^2)
import java.util.*;

public class BubbleSort {
    public static void swap(int i, int j, int[] ar) {
        int temp = ar[i];
        ar[i] = ar[j];
        ar[j] = temp;
    }

    public static void main(String[] args) {
        int[] ar = { 2, 5, 1, 6, 4 };
        for (int i = 0; i < ar.length - 1; i++) {
            for (int j = 1; j < ar.length - i; j++) {
                if (ar[j] < ar[j - 1])
                    swap(j - 1, j, ar);
            }
        }
        System.out.println(Arrays.toString(ar));
    }
}
