package week_2;

import java.lang.Math;

abstract class Shape {
    String name;
    double area;
    double parameter;

    Shape(String name) {
        this.name = name;
        this.area = 0.0f;
        this.parameter = 0.0f;
    }

    abstract void draw();

    abstract void calculateArea();

    abstract void calculateParameter();

    public double getArea() {
        return area;
    }

    public void setArea(double area) {
        this.area = area;
    }

    public double getParameter() {
        return parameter;
    }

    public void setParameter(double parameter) {
        this.parameter = parameter;
    }

}

class Rectangle extends Shape {
    float length;
    float breadth;

    Rectangle(String name, float length, float breadth) {
        super(name);
        this.length = length;
        this.breadth = breadth;
    }

    void calculateArea() {
        setArea(length * breadth);
    }

    void calculateParameter() {
        setParameter(2 * length + 2 * breadth);
    }

    void draw() {
        System.out.println("Draw Rectangle");
    }
}

class Square extends Shape {
    float side;

    Square(String name, float side) {
        super(name);
        this.side = side;

    }

    void calculateArea() {
        setArea(side * side);
    }

    void calculateParameter() {
        setParameter(4 * side);
    }

    void draw() {
        System.out.println("Draw Square");
    }
}

class Circle extends Shape {
    double radius;
    final double PI = Math.PI;

    Circle(String name, float radius) {
        super(name);
        this.radius = radius;
    }

    void calculateArea() {
        setArea(PI * radius * radius);
    }

    void calculateParameter() {
        setParameter(2 * PI * radius);
    }

    void draw() {
        System.out.println("Draw Circle");
    }
}

public class Abstract1 {
    public static void main(String[] args) {
        Shape rec = new Rectangle("Rectangle", 2, 3);
        Shape sq = new Square("Square", 4);
        Shape circle = new Circle("Circle", 3);
        rec.calculateParameter();
        rec.calculateArea();
        sq.calculateParameter();
        sq.calculateArea();
        circle.calculateParameter();
        circle.calculateArea();
        rec.draw();
        System.out.println("Parameter: " + rec.getParameter());
        System.out.println("Area: " + rec.getArea());
        sq.draw();
        System.out.println("Parameter: " + sq.getParameter());
        System.out.println("Area: " + sq.getArea());
        circle.draw();
        System.out.println("Parameter: " + circle.getParameter());
        System.out.println("Area: " + circle.getArea());

    }
}