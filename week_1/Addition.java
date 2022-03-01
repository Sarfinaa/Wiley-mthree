package week_1;

class AdditonOverloading {
    int sum;
    int a;
    int b;
    int c;
    int d;

    AdditonOverloading() {
        sum = 0;
    }

    AdditonOverloading(int a, int b) {
        this();
        this.a = a;
        this.b = b;
        sum = a + b;
    }

    AdditonOverloading(int a, int b, int c) {
        this(a, b);
        this.c = c;
        sum += c;
    }

    AdditonOverloading(int a, int b, int c, int d) {
        this(a, b, c);
        this.d = d;
        sum += d;
    }

    public String toString() {
        return "AdditonOverloading [a=" + a + ", b=" + b + ", c=" + c + ", d=" + d + ", sum=" + sum + "]";
    }

    int getSum() {
        return sum;
    }
}

public class Addition {
    public static void main(String[] args) {
        AdditonOverloading obj1 = new AdditonOverloading(1, 2);
        AdditonOverloading obj2 = new AdditonOverloading(1, 2, 3);
        AdditonOverloading obj3 = new AdditonOverloading(1, 2, 3, 4);
        System.out.println(obj1.toString());
        System.out.println(obj2);
    }
}
