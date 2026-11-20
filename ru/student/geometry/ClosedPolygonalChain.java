package ru.student.geometry;

public class ClosedPolygonalChain extends PolygonalChain {

    public ClosedPolygonalChain(Point... points) {
        super(points);

        if (points.length > 1) {
            addPoints(points[0]);
        }
    }

    @Override
    public double length() {
        return super.length();
    }

    @Override
    public String toString() {
        return "Замкнутая ломаная " + getPoints();
    }
}