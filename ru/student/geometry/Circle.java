package ru.student.geometry;

public class Circle extends Figure{

    private Point center;
    private double radius;

    public Circle(Point center, double radius) {
        setRadius(radius);
        this.center = center;
    }

    public Point getCenter() {
        return center;
    }

    public void setCenter(Point center) {
        this.center = center;
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        if (radius <= 0) {
            throw new IllegalArgumentException(
                    "Радиус должен быть положительным"
            );
        }
        this.radius = radius;
    }

    @Override
    public double area() {
        return Math.PI * radius * radius;
    }

    @Override
    public String toString() {
        return "Круг с центром " + center + " и радиусом " + radius;
    }
}