package week_1;

import java.util.Scanner;

public class SimpleCalculator {
    public static void performOperation(int choice, int a, int b) {
        switch (choice) {
            case 1:
                System.out.println("Addition of " + a + " and " + b + ": " + a + b);
                break;
            case 2:
                System.out.println("Subtraction of " + a + " and " + b + ": " + (a - b));
                break;
            case 3:
                System.out.println("Multiplication of " + a + " and " + b + ": " + a * b);
                break;
            case 4:
                if (b == 0) {
                    System.out.println("You can't divide " + a + " by 0");
                    break;
                }
                System.out.println("Division of " + a + " and " + b + ": " + a / b);
                break;
            case 5:
                if (b == 0) {
                    System.out.println("You can't modulus " + a + " by 0");
                    break;
                }
                System.out.println("Modulus of " + a + " and " + b + ": " + a % b);
                break;
            default:
                System.out.println("Ivalid Argument");
        }

    }

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        System.out.println("            Simple Calculator");
        System.out.println("1. Addition");
        System.out.println("2. Subtraction");
        System.out.println("3. Multiplication");
        System.out.println("4. Division");
        System.out.println("5. Modulus");
        System.out.println("Enter Your Choice According To The Operation You Want To Perform(Ex->1,2,3,4 or 5):");
        int choice = s.nextInt();
        System.out.println("Enter the two numbers:");
        int a = s.nextInt();
        int b = s.nextInt();
        performOperation(choice, a, b);
        s.close();

    }
}