package com.stir.cscu9t4practical1;

public class Cycle extends TrainingSession {
    private float distance;
    private String terrain;
    private int time; // Time in minutes

    public Cycle(String name, int day, int month, int year, int hours, int minutes, int seconds,
                 float distance, String terrain, int time) {
        super(name, day, month, year, hours, minutes, seconds);
        this.distance = distance;
        this.terrain = terrain;
        this.time = time;
    }

    @Override
    public String getType() {
        return "Cycle";
    }

    @Override
    public String getDetails() {
        return "Distance: " + distance + " km, Terrain: " + terrain + ", Time: " + time + " minutes";
    }
}
