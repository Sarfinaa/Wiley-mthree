
public class Loop {
    public static void main(String[] args) {
        int n = 10;
        int sum = 0;
        System.out.println("First Loop Output!!!");
        for (int i = 1; i <= n; i++) {
            sum += i;
            System.out.println(sum);
        }
        System.out.println("Second Loop Output!!!");
        sum = 0;
        int i;
        for (i = 1; sum <= 100; i++) {
            sum += i;
            if (sum <= 100)
                System.out.println(sum);
        }
        System.out.println("Loop terminated at i = " + i);
    }
}
