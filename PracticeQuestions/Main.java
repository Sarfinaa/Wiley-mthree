package PracticeQuestions;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

class A implements Comparable<A> {
    int a;
    int b;

    final static void hello() {
        System.out.println("hello");
    }

    A() {
    }

    A(int a, int b) {
        this.a = a;
        this.b = b;

    }

    public int compareTo(A other) {
        return this.a - other.a;
    }

    public String toString() {
        return "(" + a + "," + b + ")";
    }
}

public class Main {
    public static void main(String[] args) {
        // List<A> list = Arrays.asList(new A(1, 2), new A(3, 1), new A(2, 3));
        // Comparator<A> comparator = (a, b) -> a.b - b.b;
        // System.out.println(list);
        // list.sort(comparator);
        // System.out.println(list);
        // A a = new A(1, 2);
        // A b = a;
        // System.out.println(b);
        // b.a = 2;
        // System.out.println(a);
        A.hello();

    }
}