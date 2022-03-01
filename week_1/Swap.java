package week_1;

public class Swap {
    public static void swap(int a, int b) {
        a = a + b;// a=8
        b = a - b;// b=5
        a = a - b;// a=3
        System.out.println("After Swapping: a->" + a + " & b->" + b);
    }

    public static void main(String[] args) {
        int a = 5;
        int b = 3;
        System.out.println("Number Before Swapping: a->" + a + " & b->" + b);
        swap(a, b);
    }
}
