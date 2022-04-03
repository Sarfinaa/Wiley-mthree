package sortingalgos;

// insertion sort me agar 5 element hai to 4 iteration hogi or har iteration me smallest element start me aajega or swap end me karte hai 
// best time -> O(n)
// worst time -> O(n^2)
import java.util.*;

public class InsertionSort {
    public static void swap(int i, int j, int[] ar) {
        int temp = ar[i];
        ar[i] = ar[j];
        ar[j] = temp;
    }

    public static void main(String[] args) {
        int[] ar = { 2, 5, 1, 6, 4 };
        for (int i = 0; i < ar.length - 1; i++) {
            for (int j = i - 1; j >= 0; j--) {
                if (ar[j] > ar[j + 1])
                    swap(j, j + 1, ar);
                else
                    break;
            }
        }
        System.out.println(Arrays.toString(ar));
    }
}
