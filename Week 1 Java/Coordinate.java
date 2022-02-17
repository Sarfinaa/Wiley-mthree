import java.util.Scanner;

public class Coordinate {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        System.out.print("Enter the value of x and y coordinate:");
        int x = s.nextInt();
        int y = s.nextInt();
        int quad = 0;
        if (x > 0) {
            if (y > 0)
                quad = 1;
            else
                quad = 4;
        } else {
            if (y > 0)
                quad = 2;
            else
                quad = 3;
        }
        System.out.println("(" + x + "," + y + ")" + " present in " + quad + " quadrant");
    }

}
