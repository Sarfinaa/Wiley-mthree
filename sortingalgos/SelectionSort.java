package sortingalgos;

// selection sort me agar 5 element hai to 4 iteration hogi or har iteration me smallest element start me aajega or swap end me karte hai 
// best time -> O(n^2)
// worst time -> O(n^2)
import java.util.*;

public class SelectionSort {
    public static void swap(int i, int j, int[] ar) {
        int temp = ar[i];
        ar[i] = ar[j];
        ar[j] = temp;
    }

    public static void main(String[] args) {
        int[] ar = { 2, 5, 1, 6, 4 };
        for (int i = 0; i < ar.length - 1; i++) {
            int min = i;
            for (int j = i + 1; j < ar.length; j++) {
                if (ar[min] > ar[j])
                    min = j;
            }
            swap(i, min, ar);
        }
        System.out.println(Arrays.toString(ar));
    }
}
