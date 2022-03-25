package week_4.generic_classes;

public class Task1 {
    <T> T accept(Integer n, T param) {
        if (param instanceof Integer || param instanceof Double) {
            Integer res = n * Integer.parseInt(String.valueOf(param));
            return (T) res;
        } else if (param instanceof String) {
            return (T) "Can't perform multiplication";
        } else if (param instanceof Boolean)
            return (T) (Object) false;
        else
            return (T) "No output";
    }

    public static void main(String[] args) {
        Task1 task1 = new Task1();
        System.out.println(task1.accept(2, 2.0));
        System.out.println(task1.accept(1, "hello"));
        System.out.println(task1.accept(2, true));

    }
}
