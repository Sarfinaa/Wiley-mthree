import java.util.Arrays;

public class Hello {
    public static void displayArray(int[] ar) {
        System.out.println(Arrays.toString(ar));
    }

    public static void printSubset(int[] ar, int idx, int sum, int t, String ans) {
        if (idx == ar.length - 1) {
            if (sum + ar[idx] == t) {
                System.out.println(ans + ar[idx]);
            }
            return;
        }
        if (sum + ar[idx] == t) {
            System.out.println(ans + ar[idx]);
        }
        printSubset(ar, idx + 1, sum + ar[idx], t, ans + ar[idx] + ",");
        printSubset(ar, idx + 1, sum, t, ans + "");
    }

    public static void main(String[] args) {
        int[] a = { 1, 2, 3, 4, 5 };
        int t = 6;
        printSubset(a, 0, 0, t, "");
        // 0 sum=1

    }
}

// ar-1
// 9.00,9.30,11.30,15.30
// 9.05,11.35,15.35,18.00

// 1.) Arrays are sorted
// 2.) time- O(n)

// class Time{
// arivTime
// leavTime
// }
// (9,9.05),(9.30,11.35),(11.30,15.35),(15.30,18.00)

// 1,2,3,4,5 t=6
//