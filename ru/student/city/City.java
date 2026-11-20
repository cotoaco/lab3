package ru.student.city;

import java.util.HashMap;
import java.util.Map;

public class City {
    private final String name;
    private final Map<City, Integer> roads = new HashMap<>();

    public City(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void addRoad(City city, int distance) {
        if (city == null || distance < 0) {
            throw new IllegalArgumentException("Некорректная дорога");
        }

        roads.put(city, distance);
    }

    public Map<City, Integer> getRoads() {
        return new HashMap<>(roads);
    }

    public int getDistance(City city) {
        Integer distance = roads.get(city);

        if (distance == null) {
            return -1;
        }

        return distance;
    }

    @Override
    public String toString() {
        return name;
    }
}