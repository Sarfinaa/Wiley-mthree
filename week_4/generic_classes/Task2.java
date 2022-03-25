package week_4.generic_classes;

class NumberClass<T extends Number> {
    T num;

    NumberClass(T num) {
        this.num = num;
    }

    double square() {
        return num.doubleValue() * num.doubleValue();
    }

    boolean absEquals(NumberClass<?> other) {// wildcard symbol - ?
        return (Math.abs(this.num.doubleValue()) == Math.abs(other.num.doubleValue()));
    }
}

public class Task2 {
    public static void main(String[] args) {
        NumberClass<Double> num1 = new NumberClass<>(3.0);
        NumberClass<Integer> num2 = new NumberClass<>(-3);
        System.out.println(num1.absEquals(num2));

    }
}
