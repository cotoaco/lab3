package ru.student.geometry;

public class Square extends Figure implements HasPolygonalChain{

    private Point topLeft;
    private double side;

    public Square(Point topLeft, double side) {
        if (side <= 0) {
            throw new IllegalArgumentException("Сторона квадрата должна быть положительной");
        }

        this.topLeft = topLeft;
        this.side = side;
    }

    public Square(double x, double y, double side) {
        this(new Point(x, y), side);
    }

    public Point getTopLeft() {
        return topLeft;
    }

    public void setTopLeft(Point topLeft) {
        this.topLeft = topLeft;
    }

    public double getSide() {
        return side;
    }

    public double getArea() {
        return side * side;
    }

    @Override
    public double area() {
        return getArea();
    }

    public double getPerimeter() {
        return 4 * side;
    }

    public void setSide(double side) {
        if (side <= 0) {
            throw new IllegalArgumentException("Сторона квадрата должна быть положительной");
        }

        this.side = side;
    }

    // Получение ломаной по углам квадрата
    public PolygonalChain getPolygonalChain() {
        double x = topLeft.getX();
        double y = topLeft.getY();

        return new PolygonalChain(
                new Point(x, y),
                new Point(x + side, y),
                new Point(x + side, y + side),
                new Point(x, y + side)
        );
    }

    @Override
    public String toString() {
        return "Квадрат в точке " + topLeft + " со стороной " + side;
    }
}