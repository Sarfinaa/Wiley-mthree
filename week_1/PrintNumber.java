import java.util.Scanner;

public class PrintNumber {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        System.out.print("Enter number from 0-9:");
        int num = s.nextInt();
        String snum = "";
        switch (num) {
            case 0:
                snum = "Zero";
                break;
            case 1:
                snum = "One";
                break;
            case 2:
                snum = "Two";
                break;
            case 3:
                snum = "Three";
                break;
            case 4:
                snum = "Four";
                break;
            case 5:
                snum = "Five";
                break;
            case 6:
                snum = "Six";
                break;
            case 7:
                snum = "Seven";
                break;
            case 8:
                snum = "Eight";
                break;
            case 9:
                snum = "Nine";
                break;
            default:
                snum = "Number out of range!!";

        }
        System.out.println(num + "->" + snum);
    }
}