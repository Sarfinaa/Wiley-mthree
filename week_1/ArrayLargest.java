package week_1;

public class ArrayLargest {
    public static void main(String[] args) {
        int[] a = { 1, 2, 4, 6, 2, 5, 7, 34, 8, 39, -1 };
        int min = a[0];
        int max = a[0];
        for (int el : a) {
            if (el < min)
                min = el;
            else if (el > max)
                max = el;
        }
        System.out.println("Min: " + min + "\n Max: " + max);
    }
}
