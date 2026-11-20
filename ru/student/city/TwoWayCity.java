package ru.student.city;

public class TwoWayCity extends City {

    public TwoWayCity(String name) {
        super(name);
    }

    @Override
    public void addRoad(City city, int distance) {
        super.addRoad(city, distance);
        city.addRoad(this, distance);
    }
}