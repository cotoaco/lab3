package ru.student.geometry;
import ru.student.util.Measurable;

public class Line implements HasPolygonalChain, Measurable{

    private Point start;
    private Point end;

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

    public double length() {
        return start.distanceTo(end);
    }

    public PolygonalChain getPolygonalChain() {
        return new PolygonalChain(start, end);
    }

    @Override
    public String toString() {
        return "Линия от " + start + " до " + end;
    }
}