package week_1;

import java.util.Scanner;

public class Triangle {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        System.out.print("Enter Three Sides of Triangle:");
        int s1 = s.nextInt();
        int s2 = s.nextInt();
        int s3 = s.nextInt();
        if (s1 == s2 && s2 == s3) {
            System.out.println("Equilateral triangle!");
        } else if (s1 != s2 && s2 != s3 && s1 != s3) {
            System.out.println("Scalene triangle!");
        } else {
            System.out.println("Isosceles triangle!");
        }
    }
}