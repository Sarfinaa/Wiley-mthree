package week_6;

public class FooBar {
    public static void main(String[] args) {
        Foo foo = new Foo("Karan Seth");
        Bar bar = new Bar("Karan", 21);
        bar.setFoo(foo);
        bar.processFooName();
        System.out.println(bar);
    }
}