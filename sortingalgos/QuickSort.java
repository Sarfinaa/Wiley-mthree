package sortingalgos;

// best time -> O(nlogn)
// worst time -> O(n^2)
import java.util.*;

public class QuickSort {
    public static void swap(int i, int j, int[] ar) {
        int temp = ar[i];
        ar[i] = ar[j];
        ar[j] = temp;
    }

    public static int partition(int s, int e, int[] ar) {
        int pivot = ar[s];
        int pi = s;
        while (s <= e) {
            while (ar[s] <= pivot) {
                s++;
            }
            while (ar[e] > pivot) {
                e--;
            }
            if (s < e)

                swap(s, e, ar);
        }
        swap(pi, e, ar);
        return e;
    }

    public static void quickSort(int s, int e, int[] ar) {
        if (s < e) {
            int pi = partition(s, e, ar);
            quickSort(s, pi - 1, ar);
            quickSort(pi + 1, e, ar);

        }
    }

    public static void main(String[] args) {
        int[] ar = { 2, 5, 1, 6, 4 };// 1 2 4 5 6
        quickSort(0, ar.length - 1, ar);
        System.out.println(Arrays.toString(ar));
    }
}
