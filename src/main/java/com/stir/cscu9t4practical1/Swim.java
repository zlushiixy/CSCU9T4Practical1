package com.stir.cscu9t4practical1;

public class Swim extends TrainingSession {
    private float distance;
    private boolean pool; // true if in pool, false if outdoors

    public Swim(String name, int day, int month, int year, int hours, int minutes, int seconds,
                float distance, boolean pool) {
        super(name, day, month, year, hours, minutes, seconds);
        this.distance = distance;
        this.pool = pool;
    }

    @Override
    public String getType() {
        return "Swim";
    }

    @Override
    public String getDetails() {
        return "Distance: " + distance + " km, Location: " + (pool ? "Pool" : "Outdoors");
    }
}
