import java.util.Scanner;

public class Arrays {
    public static boolean found(int el, int[] a2) {
        int low = 0;
        int high = a2.length - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (a2[mid] == el)
                return true;
            else if (a2[mid] < el)
                low = mid + 1;
            else
                high = mid - 1;

        }
        return false;
    }

    public static int findAns(int[] a1, int[] a2) {
        int ans = a2.length;
        for (int i = 0; i < a1.length; i++) {
            int el = a1[i];
            if (!found(el, a2))
                ans++;
        }
        return ans;
    }

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        System.out.print("Enter value of n and m :");
        int n = s.nextInt();
        int m = s.nextInt();
        int[] a1 = new int[n];
        int[] a2 = new int[m];
        for (int i = 0; i < n; i++)
            a1[i] = s.nextInt();
        for (int i = 0; i < m; i++)
            a2[i] = s.nextInt();
        System.out.println(findAns(a1, a2));

    }
}
