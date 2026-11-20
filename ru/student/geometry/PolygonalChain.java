
package ru.student.geometry;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import ru.student.util.Measurable;

public class PolygonalChain implements HasPolygonalChain, Measurable {

    private List<Point> points;

    public PolygonalChain() {
        points = new ArrayList<>();
    }

    public PolygonalChain(Point... points) {
        this.points = new ArrayList<>(Arrays.asList(points));
    }

    public List<Point> getPoints() {
        return new ArrayList<>(points);
    }

    public void addPoints(Point... newPoints) {
        points.addAll(Arrays.asList(newPoints));
    }

    public PolygonalChain merge(PolygonalChain other) {
        PolygonalChain result = new PolygonalChain();

        result.addPoints(this.getPoints().toArray(new Point[0]));
        result.addPoints(other.getPoints().toArray(new Point[0]));

        return result;
    }

    public Point getPoint(int index) {
        return points.get(index);
    }

    public void setPoint(int index, Point point) {
        points.set(index, point);
    }

    public double length() {
        double result = 0;

        for (int i = 1; i < points.size(); i++) {
            result += points.get(i - 1)
                    .distanceTo(points.get(i));
        }

        return result;
    }

    @Override
    public String toString() {
        return "Линия " + points;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }

        if (!(obj instanceof PolygonalChain)) {
            return false;
        }

        PolygonalChain other = (PolygonalChain) obj;

        return points.equals(other.points);
    }

    @Override
    public int hashCode() {
        return points.hashCode();
    }

    @Override
    public PolygonalChain getPolygonalChain() {
        return this;
    }

}
