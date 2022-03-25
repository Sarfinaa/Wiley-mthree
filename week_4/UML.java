package week_4;

class Point {
    private int x;
    private int y;

    public int getX() {
        return x;
    }

    Point() {

    }

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public void setX(int x) {
        this.x = x;
    }

    @Override
    public String toString() {
        return "Point [x=" + x + ", y=" + y + "]";
    }

    public int getY() {
        return y;
    }

    double distance(Point point) {
        return Math.sqrt((Math.pow(point.x - this.x, 2) + Math.pow(point.y - this.y, 2)));
    }

    public void setY(int y) {
        this.y = y;
    }

}

class Line {
    private Point start;
    private Point end;

    Line(int x1, int y1, int x2, int y2) {
        this(new Point(), new Point());
        start.setX(x1);
        start.setY(y1);
        end.setX(x2);
        end.setY(y2);
    }

    public Line(Point start, Point end) {
        this.start = start;
        this.end = end;
    }

    public Point getStart() {
        return start;
    }

    public void setStart(Point start) {
        this.start = start;
    }

    public Point getEnd() {
        return end;
    }

    public void setEnd(Point end) {
        this.end = end;
    }

    double length() {

        return start.distance(end);
    }
}

public class UML {
    public static void main(String[] args) {
        Point start = new Point(1, 2);
        Point end = new Point(1, 5);
        Line line = new Line(1, 2, 1, 5);
        System.out.println("Distance between two points: " + start.distance(end));
        System.out.println("Line Length: " + line.length());
    }
}
