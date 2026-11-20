package ru.student.geometry;
import java.lang.Math;

public class Triangle extends Figure implements HasPolygonalChain{

    private double sideA;
    private double sideB;
    private double sideC;

    public Triangle(double sideA, double sideB, double sideC) {
        setSides(sideA, sideB, sideC);
    }

    public void setSides(double a, double b, double c) {
        if (a <= 0 || b <= 0 || c <= 0) {
            throw new IllegalArgumentException(
                    "Стороны должны быть положительными"
            );
        }

        if (a + b <= c || a + c <= b || b + c <= a) {
            throw new IllegalArgumentException(
                    "Такой треугольник не существует"
            );
        }

        sideA = a;
        sideB = b;
        sideC = c;
    }

    public double getSideA() {
        return sideA;
    }

    public double getSideB() {
        return sideB;
    }

    public double getSideC() {
        return sideC;
    }

    @Override
    public double area() {
        double p = (sideA + sideB + sideC) / 2;
        return Math.sqrt(
                p * (p - sideA) * (p - sideB) * (p - sideC)
        );
    }
    public PolygonalChain getPolygonalChain() {
        Point p1 = new Point(0, 0);
        Point p2 = new Point(sideA, 0);

        double x = (sideA * sideA + sideC * sideC - sideB * sideB)
                / (2 * sideA);

        double y = Math.sqrt(sideC * sideC - x * x);

        Point p3 = new Point(x, y);

        return new PolygonalChain(p1, p2, p3);
    }
    @Override
    public String toString() {
        return "Треугольник со сторонами: "
                + sideA + ", " + sideB + ", " + sideC;
    }
}