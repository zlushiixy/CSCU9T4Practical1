package com.stir.cscu9t4practical1;

public class Sprint extends TrainingSession {
    private float distance;

    public Sprint(String name, int day, int month, int year, int hours, int minutes, int seconds, float distance) {
        super(name, day, month, year, hours, minutes, seconds);
        this.distance = distance;
    }

    @Override
    public String getType() {
        return "Sprint";
    }

    @Override
    public String getDetails() {
        return "Distance: " + distance + " km";
    }
}
