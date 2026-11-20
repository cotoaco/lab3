package ru.student.util;

import ru.student.geometry.*;

public class PolygonalChainUtils {
    public static PolygonalChain merge(HasPolygonalChain... objects) {
        PolygonalChain result = new PolygonalChain();

        for (HasPolygonalChain object : objects) {
            if (object != null) {
                Point[] points = object.getPolygonalChain()
                        .getPoints()
                        .toArray(new Point[0]);

                result.addPoints(points);
            }
        }

        return result;
    }
}