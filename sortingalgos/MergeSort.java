package sortingalgos;

import java.util.*;

public class MergeSort {
    public static int[] merge(int a[], int b[]) {
        int alen = a.length;
        int blen = b.length;
        int i = 0;
        int j = 0;
        int k = 0;
        int[] res = new int[alen + blen];
        while (i < alen && j < blen) {
            if (a[i] <= b[j]) {
                res[k++] = a[i++];
            } else {
                res[k++] = b[j++];
            }
        }
        while (i < alen) {
            res[k++] = a[i++];
        }
        while (j < blen) {
            res[k++] = b[j++];
        }
        return res;
    }

    public static int[] mergeSort(int[] a, int low, int high) {
        if (low == high) {
            return new int[] { a[low] };
        }
        int mid = low + (high - low) / 2;
        int[] lhalf = mergeSort(a, low, mid);
        int[] rhalf = mergeSort(a, mid + 1, high);
        return merge(lhalf, rhalf);
    }

    public static void main(String[] args) {
        int[] a = { 1, 11, 2, 45, 1 };
        int[] sortedA = mergeSort(a, 0, a.length - 1);
        System.out.println(Arrays.toString(sortedA));
    }
}
