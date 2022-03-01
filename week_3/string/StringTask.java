package week_3.string;

import java.util.Scanner;

public class StringTask {
    static boolean isSubstring(String s1, String s2) {
        int n = s1.length();
        int m = s2.length();
        boolean result = false;
        if (m > n)
            return result;
        for (int i = 0; i <= n - m; i++) {
            if (s1.charAt(i) == s2.charAt(0)) {
                boolean substring = true;
                for (int j = 1; j < m; j++) {
                    if (s1.charAt(i + j) != s2.charAt(j)) {
                        substring = false;
                        break;
                    }
                }
                if (substring) {
                    result = true;
                    break;
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        System.out.print("Enter the String:");
        String mainStr = s.next();
        String[] possibleSubstring = new String[100];
        int i = 0;
        System.out.println("Enter the possible substring:");
        while (s.hasNext()) {
            String str = s.next();
            if (Character.isDigit(str.charAt(0))) {
                break;
            } else {
                possibleSubstring[i++] = str;
            }
        }
        boolean result = true;
        for (int j = 0; j < i; j++) {
            if (!isSubstring(mainStr, possibleSubstring[j])) {
                result = false;
                break;
            }
        }
        System.out.println(result);
    }
}