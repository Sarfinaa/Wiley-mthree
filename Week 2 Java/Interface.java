import java.util.*;

interface in1 {
    void display(int p);
}

class testClass implements in1 {

    public boolean isPrime(int n) {
        boolean prime = true;
        for (int i = 2; i * i <= n; i++) {
            if (n % i == 0)
                prime = false;
        }
        return prime;
    }

    public int count(int p) {
        int count = 0;
        for (int i = 2; i <= p; i++) {
            if (isPrime(i))
                count++;
        }
        return count;
    }

    public void display(int p) {
        System.out.println("count for " + p + ":" + count(p));
    }
}

public class Interface {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        System.out.print("Enter value of n:");
        int n = s.nextInt();
        for (int i = 0; i < n; i++) {
            testClass test = new testClass();
            test.display(s.nextInt());
        }

    }
}
