package week_2;

interface Shape1 {
    void draw();
}

interface Polygon {

    double getArea();

    double getPerimeter();

    boolean isPolygon();
}

class Line implements Shape1 {
    public void draw() {
        System.out.println("I am of " + this.getClass().getSimpleName() + " shape");

    }

}

class PolyClass {
    double area;
    double perimeter;
    int noOfSides;

    @Override
    public String toString() {
        return this.getClass().getSimpleName() + " [area=" + area + ", noOfSides=" + noOfSides + ", perimeter="
                + perimeter + "]";
    }
}

class Triangle1 extends PolyClass implements Shape1, Polygon {

    double base;
    double height;
    double s1;
    double s2;

    Triangle1(double base, double height, double s1, double s2) {
        this.base = base;
        this.height = height;
        this.s1 = s1;
        this.s2 = s2;
        noOfSides = 3;
        this.area = 0.5 * base * height;
        this.perimeter = base + s1 + s2;
    }

    public void draw() {
        System.out.println("I am of " + this.getClass().getSimpleName() + " shape");
    }

    public double getArea() {

        return area;
    }

    public double getPerimeter() {

        return perimeter;
    }

    public boolean isPolygon() {
        return true;
    }
}

class Rectangle1 extends PolyClass implements Shape1, Polygon {
    double length;
    double breadth;

    Rectangle1(double length, double breadth) {
        this.length = length;
        this.breadth = breadth;
        noOfSides = 4;
        this.area = length * breadth;
        this.perimeter = 2 * (length + breadth);
    }

    public void draw() {
        System.out.println("I am of " + this.getClass().getSimpleName() + " shape");

    }

    public double getArea() {

        return area;
    }

    public double getPerimeter() {

        return perimeter;
    }

    public boolean isPolygon() {
        return true;
    }
}

public class Interface2 {
    public static void main(String[] args) {
        Line line = new Line();
        line.draw();
        Rectangle1 rec = new Rectangle1(2, 4);
        Triangle1 t = new Triangle1(2, 4, 6, 6);
        System.out.println(rec);
        System.out.println(t);

    }
}