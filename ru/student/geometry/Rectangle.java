package ru.student.geometry;

public class Rectangle extends Figure{

    private double width;
    private double height;

    public Rectangle(double width, double height) {
        setWidth(width);
        setHeight(height);
    }

    public double getWidth() {
        return width;
    }

    public void setWidth(double width) {
        if (width <= 0) {
            throw new IllegalArgumentException(
                    "Ширина должна быть положительной"
            );
        }
        this.width = width;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        if (height <= 0) {
            throw new IllegalArgumentException(
                    "Высота должна быть положительной"
            );
        }
        this.height = height;
    }

    @Override
    public double area() {
        return width * height;
    }

    @Override
    public String toString() {
        return "Прямоугольник: ширина = " + width
                + ", высота = " + height;
    }
}