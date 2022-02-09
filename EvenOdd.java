public class EvenOdd {
    public static void oddeven(int a) {
        if (a % 2 == 0)
            System.out.println(a + " is Even.");
        else
            System.out.println(a + " is Odd.");
    }

    public static void main(String[] args) {
        int a = 5;
        oddeven(a);

    }

}
