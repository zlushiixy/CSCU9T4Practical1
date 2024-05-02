package com.stir.cscu9t4practical1;

public class Entry extends TrainingSession {
    private float distance;

    public Entry(String name, int day, int month, int year, int hours, int minutes, int seconds, float distance) {
        super(name, day, month, year, hours, minutes, seconds);
        this.distance = distance;
    }

    @Override
    public String getType() {
        return "General Entry";
    }

    @Override
    public String getDetails() {
        return "Distance: " + distance + " km";
    }

    public float getDistance() {
        return distance;
    }

    public String getEntry() {
        String result = getName() + " ran " + getDistance() + " km in "
                + String.format("%d:%02d:%02d", getHours(), getMinutes(), getSeconds()) + " on "
                + getDay() + "/" + getMonth() + "/" + getYear() + "\n";
        return result;
    }
}
