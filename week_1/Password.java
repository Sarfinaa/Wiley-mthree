package week_1;

import java.util.Scanner;

public class Password {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        String str = s.next();
        int lower = 0, upper = 0, digit = 0;
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if (c >= 'a' && c <= 'z')
                lower++;
            else if (c >= '0' && c <= '9')
                digit++;
            else if (c >= 'A' && c <= 'Z')
                upper++;
        }
        System.out.println("Lowercase Character Count: " + lower);
        System.out.println("Uppercase Character Count: " + upper);
        System.out.println("Digit Character Count:" + digit);
    }

}
