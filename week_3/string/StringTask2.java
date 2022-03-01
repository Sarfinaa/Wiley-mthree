package week_3.string;

import java.util.*;

public class StringTask2 {
    static String merge(char[] s1, char[] s2) {
        int i = 0, j = 0;
        String result = "";
        while (i < s1.length && j < s2.length) {
            if (s1[i] <= s2[j]) {
                result += s1[i++];
            } else {
                result += s2[j++];
            }
        }
        while (i < s1.length) {
            result += s1[i++];
        }
        while (j < s2.length) {
            result += s2[j++];
        }
        return result;
    }

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        char[] s1 = s.next().toCharArray();
        Arrays.sort(s1);
        char[] s2 = s.next().toCharArray();
        Arrays.sort(s2);
        System.out.println(merge(s1, s2));
    }
}
