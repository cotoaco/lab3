package ru.student.util;

public class LengthUtils {

    public static double sumLength(Measurable... objects) {
        double sum = 0;

        for (Measurable object : objects) {
            if (object != null) {
                sum += object.length();
            }
        }

        return sum;
    }
}